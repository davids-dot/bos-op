package com.luoge.bos.op.invoice.park.provider;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.github.pagehelper.Page;
import com.luoge.bos.op.core.BOSConsts;
import com.luoge.bos.op.invoice.entity.ParkProviderDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@DS(BOSConsts.DataSource.INVOICE)
@Mapper
public interface ParkProviderDao {
    int insert(ParkProviderDO row);

    void update(ParkProviderDO parkProviderDO);

    Page<ParkProviderDO> list(@Param("name") String name,
                              @Param("pageNo") Integer pageNo,
                              @Param("pageSize") Integer pageSize);

    ParkProviderDO get(Integer id);

    void updateStatus(@Param("id") Integer id, @Param("status") Integer status);

    boolean existName(String name);

    ParkProviderDO getByName(String name);

    List<ParkProviderDO> listAll();

    List<ParkProviderDO> listByStatus(Integer status);

}