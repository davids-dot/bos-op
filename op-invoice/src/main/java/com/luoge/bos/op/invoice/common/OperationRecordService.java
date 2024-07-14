package com.luoge.bos.op.invoice.common;

import com.luoge.bos.op.invoice.entity.invoice.OperationRecordDO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationRecordService {

    @Resource
    private OperationRecordDao operationRecordDao;

    public void saveOperationRecord(OperationRecordDO operationRecordDO) {
        operationRecordDao.insert(operationRecordDO);
    }

    public List<OperationRecordDO> listByBusinessId(Long id) {
        return operationRecordDao.listByBusinessId(id);
    }
}
