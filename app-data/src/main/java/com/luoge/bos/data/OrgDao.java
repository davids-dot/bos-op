package com.luoge.bos.invoice.org;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.github.pagehelper.Page;
import com.luoge.bos.core.BOSConsts;
import com.luoge.bos.invoice.entity.uc.OrgDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@DS(BOSConsts.DataSource.UC)
@Mapper
public interface OrgDao {
    Page<OrgDO> listByPage(@Param("name") String name, @Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);

    OrgDO getOrg(Integer id);

    void insert(OrgDO orgDO);

    boolean existName(String name);

    void update(OrgDO orgDO);

    OrgDO getByName(String name);

    List<OrgDO> listAll();

    int countEnterprise(Integer orgId);

    void updateName(@Param("name") String name, @Param("id") Integer id, @Param("updateTime") LocalDateTime updateTime);
}