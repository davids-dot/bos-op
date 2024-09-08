package com.luoge.bos.invoice.common;

import com.luoge.bos.invoice.model.DictVO;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 公共/字典
 */
@RestController
@RequestMapping("/invoice/common")
public class AppDictController {
    @Resource
    AppDictService appDictService;

    /**
     * 查询某类字典数据
     *
     * @param type UNIT-单位, ID_TYPE-证件类型, COUNTRY-国籍
     */
    @GetMapping("/dict")
    public R<List<DictVO>> listDicts(String type) {
        return R.success(appDictService.listByType(type));
    }

    @Service
    public static class AppDictService {

        @Resource
        private AppDictDao appDictDao;

        public List<DictVO> listByType(String type) {
            return appDictDao.listByType(type);
        }
    }
}
