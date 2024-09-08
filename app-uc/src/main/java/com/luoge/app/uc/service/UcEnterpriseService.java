package com.luoge.app.uc.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.luoge.app.uc.model.EnterpriseBO;
import com.luoge.app.uc.model.ListEnterpriseBO;
import com.luoge.app.uc.model.SaveEnterpriseBO;
import com.luoge.bos.core.utils.DateUtil;
import com.luoge.bos.core.utils.StrUtil;
import com.luoge.bos.data.EnterpriseDao;
import com.luoge.bos.data.entity.EnterpriseDO;
import com.luoge.bos.data.entity.UserDO;
import com.luoge.ns.core.Page;
import com.luoge.ns.core.R;
import com.luoge.ns.uc.core.AppID;
import com.luoge.ns.uc.core.EnterpriseType;
import com.luoge.ns.uc.core.UCCode;
import com.luoge.ns.uc.model.Enterprise;
import jakarta.annotation.Resource;
import jakarta.validation.Validator;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UcEnterpriseService {
    private static final Logger log = LoggerFactory.getLogger(UcEnterpriseService.class);

    @Resource
    private EnterpriseDao enterpriseDao;
    @Resource
    private TransactionTemplate transactionTemplate;
    //    @Resource
//    private ThirdEnterpriseConfig thirdEnterpriseConfig;
//    @Resource
//    private CommonService commonService;
    @Resource
    private Validator validator;

//    /**
//     * 企业管理-查询企业列表
//     *
//     * @param orgId 机构
//     * @param query 查询条件
//     * @return 企业列表
//     */
//    public Page<EnterpriseBO> listEnterprises(int orgId, ListEnterpriseBO query) {
//        query.check();
//        var page = enterpriseDao.listEnterprises(orgId, query, query.getPageNo(), query.getPageSize());
//        if (page == null || page.isEmpty()) {
//            return new Page<>(0, Collections.emptyList());
//        }
//        return new Page<>(page.getTotal(), page.getResult());
//    }
//
//    /**
//     * 查询用户选择的企业信息
//     *
//     * @param orgId        机构
//     * @param userId       用户
//     * @param enterpriseId 企业ID
//     * @return 企业信息
//     */
    public EnterpriseBO getSelectedEnterprise(int orgId, int userId, int enterpriseId) {
        return toEnterpriseBO(enterpriseDao.get(orgId, enterpriseId));
    }

    /**
     * 查询当前用户可选择的企业列表
     * 查询合并发票、风控企业信息
     * @return 可选择的企业列表
     */
//    public List<EnterpriseSelectBO> listUserEnterprises(int orgId, Integer userId, String name) {
//        var enterprises = enterpriseDao.listUserEnterprises(orgId, userId, name);
//        if (enterprises == null) {
//            return Collections.emptyList();
//        }
//
//        return enterprises.stream()
//                .map(this::toEnterpriseSelectBO).toList();
//    }

//    /**
//     * 新增企业
//     *
//     * @param orgId      机构id
//     * @param enterprise 企业信息
//     * @return 新增企业
//     */
//    @Transactional
//    public R<EnterpriseDO> insertEnterprise(int orgId, SaveEnterpriseBO enterprise) {
//        // 校验
//        R<Void> checkR = checkSaveEnterprise(enterprise);
//        if (checkR.failed()) {
//            return R.fail(checkR);
//        }
//
//        var existEnterprise = enterpriseDao.getByTaxNo(orgId, enterprise.getTaxNo());
//        if (Objects.nonNull(existEnterprise)) {
//            return R.fail(UCCode.DUPLICATE_TAX_NO);
//        }
//
//        LocalDateTime now = LocalDateTime.now();
//        EnterpriseDO enterpriseDO = new EnterpriseDO();
//        BeanUtils.copyProperties(enterprise, enterpriseDO);
//        enterpriseDO.setBank(enterprise.getBankName());
//        enterpriseDO.setAccount(enterprise.getBankAccount());
//        enterpriseDO.setOrgId(orgId);
//        enterpriseDO.setCreateTime(now);
//        enterpriseDO.setUpdateTime(now);
//        enterpriseDao.insertEnterprise(enterpriseDO);
//
//        return R.success(enterpriseDO);
//    }
    public R<EnterpriseDO> updateEnterprise(int orgId, SaveEnterpriseBO enterprise) {
        // 校验
        R<Void> checkR = checkSaveEnterprise(enterprise);
        if (checkR.failed()) {
            return R.fail(checkR);
        }

        // 根据id查询企业
        EnterpriseDO existEnterprise = enterpriseDao.get(orgId, enterprise.getId());
        if (existEnterprise == null) {
            return R.fail(UCCode.ENTERPRISE_NOT_EXIST);
        }

        // 查询同税号企业，如果存在，并且不是当前企业，则提示重复
        var sameEnterprise = enterpriseDao.getByTaxNo(orgId, enterprise.getTaxNo());
        if (sameEnterprise != null && !Objects.equals(existEnterprise.getId(), sameEnterprise.getId())) {
            return R.fail(UCCode.DUPLICATE_TAX_NO);
        }

        existEnterprise.setName(enterprise.getName())
                .setTaxNo(enterprise.getTaxNo())
                .setRemark(enterprise.getRemark())
                .setUpdateTime(LocalDateTime.now());
        // 兼容原有修改逻辑
        if (StrUtil.isNotBlank(enterprise.getRegionCode())) {
            existEnterprise.setRegionCode(enterprise.getRegionCode());
        }
        if (ObjectUtil.isNotNull(enterprise.getType())) {
            existEnterprise.setType(enterprise.getType());
        }
        if (StrUtil.isNotBlank(enterprise.getUpstreamUsername())) {
            existEnterprise.setUpstreamUsername(enterprise.getUpstreamUsername());
        }
        if (StrUtil.isNotBlank(enterprise.getUpstreamPasswd())) {
            existEnterprise.setUpstreamPasswd(enterprise.getUpstreamPasswd());
        }
        // 如果是云票
        if (enterprise.getAppId() == AppID.INVOICE.getId()) {
            existEnterprise.setBank(enterprise.getBankName())
                    .setAccount(enterprise.getBankAccount())
                    .setAddress(enterprise.getAddress())
                    .setPhone(enterprise.getPhone())
                    .setBureauIdentityType(enterprise.getBureauIdentityType());
        }

        if (enterprise.getAppId() == AppID.RISK.getId()) {
            existEnterprise.setIndustryCode(enterprise.getIndustryCode());
        }
        enterpriseDao.updateEnterprise(existEnterprise);
        return R.success(existEnterprise);
    }
//
//    public List<EnterpriseDO> listEnterpriseByIds(int orgId, List<Integer> ids) {
//        return enterpriseDao.listByIds(orgId, ids);
//    }
//
//    public void setStatus(int orgId, int id, int status) {
//        enterpriseDao.setStatus(orgId, id, status);
//    }

//    @Transactional
//    public void bindEnterpriseUsers(int orgId, Integer enterpriseId, List<Integer> userIds) {
//        enterpriseDao.deleteEnterpriseUsers(orgId, enterpriseId);
//        if (CollectionUtil.isNotEmpty(userIds)) {
//            enterpriseDao.insertEnterpriseUsers(orgId, enterpriseId, userIds, DateUtil.nowTime());
//        }
//    }
//
//    public List<Integer> listEnterpriseUserIds(int orgId, int enterpriseId, String name) {
//        List<UserDO> users = enterpriseDao.listEnterpriseUsers(orgId, enterpriseId, name);
//        return users.stream().map(UserDO::getId).collect(Collectors.toList());
//    }
//
//    public List<UserDO> listEnterpriseUsers(int orgId, int enterpriseId, String name) {
//        return enterpriseDao.listEnterpriseUsers(orgId, enterpriseId, name);
//    }
//
//    private EnterpriseSelectBO toEnterpriseSelectBO(EnterpriseBO enterpriseDO) {
//        return new EnterpriseSelectBO()
//                .setId(enterpriseDO.getId())
//                .setName(enterpriseDO.getName())
//                .setType(enterpriseDO.getType())
//                .setAddress(enterpriseDO.getAddress())
//                .setPhone(enterpriseDO.getPhone())
//                .setBankName(enterpriseDO.getBankName())
//                .setBankAccount(enterpriseDO.getBankAccount())
//                .setRegionCode(enterpriseDO.getRegionCode())
//                .setRegionName(enterpriseDO.getRegionName())
//                .setTaxNo(enterpriseDO.getTaxNo())
//                .setUpstreamUsername(enterpriseDO.getUpstreamUsername());
//    }

    private EnterpriseBO toEnterpriseBO(EnterpriseDO enterpriseDO) {
        return new EnterpriseBO()
                .setId(enterpriseDO.getId())
                .setName(enterpriseDO.getName())
                .setType(enterpriseDO.getType())
                .setTaxNo(enterpriseDO.getTaxNo())

                .setRegionCode(enterpriseDO.getRegionCode())
                .setBankName(enterpriseDO.getBank())
                .setBankAccount(enterpriseDO.getAccount())
                .setPhone(enterpriseDO.getPhone())
                .setAddress(enterpriseDO.getAddress())

                .setIndustryCode(enterpriseDO.getIndustryCode())

                .setUpstreamUsername(enterpriseDO.getUpstreamUsername())
                .setUpstreamPasswd(enterpriseDO.getUpstreamPasswd())
                .setBureauIdentityType(enterpriseDO.getBureauIdentityType())
                .setRemark(enterpriseDO.getRemark())
                .setCreateTime(enterpriseDO.getCreateTime())
                .setUpdateTime(enterpriseDO.getUpdateTime())
                ;
    }

    private EnterpriseBO toEnterpriseBO(Enterprise enterprise) {
        return new EnterpriseBO()
                .setId(enterprise.getId())
                .setName(enterprise.getName())
                .setType(Objects.nonNull(enterprise.getType()) ? enterprise.getType().getType() : null)
                .setTaxNo(enterprise.getTaxNo())

                .setRegionCode(enterprise.getRegionCode())
                .setRegionName(enterprise.getRegionName())
                .setBankName(enterprise.getBank())
                .setBankAccount(enterprise.getAccount())
                .setPhone(enterprise.getPhone())
                .setAddress(enterprise.getAddress())

                .setIndustryCode(enterprise.getIndustryCode())
                .setIndustryName(enterprise.getIndustryName())

                .setUpstreamUsername(enterprise.getUpstreamUsername())
                .setUpstreamPasswd(enterprise.getUpstreamPasswd())
                .setBureauIdentityType(enterprise.getBureauIdentityType())
                .setRemark(enterprise.getRemark());
    }


//    public R<Integer> saveOrUpdate(int orgId, int userId, Enterprise enterprise) {
//        if (ObjectUtil.isNull(enterprise.getId())) {
//            var existEnterprise = enterpriseDao.getByTaxNo(orgId, enterprise.getTaxNo());
//            if (Objects.nonNull(existEnterprise)) {
//                return R.fail(UCCode.DUPLICATE_TAX_NO);
//            }
//
//            return transactionTemplate.execute(status -> {
//                R<EnterpriseDO> inserR = insertEnterprise(orgId, toSaveEnterpriseBO(enterprise));
//                if (inserR.failed()) {
//                    status.setRollbackOnly();
//                    return R.fail(inserR);
//                }
//
//                EnterpriseDO enterpriseDO = inserR.getData();
//                //添加完企业 绑定企业用户
//                if (userId > 0 && ObjectUtil.isNull(enterpriseDao.checkEnterpriseUsersExist(orgId, userId, enterpriseDO.getId()))) {
//                    enterpriseDao.insertEnterpriseUsers(orgId, enterpriseDO.getId(), CollUtil.newArrayList(userId), DateUtil.nowTime());
//                }
//                return R.success(enterpriseDO.getId());
//            });
//        } else {
//            var existEnterprise = enterpriseDao.getByTaxNo(orgId, enterprise.getTaxNo());
//            if (Objects.nonNull(existEnterprise) && !Objects.equals(existEnterprise.getId(), enterprise.getId())) {
//                return R.fail(UCCode.DUPLICATE_TAX_NO);
//            }
//
//            return transactionTemplate.execute(status -> {
//                R<EnterpriseDO> updateR = updateEnterprise(orgId, toSaveEnterpriseBO(enterprise));
//                if (updateR.failed()) {
//                    status.setRollbackOnly();
//                    return R.fail(updateR);
//                }
//                return R.success(updateR.getData().getId());
//            });
//        }
//    }

    private SaveEnterpriseBO toSaveEnterpriseBO(Enterprise enterprise) {
        SaveEnterpriseBO saveEnterpriseBO = new SaveEnterpriseBO();
        saveEnterpriseBO.setAppId(enterprise.getAppId())
                .setId(enterprise.getId())
                .setName(enterprise.getName())
                .setType(enterprise.getType().getType())
                .setTaxNo(enterprise.getTaxNo())
                .setBankName(enterprise.getBank())
                .setBankAccount(enterprise.getAccount())
                .setAddress(enterprise.getAddress())
                .setPhone(enterprise.getPhone())
                .setRegionCode(enterprise.getRegionCode())
                .setIndustryCode(enterprise.getIndustryCode())
                .setRemark(enterprise.getRemark())
                .setUpstreamUsername(enterprise.getUpstreamUsername())
                .setUpstreamPasswd(enterprise.getUpstreamPasswd())
                .setBureauIdentityType(enterprise.getBureauIdentityType());
        return saveEnterpriseBO;
    }

//    public Enterprise toEnterprise(EnterpriseDO enterpriseDO) {
//        RegionDO region = commonService.getRegion(enterpriseDO.getRegionCode());
//        IndustryDO industry = commonService.getIndustry(enterpriseDO.getIndustryCode());
//
//        Enterprise enterprise = new Enterprise();
//        enterprise.setId(enterpriseDO.getId());
//        enterprise.setOrgId(enterpriseDO.getOrgId());
//        enterprise.setName(enterpriseDO.getName());
//        enterprise.setType(EnterpriseType.of(enterpriseDO.getType()));
//        enterprise.setTaxNo(enterpriseDO.getTaxNo());
//        enterprise.setRegionCode(enterpriseDO.getRegionCode());
//        enterprise.setRegionName(region != null ? region.getName() : null);
//        enterprise.setIndustryCode(enterpriseDO.getIndustryCode());
//        enterprise.setIndustryName(ObjectUtil.isEmpty(industry) ? null : industry.getName());
//        enterprise.setBank(enterpriseDO.getBank());
//        enterprise.setAccount(enterpriseDO.getAccount());
//        enterprise.setAddress(enterpriseDO.getAddress());
//        enterprise.setPhone(enterpriseDO.getPhone());
//        enterprise.setRemark(enterpriseDO.getRemark());
//        enterprise.setUpstreamUsername(enterpriseDO.getUpstreamUsername());
//        enterprise.setUpstreamPasswd(enterpriseDO.getUpstreamPasswd());
//        enterprise.setStatus(enterprise.getStatus());
//        enterprise.setIsLocal(enterprise.getIsLocal());
//        return enterprise;
//    }

    public Enterprise toEnterprise(EnterpriseBO enterpriseBO, boolean isLocal) {
        Enterprise enterprise = new Enterprise();
        enterprise.setId(enterpriseBO.getId());
        enterprise.setOrgId(enterpriseBO.getOrgId());
        enterprise.setName(enterpriseBO.getName());
        enterprise.setType(EnterpriseType.of(enterpriseBO.getType()));
        enterprise.setTaxNo(enterpriseBO.getTaxNo());
        enterprise.setRegionCode(enterpriseBO.getRegionCode());
        enterprise.setRegionName(enterpriseBO.getRegionName());
        enterprise.setIndustryCode(enterpriseBO.getIndustryCode());
        enterprise.setIndustryName(enterpriseBO.getIndustryName());
        enterprise.setBank(enterpriseBO.getBankName());
        enterprise.setAccount(enterpriseBO.getBankAccount());
        enterprise.setAddress(enterpriseBO.getAddress());
        enterprise.setPhone(enterpriseBO.getPhone());
        enterprise.setRemark(enterpriseBO.getRemark());
        enterprise.setUpstreamUsername(enterpriseBO.getUpstreamUsername());
        enterprise.setUpstreamPasswd(enterpriseBO.getUpstreamPasswd());
        enterprise.setStatus(enterpriseBO.getStatus());
        enterprise.setIsLocal(isLocal);
        return enterprise;
    }

//    public List<EnterpriseBO> listEnterpriseByKeywordAndScope(Integer orgId, Integer userId, String keyWord, Integer scope) {
//        List<Enterprise> enterpriseList = Collections.emptyList();
//        if (scope == 1) {
//            var enterprises = enterpriseDao.listUserEnterprises(orgId, userId, keyWord);
//            enterpriseList = enterprises.stream()
//                    .map(e -> toEnterprise(e, true))
//                    .toList();
//        }
//
//        if (scope == 2) {
//            enterpriseList = listEnterpriseAndSearchThird(orgId, userId, keyWord, true);
//        }
//
//        if (scope == 3) {
//            R<List<Enterprise>> listR = listThirdEnterprise(keyWord);
//            enterpriseList = listR.getData();
//        }
//
//        if (!CollectionUtils.isEmpty(enterpriseList)) {
//            return enterpriseList.stream().map(this::toEnterpriseBO).toList();
//        }
//
//        return Collections.emptyList();
//    }

//    /**
//     * 查询企业包含第三方企业查询
//     */
//    public List<Enterprise> listEnterpriseAndSearchThird(int orgId, int userId, String keyWord, boolean isThird) {
//        List<Enterprise> enterprises = enterpriseDao.listUserEnterprises(orgId, userId, keyWord)
//                .stream()
//                .map(e -> toEnterprise(e, true))
//                .collect(Collectors.toList());
//        if (isThird) {
//            R<List<Enterprise>> thirdEnterpriseR = listThirdEnterprise(keyWord);
//            //根据税号过滤掉本地已维护过的企业
//            if (thirdEnterpriseR.ok() && CollectionUtils.isNotEmpty(thirdEnterpriseR.getData())) {
//                List<Enterprise> thirdEnterprise = thirdEnterpriseR.getData();
//                Set<String> taxNo = enterprises.stream().map(Enterprise::getTaxNo).collect(Collectors.toSet());
//                thirdEnterprise = thirdEnterprise.stream().filter(item -> !taxNo.contains(item.getTaxNo())).toList();
//                enterprises.addAll(thirdEnterprise);
//            }
//        }
//        return enterprises;
//    }

    /**
     * 查询第三方企业
     */
//    public R<List<Enterprise>> listThirdEnterprise(String keyWord) {
//        Map<String, String> header = new HashMap<>();
//        header.put("appid", thirdEnterpriseConfig.getAppId());
//        header.put("secretkey", SecureUtil.sha256(thirdEnterpriseConfig.getSecretKey()));
//        Map<String, Object> data = new HashMap<>();
//        data.put("keywords", keyWord);
//        JSONObject resObj = HttpKit.get(thirdEnterpriseConfig.getUrl(), data, header, JSONObject.class);
//        if (Objects.isNull(resObj) || !Objects.equals("200", resObj.getString("code"))) {
//            log.error("查询第三方企业信息失败");
//            return R.fail(UCCode.SEARCH_CLOUD_ENTERPRISE_ERROR);
//        }
//
//        JSONArray resData = resObj.getJSONArray("data");
//        List<Enterprise> res = new ArrayList<>();
//        if (CollectionUtils.isNotEmpty(resData)) {
//            for (int i = 0; i < resData.size(); i++) {
//                JSONObject jsonObject = resData.getJSONObject(i);
//                Enterprise enterprise = new Enterprise();
//                enterprise.setTaxNo(jsonObject.getString("id"));
//                enterprise.setName(jsonObject.getString("qymc"));
//                enterprise.setIsLocal(false);
//                res.add(enterprise);
//            }
//        }
//        return R.success(res);
//    }
//    @Transactional
//    public R<Integer> removeEnterprise(int orgId, int enterpriseId) {
//        enterpriseDao.deleteEnterprise(orgId, enterpriseId);
//        enterpriseDao.deleteEnterpriseUsers(orgId, enterpriseId);
//        return R.success(enterpriseId);
//    }


    private R<Void> checkSaveEnterprise(SaveEnterpriseBO enterprise) {
        // 校验
        AppID appID = AppID.of(enterprise.getAppId());
        if (appID == null) {
            log.error("未知的appId");
            enterprise.setAppId(AppID.INVOICE.getId());
        }

        return R.SUCCESS;
    }
}
