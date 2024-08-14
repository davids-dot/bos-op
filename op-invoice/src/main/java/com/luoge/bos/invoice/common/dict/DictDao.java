package com.luoge.bos.invoice.common.dict;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.luoge.bos.core.BOSConsts;
import com.luoge.bos.invoice.model.common.dict.DictVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@DS(BOSConsts.DataSource.INVOICE)
@Mapper
public interface DictDao {

    public List<DictVO> listByType(String type);
}
