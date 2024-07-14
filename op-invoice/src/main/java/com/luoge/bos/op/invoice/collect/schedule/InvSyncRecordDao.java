package com.luoge.bos.op.invoice.collect.schedule;

import com.luoge.bos.op.invoice.entity.InvSyncRecordDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;

@Mapper
public interface InvSyncRecordDao {

    int updateSyncTime(@Param("lastSyncTime") LocalDateTime lastMonthEnd,
                       @Param("updateTime") LocalDateTime localDateTime);

    InvSyncRecordDO getSyncRecord();
}