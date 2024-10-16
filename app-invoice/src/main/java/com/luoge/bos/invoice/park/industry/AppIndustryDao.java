package com.luoge.bos.invoice.park.industry;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.luoge.bos.core.BOSConsts;
import com.luoge.bos.invoice.entity.IndustryDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@DS(BOSConsts.DataSource.INVOICE)
@Mapper
public interface AppIndustryDao {

    IndustryDO getById(Integer id);


    List<IndustryDO> listAll();
}