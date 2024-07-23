package com.luoge.bos.op.uc.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.luoge.bos.op.core.BOSConsts;
import com.luoge.bos.op.uc.model.permission.PermissionMenuBO;
import com.luoge.bos.op.uc.model.permission.PermissionResourceBO;
import com.luoge.bos.op.uc.model.permission.PermissionVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@DS(BOSConsts.DataSource.BOS_UC)
@Mapper
public interface PermissionDao {
    List<PermissionVO> list();

    List<PermissionMenuBO> listPermissionMenus();

    List<PermissionResourceBO> listPermissionResources();
}
