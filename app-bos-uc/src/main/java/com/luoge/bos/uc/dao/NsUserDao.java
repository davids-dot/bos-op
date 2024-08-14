package com.luoge.bos.uc.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.luoge.bos.core.BOSConsts;
import com.luoge.bos.uc.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@DS(BOSConsts.DataSource.UC)
@Mapper
public interface NsUserDao {

    List<UserDO> list(@Param("orgId") int orgId, @Param("name") String name);

    int insert(UserDO user);

    int update(UserDO user);

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
                                     @Param("roles") List<Integer> roles);

    UserDO getByUsername(String username);

    UserDO getByMobile(String mobile);

    UserDO getByEmail(String email);

    UserDO get(@Param("orgId") int orgId, @Param("userId") int userId);

    UserDO getById(@Param("userId") int userId);
}
