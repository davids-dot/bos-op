package com.luoge.bos.op.core.types;

import java.util.Arrays;

public enum InvoiceType {
    /**
     * 未知票据
     */
    UNKNOWN(0, "未知票据"),
    /**
     * 增值税专用发票
     */
    VAT_SPECIAL_INVOICE(1, "增值税专用发票"),
    /**
     * 机动车销售统一发票
     */
    MVS_INVOICE(3, "机动车销售统一发票"),
    /**
     * 增值税普通发票
     */
    VAT_COMMON_INVOICE(4, "增值税普通发票"),
    /**
     * 增值税电子专用发票
     */
    VAT_ELE_SPECIAL(8, "增值税电子专用发票"),
    /**
     * 增值税电子普通发票
     */
    VAT_ELE_GENERAL(10, "增值税电子普通发票"),
    /**
     * 增值税电子普通发票
     */
    VAT_ELE_GENERAL_ROLL(11, "增值税普票发票（卷票）"),
    /**
     * 增值税电子普通发票
     */
    TOLL_INVOICE(14, "通行费发票"),
    /**
     * 二手车统一销售发票
     */
    OLD_MVS_INVOICE(15, "二手车统一销售发票"),
    /**
     * 海关缴款书
     */
    CUSTOMS_TICKET(17, "海关缴款书"),
    /**
     * 数电票（铁路电子客票）
     */
    ELECTRONIC_INVOICE_TRAIN(51, "铁路电子客票"),
    /**
     * 航空运输电子客票行程单
     */
    ELECTRONIC_FLIGHT(61, "航空运输电子客票行程单"),
    /**
     * 全电票(增值税专用发票)
     */
    ELECTRONIC_FULL_SPECIAL(81, "全电票(增值税专用发票)"),
    /**
     * 全电票(增值税普通发票)
     */
    ELECTRONIC_FULL_GENERAL(82, "全电票(增值税普通发票)"),
    /**
     * 纸质发票(增值税专用发票)
     */
    VAT_ELE_PAPER_SPECIAL(85, "纸质发票(增值税专用发票)"),
    /**
     * 纸质发票(增值税普通发票)
     */
    VAT_ELE_PAPER_GENERAL(86, "纸质发票(增值税普通发票)"),
    /**
     * 收购发票
     */
    PURCHASE_INVOICE(90, "收购发票"),
    /**
     * 免税自产农产品普通发票
     */
    AGRICULTURAL_FREE_TAX(91, "免税自产农产品普通发票"),
    /**
     * 代扣代缴完税凭证
     */
    WITHHOLDING_TAX_TICKET(92, "代扣代缴完税凭证"),
    /**
     * 火车票
     */
    TRAIN_TICKET(99, "火车票"),
    /**
     * 合计
     */
    SUMMARY(999, "合计");

    public final int type;
    public final String name;

    InvoiceType(int type, String name) {
        this.type = type;
        this.name = name;
    }


    public static InvoiceType of(int type) {
        return Arrays.stream(InvoiceType.values()).filter(t -> t.type == type).findFirst().orElse(UNKNOWN);
    }


    public static boolean personalCanIssue(InvoiceType invoiceType) {
        return ELECTRONIC_FULL_SPECIAL != invoiceType
                && VAT_SPECIAL_INVOICE != invoiceType;
    }

    /**
     * 是全电票(数电票)
     */
    public boolean isFullElectronic() {
        return this == ELECTRONIC_FULL_SPECIAL || this == ELECTRONIC_FULL_GENERAL;
    }

    /**
     * 是增值税票
     */
    public boolean isVatInvoice() {
        return this == VAT_SPECIAL_INVOICE ||
                this == VAT_COMMON_INVOICE ||
                this == VAT_ELE_GENERAL ||
                this == VAT_ELE_SPECIAL;
    }

    /**
     * 是增值税票
     */
    public boolean isVatNormalInvoice() {
        return this == VAT_SPECIAL_INVOICE ||
                this == VAT_COMMON_INVOICE;
    }

    /**
     * 是增值税票
     */
    public boolean isVatELEInvoice() {
        return this == VAT_ELE_GENERAL ||
                this == VAT_ELE_SPECIAL;
    }

    public boolean isNotSupported() {
        return !isVatInvoice() && !isFullElectronic();
    }

    /**
     * 是否支持查验
     * <p>
     * 支持查验的票有
     * 增值税票：
     * （01）增值税专用发票
     * （04）增值税普通发票
     * （08）增值税电子专用发票
     * （10）增值税电子普通发票（含通行费发票）
     * <p>
     * 全电票：
     * （81）电子发票（增值税专用发票）
     * （82）电子发票（普通发票）
     * <p>
     * 其他：
     * （03）机动车销售统一发票
     * （11）增值税普通发票（卷票）
     * （15）二手车销售统一发票发票
     * （51）电子发票（铁路电子客票）
     * （61）电子发票（航空运输电子客票行程单）
     * （85）纸质发票（增值税专用发票）
     * （86）纸质发票（普通发票）
     */
    public boolean isSupportVerify() {
        return isVatInvoice() ||
                isFullElectronic() ||
                this == MVS_INVOICE ||   // 3
                this == VAT_ELE_GENERAL_ROLL ||  // 11
                this == OLD_MVS_INVOICE || // 15
                this == ELECTRONIC_INVOICE_TRAIN || // 51
                this == ELECTRONIC_FLIGHT ||  // 61
                this == VAT_ELE_PAPER_SPECIAL || // 85
                this == VAT_ELE_PAPER_GENERAL; // 86

    }
}
