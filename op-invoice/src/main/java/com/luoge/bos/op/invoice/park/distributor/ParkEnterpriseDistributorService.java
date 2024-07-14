package com.luoge.bos.op.invoice.park.distributor;


import com.luoge.bos.op.core.BOSConsts;
import com.luoge.bos.op.core.BosAppCode;
import com.luoge.bos.op.core.utils.DateUtil;
import com.luoge.bos.op.core.utils.Numbers;
import com.luoge.bos.op.invoice.entity.ParkEnterpriseDistributorDO;
import com.luoge.bos.op.invoice.model.park.distributor.ParkEnterpriseDistributorBO;
import com.luoge.bos.op.invoice.model.park.distributor.ParkEnterpriseDistributorDetailsBO;
import com.luoge.bos.op.invoice.model.park.distributor.ParkEnterpriseDistributorStatusBO;
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
public class ParkEnterpriseDistributorService {
    @Resource
    private ParkEnterpriseDistributorDao parkEnterpriseDistributorDao;

    public Page<ParkEnterpriseDistributorBO> listParkEnterpriseDistributor(Integer pageNo, Integer pageSize, String name) {
        var distributorDOPage = parkEnterpriseDistributorDao.list(name, pageNo, pageSize);

        List<ParkEnterpriseDistributorBO> distributorBOS = new ArrayList<>();

        for (var distributorDO : distributorDOPage.getResult()) {
            var bo = toDistributorBO(distributorDO);
            distributorBOS.add(bo);
        }
        return new Page<>(distributorDOPage.getTotal(), distributorBOS);
    }

    private ParkEnterpriseDistributorBO toDistributorBO(ParkEnterpriseDistributorDO distributorDO) {
        return new ParkEnterpriseDistributorBO()
                .setId(distributorDO.getId())
                .setName(distributorDO.getName())
                .setRemark(distributorDO.getRemark())
                .setStatus(distributorDO.getStatus())
                .setDistributorFeeRate(Numbers.mul(distributorDO.getFeeRate(), BOSConsts.BIG_DECIMAL_100))
                .setCreateTime(DateUtil.toTimeMills(distributorDO.getCreateTime()));
    }

    public List<ParkEnterpriseDistributorBO> listParkEnterpriseDistributor(Integer status) {
        List<ParkEnterpriseDistributorDO> distributors = parkEnterpriseDistributorDao.listByStatus(status);
        return distributors.stream()
                .map(this::toDistributorBO)
                .collect(Collectors.toList());
    }

    public R<Void> insertParkEnterpriseDistributor(ParkEnterpriseDistributorDetailsBO parkEnterpriseDistributorDetailsBO) {
        if (parkEnterpriseDistributorDao.existName(parkEnterpriseDistributorDetailsBO.getName())) {
            return R.fail(BosAppCode.EXIST_DISTRIBUTOR_NAME);
        }
        ParkEnterpriseDistributorDO parkEnterpriseDistributorDO = toParkEnterpriseDistributorDO(parkEnterpriseDistributorDetailsBO);
        parkEnterpriseDistributorDao.insert(parkEnterpriseDistributorDO);
        return R.SUCCESS;
    }

    private ParkEnterpriseDistributorDO toParkEnterpriseDistributorDO(ParkEnterpriseDistributorDetailsBO parkEnterpriseDistributorDetailsBO) {
        LocalDateTime now = DateUtil.nowTime();
        return new ParkEnterpriseDistributorDO()
                .setId(parkEnterpriseDistributorDetailsBO.getId())
                .setName(parkEnterpriseDistributorDetailsBO.getName())
                .setRemark(parkEnterpriseDistributorDetailsBO.getRemark())
                .setStatus(1)
                .setAccountName(parkEnterpriseDistributorDetailsBO.getAccountName())
                .setAccountOpenBank(parkEnterpriseDistributorDetailsBO.getAccountOpenBank())
                .setAccountBank(parkEnterpriseDistributorDetailsBO.getAccountBank())
                .setAccountNo(parkEnterpriseDistributorDetailsBO.getAccountNo())
                .setFeeRate(Numbers.divide(parkEnterpriseDistributorDetailsBO.getFeeRate(), BOSConsts.BIG_DECIMAL_100))
                .setCreateTime(now)
                .setUpdateTime(now);
    }

    public R<Void> updateParkEnterpriseDistributor(ParkEnterpriseDistributorDetailsBO parkEnterpriseDistributorDetailsBO) {
        int id = parkEnterpriseDistributorDetailsBO.getId();
        ParkEnterpriseDistributorDO existParkEnterpriseDistributorDO = parkEnterpriseDistributorDao.getByName(parkEnterpriseDistributorDetailsBO.getName());
        if (Objects.nonNull(existParkEnterpriseDistributorDO) && !Objects.equals(existParkEnterpriseDistributorDO.getId(), id)) {
            return R.fail(BosAppCode.EXIST_DISTRIBUTOR_NAME);
        }
        ParkEnterpriseDistributorDO parkEnterpriseDistributorDO = toParkEnterpriseDistributorDO(parkEnterpriseDistributorDetailsBO);
        parkEnterpriseDistributorDao.update(parkEnterpriseDistributorDO);
        return R.SUCCESS;
    }

    public void updateParkEnterpriseDistributorStatus(ParkEnterpriseDistributorStatusBO statusBO) {
        parkEnterpriseDistributorDao.updateStatus(statusBO.getId(), statusBO.getStatus());
    }

    public ParkEnterpriseDistributorDetailsBO getParkEnterpriseDistributorDetails(Integer id) {
        ParkEnterpriseDistributorDO detailDO = parkEnterpriseDistributorDao.get(id);
        return toParkEnterpriseDistributorBO(detailDO);
    }

    private ParkEnterpriseDistributorDetailsBO toParkEnterpriseDistributorBO(ParkEnterpriseDistributorDO parkEnterpriseDistributorDO) {
        return new ParkEnterpriseDistributorDetailsBO()
                .setId(parkEnterpriseDistributorDO.getId())
                .setName(parkEnterpriseDistributorDO.getName())
                .setRemark(parkEnterpriseDistributorDO.getRemark())
                .setStatus(parkEnterpriseDistributorDO.getStatus())
                .setAccountName(parkEnterpriseDistributorDO.getAccountName())
                .setAccountOpenBank(parkEnterpriseDistributorDO.getAccountOpenBank())
                .setAccountBank(parkEnterpriseDistributorDO.getAccountBank())
                .setAccountNo(parkEnterpriseDistributorDO.getAccountNo())
                .setFeeRate(Numbers.mul(parkEnterpriseDistributorDO.getFeeRate(), BOSConsts.BIG_DECIMAL_100))
                .setCreateTime(DateUtil.toTimeMills(parkEnterpriseDistributorDO.getCreateTime()));
    }

    public List<ParkEnterpriseDistributorDO> listDistributors() {
        return parkEnterpriseDistributorDao.listAll();
    }


}
