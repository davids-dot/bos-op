package com.luoge.bos.invoice.apply;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.luoge.bos.core.BOSConsts;
import com.luoge.bos.invoice.entity.invoice.InvoiceApplyItemDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@DS(BOSConsts.DataSource.INVOICE)
@Mapper
public interface InvoiceApplyItemDao {

    List<InvoiceApplyItemDO> listItemsByApplyId(Long id);
}