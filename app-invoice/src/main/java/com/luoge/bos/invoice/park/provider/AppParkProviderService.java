package com.luoge.bos.invoice.park.provider;


import com.luoge.bos.invoice.entity.ParkProviderDO;
import com.luoge.bos.invoice.model.ParkProviderBO;
import com.luoge.bos.core.utils.DateUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppParkProviderService {

    @Resource
    private AppParkProviderDao appParkProviderDao;

    private ParkProviderBO toParkProviderBO(ParkProviderDO providerDO) {
        return new ParkProviderBO()
                .setId(providerDO.getId())
                .setName(providerDO.getName())
                .setRemark(providerDO.getRemark())
                .setStatus(providerDO.getStatus())
                .setRegistrationFee(providerDO.getRegistrationFee())
                .setCreateTime(DateUtil.toTimeMills(providerDO.getCreateTime()));
    }

    public List<ParkProviderBO> listParkProvider(Integer status) {
        List<ParkProviderDO> parkProviders = appParkProviderDao.listByStatus(status);
        return parkProviders.stream()
                .map(this::toParkProviderBO)
                .collect(Collectors.toList());
    }

    public ParkProviderDO getDetail(Integer id){
        return appParkProviderDao.get(id);
    }
}
