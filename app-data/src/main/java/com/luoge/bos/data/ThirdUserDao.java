package com.luoge.bos.data;

import com.luoge.bos.data.entity.ThirdUserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ThirdUserDao {
    /**
     * 根据小程序openId 获取用户
     */
    ThirdUserDO getByOpenId(@Param("openId") String openid,
                            @Param("type") int type,
                            @Param("appId") String appId);


    List<ThirdUserDO> getByUnionId(@Param("unionId") String unionId,
                                   @Param("type") int type);

    void saveOrDoNothing(@Param("thirdUser") ThirdUserDO thirdUserDO);

    ThirdUserDO getByUserId(@Param("userId") Integer id,
                            @Param("type") int type,
                            @Param("appId") String appId);

    int deleteByOpenId(@Param("type") int type,
                       @Param("appId") String appId,
                       @Param("openId") String openId);

//    List<EnterpriseUser> listEnterpriseUserStatus(@Param("orgId") int orgId,
//                                                  @Param("userIds") List<Integer> userIds,
//                                                  @Param("appId") String appId);

    int updateUserIdByUnionId(@Param("userId") int userId, @Param("unionId") String unionId);
}