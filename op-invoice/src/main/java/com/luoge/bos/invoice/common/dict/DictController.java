package com.luoge.bos.invoice.common.dict;

import com.luoge.bos.invoice.model.common.dict.DictVO;
import com.luoge.ns.core.R;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 字典管理
 */
@RestController
@RequestMapping("/bos-op/common")
public class DictController {
    @Resource
    DictService dictService;

    @GetMapping("/dict")
    public R<List<DictVO>> listDicts(String type) {
        return R.success(dictService.listByType(type));
    }

}
