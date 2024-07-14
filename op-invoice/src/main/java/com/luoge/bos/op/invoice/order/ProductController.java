package com.luoge.bos.op.invoice.order;

import com.luoge.bos.op.core.utils.Numbers;
import com.luoge.bos.op.invoice.model.CreateProductDataBO;
import com.luoge.ns.account.api.ProductClient;
import com.luoge.ns.account.model.product.*;
import com.luoge.ns.core.Page;
import com.luoge.ns.core.R;
import com.luoge.ns.uc.dubbo.UCService;
import com.luoge.ns.uc.model.Permission;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 计费管理/商品管理
 */
@RestController
@RequestMapping("/bos-op/account/product")
public class ProductController {

    @Resource
    private ProductClient productClient;
    @DubboReference(timeout = 3000)
    private UCService ucService;

    /**
     * 获取商品列表
     */
    @PostMapping("/list")
    public R<Page<ProductBO>> listProduct(@RequestBody @Valid ListProductBO productBO) {
        ListProductBO listProductBO = new ListProductBO();
        listProductBO.setName(productBO.getName());
        listProductBO.setTags(productBO.getTags());
        listProductBO.setAppId(productBO.getAppId());
        listProductBO.setPageNo(productBO.getPageNo());
        listProductBO.setPageSize(productBO.getPageSize());
        return productClient.listProducts(listProductBO);
    }

    /**
     * 获取商品详情
     */
    @GetMapping("/detail")
    public R<ProductBO> getProductDetail(@RequestParam(name = "id") Integer id) {
        return productClient.getProduct(id);
    }

    /**
     * 新增/编辑商品
     */
    @PostMapping
    public R<Void> saveProduct(@RequestBody @Valid CreateProductDataBO productBO) {
        SaveProductBO saveProductBO = new SaveProductBO()
                .setId(productBO.getId())
                .setAppId(productBO.getAppId())
                .setName(productBO.getName())
                .setTags(productBO.getTags())
                .setUnit(productBO.getUnit())
                .setOriginPrice(Numbers.bigDecimal(productBO.getOriginPrice()))
                .setDiscountPrice(Numbers.bigDecimal(productBO.getDiscountPrice()))
                .setDescription(productBO.getDescription())
                .setValidityUnit(productBO.getValidityUnit())
                .setValidityValue(productBO.getValidityValue());

        if (CollectionUtils.isNotEmpty(productBO.getDataList())){
            saveProductBO.setDataList(productBO.getDataList().stream().map(item -> new ProductDataListBO()
                            .setId(item.getId())
                            .setDataId(item.getDataId())
                            .setDataName(item.getDataName())
                            .setProductId(item.getProductId()))
                    .toList());
        }
        if (CollectionUtils.isNotEmpty(productBO.getPermissions())){
            saveProductBO.setPermissions(productBO.getPermissions().stream().map(item -> new PermissionsBO()
                            .setCode(item.getCode())
                            .setName(item.getName()))
                    .toList());
        }
        return productClient.saveProduct(saveProductBO);
    }

    /**
     * 更新订单状态
     */
    @PutMapping("/status")
    private R<Void> updateProductStatus(@RequestBody @Valid ProductStatusBO statusBO) {
        return productClient.setProductStatus(statusBO);
    }

    /**
     * 获取权限
     */
    @GetMapping("/permissions")
    private R<List<Permission>> listPermissions() {
        return R.success(ucService.listPermissions());
    }

}
