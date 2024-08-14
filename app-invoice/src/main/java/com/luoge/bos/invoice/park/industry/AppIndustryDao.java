package com.luoge.bos.invoice.park.industry;


import com.luoge.bos.invoice.entity.IndustryDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface AppIndustryDao {

    IndustryDO getById(Integer id);


    List<IndustryDO> listAll();
}