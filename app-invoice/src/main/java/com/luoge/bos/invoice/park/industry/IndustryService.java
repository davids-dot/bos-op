package com.luoge.bos.invoice.park.industry;

import cn.hutool.core.util.ObjectUtil;
import com.luoge.bos.invoice.entity.IndustryDO;
import com.luoge.bos.invoice.model.IndustryVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 行业选择
 */
@Service
public class IndustryService {

    @Resource
    private AppIndustryDao appIndustryDao;

    /**
     * 查询所有行业类型
     * @return
     */
    public List<IndustryVO> listIndustries(){
        List<IndustryDO> industryList = appIndustryDao.listAll();
        return industryList.stream()
                .map(this::toIndustryVO)
                .collect(Collectors.toList());
    }

    private IndustryVO toIndustryVO(IndustryDO industryDO){
        return new IndustryVO()
                .setId(industryDO.getId())
                .setName(industryDO.getName())
                .setExampleEnterprise(industryDO.getExampleEnterprise())
                .setInvoiceItems(Arrays.asList(industryDO.getInvoiceItems().split(",")));
    }

    public IndustryVO getById(Integer id){
        IndustryDO industryDO = appIndustryDao.getById(id);
        if (ObjectUtil.isNull(industryDO)){
            return null;
        }
        return toIndustryVO(industryDO);
    }
}
