-- 菜单
use bos_uc;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Records of iam_app
-- ----------------------------
BEGIN;
INSERT INTO `iam_app` (`id`, `code`, `name`, `logo`, `base_url`, `status`, `remark`, `create_time`)
VALUES (1, 'invoice', '北海云票', NULL, NULL, 1, '北海云票', '2023-09-25 20:55:52');
COMMIT;

BEGIN;
INSERT INTO `iam_authorization` (`id`, `org_id`, `target_type`, `target_id`, `permission_code`, `create_time`)
VALUES (16, 1, 1, 4, 'uc:setting', '2024-03-06 11:42:42');
INSERT INTO `iam_authorization` (`id`, `org_id`, `target_type`, `target_id`, `permission_code`, `create_time`)
VALUES (17, 1, 1, 4, 'invoice:park', '2024-03-06 11:42:42');
INSERT INTO `iam_authorization` (`id`, `org_id`, `target_type`, `target_id`, `permission_code`, `create_time`)
VALUES (25, 1, 1, 6, 'invoice:park', '2024-04-16 11:11:53');
INSERT INTO `iam_authorization` (`id`, `org_id`, `target_type`, `target_id`, `permission_code`, `create_time`)
VALUES (29, 1, 1, 2, 'invoice:park', '2024-06-05 02:26:50');
INSERT INTO `iam_authorization` (`id`, `org_id`, `target_type`, `target_id`, `permission_code`, `create_time`)
VALUES (30, 1, 1, 2, 'uc:setting', '2024-06-05 02:26:50');
INSERT INTO `iam_authorization` (`id`, `org_id`, `target_type`, `target_id`, `permission_code`, `create_time`)
VALUES (31, 1, 1, 2, 'invoice:order', '2024-06-05 02:26:50');
INSERT INTO `iam_authorization` (`id`, `org_id`, `target_type`, `target_id`, `permission_code`, `create_time`)
VALUES (34, 1, 1, 5, 'invoice:park', '2024-06-16 21:57:27');
INSERT INTO `iam_authorization` (`id`, `org_id`, `target_type`, `target_id`, `permission_code`, `create_time`)
VALUES (35, 1, 1, 3, 'invoice:park', '2024-06-20 00:44:10');
INSERT INTO `iam_authorization` (`id`, `org_id`, `target_type`, `target_id`, `permission_code`, `create_time`)
VALUES (36, 1, 1, 3, 'invoice:order', '2024-06-20 00:44:10');
INSERT INTO `iam_authorization` (`id`, `org_id`, `target_type`, `target_id`, `permission_code`, `create_time`)
VALUES (37, 1, 1, 3, 'platform:charge', '2024-06-20 00:44:10');
COMMIT;


-- ----------------------------
-- Records of iam_menu
-- ----------------------------
BEGIN;
INSERT INTO `iam_menu` (`id`, `app_id`, `name`, `url`, `parent_id`, `seq`, `create_time`)
VALUES (1, 1, '机构管理', '/bos-op/org/', 0, 1, '2024-03-05 21:08:44');
INSERT INTO `iam_menu` (`id`, `app_id`, `name`, `url`, `parent_id`, `seq`, `create_time`)
VALUES (10, 1, '园区', NULL, 0, 10, '2024-03-05 21:08:44');
INSERT INTO `iam_menu` (`id`, `app_id`, `name`, `url`, `parent_id`, `seq`, `create_time`)
VALUES (11, 1, '园区服务商管理', '/bos-op/park-provider/', 10, 11, '2024-03-05 21:08:44');
INSERT INTO `iam_menu` (`id`, `app_id`, `name`, `url`, `parent_id`, `seq`, `create_time`)
VALUES (12, 1, '渠道商管理', '/bos-op/distributor/', 10, 12, '2024-03-05 21:08:44');
INSERT INTO `iam_menu` (`id`, `app_id`, `name`, `url`, `parent_id`, `seq`, `create_time`)
VALUES (13, 1, '企业管理', '/bos-op/park-enterprise/', 10, 13, '2024-03-05 21:08:44');
INSERT INTO `iam_menu` (`id`, `app_id`, `name`, `url`, `parent_id`, `seq`, `create_time`)
VALUES (20, 1, '发票补录', '/bos-op/invoice-collect/', 10, 20, '2024-03-05 21:08:44');
INSERT INTO `iam_menu` (`id`, `app_id`, `name`, `url`, `parent_id`, `seq`, `create_time`)
VALUES (30, 1, '查询统计', NULL, 0, 30, '2024-03-05 21:08:44');
INSERT INTO `iam_menu` (`id`, `app_id`, `name`, `url`, `parent_id`, `seq`, `create_time`)
VALUES (31, 1, '企业服务费查询', '/bos-op/enterprise-fee/', 30, 31, '2024-03-05 21:08:44');
INSERT INTO `iam_menu` (`id`, `app_id`, `name`, `url`, `parent_id`, `seq`, `create_time`)
VALUES (32, 1, '园区企业月报', '/bos-op/report-enterprise/', 30, 32, '2024-03-05 21:08:44');
INSERT INTO `iam_menu` (`id`, `app_id`, `name`, `url`, `parent_id`, `seq`, `create_time`)
VALUES (33, 1, '园区服务商月报', '/bos-op/report-provider/', 30, 33, '2024-03-05 21:08:44');
INSERT INTO `iam_menu` (`id`, `app_id`, `name`, `url`, `parent_id`, `seq`, `create_time`)
VALUES (34, 1, '渠道商月报', '/bos-op/report-distributor/', 30, 34, '2024-03-05 21:08:44');
INSERT INTO `iam_menu` (`id`, `app_id`, `name`, `url`, `parent_id`, `seq`, `create_time`)
VALUES (97, 1, '开票申请', '/bos-op/invoice-apply/', 10, 97, '2024-03-19 11:45:44');
INSERT INTO `iam_menu` (`id`, `app_id`, `name`, `url`, `parent_id`, `seq`, `create_time`)
VALUES (98, 1, '工商注册', '/bos-op/enterprise-registration/', 10, 98, '2024-03-05 21:08:44');
INSERT INTO `iam_menu` (`id`, `app_id`, `name`, `url`, `parent_id`, `seq`, `create_time`)
VALUES (1000, 1, '设置', NULL, 0, 1000, '2024-03-05 21:08:44');
INSERT INTO `iam_menu` (`id`, `app_id`, `name`, `url`, `parent_id`, `seq`, `create_time`)
VALUES (1001, 1, '用户管理', '/bos-uc/user/', 1000, 1001, '2024-03-05 21:08:44');
INSERT INTO `iam_menu` (`id`, `app_id`, `name`, `url`, `parent_id`, `seq`, `create_time`)
VALUES (1002, 1, '角色管理', '/bos-uc/role/', 1000, 1002, '2024-03-05 21:08:44');
INSERT INTO `iam_menu` (`id`, `app_id`, `name`, `url`, `parent_id`, `seq`, `create_time`)
VALUES (1003, 1, '计费管理', NULL, 0, 1003, '2024-06-05 11:29:31');
INSERT INTO `iam_menu` (`id`, `app_id`, `name`, `url`, `parent_id`, `seq`, `create_time`)
VALUES (1004, 1, '商品管理', '/bos-op/account/product/', 1003, 1004, '2024-06-05 11:31:07');
INSERT INTO `iam_menu` (`id`, `app_id`, `name`, `url`, `parent_id`, `seq`, `create_time`)
VALUES (1005, 1, '订单管理', '/bos-op/account/order/', 1003, 1005, '2024-06-05 11:31:41');
INSERT INTO `iam_menu` (`id`, `app_id`, `name`, `url`, `parent_id`, `seq`, `create_time`)
VALUES (1006, 1, '北海权限管理', '/bos-op/permission/', 1003, 1006, '2024-06-26 14:09:06');
COMMIT;



-- ----------------------------
-- Records of iam_org
-- ----------------------------
BEGIN;
INSERT INTO `iam_org` (`id`, `name`, `logo`, `remark`, `create_time`, `update_time`)
VALUES (1, '罗格运营', NULL, NULL, NULL, NULL);
COMMIT;


-- ----------------------------
-- Records of iam_permission
-- ----------------------------
BEGIN;
INSERT INTO `iam_permission` (`code`, `name`, `remark`, `level`, `seq`, `create_time`)
VALUES ('invoice:order', '订单管理', '商品和订单管理', 1, 99, '2024-06-05 11:43:51');
INSERT INTO `iam_permission` (`code`, `name`, `remark`, `level`, `seq`, `create_time`)
VALUES ('invoice:park', '园区运营', '园区运营及查询统计', 1, 3, '2024-03-05 00:00:00');
INSERT INTO `iam_permission` (`code`, `name`, `remark`, `level`, `seq`, `create_time`)
VALUES ('platform:charge', '计费管理', '计费管理', 1, 1, '2024-06-05 11:43:51');
INSERT INTO `iam_permission` (`code`, `name`, `remark`, `level`, `seq`, `create_time`)
VALUES ('uc:setting', '系统设置', '包括用户管理、角色管理等', 1, 1, '2024-03-05 00:00:00');
COMMIT;


-- ----------------------------
-- Records of iam_permission_menu
-- ----------------------------
BEGIN;
INSERT INTO `iam_permission_menu` (`id`, `permission_code`, `menu_id`, `create_time`)
VALUES (1, 'uc:setting', 1001, '2024-03-05 00:00:00');
INSERT INTO `iam_permission_menu` (`id`, `permission_code`, `menu_id`, `create_time`)
VALUES (2, 'uc:setting', 1002, '2024-03-05 00:00:00');
INSERT INTO `iam_permission_menu` (`id`, `permission_code`, `menu_id`, `create_time`)
VALUES (3, 'invoice:park', 1, '2024-03-05 00:00:00');
INSERT INTO `iam_permission_menu` (`id`, `permission_code`, `menu_id`, `create_time`)
VALUES (4, 'invoice:park', 11, '2024-03-05 00:00:00');
INSERT INTO `iam_permission_menu` (`id`, `permission_code`, `menu_id`, `create_time`)
VALUES (5, 'invoice:park', 12, '2024-03-05 00:00:00');
INSERT INTO `iam_permission_menu` (`id`, `permission_code`, `menu_id`, `create_time`)
VALUES (6, 'invoice:park', 13, '2024-03-05 00:00:00');
INSERT INTO `iam_permission_menu` (`id`, `permission_code`, `menu_id`, `create_time`)
VALUES (7, 'invoice:park', 20, '2024-03-05 00:00:00');
INSERT INTO `iam_permission_menu` (`id`, `permission_code`, `menu_id`, `create_time`)
VALUES (8, 'invoice:park', 31, '2024-03-05 00:00:00');
INSERT INTO `iam_permission_menu` (`id`, `permission_code`, `menu_id`, `create_time`)
VALUES (10, 'invoice:park', 32, '2024-03-05 00:00:00');
INSERT INTO `iam_permission_menu` (`id`, `permission_code`, `menu_id`, `create_time`)
VALUES (11, 'invoice:park', 33, '2024-03-05 00:00:00');
INSERT INTO `iam_permission_menu` (`id`, `permission_code`, `menu_id`, `create_time`)
VALUES (12, 'invoice:park', 34, '2024-03-05 00:00:00');
INSERT INTO `iam_permission_menu` (`id`, `permission_code`, `menu_id`, `create_time`)
VALUES (97, 'invoice:park', 97, '2024-03-19 14:18:56');
INSERT INTO `iam_permission_menu` (`id`, `permission_code`, `menu_id`, `create_time`)
VALUES (98, 'invoice:park', 98, '0024-03-05 00:00:00');
COMMIT;


-- ----------------------------
-- Records of iam_permission_resource
-- ----------------------------
BEGIN;
INSERT INTO `iam_permission_resource` (`id`, `permission_code`, `resource_id`, `create_time`)
VALUES (1, 'uc:setting', 1, '2024-03-05 00:00:00');
INSERT INTO `iam_permission_resource` (`id`, `permission_code`, `resource_id`, `create_time`)
VALUES (2, 'invoice:park', 2, '2024-03-05 00:00:00');
INSERT INTO `iam_permission_resource` (`id`, `permission_code`, `resource_id`, `create_time`)
VALUES (3, 'invoice:order', 3, '2024-06-05 11:46:46');
INSERT INTO `iam_permission_resource` (`id`, `permission_code`, `resource_id`, `create_time`)
VALUES (4, 'invoice:order', 4, '2024-06-05 11:47:29');
INSERT INTO `iam_permission_resource` (`id`, `permission_code`, `resource_id`, `create_time`)
VALUES (5, 'platform:charge', 3, '2024-06-05 11:46:46');
INSERT INTO `iam_permission_resource` (`id`, `permission_code`, `resource_id`, `create_time`)
VALUES (6, 'platform:charge', 4, '2024-06-05 11:47:29');
COMMIT;


-- ----------------------------
-- Records of iam_resource
-- ----------------------------
BEGIN;
INSERT INTO `iam_resource` (`id`, `name`, `url`, `create_time`)
VALUES (1, '系统设置', '/bos-uc/**', '2024-03-05 00:00:00');
INSERT INTO `iam_resource` (`id`, `name`, `url`, `create_time`)
VALUES (2, '小北云票资源', '/bos-op/**', '2024-03-05 00:00:00');
INSERT INTO `iam_resource` (`id`, `name`, `url`, `create_time`)
VALUES (3, '订单管理', '/bos-op/account/order/**', '2024-06-05 11:38:33');
INSERT INTO `iam_resource` (`id`, `name`, `url`, `create_time`)
VALUES (4, '商品管理', '/bos-op/account/product/**', '2024-06-05 11:41:42');
COMMIT;


-- ----------------------------
-- Records of iam_role
-- ----------------------------
BEGIN;
INSERT INTO `iam_role` (`id`, `org_id`, `name`, `remark`, `create_time`, `update_time`)
VALUES (2, 1, '产研组', '产品研发测试组', '2024-03-06 11:39:36', '2024-03-06 11:39:36');
INSERT INTO `iam_role` (`id`, `org_id`, `name`, `remark`, `create_time`, `update_time`)
VALUES (3, 1, '园区运营', NULL, '2024-03-06 11:42:28', '2024-03-06 11:42:28');
INSERT INTO `iam_role` (`id`, `org_id`, `name`, `remark`, `create_time`, `update_time`)
VALUES (4, 1, '管理组', NULL, '2024-03-06 11:42:42', '2024-03-06 11:42:42');
INSERT INTO `iam_role` (`id`, `org_id`, `name`, `remark`, `create_time`, `update_time`)
VALUES (5, 1, '演示账户', NULL, '2024-04-07 14:22:54', '2024-04-07 14:22:54');
INSERT INTO `iam_role` (`id`, `org_id`, `name`, `remark`, `create_time`, `update_time`)
VALUES (6, 1, '商务组', NULL, '2024-04-16 11:11:53', '2024-04-16 11:11:53');
COMMIT;



-- ----------------------------
-- Records of iam_user
-- ----------------------------
BEGIN;
INSERT INTO `iam_user` (`id`, `org_id`, `name`, `username`, `mobile`, `email`, `passwd`, `avatar`, `status`, `remark`,
                        `admin`, `create_time`, `update_time`)
VALUES (1, 1, 'admin', 'admin', 'admin', NULL, '3e5ba147999c68dc76ef33613c2c2c8f', NULL, 1, NULL, 1, NULL, NULL);

INSERT INTO `iam_user` (`id`, `org_id`, `name`, `username`, `mobile`, `email`, `passwd`, `avatar`, `status`, `remark`,
                        `admin`, `create_time`, `update_time`)
VALUES (13, 1, '罗灿', 'luocan', '18701485121', 'luo.can@luoge.com', '3acffe86d14180ff895df4a773f8364f', NULL, 1, NULL,
        0, '2024-05-08 17:17:33', '2024-05-08 17:17:33');

COMMIT;


-- ----------------------------
-- Records of iam_user_role
-- ----------------------------
BEGIN;
INSERT INTO `iam_user_role` (`id`, `org_id`, `user_id`, `role_id`, `create_time`)
VALUES (17, 1, 13, 2, '2024-06-05 02:27:24');
INSERT INTO `iam_user_role` (`id`, `org_id`, `user_id`, `role_id`, `create_time`)
VALUES (18, 1, 13, 3, '2024-06-05 02:27:24');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;


