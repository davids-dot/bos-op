package com.luoge.bos.invoice.org.enterprise;

import cn.hutool.core.collection.CollectionUtil;
import com.luoge.bos.invoice.model.org.*;
import com.luoge.bos.invoice.park.enterprise.ParkEnterpriseDao;
import com.luoge.bos.core.BosAppCode;
import com.luoge.bos.core.model.PageQuery;
import com.luoge.bos.core.utils.DateUtil;
import com.luoge.bos.invoice.common.RegionDao;
import com.luoge.bos.invoice.entity.ParkEnterpriseDO;
import com.luoge.bos.invoice.entity.uc.EnterpriseDO;
import com.luoge.bos.invoice.entity.uc.OrgDO;
import com.luoge.bos.invoice.entity.uc.RegionDO;
import com.luoge.bos.invoice.org.OrgDao;
import com.luoge.ns.core.Page;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EnterpriseService {

    @Resource
    private EnterpriseDao enterpriseDao;
    @Resource
    private ParkEnterpriseDao parkEnterpriseDao;
    @Resource
    private RegionDao regionDao;
    @Resource
    private OrgDao orgDao;

    public Page<EnterpriseBO> listEnterprise(String name, Integer orgId, PageQuery pageQuery) {
        var enterpriseDOPage = enterpriseDao.listByPage(name, orgId, pageQuery.getPageNo(), pageQuery.getPageSize());

        List<EnterpriseBO> enterpriseBOS = new ArrayList<>();

        List<RegionDO> regionList = regionDao.list();

        for (var enterpriseDO : enterpriseDOPage.getResult()) {
            String regionCode = enterpriseDO.getRegionCode();
            RegionDO regionDO = find(regionList, regionCode);
            var bo = toEnterpriseBO(enterpriseDO, regionDO, null);
            enterpriseBOS.add(bo);
        }
        return new Page<>(enterpriseDOPage.getTotal(), enterpriseBOS);
    }

    private RegionDO find(List<RegionDO> regionList, String regionCode) {
        for (var region : regionList) {
            if (region.getCode().equals(regionCode)) {
                return region;
            }
        }
        return null;
    }

    public Page<EnterpriseBO> listParkEnterpriseSource(Integer orgId, String name, PageQuery pageQuery) {
        List<ParkEnterpriseDO> parkEnterprises = parkEnterpriseDao.list();
        List<Integer> enterpriseIds = parkEnterprises.stream().map(ParkEnterpriseDO::getEnterpriseId)
                .toList();

        var enterprises = enterpriseDao.listNotParkEnterprise(orgId, name, enterpriseIds,
                pageQuery.getPageNo(), pageQuery.getPageSize());

        List<OrgDO> orgList = orgDao.listAll();

        List<EnterpriseBO> results = enterprises.stream()
                .map(x -> toEnterpriseBO(x, null,orgList))
                .toList();
        return new Page<>(enterprises.getTotal(), results);
    }

    private EnterpriseBO toEnterpriseBO(EnterpriseDO enterpriseDO, RegionDO regionDO, List<OrgDO> orgList) {
        OrgDO orgDO = CollectionUtils.isNotEmpty(orgList) ? findOrg(orgList,enterpriseDO.getOrgId()) : null;
        return new EnterpriseBO()
                .setId(enterpriseDO.getId())
                .setOrgId(enterpriseDO.getOrgId())
                .setOrgName(Objects.nonNull(orgDO) ? orgDO.getName() : "")
                .setName(enterpriseDO.getName())
                .setRegionName(Objects.nonNull(regionDO) ? regionDO.getName() : "")
                .setTaxNo(enterpriseDO.getTaxNo())
                .setType(enterpriseDO.getType())
                .setRegion(enterpriseDO.getRegionCode())
                .setStatus(enterpriseDO.getStatus())
                .setCreateTime(DateUtil.toTimeMills(enterpriseDO.getCreateTime()));
    }

    private OrgDO findOrg(List<OrgDO> orgList, Integer orgId) {
        for (var org : orgList) {
            if (org.getId().equals(orgId)) {
                return org;
            }
        }
        return null;
    }

    public R<Void> insertEnterprise(EnterpriseDetailBO enterpriseDetailBO) {
        if (enterpriseDao.existName(enterpriseDetailBO.getOrgId(), enterpriseDetailBO.getName())) {
            return R.fail(BosAppCode.EXIST_ENTERPRISE_NAME);
        }
        EnterpriseDO existEnterprise = enterpriseDao.getByTaxNo(enterpriseDetailBO.getOrgId(), enterpriseDetailBO.getTaxNo());
        if (Objects.nonNull(existEnterprise)) {
            return R.fail(BosAppCode.EXIST_TAX_NO);
        }
        EnterpriseDO enterpriseDO = toEnterpriseDO(enterpriseDetailBO);
        enterpriseDao.insert(enterpriseDO);
        return R.SUCCESS;
    }

    public R<Void> updateEnterprise(EnterpriseDetailBO enterpriseDetailBO) {
        int id = enterpriseDetailBO.getId();
        EnterpriseDO existEnterpriseDO = enterpriseDao.getByName(enterpriseDetailBO.getOrgId(), enterpriseDetailBO.getName());
        if (Objects.nonNull(existEnterpriseDO) && !Objects.equals(existEnterpriseDO.getId(), id)) {
            return R.fail(BosAppCode.EXIST_ENTERPRISE_NAME);
        }
        existEnterpriseDO = enterpriseDao.getByTaxNo(enterpriseDetailBO.getOrgId(), enterpriseDetailBO.getTaxNo());
        if (Objects.nonNull(existEnterpriseDO) && !Objects.equals(existEnterpriseDO.getId(), id)) {
            return R.fail(BosAppCode.EXIST_TAX_NO);
        }
        EnterpriseDO enterpriseDO = toEnterpriseDO(enterpriseDetailBO);
        enterpriseDao.update(enterpriseDO);
        return R.SUCCESS;
    }

    public List<IndustryBO> listIndustries() {
        var industryDOS = enterpriseDao.listIndustries();
        if (CollectionUtil.isEmpty(industryDOS)) {
            return Collections.emptyList();
        }

        var industries = industryDOS.stream()
                .map(industry -> new IndustryBO()
                        .setValue(industry.getCode())
                        .setLabel(industry.getName())
                        .setSelectable(true)).toList();
        buildIndustryTree(industries);
        return industries.stream().filter(industryBO -> industryBO.getValue().length() == 1).toList();
    }

    private void buildIndustryTree(List<IndustryBO> industries) {
        industries.forEach(industry -> {
            var len = industry.getValue().length();
            if (len == 1) {
                var children = industries.stream()
                        .filter(item -> item.getValue().length() == 3 && item.getValue().substring(0, 1).equals(industry.getValue())).toList();
                industry.setSelectable(false);
                industry.setChildren(children);
            } else if (len == 3) {
                var children = industries.stream()
                        .filter(item -> item.getValue().length() == 4 && item.getValue().substring(0, 3).equals(industry.getValue())).toList();
                industry.setSelectable(false);
                industry.setChildren(children);
            } else if (len == 4) {
                var children = industries.stream()
                        .filter(item -> item.getValue().length() == 5 && item.getValue().substring(0, 4).equals(industry.getValue())).toList();
                industry.setSelectable(false);
                industry.setChildren(children);
            }
        });
    }

    public void updateEnterpriseStatus(UpdateEnterpriseStatusBO updateEnterpriseStatusBO) {
        enterpriseDao.updateStatus(updateEnterpriseStatusBO.getEnterpriseId(), updateEnterpriseStatusBO.getStatus());
    }

    public EnterpriseDO toEnterpriseDO(EnterpriseDetailBO enterpriseDetailBO) {
        LocalDateTime now = DateUtil.nowTime();
        return new EnterpriseDO()
                .setId(enterpriseDetailBO.getId())
                .setOrgId(enterpriseDetailBO.getOrgId())
                .setName(enterpriseDetailBO.getName())
                .setTaxNo(enterpriseDetailBO.getTaxNo())
                .setType(enterpriseDetailBO.getType())
                .setRegionCode(enterpriseDetailBO.getRegion())
                .setIndustryCode(enterpriseDetailBO.getIndustryCode())
                .setAddress(enterpriseDetailBO.getAddress())
                .setBank(enterpriseDetailBO.getBankName())
                .setAccount(enterpriseDetailBO.getBankAccount())
                .setPhone(enterpriseDetailBO.getPhone())
                .setRemark(enterpriseDetailBO.getRemark())
                .setUpstreamUsername(enterpriseDetailBO.getBureauUser())
                .setUpstreamPasswd(enterpriseDetailBO.getBureauPassword())
                .setBureauIdentityType(enterpriseDetailBO.getBureauIdentityType())
                .setStatus(1)
                .setCreateTime(now)
                .setUpdateTime(now);
    }

    public EnterpriseDetailBO getEnterprise(Integer id) {
        EnterpriseDO enterpriseDO = enterpriseDao.getDetail(id);
        if (Objects.isNull(enterpriseDO)) {
            return null;
        }
        RegionDO regionDO = regionDao.get(enterpriseDO.getRegionCode());
        return toEnterpriseDetailBO(enterpriseDO, regionDO);
    }

    public EnterpriseDetailBO toEnterpriseDetailBO(EnterpriseDO enterpriseDO, RegionDO regionDO) {
        return new EnterpriseDetailBO()
                .setId(enterpriseDO.getId())
                .setName(enterpriseDO.getName())
                .setTaxNo(enterpriseDO.getTaxNo())
                .setType(enterpriseDO.getType())
                .setRegion(enterpriseDO.getRegionCode())
                .setRegionName(Objects.nonNull(regionDO) ? regionDO.getName() : "")
                .setIndustryCode(enterpriseDO.getIndustryCode())
                .setAddress(enterpriseDO.getAddress())
                .setBankName(enterpriseDO.getBank())
                .setBankAccount(enterpriseDO.getAccount())
                .setPhone(enterpriseDO.getPhone())
                .setRemark(enterpriseDO.getRemark())
                .setBureauUser(enterpriseDO.getUpstreamUsername())
                .setBureauPassword(enterpriseDO.getUpstreamPasswd())
                .setBureauIdentityType(enterpriseDO.getBureauIdentityType())
                .setStatus(1)
                .setCreateTime(DateUtil.toTimeMills(enterpriseDO.getCreateTime()));

    }

    public List<OrgEnterpriseBO> listEnterpriseByIds(List<Integer> enterpriseIds) {
        return enterpriseDao.listEnterpriseByIds(enterpriseIds);
    }

    public List<EnterpriseBO> listEnterprise() {
        List<EnterpriseDO> enterprises = enterpriseDao.listAll();
        return enterprises.stream().map(x -> toEnterpriseBO(x, null, null)).collect(Collectors.toList());

    }

}
