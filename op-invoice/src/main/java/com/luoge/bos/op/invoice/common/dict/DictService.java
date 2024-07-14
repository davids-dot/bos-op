package com.luoge.bos.op.invoice.common.dict;

import com.luoge.bos.op.invoice.model.common.dict.DictVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictService {

    @Resource
    private DictDao dictDao;

    public List<DictVO> listByType(String type) {
        return dictDao.listByType(type);
    }
}
