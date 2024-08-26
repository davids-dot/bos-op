package com.luoge.bos.data;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.luoge.bos.core.BOSConsts;
import com.luoge.bos.data.model.PermissionMenuBO;
import com.luoge.bos.data.model.PermissionResourceBO;
import com.luoge.bos.data.model.PermissionVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@DS(BOSConsts.DataSource.BOS_UC)
@Mapper
public interface PermissionDao {
    List<PermissionVO> list();

    List<PermissionMenuBO> listPermissionMenus();

    List<PermissionResourceBO> listPermissionResources();
}
