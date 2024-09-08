package com.luoge.bos.invoice.org;

import com.baomidou.dynamic.datasource.annotation.DSTransactional;
import com.luoge.bos.core.BosAppCode;
import com.luoge.bos.core.model.PageQuery;
import com.luoge.bos.core.utils.DateUtil;
import com.luoge.bos.core.utils.EncryptUtil;
import com.luoge.bos.data.OrgDao;
import com.luoge.bos.data.UserDao;
import com.luoge.bos.data.entity.OrgDO;
import com.luoge.bos.data.entity.UserDO;
import com.luoge.bos.data.model.EnterpriseCountBO;
import com.luoge.bos.invoice.model.org.OrgBO;
import com.luoge.bos.invoice.model.org.OrgDetailBO;
import com.luoge.bos.data.EnterpriseDao;
import com.luoge.bos.invoice.util.ParamValidator;
import com.luoge.ns.core.Page;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class OrgService {

    @Resource
    private OrgDao orgDao;

    @Resource
    private EnterpriseDao enterpriseDao;

    @Resource
    private UserDao userDao;

    public Page<OrgBO> listOrg(String name, PageQuery pageQuery) {
        List<EnterpriseCountBO> enterpriseCountBOS = enterpriseDao.listCount();
        var orgDOPage = orgDao.listByPage(name, pageQuery.getPageNo(), pageQuery.getPageSize());

        List<OrgBO> orgBOS = new ArrayList<>();

        for (var orgDO : orgDOPage.getResult()) {

            var bo = toOrgBO(orgDO);
            bo.setEnterpriseCount(findEnterpriseCount(orgDO.getId(), enterpriseCountBOS));
            orgBOS.add(bo);
        }

        return new Page<>(orgDOPage.getTotal(), orgBOS);
    }

    private OrgBO toOrgBO(OrgDO orgDO) {
        return new OrgBO()
                .setId(orgDO.getId())
                .setName(orgDO.getName())
                .setRemark(orgDO.getRemark())
                .setCreateTime(DateUtil.toTimeMills(orgDO.getCreateTime()));
    }

    public List<OrgBO> listOrg() {
        List<OrgDO> orgList = orgDao.listAll();
        return orgList.stream()
                .map(this::toOrgBO)
                .collect(Collectors.toList());
    }

    /**
     * 从 enterpriseCountBOS 列表中根据orgId 找出对应org 的count值
     *
     * @param orgId              机构id
     * @param enterpriseCountBOS org 和 count 信息的列表
     */
    private Integer findEnterpriseCount(Integer orgId, List<EnterpriseCountBO> enterpriseCountBOS) {
        for (var enterpriseCountBO : enterpriseCountBOS) {
            if (Objects.equals(enterpriseCountBO.getOrgId(), orgId)) {
                return enterpriseCountBO.getCount();
            }
        }
        return null;
    }

    public OrgDetailBO getOrgDetail(Integer orgId) {
        OrgDO orgDO = orgDao.getOrg(orgId);
        UserDO userDO = userDao.getUser(orgId, 1);
        OrgDetailBO orgDetailBO = new OrgDetailBO()
                .setId(orgDO.getId())
                .setName(orgDO.getName())
                .setRemark(orgDO.getRemark());

        if (userDO != null) {
            orgDetailBO.setAdminName(userDO.getName())
                    .setAdminPhone(userDO.getMobile())
                    .setAdminEmail(userDO.getEmail())
                    .setAdminAccount(userDO.getUsername())
                    .setAdminPassword(userDO.getPasswd());
        }
        return orgDetailBO;
    }

    @DSTransactional
    public R<Void> insertOrg(OrgDetailBO orgBO) {
        if (orgDao.existName(orgBO.getName())) {
            return R.fail(BosAppCode.EXIST_ORG_NAME);
        }

        if (userDao.existName(orgBO.getAdminAccount())) {
            return R.fail(BosAppCode.EXIST_USER_NAME);
        }

        UserDO existUser = userDao.getByMobile(orgBO.getAdminPhone());
        if (Objects.nonNull(existUser)) {
            return R.fail(BosAppCode.INVALID_MOBILE);
        }
        String email = orgBO.getAdminEmail();
        if (StringUtils.isNotBlank(email)) {
            if (!ParamValidator.validateEmail(email)) {
                return R.fail(BosAppCode.EMAIL_FORMAT_ERROR);
            }
            existUser = userDao.getByEmail(email);
            if (Objects.nonNull(existUser)) {
                return R.fail(BosAppCode.EMAIL_EXIST);
            }
        }

        OrgDO orgDO = toOrgDO(orgBO);
        orgDao.insert(orgDO);

        UserDO userDO = toUserDO(orgBO);
        // 密码加密存储
        userDO.setOrgId(orgDO.getId());
        userDao.insert(userDO);

        return R.SUCCESS;
    }

    public OrgDO toOrgDO(OrgDetailBO orgDetailBO) {
        LocalDateTime now = DateUtil.nowTime();
        return new OrgDO()
                .setId(orgDetailBO.getId())
                .setName(orgDetailBO.getName())
                .setRemark(orgDetailBO.getRemark())
                .setCreateTime(now)
                .setUpdateTime(now);
    }

    public UserDO toUserDO(OrgDetailBO orgDetailBO) {
        LocalDateTime now = DateUtil.nowTime();
        return new UserDO()
                .setOrgId(orgDetailBO.getId())
                .setName(orgDetailBO.getAdminName())
                .setMobile(orgDetailBO.getAdminPhone())
                .setEmail(StringUtils.isBlank(orgDetailBO.getAdminEmail()) ? null : orgDetailBO.getAdminEmail())
                .setUsername(orgDetailBO.getAdminAccount())
                .setPasswd(StringUtils.isBlank(orgDetailBO.getAdminPassword()) ? StringUtils.EMPTY : EncryptUtil.crypt(orgDetailBO.getAdminPassword()))
                .setStatus(1)
                .setAdmin(true)
                .setCreateTime(now)
                .setUpdateTime(now);
    }


    @DSTransactional
    public R<Void> updateOrg(OrgDetailBO orgBO) {
        int orgId = orgBO.getId();
        OrgDO existOrgDO = orgDao.getByName(orgBO.getName());
        if (Objects.nonNull(existOrgDO) && !Objects.equals(existOrgDO.getId(), orgId)) {
            return R.fail(BosAppCode.EXIST_ORG_NAME);
        }

        UserDO currUser = userDao.getUser(orgId, 1);
        UserDO existUser = userDao.getByName(orgBO.getAdminAccount());
        if (Objects.nonNull(existUser) && !Objects.equals(existUser.getId(), currUser.getId())) {
            return R.fail(BosAppCode.EXIST_USER_NAME);
        }
        existUser = userDao.getByMobile(orgBO.getAdminPhone());
        if (Objects.nonNull(existUser) && !Objects.equals(existUser.getId(), currUser.getId())) {
            return R.fail(BosAppCode.INVALID_MOBILE);
        }

        String email = orgBO.getAdminEmail();
        if (StringUtils.isNotBlank(email)) {
            if (!ParamValidator.validateEmail(email)) {
                return R.fail(BosAppCode.EMAIL_FORMAT_ERROR);
            }
            existUser = userDao.getByEmail(orgBO.getAdminEmail());
            if (Objects.nonNull(existUser) && !Objects.equals(existUser.getId(), currUser.getId())) {
                return R.fail(BosAppCode.EMAIL_EXIST);
            }
        }

        OrgDO orgDO = toOrgDO(orgBO);
        orgDao.update(orgDO);

        UserDO userDO = toUserDO(orgBO);
        userDao.update(userDO);
        return R.SUCCESS;
    }


    public void resetAdminPasswd(Integer id, String adminPassword) {
        userDao.resetPassword(id, EncryptUtil.crypt(adminPassword));
    }

}
