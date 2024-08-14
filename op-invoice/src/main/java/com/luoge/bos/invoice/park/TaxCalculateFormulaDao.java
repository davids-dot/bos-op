package com.luoge.bos.invoice.park;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.luoge.bos.core.BOSConsts;
import com.luoge.bos.invoice.entity.TaxCalculateFormulaDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@DS(BOSConsts.DataSource.INVOICE)
@Mapper
public interface TaxCalculateFormulaDao {
    List<TaxCalculateFormulaDO> listByTaxType(Integer taxType);
}
