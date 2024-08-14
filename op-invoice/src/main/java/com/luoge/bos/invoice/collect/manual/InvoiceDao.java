package com.luoge.bos.invoice.collect.manual;

import com.github.pagehelper.Page;
import com.luoge.bos.invoice.entity.InvoiceDO;
import com.luoge.bos.invoice.model.collect.InvoiceBO;
import com.luoge.bos.invoice.model.collect.SeasonSummaryDailyBO;
import com.luoge.bos.invoice.model.collect.SummaryHistoryTaxBO;
import com.luoge.bos.invoice.model.collect.YearSummaryDailyBO;
import com.luoge.bos.invoice.model.query.EnterpriseFeeBO;
import com.luoge.bos.invoice.model.query.EnterpriseInvoiceSummaryBO;
import com.luoge.bos.invoice.model.report.ParkEnterpriseReportBO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface InvoiceDao {


    void batchInsertOrIgnore(@Param("invoices") List<InvoiceDO> invoices);

    EnterpriseInvoiceSummaryBO summaryInvoiceAmountFee(@Param("orgId") int orgId,
                                                       @Param("enterpriseId") int enterpriseId,
                                                       @Param("startTime") LocalDateTime startTime,
                                                       @Param("endTime") LocalDateTime endTime);

    List<ParkEnterpriseReportBO> summaryMonthFee(@Param("orgId") int orgId,
                                                 @Param("enterpriseId") int enterpriseId,
                                                 @Param("startTime") LocalDateTime startTime,
                                                 @Param("endTime") LocalDateTime endTime);


    BigDecimal sumYearInvoiceAmount(@Param("orgId") int orgId,
                                    @Param("enterpriseId") int enterpriseId,
                                    @Param("startTime") LocalDateTime startTime,
                                    @Param("endTime") LocalDateTime endTime);

    Page<InvoiceBO> listManualInvoice(@Param("parkProviderId") Integer parkProviderId,
                                      @Param("enterpriseName") String enterpriseName,
                                      @Param("startTime") LocalDateTime startTime,
                                      @Param("endTime") LocalDateTime endTime,
                                      @Param("pageNo") Integer pageNo,
                                      @Param("pageSize") Integer pageSize);

    InvoiceDO getDetail(long id);

    void add(InvoiceDO invoiceDO);

    void delete(Long id);


    Page<InvoiceDO> listEnterpriseInvoicesByPage(@Param("enterpriseId") int enterpriseId,
                                                 @Param("startTime") LocalDateTime monthBegin,
                                                 @Param("endTime") LocalDateTime monthEnd,
                                                 @Param("pageNo") Integer pageNo,
                                                 @Param("pageSize") Integer pageSize);

    List<InvoiceDO> listEnterpriseInvoices(@Param("enterpriseId") int enterpriseId,
                                           @Param("startTime") LocalDateTime monthBegin,
                                           @Param("endTime") LocalDateTime monthEnd);

    List<InvoiceDO> listTodayInvoices(@Param("orgId") int orgId,
                                      @Param("enterpriseId") int enterpriseId,
                                      @Param("startTime") LocalDateTime dayBegin,
                                      @Param("endTime") LocalDateTime dayEnd,
                                      @Param("offset") int offset,
                                      @Param("limit") int limit);

    SummaryHistoryTaxBO summaryHistoryTax(@Param("orgId") Integer orgId,
                                          @Param("enterpriseId") Integer enterpriseId,
                                          @Param("startTime") LocalDateTime seasonStartTime,
                                          @Param("endTime") LocalDateTime lastMonthBegin);

    SeasonSummaryDailyBO summarySeasonDaily(@Param("orgId") int orgId,
                                            @Param("enterpriseId") int enterpriseId,
                                            @Param("startTime") LocalDateTime seasonStartTime,
                                            @Param("endTime") LocalDateTime startTime);

    YearSummaryDailyBO summaryYearDaily(@Param("orgId") int orgId,
                                        @Param("enterpriseId") int enterpriseId,
                                        @Param("startTime") LocalDateTime seasonStartTime,
                                        @Param("endTime") LocalDateTime startTime);


    int batchUpdate(@Param("supplementInvoices") List<InvoiceDO> supplementInvoices);

    int countToComputeInvoice(@Param("orgId") Integer orgId,
                              @Param("enterpriseId") Integer enterpriseId,
                              @Param("startTime") LocalDateTime startTime,
                              @Param("endTime") LocalDateTime endTime);

    List<EnterpriseFeeBO> sumEnterpriseFee(@Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime,
                                           @Param("enterpriseIds") List<Integer> enterpriseIds);

    EnterpriseInvoiceSummaryBO summaryEnterpriseFee(@Param("startTime") LocalDateTime startTime,
                                                    @Param("endTime") LocalDateTime endTime,
                                                    @Param("enterpriseIds") List<Integer> enterpriseIds);

    int clearInvoicesIncome(@Param("enterpriseId") Integer enterpriseId,
                            @Param("startTime") LocalDateTime startTime,
                            @Param("endTime") LocalDateTime endTime,
                            @Param("updateTime") LocalDateTime updateTime);
}