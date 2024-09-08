package com.luoge.app.uc.common;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.luoge.app.uc.entity.RegionDO;
import com.luoge.bos.core.BOSConsts;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@DS(BOSConsts.DataSource.UC)
@Mapper
public interface CommonDao {
    List<RegionDO> listRegions();

    RegionDO getRegion(@Param("code") String code);

//    List<IndustryDO> listIndustries();
//
//    IndustryDO getIndustry(@Param("code") String code);

}