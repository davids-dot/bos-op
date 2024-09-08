package com.luoge.app.uc.common;

import com.luoge.app.uc.entity.RegionDO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UcCommonService {

    @Resource
    private CommonDao commonDao;

    public List<RegionDO> listRegions() {
        return commonDao.listRegions();
    }

//    public List<IndustryBO> listIndustries() {
//        var industryDOS = commonDao.listIndustries();
//        if (CollectionUtil.isEmpty(industryDOS)) {
//            return Collections.emptyList();
//        }
//
//        // 构建列表
//        var industries = industryDOS.stream()
//                .map(industry -> new IndustryBO()
//                        .setValue(industry.getCode())
//                        .setLabel(industry.getName())
//                        .setSelectable(true)).toList();
//        buildIndustryTree(industries);
//        return industries.stream().filter(industryBO -> industryBO.getValue().length() == 1).toList();
//    }
//
//    public RegionDO getRegion(String code) {
//        return commonDao.getRegion(code);
//    }
//
//
//    public IndustryDO getIndustry(String code) {
//        return commonDao.getIndustry(code);
//    }
//
//
//    private void buildIndustryTree(List<IndustryBO> industries) {
//        industries.forEach(industry -> {
//            var len = industry.getValue().length();
//            if (len == 1) {
//                var children = industries.stream()
//                        .filter(item -> item.getValue().length() == 3 && item.getValue().substring(0, 1).equals(industry.getValue())).toList();
//                industry.setSelectable(false);
//                industry.setChildren(children);
//            } else if (len == 3) {
//                var children = industries.stream()
//                        .filter(item -> item.getValue().length() == 4 && item.getValue().substring(0, 3).equals(industry.getValue())).toList();
//                industry.setSelectable(false);
//                industry.setChildren(children);
//            } else if (len == 4) {
//                var children = industries.stream()
//                        .filter(item -> item.getValue().length() == 5 && item.getValue().substring(0, 4).equals(industry.getValue())).toList();
//                industry.setSelectable(false);
//                industry.setChildren(children);
//            }
//        });
//    }
}
