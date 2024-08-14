package com.luoge.bos.invoice.common;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.luoge.bos.core.BOSConsts;
import com.luoge.bos.invoice.entity.ParkEnterpriseCustomerDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@DS(BOSConsts.DataSource.INVOICE)
@Mapper
public interface ParkEnterpriseCustomerDao {
    List<ParkEnterpriseCustomerDO> list();
}