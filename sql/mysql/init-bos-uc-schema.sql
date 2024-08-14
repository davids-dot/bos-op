CREATE DATABASE IF NOT EXISTS bos_uc CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

use bos_uc;

CREATE TABLE IF NOT EXISTS iam_app
(
    id          int                                    NOT NULL,
    code        varchar(10) COLLATE utf8mb4_general_ci NOT NULL COMMENT '应用代码',
    name        varchar(20) COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
    logo        varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'logo',
    base_url    varchar(30) COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '基础url',
    status      smallint                               NOT NULL COMMENT '应用状态 1-正常 2-下线',
    remark      varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
    create_time datetime                                DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (id)
) COMMENT ='应用';


CREATE TABLE IF NOT EXISTS iam_authorization
(
    id              int                                    NOT NULL AUTO_INCREMENT,
    org_id          int                                    NOT NULL COMMENT 'pk_iam_authorization',
    target_type     smallint                               NOT NULL COMMENT '授权对象类型：1-角色, 2-用户, 3-用户组',
    target_id       bigint                                 NOT NULL COMMENT '授权对象id',
    permission_code varchar(30) COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限code',
    create_time     datetime DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (id)
) COMMENT ='授权';


CREATE TABLE IF NOT EXISTS iam_menu
(
    id          int                                    NOT NULL,
    app_id      int                                    NOT NULL COMMENT '所属app',
    name        varchar(40) COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
    url         varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'url地址',
    parent_id   int                                    NOT NULL COMMENT '上级菜单id',
    seq         int                                    NOT NULL COMMENT '排序号',
    create_time datetime                                DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (id)
) COMMENT ='菜单';


CREATE TABLE IF NOT EXISTS iam_org
(
    id          int                                     NOT NULL AUTO_INCREMENT COMMENT '机构id',
    name        varchar(100) COLLATE utf8mb4_general_ci NOT NULL COMMENT '企业名称',
    logo        varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'logo',
    remark      varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
    create_time datetime                                DEFAULT NULL COMMENT '创建时间',
    update_time datetime                                DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (id)
) COMMENT ='机构';


CREATE TABLE IF NOT EXISTS iam_permission
(
    code        varchar(30) COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限编码',
    name        varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限名称',
    remark      varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
    level       smallint                               NOT NULL COMMENT '层级',
    seq         smallint                               NOT NULL COMMENT '序号',
    create_time datetime                                DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (code)
) COMMENT ='权限';


CREATE TABLE IF NOT EXISTS iam_permission_menu
(
    id              int                                    NOT NULL,
    permission_code varchar(30) COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限code',
    menu_id         int                                    NOT NULL COMMENT '菜单id',
    create_time     datetime DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (id)
) COMMENT ='权限菜单关系';

CREATE TABLE IF NOT EXISTS iam_permission_resource
(
    id              int                                    NOT NULL AUTO_INCREMENT,
    permission_code varchar(30) COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限code',
    resource_id     int                                    NOT NULL COMMENT '资源id',
    create_time     datetime DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (id)
) COMMENT ='权限资源关系';

CREATE TABLE IF NOT EXISTS iam_resource
(
    id          int                                    NOT NULL,
    name        varchar(40) COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
    url         varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'url',
    create_time datetime                                DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (id)
) COMMENT ='资源';

CREATE TABLE IF NOT EXISTS iam_role
(
    id          bigint                                 NOT NULL AUTO_INCREMENT,
    org_id      int                                    NOT NULL COMMENT '机构id',
    name        varchar(20) COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
    remark      varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '描述',
    create_time datetime                                DEFAULT NULL COMMENT '创建时间',
    update_time datetime                                DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (id)
) COMMENT ='角色';

CREATE TABLE IF NOT EXISTS iam_user
(
    id          int                                    NOT NULL AUTO_INCREMENT,
    org_id      int                                    NOT NULL,
    name        varchar(20) COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
    username    varchar(30) COLLATE utf8mb4_general_ci NOT NULL COMMENT '登录名称',
    mobile      varchar(20) COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '手机号',
    email       varchar(50) COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '邮箱',
    passwd      varchar(32) COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码（加密）',
    avatar      varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '头像url',
    status      smallint                               NOT NULL COMMENT '状态: 1-正常, 2-锁定, 3-注销',
    remark      varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
    admin       int                                    NOT NULL,
    create_time datetime                                DEFAULT NULL COMMENT '创建时间',
    update_time datetime                                DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (id),
    UNIQUE KEY uk_iam_user_username (username) USING BTREE
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