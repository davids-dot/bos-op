package com.luoge.bos.invoice.org.enterprise;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.github.pagehelper.Page;
import com.luoge.bos.invoice.model.org.EnterpriseCountBO;
import com.luoge.bos.invoice.model.org.OrgEnterpriseBO;
import com.luoge.bos.core.BOSConsts;
import com.luoge.bos.invoice.entity.uc.EnterpriseDO;
import com.luoge.bos.invoice.entity.uc.IndustryDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@DS(BOSConsts.DataSource.UC)
@Mapper
public interface EnterpriseDao {
    List<EnterpriseCountBO> listCount();

    Page<EnterpriseDO> listByPage(@Param("name") String name, @Param("orgId") Integer orgId,
                                  @Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);

    boolean existName(@Param("orgId") int orgId, @Param("name") String name);

    void insert(EnterpriseDO enterpriseDO);

    void update(EnterpriseDO enterpriseDO);

    void updateStatus(@Param("enterpriseId") Integer enterpriseId, @Param("status") Integer status);

    EnterpriseDO getByName(@Param("orgId") int orgId, @Param("name") String name);

    EnterpriseDO getDetail(Integer id);

    EnterpriseDO getByTaxNo(@Param("orgId") int orgId, @Param("taxNo") String taxNo);

    List<OrgEnterpriseBO> listEnterpriseByIds(@Param("enterpriseIds") List<Integer> enterpriseIds);

    List<EnterpriseDO> listAll();

    Page<EnterpriseDO> listNotParkEnterprise(@Param("orgId") Integer orgId,
                                             @Param("name") String name,
                                             @Param("parkEnterpriseIds") List<Integer> enterpriseIds,
                                             @Param("pageNo") int pageNo,
                                             @Param("pageSize") int pageSize);

    List<IndustryDO> listIndustries();

    List<EnterpriseDO> list();

    void insertEnterpriseUserRelation(@Param("orgId") Integer orgId,
                                      @Param("enterpriseId") Integer enterpriseId,
                                      @Param("userId") Integer userId,
                                      @Param("createTime") LocalDateTime localDateTime);
}
