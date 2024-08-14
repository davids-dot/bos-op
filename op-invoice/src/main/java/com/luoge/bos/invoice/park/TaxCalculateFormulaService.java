package com.luoge.bos.invoice.park;

import com.luoge.bos.invoice.model.TaxCalculateFormulaBO;
import com.luoge.bos.invoice.entity.TaxCalculateFormulaDO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaxCalculateFormulaService {

    @Resource
    private TaxCalculateFormulaDao taxCalculateFormulaDao;

    public List<TaxCalculateFormulaBO> listTaxCalculateFormula(Integer taxType) {
        List<TaxCalculateFormulaDO> taxCalculateFormulaDOS = taxCalculateFormulaDao.listByTaxType(taxType);
        return taxCalculateFormulaDOS.stream()
                .map(this::toTaxCalculateFormulaBO)
                .collect(Collectors.toList());
    }

    private TaxCalculateFormulaBO toTaxCalculateFormulaBO(TaxCalculateFormulaDO taxCalculateFormulaDO) {
        return new TaxCalculateFormulaBO()
                .setId(taxCalculateFormulaDO.getId())
                .setTaxType(taxCalculateFormulaDO.getTaxType())
                .setTaxTypeName(taxCalculateFormulaDO.getTaxTypeName())
                .setFormulaName(taxCalculateFormulaDO.getFormulaName())
                .setFormulaExpression(taxCalculateFormulaDO.getFormulaExpression());
    }
}
