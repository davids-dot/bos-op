package com.luoge.bos.op.invoice.report.enterprise;

import com.github.pagehelper.Page;
import com.luoge.bos.op.invoice.entity.DistributorReportDO;
import com.luoge.bos.op.invoice.entity.ParkEnterpriseReportDO;
import com.luoge.bos.op.invoice.entity.ParkProviderReportDO;
import com.luoge.bos.op.invoice.model.collect.SummaryHistoryBO;
import com.luoge.bos.op.invoice.model.report.SummaryEnterpriseReportBO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface ParkEnterpriseReportDao {

    /**
     * 查询历史数据
     */
    SummaryHistoryBO summaryHistory(@Param("orgId") int orgId,
                                    @Param("enterpriseId") int enterpriseId,
                                    @Param("months") List<String> months);

    BigDecimal sumYearHistoryTax(@Param("orgId") int orgId,
                                 @Param("enterpriseId") int enterpriseId,
                                 @Param("months") List<String> months);

    void batchInsertOnConflictUpdate(@Param("reports") List<ParkEnterpriseReportDO> parkEnterpriseReports);

    Page<ParkEnterpriseReportDO> listProviderMonthReportDetailByPage(@Param("providerId") int providerId,
                                                                     @Param("month") String month,
                                                                     @Param("pageNo") int pageNo,
                                                                     @Param("pageSize") int pageSize);

    Page<ParkEnterpriseReportDO> listDistributorMonthReportDetailByPage(@Param("distributorId") int distributorId,
                                                                        @Param("month") String month,
                                                                        @Param("pageNo") int pageNo,
                                                                        @Param("pageSize") int pageSize);

    List<ParkEnterpriseReportDO> listDistributorMonthReportDetail(@Param("distributorId") int distributorId,
                                                                  @Param("month") String month);

    Page<ParkEnterpriseReportDO> listEnterpriseReportByPage(@Param("providerId") Integer providerId,
                                                            @Param("enterpriseName") String enterpriseName,
                                                            @Param("customerManager") String customerManager,
                                                            @Param("customer") String customer,
                                                            @Param("distributorName") String distributorName,
                                                            @Param("months") List<String> months,
                                                            @Param("pageNo") int pageNo,
                                                            @Param("pageSize") int pageSize);

    List<ParkEnterpriseReportDO> listEnterpriseReport(@Param("providerId") Integer providerId,
                                                      @Param("enterpriseName") String enterpriseName,
                                                      @Param("customerManager") String customerManager,
                                                      @Param("customer") String customer,
                                                      @Param("distributorName") String distributorName,
                                                      @Param("months") List<String> months);

    SummaryEnterpriseReportBO summaryEnterpriseReport(@Param("providerId") Integer providerId,
                                                      @Param("enterpriseName") String enterpriseName,
                                                      @Param("customerManager") String customerManager,
                                                      @Param("customer") String customer,
                                                      @Param("distributorName") String distributorName,
                                                      @Param("months") List<String> months);

    List<ParkProviderReportDO> listParkProvidersReports(@Param("month") String month,
                                                        @Param("providerIds") List<Integer> providerIds);

    List<DistributorReportDO> listDistributorsReports(@Param("month") String month,
                                                      @Param("distributorIds") List<Integer> distributorIds);


    List<ParkEnterpriseReportDO> listProviderMonthReportDetail(@Param("providerId") int providerId, @Param("month") String month);
}