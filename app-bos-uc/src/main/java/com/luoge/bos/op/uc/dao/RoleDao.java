package com.luoge.bos.op.uc.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.luoge.bos.op.core.BOSConsts;
import com.luoge.bos.op.uc.entity.RoleDO;
import com.luoge.bos.op.uc.entity.RolePermissionDO;
import com.luoge.bos.op.uc.model.role.RoleVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@DS(BOSConsts.DataSource.BOS_UC)
@Mapper
public interface RoleDao {

    List<RoleVO> list(int orgId);

    void insert(RoleDO roleDO);

    void update(RoleDO roleDO);

    void delete(@Param("orgId") int orgId,
                @Param("id") int roleId);

    void deleteRoleUser(@Param("orgId") int orgId,
                        @Param("roleId") int roleId);

    List<RolePermissionDO> listRolePermissions(@Param("orgId") int orgId,
                                               @Param("roleIds") List<Integer> roleIds);

    void deleteRolePermissions(@Param("orgId") int orgId,
                               @Param("roleId") int roleId);

    void insertRolePermissions(@Param("orgId") int orgId,
                               @Param("roleId") int roleId,
                               @Param("permissions") List<String> permissions,
                               @Param("createTime") Date createTime);

    RoleDO getByName(@Param("orgId") int orgId, @Param("name") String name);
}
