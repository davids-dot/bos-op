package com.luoge.bos.invoice.apply;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.luoge.bos.core.BOSConsts;
import com.luoge.bos.invoice.entity.invoice.InvoiceOutItemDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@DS(BOSConsts.DataSource.INVOICE)
@Mapper
public interface NsInvoiceOutItemDao {

    /**
     * 批量插入
     *
     * @param items 实体列表
     */
    int batchSave(@Param("items") List<InvoiceOutItemDO> items);

    /**
     * 查询发票税率
     */
    List<InvoiceOutItemDO> selectByInvoiceIds(@Param("orgId") int orgId,
                                              @Param("invoiceIds") List<Long> invoiceIds);
}
