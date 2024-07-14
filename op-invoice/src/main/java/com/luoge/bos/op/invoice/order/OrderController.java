package com.luoge.bos.op.invoice.order;

import cn.hutool.core.util.NumberUtil;
import com.luoge.bos.op.core.utils.Numbers;
import com.luoge.bos.op.invoice.model.SaveOrderBO;
import com.luoge.bos.uc.ctx.Context;
import com.luoge.bos.uc.dubbo.UCService;
import com.luoge.bos.uc.model.User;
import com.luoge.ns.account.api.OrderClient;
import com.luoge.ns.account.core.OrderChannel;
import com.luoge.ns.account.model.order.CreateOrderBO;
import com.luoge.ns.account.model.order.CreateOrderItemBO;
import com.luoge.ns.account.model.order.ListOrderBO;
import com.luoge.ns.account.model.order.OrderBO;
import com.luoge.ns.account.model.product.ProductBO;
import com.luoge.ns.core.Page;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;


/**
 * 计费管理/订单管理
 */
@RestController
@RequestMapping("/bos-op/account/order")
public class OrderController {

    @Resource
    private OrderClient orderClient;

    @DubboReference(timeout = 3000)
    private UCService ucService;

    /**
     * 获取订单列表
     */
    @PostMapping("/list")
    public R<Page<OrderBO>> listOrder(@RequestBody @Valid ListOrderBO orderBO) {
        ListOrderBO listOrderBO = new ListOrderBO();
        listOrderBO.setOrgName(orderBO.getOrgName());
        listOrderBO.setPageNo(orderBO.getPageNo());
        listOrderBO.setPageSize(orderBO.getPageSize());
        return orderClient.listOrders(listOrderBO);
    }

    /**
     * 获取订单详情
     */
    @GetMapping("/detail")
    public R<OrderBO> getOrderDetail(@RequestParam("orgId") Integer orgId, @RequestParam("id") Long orderId) {
        return orderClient.getOrderDetail(orgId, orderId);
    }

    /**
     * 创建订单
     */
    @PostMapping
    public R<OrderBO> createOrder(@RequestBody @Valid SaveOrderBO orderBO, Context context) {
        User user = ucService.getUser(context.getUserId());

        List<CreateOrderItemBO> itemBOS = orderBO.getItems().stream().map(item -> new CreateOrderItemBO()
                        .setAppId(item.getAppId())
                        .setProductId(item.getProductId())
                        .setProductName(item.getProductName())
                        .setProductUnit(item.getProductUnit())
                        .setQuantity(item.getQuantity())
                        .setOriginPrice(Numbers.bigDecimal(item.getOriginPrice()))
                        .setFinalPrice(Numbers.bigDecimal(item.getFinalPrice()))
                        .setAmount(NumberUtil.mul(Numbers.bigDecimal(item.getFinalPrice()), item.getQuantity()))
                        .setTags(item.getTags())
                        .setValidityUnit(item.getValidityUnit())
                        .setValidityValue(item.getValidityValue()))
                .toList();

        CreateOrderBO createOrderBO = new CreateOrderBO()
                .setOrgId(orderBO.getOrgId())
                .setOrgName(orderBO.getOrgName())
                .setChannel(OrderChannel.BOS.getCode())
                .setAmount(itemBOS.stream().map(CreateOrderItemBO::getAmount)
                        .reduce(BigDecimal.ZERO, BigDecimal::add))
                .setCreateUserId(context.getUserId())
                .setCreateUserName(user != null ? user.getName() : "系统操作员")
                .setItems(itemBOS);
        return orderClient.createOrder(createOrderBO);
    }

    /**
     * 购买商品下拉选择列表
     */
    @PostMapping("/products")
    public R<List<ProductBO>> listUsableProducts() {
        return orderClient.listUsableProducts();
    }
}


