package com.luoge.bos.data;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.luoge.bos.core.BOSConsts;
import com.luoge.bos.data.entity.PermissionDO;
import com.luoge.bos.data.model.PermissionMenuBO;
import com.luoge.bos.data.model.PermissionResourceBO;
import com.luoge.bos.data.model.PermissionVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


@DS(BOSConsts.DataSource.BOS_UC)
@Mapper
public interface PermissionDao {
    List<PermissionVO> list();

    List<PermissionMenuBO> listPermissionMenus();

    List<PermissionResourceBO> listPermissionResources();



    List<PermissionDO> listWithMenus();

    List<PermissionDO> listWithResources();

    int getMaxSeq(int parentId);

    void insert(PermissionDO permission);

    void update(PermissionDO permission);

    void delete(int id);

    void deletePermissionMenu(int permissionId);

    void deletePermissionResource(int permissionId);

    void deletePermissionRole(int permissionId);

    void insertPermissionResources(@Param("permissionId") int permissionId,
                                   @Param("resourceIds") List<Integer> resourceIds,
                                   @Param("now") Date now);

    void insertPermissionMenus(@Param("permissionId") int permissionId,
                               @Param("menuIds") List<Integer> menuIds,
                               @Param("now") Date now);
}
