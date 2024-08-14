package com.luoge.bos.invoice.org.enterprise;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.github.pagehelper.Page;
import com.luoge.bos.core.BOSConsts;
import com.luoge.bos.invoice.entity.invoice.EnterpriseRegistrationDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;

@DS(BOSConsts.DataSource.INVOICE)
@Mapper
public interface EnterpriseRegistrationDao {

    int insert(EnterpriseRegistrationDO row);

    Page<EnterpriseRegistrationDO> list(@Param("corporateName") String corporateName,
                                        @Param("parkProviderId") Integer parkProviderId,
                                        @Param("status") Integer status,
                                        @Param("startTime") LocalDateTime startTime,
                                        @Param("endTime") LocalDateTime endTime,
                                        @Param("pageNo") Integer pageNo,
                                        @Param("pageSize") Integer pageSize);

    EnterpriseRegistrationDO get(Long id);

    void updateResult(EnterpriseRegistrationDO enterpriseRegistrationDO);

    EnterpriseRegistrationDO getById(Long id);

    void update(EnterpriseRegistrationDO registrationDO);

    void updateStatus(@Param("id") Long id, @Param("status") Integer status, @Param("updateTime") LocalDateTime updateTime);
}