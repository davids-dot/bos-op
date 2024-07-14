package com.luoge.bos.op.invoice.park;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.luoge.bos.op.core.BOSConsts;
import com.luoge.bos.op.invoice.entity.TaxCalculateFormulaDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@DS(BOSConsts.DataSource.INVOICE)
@Mapper
public interface TaxCalculateFormulaDao {
    List<TaxCalculateFormulaDO> listByTaxType(Integer taxType);
}
