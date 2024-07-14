CREATE DATABASE IF NOT EXISTS ns_invoice CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

use ns_invoice;

CREATE TABLE IF NOT EXISTS inv_operation_record
(
    id               bigint                                  NOT NULL AUTO_INCREMENT,
    business_id      bigint                                  NOT NULL COMMENT '业务数据的id',
    business_type    varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '业务类型',
    operation_type   varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '操作类型',
    operation_remark varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '操作备注',
    operator_id      int                                     DEFAULT NULL COMMENT '操作人id',
    create_time      datetime                                NOT NULL COMMENT '创建时间',
    PRIMARY KEY (id)
) COMMENT ='工商注册/开票申请操作历史表';

CREATE TABLE IF NOT EXISTS inv_park_enterprise
(
    id                                 bigint   NOT NULL AUTO_INCREMENT,
    org_id                             int      NOT NULL COMMENT '机构id',
    enterprise_id                      int      NOT NULL COMMENT '企业id',
    enterprise_name                    varchar(60) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '企业名称',
    service_fee_rate                   decimal(10, 5)                         DEFAULT NULL COMMENT '应收服务费费率',
    service_fee_payer_id               int                                    DEFAULT NULL COMMENT '服务费支付方',
    customer_id                        int                                    DEFAULT NULL COMMENT '所属客户',
    customer_manager                   varchar(60) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '客户经理',
    park_provider_id                   int                                    DEFAULT NULL COMMENT '园区服务商id',
    distributor_id                     int                                    DEFAULT NULL COMMENT '渠道商id',
    park_provider_additional_tax_rate  decimal(10, 5)                         DEFAULT NULL COMMENT '园区服务商个体工商户附加税税率',
    park_provider_water_tax_rate       decimal(10, 5)                         DEFAULT NULL COMMENT '园区服务商个体工商户水利基金税率',
    park_provider_stamp_tax_rate       decimal(10, 5)                         DEFAULT NULL COMMENT '园区服务商个体工商户印花税税率',
    park_provider_income_tax_rate      decimal(10, 5)                         DEFAULT NULL COMMENT '园区服务商个体工商户个人所得税税率',
    park_provider_service_fee_rate     decimal(10, 5)                         DEFAULT NULL COMMENT '园区服务商服务费费率',
    distributor_service_fee_rate       decimal(10, 5)                         DEFAULT NULL COMMENT '渠道商商服务费费率',
    create_time                        datetime NOT NULL COMMENT '创建时间',
    update_time                        datetime NOT NULL COMMENT '更新时间',
    value_added_tax_type               int                                    DEFAULT NULL COMMENT '增值税类型： 1、30万阈值； 2、每张票都缴纳',
    park_provider_value_added_tax_rate decimal(10, 5)                         DEFAULT NULL COMMENT '园区服务商个体工商户增值税税率',
    include_tax_rate                   decimal(10, 5)                         DEFAULT NULL COMMENT '包税税率',
    PRIMARY KEY (id),
    UNIQUE INDEX `uni_park_org_enterprise` (org_id, enterprise_id) USING BTREE
) COMMENT ='B表企业';

CREATE TABLE IF NOT EXISTS inv_park_enterprise_customer
(
    id   bigint NOT NULL AUTO_INCREMENT,
    name varchar(60) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '客户名称',
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS inv_park_enterprise_distributor
(
    id                bigint                                 NOT NULL AUTO_INCREMENT,
    name              varchar(60) COLLATE utf8mb4_general_ci NOT NULL COMMENT '渠道商名称',
    remark            text COLLATE utf8mb4_general_ci COMMENT '渠道商描述',
    status            int                                    NOT NULL COMMENT '渠道商状态 1-启用 2-停用',
    account_name      varchar(60) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '收款公司名',
    account_open_bank varchar(60) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '开户银行',
    account_bank      varchar(60) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '收款银行',
    account_no        varchar(40) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '收款银行账号',
    fee_rate          decimal(10, 5)                         NOT NULL COMMENT '佣金费率',
    create_time       datetime                               NOT NULL COMMENT '创建时间',
    update_time       datetime                               NOT NULL COMMENT '更新时间',
    PRIMARY KEY (id)
) COMMENT ='渠道商';

CREATE TABLE IF NOT EXISTS inv_park_enterprise_payer
(
    id   bigint NOT NULL AUTO_INCREMENT,
    name varchar(60) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '客户名称',
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS inv_park_provider
(
    id                             bigint                                 NOT NULL AUTO_INCREMENT,
    name                           varchar(60) COLLATE utf8mb4_general_ci NOT NULL COMMENT '服务商名称',
    remark                         text COLLATE utf8mb4_general_ci COMMENT '园区服务商描述',
    status                         int                                             DEFAULT NULL COMMENT '渠道商状态 1-启用 2-停用',
    account_name                   varchar(60) COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '收款公司',
    account_open_bank              varchar(60) COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '开户银行',
    account_bank                   varchar(60) COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '收款银行',
    account_no                     varchar(40) COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '收款银行账号',
    service_fee_rate               decimal(10, 5)                         NOT NULL COMMENT '服务费费率',
    additional_tax_rate            decimal(10, 5)                                  DEFAULT NULL COMMENT '个体工商户附加税税率',
    water_tax_rate                 decimal(10, 5)                                  DEFAULT NULL COMMENT '个体工商户水利基金税率',
    stamp_tax_rate                 decimal(10, 5)                                  DEFAULT NULL COMMENT '个体工商户印花税税率',
    income_tax_rate                decimal(10, 5)                                  DEFAULT NULL COMMENT '个体工商户个人所得税税率',
    income_tax_type                int                                             DEFAULT NULL COMMENT '个人所得税计算方式  1-附征率 2-应税所得，累计减半',
    registration_fee               decimal(18, 2)                                  DEFAULT NULL COMMENT '应收工商注册费',
    park_provider_registration_fee decimal(18, 2)                                  DEFAULT NULL COMMENT '应付园区服务商注册费',
    is_mini_app_show               varchar(5) COLLATE utf8mb4_general_ci           DEFAULT '0' COMMENT '移动端是否可见',
    create_time                    datetime                               NOT NULL COMMENT '创建时间',
    update_time                    datetime                               NOT NULL COMMENT '更新时间',
    value_added_tax_type           int                                             DEFAULT 1 COMMENT '增值税类型： 1、30万阈值； 2、每张票都缴纳',
    value_added_tax_formula_id     int                                             DEFAULT NULL COMMENT '增值税计算公式',
    additional_tax_formula_id      int                                             DEFAULT NULL COMMENT '附加税计算公式',
    water_tax_formula_id           int                                             DEFAULT NULL COMMENT '水利基金计算公式',
    stamp_tax_formula_id           int                                             DEFAULT NULL COMMENT '印花税计算公式',
    income_tax_formula_id          int                                             DEFAULT NULL COMMENT '个人所得税计算公式',
    value_added_tax_rate           decimal(10, 5)                                  DEFAULT NULL COMMENT '个体工商户增值税税率',
    is_include_tax                 varchar(5) COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '0' COMMENT '是否包税 ',
    include_tax_rate               decimal(10, 5)                                  DEFAULT NULL COMMENT '包税税率',
    PRIMARY KEY (id)
) COMMENT ='园区服务商';

CREATE TABLE IF NOT EXISTS sys_dict
(
    id     bigint                                  NOT NULL AUTO_INCREMENT,
    code   varchar(60) COLLATE utf8mb4_general_ci  NOT NULL COMMENT '编码',
    value  varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '值',
    type   varchar(20) COLLATE utf8mb4_general_ci  NOT NULL COMMENT '字典类型',
    weight smallint DEFAULT NULL COMMENT '权重',
    status smallint                                NOT NULL COMMENT '状态 1-启用 2-禁用',
    PRIMARY KEY (id)
) COMMENT ='代码表';


CREATE TABLE IF NOT EXISTS sys_file
(
    id            bigint                                  NOT NULL AUTO_INCREMENT,
    org_id        int                                     NOT NULL COMMENT '机构id',
    enterprise_id int                                     NOT NULL COMMENT '企业id',
    name          varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文件名称',
    content_type  varchar(40) COLLATE utf8mb4_general_ci  NOT NULL COMMENT '文件类型 1-pdf 2-jpg 3-jpeg 4-png 5-ofd',
    file_type     smallint                                DEFAULT NULL COMMENT '文件类型 1-pdf 2-jpg 3-jpeg 4-png 5-ofd',
    size          int                                     NOT NULL COMMENT '大小',
    url           varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '下载地址',
    storage_type  varchar(40) COLLATE utf8mb4_general_ci  NOT NULL COMMENT '存储类型 1-本地 2-华为云 3-阿里云',
    create_time   datetime                                NOT NULL COMMENT '创建时间',
    original_name varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '上传的原始文件名称',
    PRIMARY KEY (id)
) COMMENT ='文件表';


CREATE TABLE IF NOT EXISTS tax_calculate_formula
(
    id                 bigint                                  NOT NULL AUTO_INCREMENT,
    tax_type           int                                     NOT NULL COMMENT '税种类型',
    tax_type_name      varchar(60) COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '税种名称',
    formula_name       varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '公式名称',
    formula_expression varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '公式表达式',
    PRIMARY KEY (id)
);
