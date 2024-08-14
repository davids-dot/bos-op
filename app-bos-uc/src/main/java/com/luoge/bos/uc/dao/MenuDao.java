package com.luoge.bos.uc.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.luoge.bos.core.BOSConsts;
import com.luoge.bos.uc.entity.MenuDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@DS(BOSConsts.DataSource.BOS_UC)
@Mapper
public interface MenuDao {
    List<MenuDO> list();
}
