package com.luoge.bos.op.invoice.org.industry;

import cn.hutool.core.util.ObjectUtil;

import com.luoge.bos.op.invoice.common.IndustryDao;
import com.luoge.bos.op.invoice.entity.invoice.IndustryDO;
import com.luoge.bos.op.invoice.model.industry.IndustryVO;
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
    private IndustryDao industryDao;

    /**
     * 查询所有行业类型
     * @return
     */
    public List<IndustryVO> listIndustries(){
        List<IndustryDO> industryList = industryDao.listAll();
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

}
