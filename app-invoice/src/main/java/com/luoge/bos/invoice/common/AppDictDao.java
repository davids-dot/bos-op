package com.luoge.bos.invoice.common;

import com.luoge.bos.invoice.model.DictVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AppDictDao {

    List<DictVO> listByType(String type);
}
