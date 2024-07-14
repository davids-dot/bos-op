package com.luoge.bos.op.invoice.park.enterprise;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.github.pagehelper.Page;
import com.luoge.bos.op.core.BOSConsts;
import com.luoge.bos.op.invoice.entity.ParkEnterpriseDO;
import com.luoge.bos.op.invoice.model.park.enterprise.ParkEnterpriseBO;
import com.luoge.bos.op.invoice.model.park.enterprise.ParkEnterpriseFeeBO;
import com.luoge.bos.op.invoice.model.query.EnterpriseFeeBO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@DS(BOSConsts.DataSource.INVOICE)
@Mapper
public interface ParkEnterpriseDao {

    List<ParkEnterpriseDO> list();

    ParkEnterpriseDO get(Integer enterpriseId);

    ParkEnterpriseDO getOrg(Integer enterpriseId);

    Page<ParkEnterpriseBO> listByPage(@Param("name") String name,
                                      @Param("orgId") Integer orgId,
                                      @Param("startTime") LocalDateTime startTime,
                                      @Param("endTime") LocalDateTime endTime,
                                      @Param("pageNo") int pageNo,
                                      @Param("pageSize") int pageSize);

    int batchInsertOnConflictIgnore(List<ParkEnterpriseDO> parkEnterprises);

    ParkEnterpriseFeeBO getParkEnterpriseFee(int id);

    int delete(int id);

    int updateFeeSetting(ParkEnterpriseFeeBO parkEnterprise);

    Page<EnterpriseFeeBO> listEnterpriseForFee(@Param("name") String name,
                                               @Param("providerId") Integer providerId,
                                               @Param("distributorId") Integer distributorId,
                                               @Param("pageNo") Integer pageNo,
                                               @Param("pageSize") Integer pageSize);

    List<EnterpriseFeeBO> listEnterpriseForFeeWithoutPage(@Param("name") String name,
                                           @Param("providerId") Integer providerId,
                                           @Param("distributorId") Integer distributorId);
}