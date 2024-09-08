package com.luoge.bos.data;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.luoge.bos.core.BOSConsts;
import com.luoge.bos.data.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

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

    int insertAdmin(UserDO user);


    int resetPasswd(@Param("orgId") int orgId,
                    @Param("userId") int userId,
                    @Param("passwd") String passwd);

    void updateStatus(@Param("orgId") int orgId,
                      @Param("userId") int userId,
                      @Param("status") int status);

    void deleteUserRoles(@Param("orgId") int orgId,
                         @Param("userId") int userId);

    void insertUserRoles(@Param("orgId") int orgId,
                         @Param("userId") int userId,
                         @Param("roleIds") List<Integer> roleIds,
                         @Param("createTime") Date createTime);

    List<Integer> listUserRoles(@Param("orgId") int orgId,
                                @Param("userId") int userId);

    List<String> listUserPermissions(@Param("orgId") int orgId,
                                     @Param("userId") int userId);

    UserDO getByUsername(String username);

    UserDO get(@Param("orgId") int orgId, @Param("userId") int userId);

    UserDO getById(@Param("userId") int userId);
}