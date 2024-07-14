package com.luoge.bos.op.invoice.common;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.luoge.bos.op.core.BOSConsts;
import com.luoge.bos.op.invoice.entity.uc.RegionDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@DS(BOSConsts.DataSource.UC)
@Mapper
public interface RegionDao {
    List<RegionDO> list();

    RegionDO get(String code);
}