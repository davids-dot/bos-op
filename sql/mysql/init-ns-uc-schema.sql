CREATE DATABASE IF NOT EXISTS ns_uc CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

use ns_uc;

CREATE TABLE IF NOT EXISTS iam_api_key
(
    id          int          NOT NULL AUTO_INCREMENT,
    org_id      int          NOT NULL COMMENT '机构id',
    api_key     varchar(100) NOT NULL COMMENT 'appKey',
    secret_key  varchar(255) NOT NULL COMMENT '秘钥',
    remark      varchar(100) DEFAULT NULL COMMENT '备注',
    expire_time datetime     DEFAULT NULL COMMENT '过期时间',
    create_time datetime     NOT NULL COMMENT '创建时间',
    PRIMARY KEY (id),
    UNIQUE KEY uni_org_api_ley (org_id, api_key) USING BTREE
);


CREATE TABLE IF NOT EXISTS iam_app
(
    id          int         NOT NULL AUTO_INCREMENT,
    code        varchar(10) NOT NULL COMMENT '应用代码',
    name        varchar(20) NOT NULL COMMENT '名称',
    logo        varchar(100) DEFAULT NULL COMMENT 'logo',
    base_url    varchar(30)  DEFAULT NULL COMMENT '基础url',
    status      smallint    NOT NULL COMMENT '应用状态 1-正常 2-下线',
    remark      varchar(100) DEFAULT NULL COMMENT '备注',
    create_time datetime     DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (id)
) COMMENT ='应用';


CREATE TABLE IF NOT EXISTS iam_audit_log
(
    id          int          NOT NULL AUTO_INCREMENT,
    org_id      int          NOT NULL COMMENT '机构id',
    user_id     bigint       NOT NULL COMMENT '用户id',
    biz_type    smallint     NOT NULL COMMENT '业务类型',
    action      smallint     NOT NULL COMMENT '动作',
    request     longtext     NOT NULL COMMENT '请求',
    result      varchar(100) NOT NULL COMMENT '结果',
    create_time datetime     NOT NULL COMMENT '操作时间',
    PRIMARY KEY (id)
) COMMENT ='审计日志表';


CREATE TABLE IF NOT EXISTS iam_authorization
(
    id              int         NOT NULL AUTO_INCREMENT,
    org_id          int         NOT NULL COMMENT 'pk_iam_authorization',
    target_type     smallint    NOT NULL COMMENT '授权对象类型：1-角色, 2-用户, 3-用户组',
    target_id       bigint      NOT NULL COMMENT '授权对象id',
    permission_code varchar(30) NOT NULL COMMENT '权限code',
    create_time     datetime DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (id)
) COMMENT ='授权';


CREATE TABLE IF NOT EXISTS iam_dm_industry
(
    code   varchar(10) NOT NULL COMMENT '行业代码',
    name   varchar(200) DEFAULT NULL COMMENT '行业名称',
    remark longtext COMMENT '描述',
    PRIMARY KEY (code)
);


CREATE TABLE IF NOT EXISTS iam_dm_region
(
    code varchar(12) NOT NULL COMMENT '行政区划代码',
    name varchar(20) NOT NULL COMMENT '行政区划名称',
    PRIMARY KEY (code)
) COMMENT ='行政区划';


CREATE TABLE IF NOT EXISTS iam_email_template
(
    id          int          NOT NULL AUTO_INCREMENT,
    name        varchar(100) NOT NULL COMMENT '模板名称',
    status      smallint     NOT NULL COMMENT '模板状态 1 启用',
    business    varchar(20)  NOT NULL COMMENT '业务标识',
    description varchar(200) NOT NULL COMMENT '模板描述',
    locale      varchar(20)  NOT NULL COMMENT '语言',
    title       varchar(200) NOT NULL COMMENT '邮件标题',
    content     longtext     NOT NULL COMMENT '邮件内容',
    create_time datetime     NOT NULL COMMENT '创建时间',
    update_time datetime     NOT NULL COMMENT '更新时间',
    PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS iam_enterprise
(
    id                   int          NOT NULL AUTO_INCREMENT COMMENT '企业id',
    org_id               int          NOT NULL COMMENT '机构id',
    name                 varchar(100) NOT NULL COMMENT '企业名称',
    type                 smallint     NOT NULL COMMENT '类型: 1-一般纳税人, 2-小规模纳税人',
    tax_no               varchar(40)  NOT NULL COMMENT '纳税人识别号',
    region_code          varchar(10)  DEFAULT NULL COMMENT '所属行政编码',
    industry_code        varchar(10)  DEFAULT NULL COMMENT '所属行业代码',
    bank                 varchar(100) DEFAULT NULL COMMENT '联系电话',
    account              varchar(20)  DEFAULT NULL COMMENT '联系电话',
    address              varchar(255) DEFAULT NULL COMMENT '地址',
    phone                varchar(20)  DEFAULT NULL COMMENT '联系电话',
    remark               text COMMENT '备注',
    status               smallint     NOT NULL COMMENT '状态 1-正常 0-禁用',
    upstream_username    varchar(50)  DEFAULT NULL COMMENT '税务局-用户名',
    upstream_passwd      varchar(50)  DEFAULT NULL COMMENT '税务局-密码',
    create_time          datetime     DEFAULT NULL COMMENT '创建时间',
    update_time          datetime     DEFAULT NULL COMMENT '更新时间',
    bureau_identity_type int          DEFAULT NULL COMMENT '税局身份类型',
    PRIMARY KEY (id),
    UNIQUE KEY uk_iam_enterprise (org_id, tax_no) USING BTREE
) COMMENT ='机构';


CREATE TABLE IF NOT EXISTS iam_enterprise_user
(
    id            int      NOT NULL AUTO_INCREMENT,
    org_id        int      NOT NULL COMMENT '机构id',
    enterprise_id int      NOT NULL COMMENT '企业id',
    user_id       int      NOT NULL COMMENT '用户id',
    create_time   datetime NOT NULL COMMENT '创建时间',
    PRIMARY KEY (id),
    UNIQUE KEY uni_org_enterprise_user_key (org_id, enterprise_id, user_id) USING BTREE
) COMMENT ='企业以及用户的关联';


CREATE TABLE IF NOT EXISTS iam_menu
(
    id          int         NOT NULL AUTO_INCREMENT,
    app_id      int         NOT NULL COMMENT '所属app',
    name        varchar(40) NOT NULL COMMENT '名称',
    url         varchar(100) DEFAULT NULL COMMENT 'url地址',
    parent_id   int         NOT NULL COMMENT '上级菜单id',
    seq         int         NOT NULL COMMENT '排序号',
    create_time datetime     DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (id)
) COMMENT ='菜单';


CREATE TABLE IF NOT EXISTS iam_org
(
    id          int          NOT NULL COMMENT '机构id',
    name        varchar(100) NOT NULL COMMENT '企业名称',
    logo        varchar(255) DEFAULT NULL COMMENT 'logo',
    remark      varchar(255) DEFAULT NULL COMMENT '备注',
    create_time datetime     DEFAULT NULL COMMENT '创建时间',
    update_time datetime     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (id)
) COMMENT ='机构';


CREATE TABLE IF NOT EXISTS iam_permission
(
    code        varchar(30) NOT NULL COMMENT '权限编码',
    name        varchar(50) NOT NULL COMMENT '权限名称',
    remark      varchar(100) DEFAULT NULL COMMENT '备注',
    level       smallint    NOT NULL COMMENT '层级',
    seq         smallint    NOT NULL COMMENT '序号',
    create_time datetime     DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (code)
) COMMENT ='权限';


CREATE TABLE IF NOT EXISTS iam_permission_menu
(
    id              bigint      NOT NULL AUTO_INCREMENT,
    permission_code varchar(30) NOT NULL COMMENT '权限code',
    menu_id         int         NOT NULL COMMENT '菜单id',
    create_time     datetime DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (id)
) COMMENT ='权限菜单关系';


CREATE TABLE IF NOT EXISTS iam_permission_resource
(
    id              int         NOT NULL AUTO_INCREMENT,
    permission_code varchar(30) NOT NULL COMMENT '权限code',
    resource_id     int         NOT NULL COMMENT '资源id',
    create_time     datetime DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (id)
) COMMENT ='权限资源关系';


CREATE TABLE IF NOT EXISTS iam_product
(
    id     int         NOT NULL AUTO_INCREMENT,
    name   varchar(50) NOT NULL COMMENT '产品名称',
    price  decimal(18, 2) DEFAULT NULL,
    unit   smallint       DEFAULT NULL,
    remark varchar(100)   DEFAULT NULL COMMENT '产品描述',
    PRIMARY KEY (id)
) COMMENT ='商品';

CREATE TABLE IF NOT EXISTS iam_product_expiry
(
    id            int NOT NULL AUTO_INCREMENT,
    org_id        int NOT NULL COMMENT '机构id',
    enterprise_id int NOT NULL COMMENT '企业id',
    product_id    int NOT NULL COMMENT '商品id',
    expiry_time   datetime DEFAULT NULL COMMENT '过期时间',
    create_time   datetime DEFAULT NULL,
    update_time   datetime DEFAULT NULL,
    PRIMARY KEY (id)
) COMMENT ='商品有效期';

CREATE TABLE IF NOT EXISTS iam_product_order
(
    id            int            NOT NULL AUTO_INCREMENT,
    org_id        int            NOT NULL COMMENT '机构id',
    enterprise_id int            NOT NULL COMMENT '企业id',
    product_id    int            NOT NULL COMMENT '商品id',
    price         decimal(18, 2) NOT NULL COMMENT '商品价格',
    quantity      decimal(18, 2) NOT NULL COMMENT '商品数量',
    amount        decimal(18, 2) NOT NULL COMMENT '商品金额',
    unit          smallint       NOT NULL COMMENT '单位',
    create_time   datetime DEFAULT NULL,
    update_time   datetime DEFAULT NULL,
    PRIMARY KEY (id)
) COMMENT ='商品订单';


CREATE TABLE IF NOT EXISTS iam_resource
(
    id          int         NOT NULL AUTO_INCREMENT,
    name        varchar(40) NOT NULL COMMENT '名称',
    url         varchar(100) DEFAULT NULL COMMENT 'url',
    create_time datetime     DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (id)
) COMMENT ='资源';


CREATE TABLE IF NOT EXISTS iam_role
(
    id          bigint      NOT NULL AUTO_INCREMENT,
    org_id      int         NOT NULL COMMENT '机构id',
    name        varchar(20) NOT NULL COMMENT '角色名称',
    remark      varchar(100) DEFAULT NULL COMMENT '描述',
    create_time datetime     DEFAULT NULL COMMENT '创建时间',
    update_time datetime     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (id)
) COMMENT ='角色';

CREATE TABLE IF NOT EXISTS iam_user
(
    id          int         NOT NULL AUTO_INCREMENT,
    org_id      int         NOT NULL,
    name        varchar(20) NOT NULL COMMENT '用户名',
    username    varchar(30) NOT NULL COMMENT '登录名称',
    mobile      varchar(20)  DEFAULT NULL COMMENT '手机号',
    email       varchar(50)  DEFAULT NULL COMMENT '邮箱',
    passwd      varchar(32) NOT NULL COMMENT '密码（加密）',
    avatar      varchar(100) DEFAULT NULL COMMENT '头像url',
    status      smallint    NOT NULL COMMENT '状态: 1-正常, 2-锁定, 3-注销',
    remark      varchar(100) DEFAULT NULL COMMENT '备注',
    admin       int         NOT NULL,
    create_time datetime     DEFAULT NULL COMMENT '创建时间',
    update_time datetime     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (id),
    UNIQUE KEY uk_iam_user_username (username) USING BTREE,
    UNIQUE KEY uk_iam_user_mobile (mobile) USING BTREE,
    UNIQUE KEY uk_iam_user_email (email) USING BTREE
) COMMENT ='用户';

CREATE TABLE IF NOT EXISTS iam_user_role
(
    id          int    NOT NULL AUTO_INCREMENT,
    org_id      int    NOT NULL COMMENT '企业id',
    user_id     bigint NOT NULL COMMENT '用户id',
    role_id     int    NOT NULL COMMENT '角色id',
    create_time datetime DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (id)
) COMMENT ='用户角色';


CREATE TABLE IF NOT EXISTS iam_user_thirds
(
    id          bigint      NOT NULL AUTO_INCREMENT,
    type        int         NOT NULL COMMENT '类型 1-微信小程序  2-开放平台 3-微信公众号',
    open_id     varchar(32) NOT NULL COMMENT ' openid',
    user_id     bigint       DEFAULT NULL COMMENT '绑定的用户id',
    status      smallint    NOT NULL COMMENT '用户状态 1-正常 2-注销',
    remark      varchar(100) DEFAULT NULL COMMENT '备注',
    ext         longtext COMMENT '扩展字段',
    create_time datetime    NOT NULL COMMENT '创建时间',
    update_time datetime    NOT NULL COMMENT '修改时间',
    app_id      varchar(32)  DEFAULT NULL COMMENT '应用id',
    union_id    varchar(32)  DEFAULT NULL COMMENT '开放平台id',
    PRIMARY KEY (id),
    UNIQUE KEY uni_user_thd_open_id (open_id) USING BTREE,
    UNIQUE KEY uni_user_app_id (user_id, app_id) USING BTREE
);


CREATE TABLE IF NOT EXISTS msg_push_record
(
    id            bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
    org_id        int    NOT NULL COMMENT '机构id',
    enterprise_id int          DEFAULT NULL COMMENT '企业id',
    user_id       int          DEFAULT NULL COMMENT '发送用户id',
    wx_msg_code   longtext COMMENT '消息类型',
    content       varchar(200) DEFAULT NULL COMMENT '推送内容',
    create_time   datetime     DEFAULT NULL COMMENT '发送时间',
    PRIMARY KEY (id)
);