package com.luoge.bos.op.invoice.apply;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.github.pagehelper.Page;
import com.luoge.bos.op.core.BOSConsts;
import com.luoge.bos.op.invoice.entity.invoice.InvoiceApplyDO;
import com.luoge.bos.op.invoice.model.apply.InvoiceApplyBO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;


@DS(BOSConsts.DataSource.INVOICE)
@Mapper
public interface InvoiceApplyDao {

    InvoiceApplyDO getById(Long id);

    Page<InvoiceApplyBO> list(@Param("parkProviderId") Integer parkProviderId,
                              @Param("enterpriseName") String enterpriseName,
                              @Param("status") Integer status,
                              @Param("startTime") LocalDateTime startTime,
                              @Param("endTime") LocalDateTime endTime,
                              @Param("pageNo") Integer pageNo,
                              @Param("pageSize") Integer pageSize);

    void updateStatus(@Param("id") Long id, @Param("status") Integer status, @Param("updateTime") LocalDateTime updateTime);

}