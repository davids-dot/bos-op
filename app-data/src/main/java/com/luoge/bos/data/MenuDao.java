package com.luoge.bos.data;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.luoge.bos.core.BOSConsts;

import com.luoge.bos.data.entity.MenuDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@DS(BOSConsts.DataSource.BOS_UC)
@Mapper
public interface MenuDao {
    List<MenuDO> list();
}
