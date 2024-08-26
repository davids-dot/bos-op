package com.luoge.bos.uc.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.luoge.bos.data.PermissionDao;
import com.luoge.bos.data.RoleDao;
import com.luoge.bos.data.entity.RoleDO;
import com.luoge.bos.data.entity.RolePermissionDO;
import com.luoge.bos.data.model.PermissionVO;
import com.luoge.bos.data.model.RoleVO;
import com.luoge.bos.uc.core.Constants;
import com.luoge.bos.uc.core.UCCode;
import com.luoge.bos.uc.model.role.RoleCreateBO;
import com.luoge.bos.uc.model.role.RoleUpdateBO;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class RoleService {

    @Resource
    private RoleDao roleDao;

    @Resource
    private PermissionDao permissionDao;

    public List<RoleVO> listRoles(int orgId) {
        var roles = roleDao.list(orgId);
        var roleIds = roles.stream().map(RoleVO::getId).collect(Collectors.toList());
        if (CollectionUtil.isNotEmpty(roleIds)) {
            var rolePermissions = roleDao.listRolePermissions(orgId, roleIds);
            var rolePermissionsMap = rolePermissions.stream()
                    .collect(Collectors.groupingBy(RolePermissionDO::getRoleId,
                            Collectors.mapping(RolePermissionDO::getPermissionCode, Collectors.toList())));
            for (var role : roles) {
                role.setPermissions(rolePermissionsMap.get(role.getId()));
            }
        }
        return roles;
    }

    @Transactional
    public R<Void> insertRole(int orgId, RoleCreateBO role) {
        RoleDO existRoleDO = roleDao.getByName(orgId, role.getName());
        if (Objects.nonNull(existRoleDO)) {
            return R.fail(UCCode.ROLE_NAME_EXIST);
        }
        Date now = new Date();
        RoleDO roleDO = new RoleDO();
        BeanUtils.copyProperties(role, roleDO);
        roleDO.setOrgId(orgId);
        roleDO.setCreateTime(now);
        roleDO.setUpdateTime(now);
        roleDao.insert(roleDO);
        // 插入权限
        roleDao.insertRolePermissions(orgId, roleDO.getId(), role.getPermissions(), now);
        return R.SUCCESS;
    }

    public R<Void> updateRole(int orgId, RoleUpdateBO roleBO) {
        RoleDO existRoleDO = roleDao.getByName(orgId, roleBO.getName());
        if (Objects.nonNull(existRoleDO) && !Objects.equals(roleBO.getId(), existRoleDO.getId())) {
            return R.fail(UCCode.ROLE_NAME_EXIST);
        }

        RoleDO roleDO = new RoleDO();
        BeanUtils.copyProperties(roleBO, roleDO);
        roleDO.setOrgId(orgId);
        roleDO.setUpdateTime(new Date());
        roleDao.update(roleDO);
        return R.SUCCESS;
    }

    @Transactional
    public void deleteRole(int orgId, int roleId) {
        roleDao.delete(orgId, roleId);
        roleDao.deleteRoleUser(orgId, roleId);
        roleDao.deleteRolePermissions(orgId, roleId);
    }

    @Transactional
    public void setRolePermissions(int orgId, int roleId, List<String> permissions) {
        roleDao.deleteRolePermissions(orgId, roleId);
        if (ObjectUtil.isNotEmpty(permissions)) {
            roleDao.insertRolePermissions(orgId, roleId, permissions, new Date());
        }
    }

    public List<PermissionVO> listPermissions() {
        var permissions = permissionDao.list();
        permissions.forEach(permission -> {
            var children = permissions.stream()
                    .filter(item -> item.getLevel() == permission.getLevel() + 1 && item.getCode().startsWith(permission.getCode()))
                    .collect(Collectors.toList());
            if (CollectionUtil.isNotEmpty(children)) {
                permission.setChildren(children);
            }
        });

        // 排序
        sortPermissions(permissions);
        return permissions.stream()
                .filter(permission -> Constants.ONE == permission.getLevel())
                .collect(Collectors.toList());
    }


    private void sortPermissions(List<PermissionVO> permissions) {
        if (permissions.isEmpty()) {
            return;
        }
        permissions.sort(Comparator.comparingInt(PermissionVO::getSeq));
        permissions.stream().filter(m -> !Objects.isNull(m.getChildren())).forEach(m -> sortPermissions(m.getChildren()));
    }
}
