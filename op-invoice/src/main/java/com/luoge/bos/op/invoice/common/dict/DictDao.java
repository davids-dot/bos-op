package com.luoge.bos.op.invoice.common.dict;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.luoge.bos.op.core.BOSConsts;
import com.luoge.bos.op.invoice.model.common.dict.DictVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@DS(BOSConsts.DataSource.INVOICE)
@Mapper
public interface DictDao {

    public List<DictVO> listByType(String type);
}
