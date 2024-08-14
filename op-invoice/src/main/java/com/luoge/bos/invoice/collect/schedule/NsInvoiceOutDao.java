package com.luoge.bos.invoice.collect.schedule;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.luoge.bos.core.BOSConsts;
import com.luoge.bos.invoice.entity.InvoiceOutDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@DS(BOSConsts.DataSource.INVOICE)
@Mapper
public interface NsInvoiceOutDao {

    int countInvoice(@Param("orgId") Integer orgId,
                     @Param("enterpriseId") Integer enterpriseId,
                     @Param("startTime") LocalDateTime startTime,
                     @Param("endTime") LocalDateTime endTime);

    List<InvoiceOutDO> listByPage(@Param("orgId") Integer orgId,
                                  @Param("enterpriseId") Integer enterpriseId,
                                  @Param("startTime") LocalDateTime startTime,
                                  @Param("endTime") LocalDateTime endTime,
                                  @Param("offset") int offset,
                                  @Param("limit") int limit);

    int insert(InvoiceOutDO invoice);

}
