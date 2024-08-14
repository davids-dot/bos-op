package com.luoge.bos.invoice.report.provider;

import com.github.pagehelper.Page;
import com.luoge.bos.invoice.entity.ParkProviderReportDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ParkProviderReportDao {
    Page<ParkProviderReportDO> listByName(@Param("providerId") Integer providerId, @Param("months") List<String> months,
                                          @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

    List<ParkProviderReportDO> list(@Param("providerId") Integer providerId, @Param("months") List<String> months);

    void batchInsertOnConflictUpdate(@Param("reports") List<ParkProviderReportDO> parkProviderReports);
}