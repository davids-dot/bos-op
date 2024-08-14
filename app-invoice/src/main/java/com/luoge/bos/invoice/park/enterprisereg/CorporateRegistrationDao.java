package com.luoge.bos.invoice.park.enterprisereg;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.luoge.bos.invoice.entity.EnterpriseRegistrationDO;
import com.luoge.bos.invoice.model.EnterpriseRegistrationQuery;
import com.luoge.bos.core.BOSConsts;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@DS(BOSConsts.DataSource.INVOICE)
@Mapper
public interface CorporateRegistrationDao {

    int insert(EnterpriseRegistrationDO row);

    EnterpriseRegistrationDO getById(Long id);

    int update(EnterpriseRegistrationDO enterpriseRegistrationDO);

    int updateEnterprisePayment(@Param("id") long id,
                                @Param("paymentProofFileId") String paymentProofFileId,
                                @Param("status") int status);


    List<EnterpriseRegistrationDO> list(@Param("query") EnterpriseRegistrationQuery enterpriseRegistrationBO,
                                        @Param("pageNo") int pageNo,
                                        @Param("pageSize") int pageSize);

    /**
     * 工商注册申请列表
     */
    List<EnterpriseRegistrationDO> listByStatus(@Param("status") Integer status, @Param("orgId") int orgId);

    void delete(@Param("orgId") int orgId, @Param("id") long id);
}