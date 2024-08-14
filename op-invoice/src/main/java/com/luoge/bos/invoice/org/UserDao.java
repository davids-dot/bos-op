package com.luoge.bos.invoice.org;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.luoge.bos.core.BOSConsts;
import com.luoge.bos.invoice.entity.uc.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@DS(BOSConsts.DataSource.UC)
@Mapper
public interface UserDao {

    UserDO getUser(@Param("id") Integer orgId, @Param("admin") Integer admin);

    void insert(UserDO userDO);

    void update(UserDO userDO);

    boolean existName(String adminAccount);

    UserDO getByName(String adminAccount);

    UserDO getByMobile(@Param("mobile") String adminPhone);

    UserDO getByEmail(@Param("email") String adminEmail);

    int resetPassword(@Param("orgId") Integer id, @Param("passwd") String adminPassword);
}