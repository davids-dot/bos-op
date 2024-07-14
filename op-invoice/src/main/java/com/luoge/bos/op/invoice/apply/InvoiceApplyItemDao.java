package com.luoge.bos.op.invoice.apply;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.luoge.bos.op.core.BOSConsts;
import com.luoge.bos.op.invoice.entity.invoice.InvoiceApplyItemDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@DS(BOSConsts.DataSource.INVOICE)
@Mapper
public interface InvoiceApplyItemDao {

    List<InvoiceApplyItemDO> listItemsByApplyId(Long id);
}