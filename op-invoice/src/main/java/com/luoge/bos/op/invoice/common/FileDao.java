package com.luoge.bos.op.invoice.common;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.luoge.bos.op.core.BOSConsts;
import com.luoge.bos.op.invoice.entity.FileDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@DS(BOSConsts.DataSource.INVOICE)
@Mapper
public interface FileDao {

    int insert(FileDO row);

    List<FileDO> listByIds(@Param("orgId") int orgId,
                           @Param("fileIds") List<Integer> fileIds);

    FileDO get(@Param("id") Integer fileId);
}