package com.luoge.bos.invoice.common;

import com.luoge.bos.invoice.entity.ParkEnterpriseCustomerDO;
import com.luoge.bos.invoice.entity.ParkEnterprisePayerDO;
import com.luoge.bos.invoice.entity.uc.RegionDO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonService {

    @Resource
    private ParkEnterprisePayerDao parkEnterprisePayerDao;
    @Resource
    private ParkEnterpriseCustomerDao parkEnterpriseCustomerDao;
    @Resource
    private RegionDao regionDao;

    public List<ParkEnterprisePayerDO> listParkEnterprisePayer() {
        return parkEnterprisePayerDao.list();
    }

    public List<ParkEnterpriseCustomerDO> listParkEnterpriseCustomer() {
        return parkEnterpriseCustomerDao.list();
    }

    public List<RegionDO> listProvince() {
        return regionDao.list();
    }
}
