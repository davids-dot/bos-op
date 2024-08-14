package com.luoge.bos.invoice.park.provider;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.luoge.bos.invoice.entity.ParkProviderDO;
import com.luoge.bos.core.BOSConsts;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@DS(BOSConsts.DataSource.INVOICE)
@Mapper
public interface AppParkProviderDao {

    List<ParkProviderDO> listByStatus(Integer status);

    ParkProviderDO get(Integer id);

}