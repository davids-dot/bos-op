package com.luoge.bos.op.invoice.park.provider;

import com.luoge.bos.op.core.BOSConsts;
import com.luoge.bos.op.core.BosAppCode;
import com.luoge.bos.op.core.model.PageQuery;
import com.luoge.bos.op.core.utils.DateUtil;
import com.luoge.bos.op.core.utils.Numbers;
import com.luoge.bos.op.invoice.entity.ParkProviderDO;
import com.luoge.bos.op.invoice.model.park.provider.ParkProviderBO;
import com.luoge.bos.op.invoice.model.park.provider.ParkProviderDetailBO;
import com.luoge.bos.op.invoice.model.park.provider.ParkProviderStatusBO;
import com.luoge.ns.core.Page;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ParkProviderService {

    @Resource
    private ParkProviderDao parkProviderDao;

    public Page<ParkProviderBO> listParkProvider(String name, PageQuery pageQuery) {
        var parkProviderDOPage = parkProviderDao.list(name, pageQuery.getPageNo(), pageQuery.getPageSize());

        List<ParkProviderBO> parkProviderBOS = new ArrayList<>();

        for (var providerDO : parkProviderDOPage.getResult()) {
            var bo = toParkProviderBO(providerDO);
            parkProviderBOS.add(bo);
        }
        return new Page<>(parkProviderDOPage.getTotal(), parkProviderBOS);
    }

    private static ParkProviderBO toParkProviderBO(ParkProviderDO providerDO) {
        return new ParkProviderBO()
                .setId(providerDO.getId())
                .setName(providerDO.getName())
                .setRemark(providerDO.getRemark())
                .setStatus(providerDO.getStatus())
                .setServiceFeeRate(Numbers.mul(providerDO.getServiceFeeRate(), BOSConsts.BIG_DECIMAL_100))
                .setAdditionalTaxRate(Numbers.mul(providerDO.getAdditionalTaxRate(), BOSConsts.BIG_DECIMAL_100))
                .setWaterTaxRate(Numbers.mul(providerDO.getWaterTaxRate(), BOSConsts.BIG_DECIMAL_100))
                .setStampTaxRate(Numbers.mul(providerDO.getStampTaxRate(), BOSConsts.BIG_DECIMAL_100))
                .setIncomeTaxRate(Numbers.mul(providerDO.getIncomeTaxRate(), BOSConsts.BIG_DECIMAL_100))
                .setIncomeTaxType(providerDO.getIncomeTaxType())
                .setIsMiniAppShow(providerDO.getMiniAppShow())
                .setValueAddedTaxType(providerDO.getValueAddedTaxType())
                .setCreateTime(DateUtil.toTimeMills(providerDO.getCreateTime()))
                .setValueAddedTaxRate(Numbers.mul(providerDO.getValueAddedTaxRate(), BOSConsts.BIG_DECIMAL_100))
                .setValueAddedTaxFormulaId(providerDO.getValueAddedTaxFormulaId())
                .setAdditionalTaxFormulaId(providerDO.getAdditionalTaxFormulaId())
                .setWaterTaxFormulaId(providerDO.getWaterTaxFormulaId())
                .setStampTaxFormulaId(providerDO.getStampTaxFormulaId())
                .setIncomeTaxFormulaId(providerDO.getIncomeTaxFormulaId())
                .setIsIncludeTax(Objects.equals(providerDO.getIncludeTax(), true) ? 1 : 0)
                .setIncludeTaxRate(Numbers.mul(providerDO.getIncludeTaxRate(), BOSConsts.BIG_DECIMAL_100));
    }

    public List<ParkProviderBO> listParkProvider(Integer status) {
        List<ParkProviderDO> parkProviders = parkProviderDao.listByStatus(status);
        return parkProviders.stream()
                .map(ParkProviderService::toParkProviderBO)
                .collect(Collectors.toList());
    }

    public ParkProviderDetailBO getParkProviderDetail(Integer id) {
        ParkProviderDO parkProviderDO = parkProviderDao.get(id);
        return toParkProviderDetailBO(parkProviderDO);
    }

    public ParkProviderDetailBO toParkProviderDetailBO(ParkProviderDO parkProviderDO) {
        return new ParkProviderDetailBO()
                .setId(parkProviderDO.getId())
                .setName(parkProviderDO.getName())
                .setRemark(parkProviderDO.getRemark())
                .setStatus(parkProviderDO.getStatus())
                .setAccountName(parkProviderDO.getAccountName())
                .setAccountOpenBank(parkProviderDO.getAccountOpenBank())
                .setAccountBank(parkProviderDO.getAccountBank())
                .setAccountNo(parkProviderDO.getAccountNo())
                .setServiceFeeRate(Numbers.mul(parkProviderDO.getServiceFeeRate(), BOSConsts.BIG_DECIMAL_100))
                .setValueAddedTaxType(parkProviderDO.getValueAddedTaxType())
                .setAdditionalTaxRate(Numbers.mul(parkProviderDO.getAdditionalTaxRate(), BOSConsts.BIG_DECIMAL_100))
                .setWaterTaxRate(Numbers.mul(parkProviderDO.getWaterTaxRate(), BOSConsts.BIG_DECIMAL_100))
                .setStampTaxRate(Numbers.mul(parkProviderDO.getStampTaxRate(), BOSConsts.BIG_DECIMAL_100))
                .setIncomeTaxRate(Numbers.mul(parkProviderDO.getIncomeTaxRate(), BOSConsts.BIG_DECIMAL_100))
                .setValueAddedTaxRate(Numbers.mul(parkProviderDO.getValueAddedTaxRate(), BOSConsts.BIG_DECIMAL_100))
                .setValueAddedTaxFormulaId(parkProviderDO.getValueAddedTaxFormulaId())
                .setAdditionalTaxFormulaId(parkProviderDO.getAdditionalTaxFormulaId())
                .setWaterTaxFormulaId(parkProviderDO.getWaterTaxFormulaId())
                .setStampTaxFormulaId(parkProviderDO.getStampTaxFormulaId())
                .setIncomeTaxFormulaId(parkProviderDO.getIncomeTaxFormulaId())
                .setIncomeTaxType(parkProviderDO.getIncomeTaxType())
                .setRegistrationFee(parkProviderDO.getRegistrationFee())
                .setParkProviderRegistrationFee(parkProviderDO.getParkProviderRegistrationFee())
                .setMiniAppShow(parkProviderDO.getMiniAppShow())
                .setIsIncludeTax(parkProviderDO.getIncludeTax() ? 1 : 0)
                .setIncludeTaxRate(Numbers.mul(parkProviderDO.getIncludeTaxRate(), BOSConsts.BIG_DECIMAL_100))
                .setCreateTime(DateUtil.toTimeMills(parkProviderDO.getCreateTime()));
    }

    public R<Void> insertParkProvider(ParkProviderDetailBO parkProviderDetailBO) {
        if (parkProviderDao.existName(parkProviderDetailBO.getName())) {
            return R.fail(BosAppCode.EXIST_PROVIDER_NAME);
        }
        ParkProviderDO parkProviderDO = toParkProvider(parkProviderDetailBO);
        parkProviderDao.insert(parkProviderDO);
        return R.SUCCESS;
    }

    public R<Void> updateParkProvider(ParkProviderDetailBO parkProviderDetailBO) {
        int id = parkProviderDetailBO.getId();
        ParkProviderDO existParkProviderDO = parkProviderDao.getByName(parkProviderDetailBO.getName());
        if (Objects.nonNull(existParkProviderDO) && !Objects.equals(existParkProviderDO.getId(), id)) {
            return R.fail(BosAppCode.EXIST_PROVIDER_NAME);
        }
        ParkProviderDO parkProviderDO = toParkProvider(parkProviderDetailBO);
        parkProviderDao.update(parkProviderDO);
        return R.SUCCESS;
    }

    public ParkProviderDO toParkProvider(ParkProviderDetailBO parkProviderDetailBO) {
        LocalDateTime now = DateUtil.nowTime();
        return new ParkProviderDO()
                .setId(parkProviderDetailBO.getId())
                .setName(parkProviderDetailBO.getName())
                .setRemark(parkProviderDetailBO.getRemark())
                .setStatus(1)
                .setAccountName(parkProviderDetailBO.getAccountName())
                .setAccountOpenBank(parkProviderDetailBO.getAccountOpenBank())
                .setAccountBank(parkProviderDetailBO.getAccountBank())
                .setAccountNo(parkProviderDetailBO.getAccountNo())
                .setServiceFeeRate(Numbers.divide(parkProviderDetailBO.getServiceFeeRate(), BOSConsts.BIG_DECIMAL_100))
                .setValueAddedTaxType(parkProviderDetailBO.getValueAddedTaxType())
                .setAdditionalTaxRate(Numbers.divide(parkProviderDetailBO.getAdditionalTaxRate(), BOSConsts.BIG_DECIMAL_100))
                .setWaterTaxRate(Numbers.divide(parkProviderDetailBO.getWaterTaxRate(), BOSConsts.BIG_DECIMAL_100))
                .setStampTaxRate(Numbers.divide(parkProviderDetailBO.getStampTaxRate(), BOSConsts.BIG_DECIMAL_100))
                .setIncomeTaxRate(Numbers.divide(parkProviderDetailBO.getIncomeTaxRate(), BOSConsts.BIG_DECIMAL_100))
                .setValueAddedTaxRate(Numbers.divide(parkProviderDetailBO.getValueAddedTaxRate(), BOSConsts.BIG_DECIMAL_100))
                .setIncomeTaxType(parkProviderDetailBO.getIncomeTaxType())
                .setRegistrationFee(parkProviderDetailBO.getRegistrationFee())
                .setParkProviderRegistrationFee(parkProviderDetailBO.getParkProviderRegistrationFee())
                .setMiniAppShow(parkProviderDetailBO.getMiniAppShow())
                .setValueAddedTaxFormulaId(parkProviderDetailBO.getValueAddedTaxFormulaId())
                .setAdditionalTaxFormulaId(parkProviderDetailBO.getAdditionalTaxFormulaId())
                .setWaterTaxFormulaId(parkProviderDetailBO.getWaterTaxFormulaId())
                .setStampTaxFormulaId(parkProviderDetailBO.getStampTaxFormulaId())
                .setIncomeTaxFormulaId(parkProviderDetailBO.getIncomeTaxFormulaId())
                .setIncludeTax(Objects.equals(parkProviderDetailBO.getIsIncludeTax(), 1))
                .setIncludeTaxRate(Numbers.divide(parkProviderDetailBO.getIncludeTaxRate(), BOSConsts.BIG_DECIMAL_100))
                .setCreateTime(now)
                .setUpdateTime(now);
    }

    public void updateParkProviderStatus(ParkProviderStatusBO statusBO) {
        parkProviderDao.updateStatus(statusBO.getId(), statusBO.getStatus());
    }

    public List<ParkProviderDO> listParkProviders() {
        return parkProviderDao.listAll();
    }


}
