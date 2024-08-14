CREATE DATABASE IF NOT EXISTS bos_op CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

use bos_op;

CREATE TABLE IF NOT EXISTS inv_invoice
(
    id                               bigint         NOT NULL AUTO_INCREMENT COMMENT '主键id',
    org_id                           int            NOT NULL COMMENT '机构id',
    enterprise_id                    int            NOT NULL COMMENT '企业id',
    type                             int            NOT NULL COMMENT '票种类型 1增值税专用发票; 2增值税普通发票; 3机动车销售统一发票;4货物运输业增值税专用发票;5通行费发票;6成品油电子发票',
    invoice_no                       varchar(30) COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '发票号码',
    invoice_code                     varchar(30) COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '发票代码',
    buyer_name                       varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '购方名称',
    issue_time                       datetime                                DEFAULT NULL COMMENT '开票时间',
    total_amount                     decimal(16, 2) NOT NULL COMMENT '合计金额',
    total_tax                        decimal(16, 2) NOT NULL COMMENT '合计税额',
    total                            decimal(16, 2) NOT NULL COMMENT '价税合计',
    service_fee_rate                 decimal(16, 5)                          DEFAULT NULL COMMENT '服务费费率',
    service_fee                      decimal(16, 2)                          DEFAULT NULL COMMENT '服务费',
    source_type                      smallint                                DEFAULT NULL COMMENT '发票来源  1-发票同步 2-发票补录',
    category                         smallint       NOT NULL COMMENT '发票分类 1-增值税蓝票 2-增值税红票',
    create_time                      datetime       NOT NULL COMMENT '创建时间',
    update_time                      datetime       NOT NULL COMMENT '更新时间',
    income                           decimal(16, 3)                          DEFAULT NULL COMMENT '应归属收入',
    park_provider_id                 int                                     DEFAULT NULL COMMENT '园区服务商id',
    park_provider_name               varchar(40) COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '园区供应商名称',
    park_provider_amount             decimal(16, 3)                          DEFAULT NULL COMMENT '应付园区服务商金额',
    park_provider_fee                decimal(16, 2)                          DEFAULT NULL COMMENT '园区服务商服务费',
    park_provider_total_tax          decimal(16, 3)                          DEFAULT NULL COMMENT '园区服务商各税累计',
    park_provider_value_added_tax    decimal(16, 2)                          DEFAULT NULL COMMENT '应付园区服务商的增值税',
    park_provider_additional_tax     decimal(16, 2)                          DEFAULT NULL COMMENT '应付园区服务商的附加税',
    park_provider_water_tax          decimal(16, 2)                          DEFAULT NULL COMMENT '应付园区服务商的水利基金税',
    park_provider_stamp_tax          decimal(16, 2)                          DEFAULT NULL COMMENT '应付园区服务商的印花税',
    park_provider_income_tax         decimal(16, 2)                          DEFAULT NULL COMMENT '应付园区服务商的个人所得税',
    park_enterprise_distributor_id   int                                     DEFAULT NULL COMMENT '渠道商id',
    park_enterprise_distributor_name varchar(40) COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '渠道商名称',
    park_enterprise_distributor_fee  decimal(16, 3)                          DEFAULT NULL COMMENT '渠道商佣金',
    park_enterprise_id               int                                     DEFAULT NULL,
    park_enterprise_name             varchar(60) COLLATE utf8mb4_general_ci  DEFAULT NULL,
    invoice_tax_rate                 decimal(10, 5)                          DEFAULT NULL COMMENT '发票税率',
    business_id                      varchar(127)   NULL COMMENT '业务id',
    PRIMARY KEY (id)
) COMMENT ='销项发票表';



CREATE TABLE IF NOT EXISTS inv_sync_record
(
    id             int      NOT NULL AUTO_INCREMENT,
    last_sync_time datetime NOT NULL,
    update_time    datetime NOT NULL,
    PRIMARY KEY (id)
);