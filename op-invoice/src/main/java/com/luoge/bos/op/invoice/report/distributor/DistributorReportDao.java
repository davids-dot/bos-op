package com.luoge.bos.op.invoice.report.distributor;

import com.github.pagehelper.Page;
import com.luoge.bos.op.invoice.entity.DistributorReportDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DistributorReportDao {
    int insert(DistributorReportDO row);

    Page<DistributorReportDO> listByPage(@Param("distributorId") Integer distributorId, @Param("months") List<String> months,
                                         @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

    List<DistributorReportDO> list(@Param("distributorId") Integer distributorId, @Param("months") List<String> months);

    int batchInsertOnConflictUpdate(@Param("reports") List<DistributorReportDO> parkProviderReports);


}