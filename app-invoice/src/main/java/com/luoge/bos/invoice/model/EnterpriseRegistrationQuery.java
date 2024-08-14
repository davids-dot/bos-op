package com.luoge.bos.invoice.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 列表query
 */
public class EnterpriseRegistrationQuery {
    /**
     * 状态
     */
    private Integer status;

    /**
     * 法人名称
     */
    private String corporateName;

    /**
     * 所选园区id
     */
    private Integer parkProviderId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public Integer getParkProviderId() {
        return parkProviderId;
    }

    public void setParkProviderId(Integer parkProviderId) {
        this.parkProviderId = parkProviderId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
