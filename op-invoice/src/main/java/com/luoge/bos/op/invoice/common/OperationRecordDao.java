package com.luoge.bos.op.invoice.common;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.luoge.bos.op.core.BOSConsts;
import com.luoge.bos.op.invoice.entity.invoice.OperationRecordDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@DS(BOSConsts.DataSource.INVOICE)
@Mapper
public interface OperationRecordDao {

    int insert(OperationRecordDO row);

    List<OperationRecordDO> listByBusinessId(Long businessId);

}