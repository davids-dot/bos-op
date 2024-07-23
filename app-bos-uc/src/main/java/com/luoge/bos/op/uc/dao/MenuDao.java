package com.luoge.bos.op.uc.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.luoge.bos.op.core.BOSConsts;
import com.luoge.bos.op.uc.entity.MenuDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@DS(BOSConsts.DataSource.BOS_UC)
@Mapper
public interface MenuDao {
    List<MenuDO> list();
}
