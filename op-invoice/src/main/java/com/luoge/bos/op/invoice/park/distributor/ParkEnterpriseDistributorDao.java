package com.luoge.bos.op.invoice.park.distributor;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.github.pagehelper.Page;
import com.luoge.bos.op.core.BOSConsts;
import com.luoge.bos.op.invoice.entity.ParkEnterpriseDistributorDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@DS(BOSConsts.DataSource.INVOICE)
@Mapper
public interface ParkEnterpriseDistributorDao {

    void insert(ParkEnterpriseDistributorDO parkEnterpriseDistributorDO);

    void update(ParkEnterpriseDistributorDO parkEnterpriseDistributorDO);

    void updateStatus(@Param("id") Integer id, @Param("status") Integer status);

    Page<ParkEnterpriseDistributorDO> list(@Param("name") String name, @Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);

    ParkEnterpriseDistributorDO get(Integer id);

    boolean existName(String name);

    ParkEnterpriseDistributorDO getByName(String name);

    List<ParkEnterpriseDistributorDO> listAll();

    List<ParkEnterpriseDistributorDO> listByStatus(Integer status);

}
