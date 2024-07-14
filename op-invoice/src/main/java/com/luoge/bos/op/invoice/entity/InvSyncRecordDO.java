package com.luoge.bos.op.invoice.entity;

import java.time.LocalDateTime;

public class InvSyncRecordDO {
    private LocalDateTime lastSyncTime;

    private LocalDateTime updateTime;

    public LocalDateTime getLastSyncTime() {
        return lastSyncTime;
    }

    public void setLastSyncTime(LocalDateTime lastSyncTime) {
        this.lastSyncTime = lastSyncTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}