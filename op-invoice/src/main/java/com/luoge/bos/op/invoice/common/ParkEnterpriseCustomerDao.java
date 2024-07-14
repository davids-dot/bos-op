package com.luoge.bos.op.invoice.common;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.luoge.bos.op.core.BOSConsts;
import com.luoge.bos.op.invoice.entity.ParkEnterpriseCustomerDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@DS(BOSConsts.DataSource.INVOICE)
@Mapper
public interface ParkEnterpriseCustomerDao {
    List<ParkEnterpriseCustomerDO> list();
}