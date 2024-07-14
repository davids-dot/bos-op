package com.luoge.bos.op.invoice.park.enterprise;

import com.luoge.bos.op.core.BOSConsts;
import com.luoge.bos.op.core.model.PageQuery;
import com.luoge.bos.op.core.utils.DateUtil;
import com.luoge.bos.op.core.utils.Numbers;
import com.luoge.bos.op.invoice.entity.ParkEnterpriseDO;
import com.luoge.bos.op.invoice.model.TaxCalculateFormulaBO;
import com.luoge.bos.op.invoice.model.org.EnterpriseDetailBO;
import com.luoge.bos.op.invoice.model.org.OrgEnterpriseBO;
import com.luoge.bos.op.invoice.model.park.enterprise.ListParkEnterpriseBO;
import com.luoge.bos.op.invoice.model.park.enterprise.ParkEnterpriseBO;
import com.luoge.bos.op.invoice.model.park.enterprise.ParkEnterpriseDetailBO;
import com.luoge.bos.op.invoice.model.park.enterprise.ParkEnterpriseFeeBO;
import com.luoge.bos.op.invoice.org.enterprise.EnterpriseService;
import com.luoge.bos.op.invoice.park.TaxCalculateFormulaService;
import com.luoge.ns.core.Page;
import jakarta.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ParkEnterpriseService {

    @Resource
    private ParkEnterpriseDao parkEnterpriseDao;
    @Resource
    private EnterpriseService enterpriseService;
    @Resource
    private TaxCalculateFormulaService taxCalculateFormulaService;


    public Page<ParkEnterpriseBO> listParkEnterprisesByPage(ListParkEnterpriseBO listParkEnterpriseBO, PageQuery pageQuery) {
        LocalDateTime startTime = DateUtil.toLocalDateTime(listParkEnterpriseBO.getStartTime());
        LocalDateTime endTime = DateUtil.toLocalDateTime(listParkEnterpriseBO.getEndTime());

        var parkEnterprises = parkEnterpriseDao.listByPage(listParkEnterpriseBO.getName(), listParkEnterpriseBO.getOrgId(), startTime, endTime,
                pageQuery.getPageNo(), pageQuery.getPageSize());
        if (CollectionUtils.isEmpty(parkEnterprises)) {
            return new Page<>(0, parkEnterprises);
        }

        List<Integer> enterpriseIds = parkEnterprises.stream()
                .map(ParkEnterpriseBO::getId)
                .collect(Collectors.toList());

        List<OrgEnterpriseBO> orgEnterprises = enterpriseService.listEnterpriseByIds(enterpriseIds);
        Map<Integer, OrgEnterpriseBO> enterpriseMap = orgEnterprises.stream()
                .collect(Collectors.toMap(OrgEnterpriseBO::getEnterpriseId, Function.identity()));

        parkEnterprises.forEach(x -> {
            x.setFeeRate(Numbers.mul(x.getFeeRate(), BOSConsts.BIG_DECIMAL_100));
            OrgEnterpriseBO orgEnterprise = enterpriseMap.get(x.getId());
            if (Objects.nonNull(orgEnterprise)) {
                x.setOrgName(orgEnterprise.getOrgName());
                x.setTaxNo(orgEnterprise.getTaxNo());
            }
        });

        return new Page<>(parkEnterprises.getTotal(), parkEnterprises);
    }


    public List<ParkEnterpriseDO> listParkEnterprises() {
        return parkEnterpriseDao.list();
    }

    public ParkEnterpriseDO getParkEnterprise(Integer enterpriseId) {
        return parkEnterpriseDao.get(enterpriseId);
    }

    public void addParkEnterprise(List<Integer> enterpriseIds) {
        List<OrgEnterpriseBO> orgEnterprises = enterpriseService.listEnterpriseByIds(enterpriseIds);
        LocalDateTime now = DateUtil.nowTime();
        List<ParkEnterpriseDO> parkEnterprises = orgEnterprises.stream()
                .map(x -> toEnterpriseDO(x, now))
                .toList();
        parkEnterpriseDao.batchInsertOnConflictIgnore(parkEnterprises);
    }

    private ParkEnterpriseDO toEnterpriseDO(OrgEnterpriseBO x, LocalDateTime now) {
        return new ParkEnterpriseDO()
                .setOrgId(x.getOrgId())
                .setEnterpriseId(x.getEnterpriseId())
                .setEnterpriseName(x.getEnterpriseName())
                .setServiceFeeRate(BigDecimal.ZERO)
                .setCreateTime(now)
                .setUpdateTime(now);
    }

    public ParkEnterpriseDetailBO getParkEnterpriseDetail(int id) {
        EnterpriseDetailBO enterprise = enterpriseService.getEnterprise(id);
        ParkEnterpriseFeeBO parkEnterpriseFee = parkEnterpriseDao.getParkEnterpriseFee(id);

        if (Objects.isNull(parkEnterpriseFee)) {
            parkEnterpriseFee = new ParkEnterpriseFeeBO().setId(id);
        }
        parkEnterpriseFee.
                setFeeRate(
                        Numbers.mul(parkEnterpriseFee.getFeeRate(), BOSConsts.BIG_DECIMAL_100)
                )
                .setParkProviderAdditionalTaxRate(
                        Numbers.mul(parkEnterpriseFee.getParkProviderAdditionalTaxRate(), BOSConsts.BIG_DECIMAL_100)
                )
                .setParkProviderWaterTaxRate(
                        Numbers.mul(parkEnterpriseFee.getParkProviderWaterTaxRate(), BOSConsts.BIG_DECIMAL_100)
                )
                .setParkProviderStampTaxRate(
                        Numbers.mul(parkEnterpriseFee.getParkProviderStampTaxRate(), BOSConsts.BIG_DECIMAL_100)
                )
                .setParkProviderIncomeTaxRate(
                        Numbers.mul(parkEnterpriseFee.getParkProviderIncomeTaxRate(), BOSConsts.BIG_DECIMAL_100)
                )
                .setParkProviderServiceFeeRate(
                        Numbers.mul(parkEnterpriseFee.getParkProviderServiceFeeRate(), BOSConsts.BIG_DECIMAL_100)
                )
                .setDistributorServiceFeeRate(
                        Numbers.mul(parkEnterpriseFee.getDistributorServiceFeeRate(), BOSConsts.BIG_DECIMAL_100)
                )
                .setParkProviderValueAddedTaxRate(
                        Numbers.mul(parkEnterpriseFee.getParkProviderValueAddedTaxRate(), BOSConsts.BIG_DECIMAL_100)
                )
                .setIncludeTaxRate(
                        Numbers.mul(parkEnterpriseFee.getIncludeTaxRate(), BOSConsts.BIG_DECIMAL_100)

                );
        return new ParkEnterpriseDetailBO()
                .setEnterprise(enterprise)
                .setFeeSetting(parkEnterpriseFee);
    }

    public ParkEnterpriseFeeBO getParkEnterpriseFeeRate(int id) {
        return parkEnterpriseDao.getParkEnterpriseFee(id);
    }

    public void deleteParkEnterprise(int id) {
        parkEnterpriseDao.delete(id);
    }

    public void updateFeeSetting(ParkEnterpriseFeeBO parkEnterprise) {
        parkEnterprise
                .setFeeRate(
                        Numbers.divide(parkEnterprise.getFeeRate(), BOSConsts.BIG_DECIMAL_100)
                )
                .setParkProviderAdditionalTaxRate(
                        Numbers.divide(parkEnterprise.getParkProviderAdditionalTaxRate(), BOSConsts.BIG_DECIMAL_100)
                )
                .setParkProviderWaterTaxRate(
                        Numbers.divide(parkEnterprise.getParkProviderWaterTaxRate(), BOSConsts.BIG_DECIMAL_100)
                )
                .setParkProviderStampTaxRate(
                        Numbers.divide(parkEnterprise.getParkProviderStampTaxRate(), BOSConsts.BIG_DECIMAL_100)
                )
                .setParkProviderIncomeTaxRate(
                        Numbers.divide(parkEnterprise.getParkProviderIncomeTaxRate(), BOSConsts.BIG_DECIMAL_100)
                )
                .setParkProviderServiceFeeRate(
                        Numbers.divide(parkEnterprise.getParkProviderServiceFeeRate(), BOSConsts.BIG_DECIMAL_100)
                )
                .setDistributorServiceFeeRate(
                        Numbers.divide(parkEnterprise.getDistributorServiceFeeRate(), BOSConsts.BIG_DECIMAL_100)
                )
                .setParkProviderValueAddedTaxRate(
                        Numbers.divide(parkEnterprise.getParkProviderValueAddedTaxRate(), BOSConsts.BIG_DECIMAL_100)
                )
                .setIncludeTaxRate(
                        Numbers.divide(parkEnterprise.getIncludeTaxRate(), BOSConsts.BIG_DECIMAL_100)

                );

        parkEnterprise.setUpdateTime(DateUtil.nowTime());
        parkEnterpriseDao.updateFeeSetting(parkEnterprise);
    }

}
