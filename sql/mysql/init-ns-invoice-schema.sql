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

CREATE TABLE IF NOT EXISTS inv_enterprise_registration
(
    id                         bigint   NOT NULL AUTO_INCREMENT,
    org_id                     int                                     DEFAULT NULL COMMENT '机构id ',
    user_id                    int                                     DEFAULT NULL COMMENT '申请用户的id',
    status                     int                                     DEFAULT NULL COMMENT '申请单状态  1-待付款 2-待审核 3-办理中 4-已完成 5-已作废',
    industry_id                int                                     DEFAULT NULL COMMENT '开票行业',
    id_card_front_file_id      int                                     DEFAULT NULL COMMENT '法人身份证正面文件id',
    id_card_back_file_id       int                                     DEFAULT NULL COMMENT '法人身份证反面文件id',
    photo_file_id              int                                     DEFAULT NULL COMMENT '法人半身照片文件id',
    corporate_name             varchar(40) COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '法人姓名',
    corporate_id_no            varchar(30) COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '法人身份证号',
    corporate_phone            varchar(30) COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '法人手机号码',
    is_bureau                  varchar(5) COLLATE utf8mb4_general_ci   DEFAULT NULL COMMENT '企业名称以工商局核定为准',
    candidate_enterprise_name  varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '候选企业名称',
    payment_proof_file_id      varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '付款凭证图片',
    payment_amount             decimal(18, 2)                          DEFAULT NULL COMMENT '付款金额',
    park_provider_id           int                                     DEFAULT NULL COMMENT '园区服务商id',
    park_provider_account_name varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '收款公司名',
    park_provider_account_bank varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '收款银行',
    park_provider_account_no   varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '收款银行账号',
    park_provider_name         varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '园区名称',
    enterprise_name            varchar(50) COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '审批后的企业名称',
    enterprise_tax_no          varchar(30) COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '税号',
    enterprise_type            int                                     DEFAULT NULL COMMENT '企业类型',
    enterprise_license_file_id int                                     DEFAULT NULL COMMENT '营业执照的文件id',
    real_corporate_name        varchar(40) COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '真实法人姓名',
    has_other_enterprise       varchar(5) COLLATE utf8mb4_general_ci   DEFAULT '0' COMMENT '是否存在其他个体户',
    create_time                datetime NOT NULL COMMENT '创建时间',
    update_time                datetime NOT NULL COMMENT '更新时间',
    PRIMARY KEY (id)
) COMMENT ='工商注册申请';

CREATE TABLE IF NOT EXISTS inv_invoice_apply
(
    id                      bigint                                  NOT NULL AUTO_INCREMENT,
    org_id                  int                                     NOT NULL COMMENT '所属机构id',
    enterprise_id           int                                     NOT NULL COMMENT '企业id',
    user_id                 int                                     DEFAULT NULL,
    invoice_type            smallint                                DEFAULT NULL COMMENT '票种类型 81增值税专用发票; 82增值税普通发票; ',
    buyer_personal_flag     varchar(5) COLLATE utf8mb4_general_ci   DEFAULT NULL COMMENT '是否自然人',
    buyer_name              varchar(100) COLLATE utf8mb4_general_ci NOT NULL COMMENT '购方名称',
    buyer_tax_no            varchar(40) COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '购方税号',
    buyer_address           varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '购方地址',
    buyer_phone             varchar(20) COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '购方联系电话',
    buyer_bank_name         varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '购方开户银行',
    buyer_bank_account      varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '购方银行账号',
    seller_name             varchar(100) COLLATE utf8mb4_general_ci NOT NULL COMMENT '销方名称',
    seller_tax_no           varchar(40) COLLATE utf8mb4_general_ci  NOT NULL COMMENT '销方税号',
    seller_address          varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '销方地址',
    seller_phone            varchar(20) COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '销方联系电话',
    seller_bank_name        varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '销方开户银行',
    seller_bank_account     varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '销方银行账号',
    total_amount            decimal(16, 2)                          NOT NULL COMMENT '合计金额',
    total_tax               decimal(16, 2)                          NOT NULL COMMENT '合计税额',
    total                   decimal(16, 2)                          NOT NULL COMMENT '价税合计',
    remark                  varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
    notify_email            varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '开具通知邮件',
    status                  smallint                                NOT NULL COMMENT '申请单状态  1-待付款 2-待审核 3-已通过 4-已驳回 5-已作废',
    include_tax_flag        varchar(5) COLLATE utf8mb4_general_ci   DEFAULT NULL COMMENT '金额显示是否含税',
    business_proof_file_ids varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '业务凭证图片id列表',
    fund_proof_file_ids     varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '资金流水凭证图片id 列表',
    service_fee             decimal(18, 2)                          DEFAULT NULL COMMENT '应收服务费',
    payment_proof_file_id   varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '付款凭证图片id，逗号分隔',
    is_issued_invoice       varchar(5) COLLATE utf8mb4_general_ci   DEFAULT '0' COMMENT '是否已开具发票',
    create_time             datetime                                NOT NULL COMMENT '创建时间',
    update_time             datetime                                NOT NULL COMMENT '更新时间',
    service_fee_rate        decimal(10, 5)                          DEFAULT NULL COMMENT '服务费率',
    PRIMARY KEY (id)
) COMMENT ='销项发票申请表';

CREATE TABLE IF NOT EXISTS inv_invoice_apply_item
(
    id                 bigint                                  NOT NULL AUTO_INCREMENT,
    org_id             int                                     NOT NULL COMMENT '机构id',
    enterprise_id      int                                     NOT NULL COMMENT '企业id',
    apply_id           bigint                                  NOT NULL COMMENT '申请单id',
    row_no             int                                    DEFAULT NULL COMMENT '税局发票项目行号',
    product_id         int                                    DEFAULT NULL COMMENT '商品的id',
    name               varchar(100) COLLATE utf8mb4_general_ci NOT NULL COMMENT '货物或服务名称',
    spec               varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '规格',
    unit               varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '单位',
    quantity           decimal(26, 13)                        DEFAULT NULL COMMENT '数量',
    price              decimal(26, 13)                        DEFAULT NULL COMMENT '单价',
    amount             decimal(16, 4)                          NOT NULL COMMENT '金额',
    tax_rate           decimal(6, 4)                           NOT NULL COMMENT '税率',
    tax_amount         decimal(16, 4)                          NOT NULL COMMENT '税额',
    tax_code           varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '税收分类编码',
    type               int                                    DEFAULT NULL COMMENT '折扣标志， 1 无折扣 2 被折扣行  3是折扣行',
    special_type       varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '优惠政策及简易计税类型',
    create_time        datetime                                NOT NULL COMMENT '创建时间',
    include_tax_price  decimal(26, 13)                        DEFAULT NULL COMMENT '含税单价',
    include_tax_amount decimal(16, 2)                         DEFAULT NULL COMMENT '含税金额',
    PRIMARY KEY (id)
) COMMENT ='销项发票申请明细表';
