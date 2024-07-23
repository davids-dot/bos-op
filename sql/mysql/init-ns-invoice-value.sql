SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for inv_park_enterprise
-- ----------------------------
DROP TABLE IF EXISTS `inv_park_enterprise`;
CREATE TABLE `inv_park_enterprise`
(
    `id`                                 bigint   NOT NULL AUTO_INCREMENT,
    `org_id`                             int      NOT NULL COMMENT '机构id',
    `enterprise_id`                      int      NOT NULL COMMENT '企业id',
    `enterprise_name`                    varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '企业名称',
    `service_fee_rate`                   decimal(10, 5)                                               DEFAULT NULL COMMENT '应收服务费费率',
    `service_fee_payer_id`               int                                                          DEFAULT NULL COMMENT '服务费支付方',
    `customer_id`                        int                                                          DEFAULT NULL COMMENT '所属客户',
    `customer_manager`                   varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '客户经理',
    `park_provider_id`                   int                                                          DEFAULT NULL COMMENT '园区服务商id',
    `distributor_id`                     int                                                          DEFAULT NULL COMMENT '渠道商id',
    `park_provider_additional_tax_rate`  decimal(10, 5)                                               DEFAULT NULL COMMENT '园区服务商个体工商户附加税税率',
    `park_provider_water_tax_rate`       decimal(10, 5)                                               DEFAULT NULL COMMENT '园区服务商个体工商户水利基金税率',
    `park_provider_stamp_tax_rate`       decimal(10, 5)                                               DEFAULT NULL COMMENT '园区服务商个体工商户印花税税率',
    `park_provider_income_tax_rate`      decimal(10, 5)                                               DEFAULT NULL COMMENT '园区服务商个体工商户个人所得税税率',
    `park_provider_service_fee_rate`     decimal(10, 5)                                               DEFAULT NULL COMMENT '园区服务商服务费费率',
    `distributor_service_fee_rate`       decimal(10, 5)                                               DEFAULT NULL COMMENT '渠道商商服务费费率',
    `create_time`                        datetime NOT NULL COMMENT '创建时间',
    `update_time`                        datetime NOT NULL COMMENT '更新时间',
    `value_added_tax_type`               int                                                          DEFAULT NULL COMMENT '增值税类型： 1、30万阈值； 2、每张票都缴纳',
    `park_provider_value_added_tax_rate` decimal(10, 5)                                               DEFAULT NULL COMMENT '园区服务商个体工商户增值税税率',
    `include_tax_rate`                   decimal(10, 5)                                               DEFAULT NULL COMMENT '包税税率',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uni_park_org_enterprise` (`org_id`, `enterprise_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 340
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='B表企业';

-- ----------------------------
-- Records of inv_park_enterprise
-- ----------------------------
BEGIN;
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (3, 7, 56, '长沙市芙蓉区礼邯软件开发工作室（个体工商户）', 0.00000, NULL, NULL, NULL, 12, 5, 0.06000, 0.00060,
        0.00000, 0.00500, 0.00500, 0.00000, '2024-03-12 08:41:52', '2024-03-29 18:44:51', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (4, 7, 55, '南县南洲信良科技工作室（个体工商户）', 0.02000, NULL, 4, NULL, 8, 5, 0.05000, 0.00060, 0.00000,
        0.00970, 0.00000, 0.00000, '2024-03-12 08:41:51', '2024-05-07 18:46:22', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (5, 7, 54, '长沙市天心区真真软件开发工作室（个体工商户）', 0.00000, NULL, NULL, NULL, 12, 5, 0.06000, 0.00060,
        0.00000, 0.00500, 0.00500, 0.00000, '2024-03-12 08:41:50', '2024-03-29 18:45:05', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (6, 7, 53, '南县南洲士宏网络工作室（个体工商户）', 0.02000, NULL, 4, NULL, 8, 5, 0.05000, 0.00060, 0.00000,
        0.00970, 0.00000, 0.00000, '2024-03-12 08:41:49', '2024-05-07 18:46:05', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (7, 7, 57, '南县南洲威洁科技中心（个体工商户）', 0.02000, NULL, 4, NULL, 8, 5, 0.05000, 0.00060, 0.00000, 0.00970,
        0.00000, 0.00000, '2024-03-12 08:41:48', '2024-05-07 18:46:37', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (8, 7, 58, '南县南洲佳驰软件开发工作室（个体工商户）', 0.02000, 1, 4, NULL, 8, 5, 0.05000, 0.00060, 0.00000,
        0.00970, 0.00000, 0.00000, '2024-03-12 08:41:47', '2024-05-07 18:46:52', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (9, 7, 59, '南县南洲时洲软件开发工作室（个体工商户）', 0.02000, NULL, 4, NULL, 8, 5, 0.05000, 0.00060, 0.00000,
        0.00970, 0.00000, 0.00000, '2024-03-12 08:41:46', '2024-05-07 18:47:09', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (10, 7, 60, '长沙市天心区克炎软件开发工作室（个体工商户）', 0.00000, NULL, NULL, NULL, 12, 5, 0.06000, 0.00060,
        0.00000, 0.00500, 0.00500, 0.00000, '2024-03-12 08:41:45', '2024-03-29 18:45:56', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (11, 7, 87, '南县南洲正知营销策划中心', 0.04717, 1, 1, '李哲', 8, 3, 0.05000, 0.00060, 0.00000, 0.00970, 0.00000,
        0.00943, '2024-03-12 08:41:44', '2024-03-15 13:41:07', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (12, 7, 88, '南县南洲君玮营销策划中心', 0.04717, 1, 1, '李哲', 8, 3, 0.05000, 0.00060, 0.00000, 0.00970, 0.00000,
        0.00943, '2024-03-12 08:41:43', '2024-03-15 13:41:04', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (13, 7, 89, '南县南洲聪安营销策划中心', 0.04717, 1, 1, '李哲', 8, 3, 0.05000, 0.00060, 0.00000, 0.00970, 0.00000,
        0.00943, '2024-03-12 08:41:42', '2024-03-15 13:40:58', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (14, 7, 90, '南县南洲兆卓营销策划中心', 0.04717, 1, 1, '李哲', 8, 3, 0.05000, 0.00060, 0.00000, 0.00970, 0.00000,
        0.00943, '2024-03-12 08:41:41', '2024-03-15 13:40:56', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (15, 7, 91, '南县南洲亿昌营销策划中心', 0.04717, 1, 1, '李哲', 8, 3, 0.05000, 0.00060, 0.00000, 0.00970, 0.00000,
        0.00943, '2024-03-12 08:41:40', '2024-03-15 13:40:51', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (16, 7, 92, '南县南洲博星营销策划中心', 0.04717, 1, 1, '李哲', 8, 3, 0.05000, 0.00060, 0.00000, 0.00970, 0.00000,
        0.00943, '2024-03-12 08:41:39', '2024-03-15 13:40:48', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (17, 7, 93, '南县南洲博立营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 8, 3, 0.05000, 0.00060, 0.00000,
        0.00970, 0.00000, 0.00943, '2024-03-12 08:41:38', '2024-03-15 13:40:44', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (18, 7, 94, '南县南洲览语营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 8, 3, 0.05000, 0.00060, 0.00000,
        0.00970, 0.00000, 0.00943, '2024-03-12 08:41:37', '2024-03-15 13:40:41', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (19, 7, 95, '南县南洲启复营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 8, 3, 0.05000, 0.00060, 0.00000,
        0.00970, 0.00000, 0.00943, '2024-03-12 08:41:36', '2024-03-15 13:40:36', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (20, 7, 96, '南县南洲长欧营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 8, 3, 0.05000, 0.00060, 0.00000,
        0.00970, 0.00000, 0.00943, '2024-03-12 08:41:35', '2024-03-15 13:40:33', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (21, 7, 101, '南县南洲燃氪力文化传媒工作室', 0.08500, 1, 3, '何浩淼', 8, 4, 0.05000, 0.00060, 0.00000, 0.01960,
        0.00000, 0.03000, '2024-03-12 08:41:34', '2024-03-28 11:58:49', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (22, 7, 102, '南县南洲欧扬帆文艺创作工作室', 0.08500, 1, 3, '何浩淼', 8, 4, 0.05000, 0.00060, 0.00000, 0.01960,
        0.00000, 0.03000, '2024-03-12 08:41:33', '2024-03-28 11:59:27', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (23, 7, 97, '南县南洲璇全营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 8, 3, 0.05000, 0.00060, 0.00000,
        0.00970, 0.00000, 0.00943, '2024-03-12 08:41:32', '2024-03-15 13:40:27', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (24, 7, 98, '南县南洲清拓营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 8, 3, 0.05000, 0.00060, 0.00000,
        0.00970, 0.00000, 0.00943, '2024-03-12 08:41:31', '2024-03-15 13:40:23', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (25, 7, 99, '南县南洲奶盖晚晚文化传媒工作室', 0.08500, 1, 3, '何浩淼', 8, 4, 0.05000, 0.00060, 0.00000, 0.01960,
        0.00000, 0.03000, '2024-03-12 08:41:30', '2024-03-28 11:59:10', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (26, 7, 100, '南县南洲贾琳文艺创作工作室', 0.08500, 1, 3, '何浩淼', 8, 4, 0.05000, 0.00060, 0.00000, 0.01960,
        0.00000, 0.03000, '2024-03-12 08:41:29', '2024-03-28 11:58:33', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (27, 7, 103, '南县南洲徐缓文艺创作工作室', 0.08500, 1, 3, '何浩淼', 8, 4, 0.05000, 0.00060, 0.00000, 0.01960,
        0.00000, 0.03000, '2024-03-12 08:41:28', '2024-03-28 11:59:55', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (28, 7, 104, '南县南洲于婧涵文艺创作工作室', 0.08500, 1, 3, '何浩淼', 8, 4, 0.05000, 0.00060, 0.00000, 0.01960,
        0.00000, 0.03000, '2024-03-12 08:41:27', '2024-03-28 11:57:58', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (29, 7, 105, '南县南洲康回文艺创作工作室', 0.08500, 1, 3, '何浩淼', 8, 4, 0.05000, 0.00060, 0.00000, 0.01960,
        0.00000, 0.03000, '2024-03-12 08:41:26', '2024-03-28 11:58:21', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (30, 7, 106, '南县南洲郭丽萍文化传媒工作室', 0.08500, 1, 3, '何浩淼', 8, 4, 0.05000, 0.00060, 0.00000, 0.01960,
        0.00000, 0.03000, '2024-03-12 08:41:25', '2024-03-28 11:58:10', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (31, 7, 107, '南县南洲尚凡商务服务部（个体工商户）', 0.02060, 1, 1, '李哲', 8, 5, 0.05000, 0.00060, 0.00000,
        0.00970, 0.00000, 0.00000, '2024-03-12 08:41:24', '2024-03-29 17:58:47', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (32, 7, 109, '南县南洲姜东咨询工作室', 0.04500, 1, 2, '何亚蓝', 8, 5, 0.05000, 0.00060, 0.00000, 0.00800,
        0.00000, 0.00000, '2024-03-12 08:41:23', '2024-03-29 18:05:28', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (33, 7, 110, '南县南洲惠康咨询策划中心', 0.03500, NULL, 2, '马中柱', 8, 7, 0.05000, 0.00060, 0.00000, 0.00650,
        0.00000, 0.01000, '2024-03-12 08:41:22', '2024-03-29 18:11:34', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (34, 7, 111, '南县南洲黑马信息服务中心', 0.02700, 1, 2, '马中柱', 8, 5, 0.05000, 0.00060, 0.00000, 0.00800,
        0.00000, 0.00000, '2024-03-12 08:41:21', '2024-03-29 17:59:46', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (35, 7, 112, '南县南洲一路前行汽车工作室', 0.04000, 1, 2, '鲁浩然', 8, 9, 0.05000, 0.00060, 0.00000, 0.00800,
        0.00000, 0.01600, '2024-03-12 08:41:20', '2024-03-29 18:43:41', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (36, 7, 113, '安阳市殷都区善询信息咨询中心', 0.02810, 1, 2, '何亚蓝', 3, 5, 0.06000, 0.00000, 0.00000, 0.00350,
        0.00200, 0.00000, '2024-03-12 08:41:19', '2024-03-29 18:21:04', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (37, 7, 114, '南县南洲潘波咨询服务工作室', 0.05000, 1, 2, NULL, 8, 10, 0.05000, 0.00060, 0.00000, 0.00750,
        0.00000, 0.00800, '2024-03-12 08:41:18', '2024-03-29 18:25:10', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (38, 7, 115, '南县南洲星九咨询工作室', 0.04500, 1, 2, '赵立柱', 8, 6, 0.05000, 0.00060, 0.00000, 0.00950,
        0.00000, 0.02000, '2024-03-12 08:41:17', '2024-03-29 18:02:41', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (39, 7, 116, '南县南洲旭帆咨询工作室', 0.04500, 1, 2, '赵立柱', 8, 6, 0.05000, 0.00060, 0.00000, 0.00950,
        0.00000, 0.02000, '2024-03-12 08:41:16', '2024-03-29 18:02:52', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (40, 7, 117, '南县南洲卓日咨询工作室', 0.04500, 1, 2, '赵立柱', 8, 6, 0.05000, 0.00060, 0.00000, 0.00950,
        0.00000, 0.02000, '2024-03-12 08:41:15', '2024-03-29 18:03:01', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (41, 7, 118, '中山市达江营销策划中心 (个体工商户)', 0.05000, 1, 2, '黄珊', 27, 5, 0.06000, 0.00000, 0.00000,
        0.00540, 0.00500, 0.00000, '2024-03-12 08:41:14', '2024-03-29 18:26:15', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (42, 7, 119, '南县南洲地之阳影视制作中心（个体工商户）', 0.07000, 1, 2, '刘扬', 8, 11, 0.05000, 0.00060, 0.00000,
        0.02210, 0.00000, 0.01000, '2024-03-12 08:41:13', '2024-03-29 18:56:38', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (43, 7, 120, '南县南洲瑞乐营销策划部（个体工商户）', 0.03500, 1, 2, '黄珊', 8, 5, 0.05000, 0.00060, 0.00000,
        0.00650, 0.00000, 0.00000, '2024-03-12 08:41:12', '2024-03-29 17:59:23', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (44, 7, 121, '安阳市殷都区众之耀策划中心 (个体工商户)', 0.07000, 1, 2, '刘扬', 3, 5, 0.06000, 0.00000, 0.00000,
        0.00350, 0.00200, 0.00000, '2024-03-12 08:41:11', '2024-03-29 17:59:18', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (45, 7, 122, '安阳市殷都区辉桦营销策划中心 (个体工商户)', 0.04717, 1, 1, '李哲', 2, 3, 0.06000, 0.00000, 0.00000,
        0.00350, 0.00400, 0.00943, '2024-03-12 08:41:10', '2024-03-15 13:40:03', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (46, 7, 123, '安阳市殷都区亚帆营销策划中心 (个体工商户)', 0.04717, 1, 1, '李哲', 2, 3, 0.06000, 0.00000, 0.00000,
        0.00350, 0.00400, 0.00943, '2024-03-12 08:41:09', '2024-03-15 13:39:59', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (48, 7, 125, '安阳市殷都区傲营营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 2, 3, 0.06000, 0.00000, 0.00000,
        0.00350, 0.00400, 0.00943, '2024-03-12 08:41:07', '2024-03-15 13:39:55', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (49, 7, 126, '安阳市殷都区贝莱茗营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 2, 3, 0.06000, 0.00000,
        0.00000, 0.00350, 0.00400, 0.00943, '2024-03-12 08:41:06', '2024-03-15 13:39:52', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (50, 7, 127, '安阳市殷都区奔望月雪营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 2, 3, 0.06000, 0.00000,
        0.00000, 0.00350, 0.00400, 0.00943, '2024-03-12 08:41:05', '2024-03-15 13:39:48', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (51, 7, 128, '安阳市殷都区博思营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 2, 3, 0.06000, 0.00000, 0.00000,
        0.00350, 0.00400, 0.00943, '2024-03-12 08:41:04', '2024-03-15 13:39:44', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (52, 7, 129, '安阳市殷都区帆银营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 2, 3, 0.06000, 0.00000, 0.00000,
        0.00350, 0.00400, 0.00943, '2024-03-12 08:41:03', '2024-03-15 13:39:40', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (53, 7, 130, '安阳市殷都区丰频拓营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 2, 3, 0.06000, 0.00000,
        0.00000, 0.00350, 0.00400, 0.00943, '2024-03-12 08:41:02', '2024-03-15 13:39:34', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (54, 7, 131, '中山市奥新营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 27, 3, 0.06000, 0.00000, 0.00000,
        0.00540, 0.00500, 0.00943, '2024-03-12 08:41:01', '2024-03-15 13:39:30', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (55, 7, 132, '中山市博迪营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 27, 3, 0.06000, 0.00000, 0.00000,
        0.00540, 0.00500, 0.00943, '2024-03-12 08:41:00', '2024-03-15 13:39:25', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (56, 7, 133, '安阳市殷都区泓拾珺营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 2, 3, 0.06000, 0.00000,
        0.00000, 0.00350, 0.00400, 0.00943, '2024-03-12 08:40:59', '2024-03-15 13:39:22', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (57, 7, 134, '安阳市殷都区鸿桦营销策划中心', 0.04717, 1, 1, '李哲', 2, 3, 0.06000, 0.00000, 0.00000, 0.00350,
        0.00400, 0.00943, '2024-03-12 08:40:58', '2024-03-15 13:39:18', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (58, 7, 135, '安阳市殷都区厚思勒信息服务中心', 0.04717, 1, 1, '李哲', 2, 3, 0.06000, 0.00000, 0.00000, 0.00350,
        0.00400, 0.00943, '2024-03-12 08:40:57', '2024-03-15 13:39:14', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (59, 7, 136, '安阳市殷都区捷普信息咨询中心', 0.04717, 1, 1, '李哲', 2, 3, 0.06000, 0.00000, 0.00000, 0.00350,
        0.00400, 0.00943, '2024-03-12 08:40:56', '2024-03-15 13:39:11', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (61, 7, 138, '中山市惠创营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 27, 3, 0.06000, 0.00000, 0.00000,
        0.00540, 0.00500, 0.00943, '2024-03-12 08:40:54', '2024-03-15 13:39:00', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (62, 7, 139, '贵安新区开群营销策划工作室(个体工商户)', 0.04717, 1, 1, '李哲', 19, 3, 0.06000, 0.00000, 0.00050,
        0.01000, 0.00000, 0.00943, '2024-03-12 08:40:53', '2024-03-15 13:38:56', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (63, 7, 140, '安阳市殷都区峻峙峤信息服务中心', 0.04717, 1, 1, '李哲', 2, 3, 0.06000, 0.00000, 0.00000, 0.00350,
        0.00400, 0.00943, '2024-03-12 08:40:52', '2024-03-15 13:38:48', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (64, 7, 141, '安阳市殷都区凯尼信息咨询中心', 0.04717, 1, 1, '李哲', 2, 3, 0.06000, 0.00000, 0.00000, 0.00350,
        0.00400, 0.00943, '2024-03-12 08:40:51', '2024-03-15 13:38:44', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (65, 7, 142, '安阳市殷都区康骏营销策划中心', 0.04717, 1, 1, '李哲', 2, 3, 0.06000, 0.00000, 0.00000, 0.00350,
        0.00400, 0.00943, '2024-03-12 08:40:50', '2024-03-15 13:38:41', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (66, 7, 143, '安阳市殷都区科曼系营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 2, 3, 0.06000, 0.00000,
        0.00000, 0.00350, 0.00400, 0.00943, '2024-03-12 08:40:49', '2024-03-15 13:38:38', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (67, 7, 144, '安阳市殷都区揽月集营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 2, 3, 0.06000, 0.00000,
        0.00000, 0.00350, 0.00400, 0.00943, '2024-03-12 08:40:48', '2024-03-15 13:38:34', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (68, 7, 145, '安阳市殷都区立壮营销策划中心(个体工商户)个体工商户', 0.04717, 1, 1, '李哲', 2, 3, 0.06000, 0.00000,
        0.00000, 0.00350, 0.00400, 0.00943, '2024-03-12 08:40:47', '2024-03-15 13:38:22', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (69, 7, 146, '安阳市殷都区铃星图营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 2, 3, 0.06000, 0.00000,
        0.00000, 0.00350, 0.00400, 0.00943, '2024-03-12 08:40:46', '2024-03-15 13:38:11', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (70, 7, 147, '安阳市殷都区凌达铁营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 2, 3, 0.06000, 0.00000,
        0.00000, 0.00350, 0.00400, 0.00943, '2024-03-12 08:40:45', '2024-03-15 13:38:07', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (71, 7, 148, '安阳市殷都区盼巍源信息咨询中心', 0.04762, 1, 1, '李哲', 2, 2, 0.06000, 0.00000, 0.00000, 0.00350,
        0.00400, 0.00952, '2024-03-12 08:40:44', '2024-03-15 13:44:32', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (72, 7, 149, '贵安新区名洋营销策划工作室(个体工商户)', 0.04717, 1, 1, '李哲', 19, 3, 0.06000, 0.00000, 0.00050,
        0.01000, 0.00000, 0.00943, '2024-03-12 08:40:43', '2024-03-15 13:38:02', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (73, 7, 150, '安阳市殷都区纾炔筱营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 2, 3, 0.06000, 0.00000,
        0.00000, 0.00350, 0.00400, 0.00943, '2024-03-12 08:40:42', '2024-03-15 13:37:55', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (74, 7, 151, '安阳市殷都区顺元智营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 2, 3, 0.06000, 0.00000,
        0.00000, 0.00350, 0.00400, 0.00943, '2024-03-12 08:40:41', '2024-03-15 13:37:52', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (75, 7, 152, '安阳市殷都区同源闻信息服务中心', 0.04717, 1, 1, '李哲', 2, 3, 0.06000, 0.00000, 0.00000, 0.00350,
        0.00400, 0.00943, '2024-03-12 08:40:40', '2024-03-15 13:37:48', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (76, 7, 153, '安阳市殷都区维高信息咨询中心', 0.04762, 1, 1, '李哲', 2, 2, 0.06000, 0.00000, 0.00000, 0.00350,
        0.00400, 0.00952, '2024-03-12 08:40:39', '2024-03-15 13:43:43', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (77, 7, 154, '安阳市殷都区文辅鑫营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 2, 3, 0.06000, 0.00000,
        0.00000, 0.00350, 0.00400, 0.00943, '2024-03-12 08:40:38', '2024-03-15 13:37:22', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (78, 7, 155, '贵安新区顺晔营销策划工作室(个体工商户)', 0.04717, 1, 1, '李哲', 19, 3, 0.06000, 0.00000, 0.00050,
        0.01000, 0.00000, 0.00943, '2024-03-12 08:40:37', '2024-03-15 13:37:19', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (79, 7, 156, '贵安新区言峰营销策划工作室', 0.04717, 1, 1, '李哲', 19, 3, 0.06000, 0.00000, 0.00050, 0.01000,
        0.00000, 0.00943, '2024-03-12 08:40:36', '2024-03-15 13:37:15', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (80, 7, 157, '安阳市殷都区优品嘉信息服务中心', 0.04717, 1, 1, '李哲', 2, 3, 0.06000, 0.00000, 0.00000, 0.00350,
        0.00400, 0.00943, '2024-03-12 08:40:35', '2024-03-15 13:37:12', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (81, 7, 158, '安阳市殷都区誉贺环信息服务中心', 0.04717, 1, 1, '李哲', 2, 3, 0.06000, 0.00000, 0.00000, 0.00350,
        0.00400, 0.00943, '2024-03-12 08:40:34', '2024-03-15 13:37:08', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (82, 7, 159, '贵安新区羽韦营销策划工作室(个体工商户)', 0.04717, 1, 1, '李哲', 19, 3, 0.06000, 0.00000, 0.00050,
        0.01000, 0.00000, 0.00943, '2024-03-12 08:40:33', '2024-03-15 13:37:02', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (83, 7, 160, '庆云君正营销策划服务部', 0.04717, 1, 1, '李哲', 17, 3, 0.05000, 0.00000, 0.00000, 0.01100, 0.00000,
        0.00943, '2024-03-12 08:40:32', '2024-03-15 13:36:57', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (84, 7, 161, '方山县铂韬信息服务部', 0.04717, 1, 1, '李哲', 15, 3, 0.06000, 0.00000, 0.00030, 0.10000, 0.00200,
        0.00943, '2024-03-12 08:40:31', '2024-03-15 13:36:52', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (85, 7, 162, '方山县冠智营销策划部', 0.04717, 1, 1, '李哲', 15, 3, 0.06000, 0.00000, 0.00030, 0.10000, 0.00200,
        0.00943, '2024-03-12 08:40:30', '2024-03-15 13:36:48', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (86, 7, 163, '方山县杰智信息服务部', 0.04717, 1, 1, '李哲', 15, 3, 0.06000, 0.00000, 0.00030, 0.10000, 0.00200,
        0.00943, '2024-03-12 08:40:29', '2024-03-15 13:36:40', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (87, 7, 164, '方山县鑫悦信息服务部', 0.04717, 1, 1, '李哲', 15, 3, 0.06000, 0.00000, 0.00030, 0.10000, 0.00200,
        0.00943, '2024-03-12 08:40:28', '2024-03-15 13:36:36', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (88, 7, 165, '方山县永晟信息服务部', 0.04717, 1, 1, '李哲', 15, 3, 0.06000, 0.00000, 0.00030, 0.10000, 0.00200,
        0.00943, '2024-03-12 08:40:27', '2024-03-15 13:36:32', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (89, 7, 166, '方山县振鑫信息服务部(个体工商户)', 0.04717, 1, 1, '李哲', 15, 3, 0.06000, 0.00000, 0.00030,
        0.10000, 0.00200, 0.00943, '2024-03-12 08:40:26', '2024-03-15 13:36:28', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (90, 7, 167, '贵安新区定阳营销策划工作室', 0.04717, 1, 1, '李哲', 19, 3, 0.06000, 0.00000, 0.00050, 0.01000,
        0.00000, 0.00943, '2024-03-12 08:40:25', '2024-03-15 13:36:24', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (91, 7, 168, '贵安新区继顺营销策划中心', 0.04717, 1, 1, '李哲', 19, 3, 0.06000, 0.00000, 0.00050, 0.01000,
        0.00000, 0.00943, '2024-03-12 08:40:24', '2024-03-15 13:36:16', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (92, 7, 169, '贵安新区嘉迎营销策划工作室', 0.04717, 1, 1, '李哲', 19, 3, 0.06000, 0.00000, 0.00050, 0.01000,
        0.00000, 0.00943, '2024-03-12 08:40:23', '2024-03-15 13:36:10', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (93, 7, 170, '贵安新区静文营销策划工作室', 0.04762, 1, 1, '李哲', 19, 2, 0.06000, 0.00000, 0.00050, 0.01000,
        0.00000, 0.00952, '2024-03-12 08:40:22', '2024-03-15 13:43:49', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (94, 7, 171, '安阳市殷都区丰生营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 2, 3, 0.06000, 0.00000, 0.00000,
        0.00350, 0.00400, 0.00943, '2024-03-12 08:40:21', '2024-03-15 13:35:57', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (95, 7, 172, '贵安新区敏博营销策划工作室（个体工商户）', 0.04717, 1, 1, '李哲', 19, 3, 0.06000, 0.00000, 0.00050,
        0.01000, 0.00000, 0.00943, '2024-03-12 08:40:20', '2024-03-15 13:35:50', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (96, 7, 173, '安阳市殷都区津荟营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 2, 3, 0.06000, 0.00000, 0.00000,
        0.00350, 0.00400, 0.00943, '2024-03-12 08:40:19', '2024-03-15 13:35:43', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (97, 7, 174, '贵安新区识跃营销策划中心', 0.04717, 1, 1, '李哲', 19, 3, 0.06000, 0.00000, 0.00050, 0.01000,
        0.00000, 0.00943, '2024-03-12 08:40:18', '2024-03-15 13:35:35', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (98, 7, 175, '贵安新区水勤营销策划工作室(个体工商户)', 0.04717, 1, 1, '李哲', 19, 3, 0.06000, 0.00000, 0.00050,
        0.01000, 0.00000, 0.00943, '2024-03-12 08:40:17', '2024-03-15 13:35:27', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (99, 7, 176, '安阳市殷都区敬建营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 2, 3, 0.06000, 0.00000, 0.00000,
        0.00350, 0.00400, 0.00943, '2024-03-12 08:40:16', '2024-03-15 13:35:20', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (100, 7, 177, '安阳市殷都区泉锐盛营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 2, 3, 0.06000, 0.00000,
        0.00000, 0.00350, 0.00400, 0.00943, '2024-03-12 08:40:15', '2024-03-15 13:35:11', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (101, 7, 178, '贵安新区耀尔营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 19, 3, 0.06000, 0.00000, 0.00050,
        0.01000, 0.00000, 0.00943, '2024-03-12 08:40:14', '2024-03-15 13:35:03', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (102, 7, 179, '安阳市殷都区西荣营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 2, 3, 0.06000, 0.00000, 0.00000,
        0.00350, 0.00400, 0.00943, '2024-03-12 08:40:13', '2024-03-15 13:34:53', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (103, 7, 181, '庆云君硕营销策划服务部', 0.04717, 1, 1, '李哲', 17, 3, 0.05000, 0.00000, 0.00000, 0.01100,
        0.00000, 0.00943, '2024-03-12 08:40:24', '2024-03-15 13:36:21', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (104, 7, 182, '安阳市殷都区信旺营销策划部(个体工商户)', 0.04717, 1, 1, '李哲', 2, 3, 0.06000, 0.00000, 0.00000,
        0.00350, 0.00400, 0.00943, '2024-03-12 08:40:23', '2024-03-15 13:36:13', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (105, 7, 184, '安阳市殷都区智福泽营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 2, 3, 0.06000, 0.00000,
        0.00000, 0.00350, 0.00400, 0.00943, '2024-03-12 08:40:22', '2024-03-15 13:36:05', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (106, 7, 185, '林州市宾宏营销策划中心', 0.04717, 1, 1, '李哲', 20, 3, 0.05000, 0.00000, 0.00000, 0.01150,
        0.00000, 0.00943, '2024-03-12 08:40:21', '2024-03-15 13:36:01', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (107, 7, 186, '林州市博芊营销策划中心', 0.04717, 1, 1, '李哲', 20, 3, 0.05000, 0.00000, 0.00000, 0.01150,
        0.00000, 0.00943, '2024-03-12 08:40:20', '2024-03-15 13:35:53', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (108, 7, 195, '林州市贝莱奥营销策划中心', 0.04717, 1, 1, '李哲', 20, 3, 0.05000, 0.00000, 0.00000, 0.01150,
        0.00000, 0.00943, '2024-03-12 08:40:19', '2024-03-15 13:35:46', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (109, 7, 196, '林州市妙俊营销策划中心', 0.04717, 1, 1, '李哲', 20, 3, 0.05000, 0.00000, 0.00000, 0.01150,
        0.00000, 0.00943, '2024-03-12 08:40:18', '2024-03-15 13:35:39', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (110, 7, 197, '林州市洋泽营销策划中心', 0.04717, 1, 1, '李哲', 20, 3, 0.05000, 0.00000, 0.00000, 0.01150,
        0.00000, 0.00943, '2024-03-12 08:40:17', '2024-03-15 13:35:31', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (111, 7, 198, '林州市呈飞营销策划中心', 0.04717, 1, 1, '李哲', 20, 3, 0.05000, 0.00000, 0.00000, 0.01150,
        0.00000, 0.00943, '2024-03-12 08:40:16', '2024-03-15 13:35:23', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (112, 7, 200, '林州市伽莱营销策划中心', 0.04717, 1, 1, '李哲', 20, 3, 0.05000, 0.00000, 0.00000, 0.01150,
        0.00000, 0.00943, '2024-03-12 08:40:15', '2024-03-15 13:35:16', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (113, 7, 209, '林州市新载辰营销策划中心', 0.04717, 1, 1, '李哲', 20, 3, 0.05000, 0.00000, 0.00000, 0.01150,
        0.00000, 0.00943, '2024-03-12 08:40:14', '2024-03-15 13:35:06', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (114, 7, 212, '灵丘县韬博信息服务部', 0.04717, 1, 1, '李哲', 16, 3, 0.06000, 0.00000, 0.00300, 0.10000, 0.00200,
        0.00943, '2024-03-12 08:40:13', '2024-03-15 13:34:57', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (115, 7, 213, '吕梁市离石区彩丰信息服务部(个体工商户)', 0.04717, 1, 1, '李哲', 14, 3, 0.06000, 0.00000, 0.00030,
        0.10000, 0.00200, 0.00943, '2024-03-12 08:40:12', '2024-03-15 13:34:49', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (116, 7, 214, '吕梁市离石区朝华信息服务部(个体工商户)', 0.04717, 1, 1, '李哲', 14, 3, 0.06000, 0.00000, 0.00030,
        0.10000, 0.00200, 0.00943, '2024-03-12 08:40:11', '2024-03-15 13:34:45', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (117, 7, 216, '吕梁市离石区景顺信息服务部(个体工商户)', 0.04762, 1, 1, '李哲', 14, 2, 0.06000, 0.00000, 0.00030,
        0.10000, 0.00200, 0.00952, '2024-03-12 08:40:10', '2024-03-15 13:43:55', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (118, 7, 217, '吕梁市离石区鑫泓信息服务部(个体工商户)', 0.04717, 1, 1, '李哲', 14, 3, 0.06000, 0.00000, 0.00030,
        0.10000, 0.00200, 0.00943, '2024-03-12 08:40:09', '2024-03-15 13:34:41', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (119, 7, 233, '庆云德林营销策划服务部', 0.04717, 1, 1, '李哲', 17, 3, 0.05000, 0.00000, 0.00000, 0.01100,
        0.00000, 0.00943, '2024-03-12 08:40:08', '2024-03-15 13:34:37', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (120, 7, 236, '庆云恒鑫营销策划服务部', 0.04717, 1, 1, '李哲', 17, 3, 0.05000, 0.00000, 0.00000, 0.01100,
        0.00000, 0.00943, '2024-03-12 08:40:07', '2024-03-15 13:34:33', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (121, 7, 237, '庆云恒悦营销策划服务部', 0.04717, 1, 1, '李哲', 17, 3, 0.05000, 0.00000, 0.00000, 0.01100,
        0.00000, 0.00943, '2024-03-12 08:40:06', '2024-03-15 13:34:29', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (122, 7, 238, '庆云锦阳营销策划服务部', 0.04762, 1, 1, '李哲', 17, 2, 0.05000, 0.00000, 0.00000, 0.01100,
        0.00000, 0.00952, '2024-03-12 08:40:05', '2024-03-15 13:44:00', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (123, 7, 239, '庆云久泰营销策划服务部', 0.04717, 1, 1, '李哲', 17, 3, 0.05000, 0.00000, 0.00000, 0.01100,
        0.00000, 0.00943, '2024-03-12 08:40:04', '2024-03-15 13:32:23', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (124, 7, 240, '庆云君丰营销策划服务部', 0.04762, 1, 1, '李哲', 17, 2, 0.05000, 0.00000, 0.00000, 0.01100,
        0.00000, 0.00952, '2024-03-12 08:40:03', '2024-03-15 13:44:03', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (125, 7, 241, '庆云开运营销策划服务部', 0.04717, 1, 1, '李哲', 17, 3, 0.05000, 0.00000, 0.00000, 0.01100,
        0.00000, 0.00943, '2024-03-12 08:40:02', '2024-03-15 13:32:27', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (126, 7, 242, '庆云科奇营销策划服务部', 0.04717, 1, 1, '李哲', 17, 3, 0.05000, 0.00000, 0.00000, 0.01100,
        0.00000, 0.00943, '2024-03-12 08:40:01', '2024-03-15 13:32:31', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (127, 7, 243, '庆云立兴营销策划服务部', 0.04717, 1, 1, '李哲', 17, 3, 0.05000, 0.00000, 0.00000, 0.01100,
        0.00000, 0.00943, '2024-03-12 08:40:00', '2024-03-15 13:32:34', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (128, 7, 244, '新宾满族自治县奥利润达营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 28, 3, 0.05000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:39:59', '2024-04-08 21:28:59', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (129, 7, 245, '庆云瑞新营销策划服务部', 0.04717, 1, 1, '李哲', 17, 3, 0.05000, 0.00000, 0.00000, 0.01100,
        0.00000, 0.00943, '2024-03-12 08:39:58', '2024-03-15 13:32:42', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (130, 7, 246, '新宾满族自治县合知莱清营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 28, 3, 0.05000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:39:57', '2024-04-08 21:28:52', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (131, 7, 247, '庆云舒纬营销策划服务部', 0.04717, 1, 1, '李哲', 17, 3, 0.05000, 0.00000, 0.00000, 0.01100,
        0.00000, 0.00943, '2024-03-12 08:39:56', '2024-03-15 13:32:48', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (132, 7, 248, '庆云顺悦营销策划服务部', 0.04717, 1, 1, '李哲', 17, 3, 0.05000, 0.00000, 0.00000, 0.01100,
        0.00000, 0.00943, '2024-03-12 08:39:55', '2024-03-15 13:32:52', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (133, 7, 249, '庆云县慕佳营销策划服务部', 0.04717, 1, 1, '李哲', 17, 3, 0.05000, 0.00000, 0.00000, 0.01100,
        0.00000, 0.00943, '2024-03-12 08:39:54', '2024-03-15 13:34:16', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (134, 7, 257, '天津市河东区奥卓商务服务工作室', 0.04717, 1, 1, '李哲', 22, 3, 0.06000, 0.00000, 0.00000, 0.10000,
        0.00200, 0.00943, '2024-03-12 08:39:53', '2024-03-15 13:34:08', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (135, 7, 258, '天津市河东区佰业商务服务工作室', 0.04717, 1, 1, '李哲', 22, 3, 0.06000, 0.00000, 0.00000, 0.10000,
        0.00200, 0.00943, '2024-03-12 08:39:52', '2024-03-15 13:34:04', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (136, 7, 259, '新宾满族自治县良御盛知营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 28, 3, 0.05000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:39:51', '2024-04-08 21:28:47', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (137, 7, 260, '天津市河东区北域商务服务工作室(个体工商户)', 0.04717, 1, 1, '李哲', 22, 3, 0.06000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:39:50', '2024-03-15 13:34:00', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (138, 7, 261, '天津市河东区博汇商务服务工作室', 0.04717, 1, 1, '李哲', 22, 3, 0.06000, 0.00000, 0.00000, 0.10000,
        0.00200, 0.00943, '2024-03-12 08:39:49', '2024-03-15 13:33:55', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (139, 7, 262, '天津市河东区博仲商务服务工作室', 0.04717, 1, 1, '李哲', 22, 3, 0.06000, 0.00000, 0.00000, 0.10000,
        0.00200, 0.00943, '2024-03-12 08:39:48', '2024-03-15 13:33:51', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (140, 7, 263, '天津市河东区成达商务服务工作室', 0.04717, 1, 1, '李哲', 22, 3, 0.06000, 0.00000, 0.00000, 0.10000,
        0.00200, 0.00943, '2024-03-12 08:39:47', '2024-03-15 13:33:47', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (141, 7, 264, '天津市河东区程鸣商务服务工作室', 0.04717, 1, 1, '李哲', 22, 3, 0.06000, 0.00000, 0.00000, 0.10000,
        0.00200, 0.00943, '2024-03-12 08:39:46', '2024-03-15 13:33:42', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (142, 7, 265, '天津市河东区创腾商务服务工作室', 0.04717, 1, 1, '李哲', 22, 3, 0.06000, 0.00000, 0.00000, 0.10000,
        0.00200, 0.00943, '2024-03-12 08:39:45', '2024-03-15 13:33:38', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (143, 7, 266, '天津市河东区鼎晟商务服务工作室', 0.04717, 1, 1, '李哲', 22, 3, 0.06000, 0.00000, 0.00000, 0.10000,
        0.00200, 0.00943, '2024-03-12 08:39:44', '2024-03-15 13:33:33', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (144, 7, 267, '天津市河东区浩月商务服务工作室(个体工商户)', 0.04717, 1, 1, '李哲', 22, 3, 0.06000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:39:43', '2024-03-15 13:33:29', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (145, 7, 268, '天津市河东区嘉帆商务服务工作室(个体工商户)', 0.04717, 1, 1, '李哲', 22, 3, 0.06000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:39:42', '2024-03-15 13:33:24', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (146, 7, 269, '天津市河东区郎吉商务服务工作室', 0.04717, 1, 1, '李哲', 22, 3, 0.06000, 0.00000, 0.00000, 0.10000,
        0.00200, 0.00943, '2024-03-12 08:39:41', '2024-03-15 13:33:17', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (147, 7, 270, '天津市河东区琪鑫商务服务工作室', 0.04717, 1, 1, '李哲', 22, 3, 0.06000, 0.00000, 0.00000, 0.10000,
        0.00200, 0.00943, '2024-03-12 08:39:40', '2024-03-15 13:33:13', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (148, 7, 271, '天津市河东区启年商务服务工作室(个体工商户)', 0.04717, 1, 1, '李哲', 22, 3, 0.06000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:39:39', '2024-03-15 13:33:10', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (149, 7, 272, '新宾满族自治县英汇予翰营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 28, 3, 0.05000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:39:38', '2024-04-08 21:28:39', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (150, 7, 273, '新宾满族自治县永晟千汇营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 28, 3, 0.05000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:39:37', '2024-04-08 21:28:34', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (151, 7, 274, '天津市河东区赛威商务服务工作室(个体工商户)', 0.04717, 1, 1, '李哲', 22, 3, 0.06000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:39:36', '2024-03-15 13:32:58', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (152, 7, 275, '天津市河东区世嘉商务服务工作室(个体工商户)', 0.04717, 1, 1, '李哲', 22, 3, 0.06000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:39:35', '2024-03-15 13:32:11', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (153, 7, 276, '天津市河东区四青商务服务工作室(个体工商户）', 0.04717, 1, 1, '李哲', 22, 3, 0.06000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:39:34', '2024-03-15 13:32:16', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (154, 7, 277, '新宾满族自治县优晟智澜营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 28, 3, 0.05000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:39:33', '2024-04-08 21:28:28', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (155, 7, 278, '庆云金原营销策划服务部', 0.04717, 1, 1, '李哲', 17, 3, 0.05000, 0.00000, 0.00000, 0.01100,
        0.00000, 0.00943, '2024-03-12 08:39:32', '2024-03-15 13:32:03', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (156, 7, 279, '天津市河东区艺俪商务服务工作室(个体工商户）', 0.04717, 1, 1, '李哲', 22, 3, 0.06000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:39:31', '2024-03-15 13:32:00', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (157, 7, 280, '天津市河东区宇盟商务服务工作室', 0.04717, 1, 1, '李哲', 22, 3, 0.06000, 0.00000, 0.00000, 0.10000,
        0.00200, 0.00943, '2024-03-12 08:39:30', '2024-03-15 13:31:56', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (158, 7, 281, '天津市河东区月茗商务服务工作室(个体工商户)', 0.04717, 1, 1, '李哲', 22, 3, 0.06000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:39:29', '2024-03-15 13:31:51', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (159, 7, 282, '天津市河东区众凯商务服务工作室(个体工商户)', 0.04717, 1, 1, '李哲', 22, 3, 0.06000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:39:28', '2024-03-15 13:31:48', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (160, 7, 283, '天津市河东区众硕商务服务工作室', 0.04717, 1, 1, '李哲', 22, 3, 0.06000, 0.00000, 0.00000, 0.10000,
        0.00200, 0.00943, '2024-03-12 08:39:27', '2024-03-15 13:31:44', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (161, 7, 284, '天津市红桥区宏通营销策划工作室', 0.04717, 1, 1, '李哲', 21, 3, 0.06000, 0.00000, 0.00000, 0.00700,
        0.00000, 0.00943, '2024-03-12 08:39:26', '2024-03-15 13:31:40', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (162, 7, 285, '天津市红桥区佳益营销策划工作室(个体工商户)', 0.04717, 1, 1, '李哲', 21, 3, 0.06000, 0.00000,
        0.00000, 0.00700, 0.00000, 0.00943, '2024-03-12 08:39:25', '2024-03-15 13:31:36', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (163, 7, 286, '天津市红桥区盛德营销策划工作室(个体工商户)', 0.04717, 1, 1, '李哲', 21, 3, 0.06000, 0.00000,
        0.00000, 0.00700, 0.00000, 0.00943, '2024-03-12 08:39:24', '2024-03-15 13:31:32', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (164, 7, 287, '天津市红桥区西付营销策划工作室', 0.04717, 1, 1, '李哲', 21, 3, 0.06000, 0.00000, 0.00000, 0.00700,
        0.00000, 0.00943, '2024-03-12 08:39:23', '2024-03-15 13:31:29', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (165, 7, 288, '天津市红桥区兴盛营销策划工作室', 0.04717, 1, 1, '李哲', 21, 3, 0.06000, 0.00000, 0.00000, 0.00700,
        0.00000, 0.00943, '2024-03-12 08:39:22', '2024-03-15 13:31:25', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (166, 7, 289, '天津中红桥区子岭营销策划工作室', 0.04717, 1, 1, '李哲', 21, 3, 0.06000, 0.00000, 0.00000, 0.00700,
        0.00000, 0.00943, '2024-03-12 08:39:21', '2024-03-15 13:31:21', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (167, 7, 290, '庆云丰英营销策划服务部(个体工商户)', 0.04717, 1, 1, '李哲', 17, 3, 0.05000, 0.00000, 0.00000,
        0.01100, 0.00000, 0.00943, '2024-03-12 08:39:20', '2024-03-15 13:31:16', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (168, 7, 291, '新宾满族自治县灿智辉荟营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 28, 3, 0.05000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:39:19', '2024-04-08 21:28:19', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (169, 7, 292, '新宾满族自治县辰高羽强营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 28, 3, 0.05000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:39:18', '2024-04-08 21:28:14', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (170, 7, 293, '新宾满族自治县晨晖都晟营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 28, 3, 0.05000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:39:17', '2024-04-08 21:28:09', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (171, 7, 294, '新宾满族自治县晟铭程鑫营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 28, 3, 0.05000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:39:16', '2024-04-08 21:28:03', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (172, 7, 295, '新宾满族自治县航纪宏嘉营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 28, 3, 0.05000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:39:15', '2024-04-08 21:27:57', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (173, 7, 296, '庆云荣发营销策划服务部(个体工商户)', 0.04717, 1, 1, '李哲', 17, 3, 0.05000, 0.00000, 0.00000,
        0.01100, 0.00000, 0.00943, '2024-03-12 08:39:14', '2024-03-15 13:30:01', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (174, 7, 297, '新宾满族自治县君利鸿安营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 28, 3, 0.05000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:39:13', '2024-04-08 21:27:49', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (175, 7, 298, '新宾满族自治县凯辉万业营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 28, 3, 0.05000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:39:12', '2024-04-08 21:27:42', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (176, 7, 299, '新宾满族自治县凯惠领东营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 28, 3, 0.05000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:39:11', '2024-04-08 21:27:36', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (177, 7, 300, '新宾满族自治县凯宇劳诚营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 28, 3, 0.05000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:39:10', '2024-04-08 21:27:30', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (178, 7, 301, '新宾满族自治县莱尼知智营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 28, 3, 0.05000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:39:09', '2024-04-08 21:27:21', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (179, 7, 302, '新宾满族自治县莱诺诚邦营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 28, 3, 0.05000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:39:08', '2024-04-08 21:27:11', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (180, 7, 303, '庆云盛跃营销策划服务部(个体工商户)', 0.04717, 1, 1, '李哲', 17, 3, 0.05000, 0.00000, 0.00000,
        0.01100, 0.00000, 0.00943, '2024-03-12 08:39:07', '2024-03-15 13:29:28', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (181, 7, 304, '新宾满族自治县凌程凯都营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 28, 3, 0.05000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:39:06', '2024-04-08 21:27:05', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (182, 7, 305, '新宾满族自治县凌程智源营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 28, 3, 0.05000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:39:05', '2024-04-08 21:26:59', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (183, 7, 306, '新宾满族自治县美星语康营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 28, 3, 0.05000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:39:04', '2024-04-08 21:26:43', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (184, 7, 307, '新宾满族自治县鹏宇新盛营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 28, 3, 0.05000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:39:03', '2024-04-08 21:26:31', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (185, 7, 308, '新宾满族自治县强智益辉营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 28, 3, 0.05000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:39:02', '2024-04-08 21:26:22', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (186, 7, 309, '新宾满族自治县尚宇晟环营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 28, 3, 0.05000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:39:01', '2024-04-08 21:26:11', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (187, 7, 310, '新宾满族自治县堂慕捷睿营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 28, 3, 0.05000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:39:00', '2024-04-08 21:26:05', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (188, 7, 311, '新宾满族自治县同乘惠企营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 28, 3, 0.05000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:38:59', '2024-04-08 21:25:54', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (189, 7, 312, '新宾满族自治县伟诚顺汇营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 28, 3, 0.05000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:38:58', '2024-04-08 21:25:33', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (190, 7, 313, '新宾满族自治县文程度莱营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 28, 3, 0.05000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:38:57', '2024-04-08 21:25:40', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (191, 7, 314, '新宾满族自治县希祥赢征营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 28, 3, 0.05000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:38:56', '2024-04-08 21:25:23', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (192, 7, 315, '新宾满族自治县新兰慧宇营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 28, 3, 0.05000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:38:55', '2024-04-08 21:25:15', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (193, 7, 316, '新宾满族自治县易智斯文营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 28, 3, 0.05000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:38:54', '2024-04-08 21:25:04', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (194, 7, 317, '吕梁市离石区金花信息服务部(个体工商户)', 0.04717, 1, 1, '李哲', 14, 3, 0.06000, 0.00000, 0.00030,
        0.10000, 0.00200, 0.00943, '2024-03-12 08:38:53', '2024-03-15 13:28:17', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (195, 7, 318, '天津市河东区柏祺商务服务工作室(个体工商户)', 0.04717, 1, 1, '李哲', 22, 3, 0.06000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:38:52', '2024-03-15 13:28:09', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (196, 7, 319, '天津市河东区翘奇商务服务工作室(个体工商户)', 0.04717, 1, 1, '李哲', 22, 3, 0.06000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:38:51', '2024-03-15 13:28:01', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (197, 7, 320, '新宾满族自治县源新共创营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 28, 3, 0.05000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:38:50', '2024-04-08 21:24:43', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (198, 7, 321, '新宾满族自治县知晟惠德营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 28, 3, 0.05000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:38:49', '2024-04-08 21:24:33', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (199, 7, 322, '新宾满族自治县综智宸宇营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 28, 3, 0.05000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:38:48', '2024-04-08 21:24:25', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (200, 7, 323, '天津市河东区润洁商务服务工作室(个体工商户)', 0.04717, 1, 1, '李哲', 22, 3, 0.06000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:38:47', '2024-03-15 13:27:21', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (201, 7, 325, '天津市河东区温芯商务服务工作室(个体工商户)', 0.04717, 1, 1, '李哲', 22, 3, 0.06000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-03-12 08:38:46', '2024-03-15 13:27:12', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (202, 7, 327, '天津市河东区祥睿商务服务工作室', 0.04717, 1, 1, '李哲', 22, 3, 0.06000, 0.00000, 0.00000, 0.10000,
        0.00200, 0.00943, '2024-03-12 08:38:45', '2024-03-15 13:27:01', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (203, 7, 180, '贵安新区宗喜营销策划工作室', 0.04717, 1, 1, '李哲', 19, 3, 0.06000, 0.00000, 0.00050, 0.01000,
        0.00000, 0.00943, '2024-03-12 08:38:54', '2024-03-15 13:28:20', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (204, 7, 183, '涟源市创锦市场营销中心', 0.04717, 1, 1, '李哲', 24, 3, 0.05000, 0.00060, 0.00015, 0.00500,
        0.00600, 0.00943, '2024-03-12 08:38:53', '2024-03-15 13:28:13', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (205, 7, 187, '涟源市诺晨市场营销中心', 0.04717, 1, 1, '李哲', 24, 3, 0.05000, 0.00060, 0.00015, 0.00500,
        0.00600, 0.00943, '2024-03-12 08:38:52', '2024-03-15 13:28:05', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (206, 7, 188, '涟源市瑞佳市场营销中心', 0.04717, 1, 1, '李哲', 24, 3, 0.05000, 0.00060, 0.00015, 0.00500,
        0.00600, 0.00943, '2024-03-12 08:38:51', '2024-03-15 13:27:58', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (207, 7, 189, '涟源市杉旭市场营销中心', 0.04717, 1, 1, '李哲', 24, 3, 0.05000, 0.00060, 0.00015, 0.00500,
        0.00600, 0.00943, '2024-03-12 08:38:50', '2024-03-15 13:27:44', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (208, 7, 190, '涟源市尚语市场营销中心', 0.04717, 1, 1, '李哲', 24, 3, 0.05000, 0.00060, 0.00015, 0.00500,
        0.00600, 0.00943, '2024-03-12 08:38:49', '2024-03-15 13:27:36', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (209, 7, 191, '涟源市顺源市场营销中心', 0.04717, 1, 1, '李哲', 24, 3, 0.05000, 0.00060, 0.00015, 0.00500,
        0.00600, 0.00943, '2024-03-12 08:38:48', '2024-03-15 13:27:27', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (210, 7, 192, '涟源市星瀚市场营销中心', 0.04717, 1, 1, '李哲', 24, 3, 0.05000, 0.00060, 0.00015, 0.00500,
        0.00600, 0.00943, '2024-03-12 08:38:47', '2024-03-15 13:27:16', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (211, 7, 193, '涟源市旭谦市场营销中心', 0.04717, 1, 1, '李哲', 24, 3, 0.05000, 0.00060, 0.00015, 0.00500,
        0.00600, 0.00943, '2024-03-12 08:38:46', '2024-03-15 13:27:08', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (212, 7, 194, '涟源市谊卓市场营销中心', 0.04717, 1, 1, '李哲', 24, 3, 0.05000, 0.00060, 0.00015, 0.00500,
        0.00600, 0.00943, '2024-03-12 08:38:45', '2024-03-15 13:26:56', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (213, 7, 199, '林州市锤佳营销策划中心', 0.04717, 1, 1, '李哲', 20, 3, 0.05000, 0.00000, 0.00000, 0.01150,
        0.00000, 0.00943, '2024-03-12 08:38:44', '2024-03-15 13:26:52', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (214, 7, 201, '涟源市楚娴市场营销中心(个体工商户)', 0.04717, 1, 1, '李哲', 24, 3, 0.05000, 0.00060, 0.00015,
        0.00500, 0.00600, 0.00943, '2024-03-12 08:38:43', '2024-03-15 13:26:48', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (215, 7, 202, '林州市善儒营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 20, 3, 0.05000, 0.00000, 0.00000,
        0.01150, 0.00000, 0.00943, '2024-03-12 08:38:42', '2024-03-15 13:26:42', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (216, 7, 203, '林州市思贝达营销策划中心', 0.04717, 1, 1, '李哲', 20, 3, 0.05000, 0.00000, 0.00000, 0.01150,
        0.00000, 0.00943, '2024-03-12 08:38:41', '2024-03-15 13:26:38', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (217, 7, 204, '林州市旺拓营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 20, 3, 0.05000, 0.00000, 0.00000,
        0.01150, 0.00000, 0.00943, '2024-03-12 08:38:40', '2024-03-15 13:26:34', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (218, 7, 205, '林州市蔚玛营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 20, 3, 0.05000, 0.00000, 0.00000,
        0.01150, 0.00000, 0.00943, '2024-03-12 08:38:39', '2024-03-15 13:26:30', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (219, 7, 206, '林州市稳方营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 20, 3, 0.05000, 0.00000, 0.00000,
        0.01150, 0.00000, 0.00943, '2024-03-12 08:38:38', '2024-03-15 13:26:26', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (220, 7, 207, '林州市新奥灿营销策划中心', 0.04717, 1, 1, '李哲', 20, 3, 0.05000, 0.00000, 0.00000, 0.01150,
        0.00000, 0.00943, '2024-03-12 08:38:37', '2024-03-15 13:26:20', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (221, 7, 208, '林州市新旭凯营销策划中心', 0.04717, 1, 1, '李哲', 20, 3, 0.05000, 0.00000, 0.00000, 0.01150,
        0.00000, 0.00943, '2024-03-12 08:38:36', '2024-03-15 13:26:16', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (222, 7, 210, '涟源市冠顶市场营销中心(个体工商户)', 0.04717, 1, 1, '李哲', 24, 3, 0.05000, 0.00060, 0.00015,
        0.00500, 0.00600, 0.00943, '2024-03-12 08:38:35', '2024-03-15 13:26:12', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (223, 7, 211, '林州市智步营销策划中心', 0.04717, 1, 1, '李哲', 20, 3, 0.05000, 0.00000, 0.00000, 0.01150,
        0.00000, 0.00943, '2024-03-12 08:38:34', '2024-03-15 13:26:08', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (224, 7, 215, '涟源市欢至市场营销中心(个体工商户)', 0.04717, 1, 1, '李哲', 24, 3, 0.05000, 0.00060, 0.00015,
        0.00500, 0.00600, 0.00943, '2024-03-12 08:38:33', '2024-03-15 13:26:04', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (225, 7, 221, '南县南洲界越营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 8, 3, 0.05000, 0.00060, 0.00000,
        0.00970, 0.00000, 0.00943, '2024-03-12 08:38:32', '2024-03-15 13:26:00', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (226, 7, 234, '涟源市景兴市场营销中心(个体工商户)', 0.04717, 1, 1, '李哲', 24, 3, 0.05000, 0.00060, 0.00015,
        0.00500, 0.00600, 0.00943, '2024-03-12 08:38:31', '2024-03-15 13:25:56', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (227, 7, 235, '庆云峰达营销策划服务部', 0.04717, 1, 1, '李哲', 17, 3, 0.05000, 0.00000, 0.00000, 0.01100,
        0.00000, 0.00943, '2024-03-12 08:38:30', '2024-03-15 13:25:49', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (228, 7, 250, '邵东市大禾塘君熠营销策划服务部(个体工商户)', 0.04717, 1, 1, '李哲', 26, 3, 0.05000, 0.00060,
        0.00015, 0.00600, 0.00600, 0.00943, '2024-03-12 08:38:29', '2024-03-15 13:25:45', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (229, 7, 251, '邵东市大禾塘李杜娟营销策划服务部(个体工商户)', 0.04717, 1, 1, '李哲', 26, 3, 0.05000, 0.00060,
        0.00015, 0.00600, 0.00600, 0.00943, '2024-03-12 08:38:28', '2024-03-15 13:25:40', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (230, 7, 252, '邵东市大禾塘李健营销策划服务部(个体工商户)', 0.04717, 1, 1, '李哲', 26, 3, 0.05000, 0.00060,
        0.00015, 0.00600, 0.00600, 0.00943, '2024-03-12 08:38:27', '2024-03-15 13:25:36', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (231, 7, 253, '邵东市大禾塘刘贤芬营销策划服务部(个体工商户)', 0.04717, 1, 1, '李哲', 26, 3, 0.05000, 0.00060,
        0.00015, 0.00600, 0.00600, 0.00943, '2024-03-12 08:38:26', '2024-03-15 13:25:33', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (232, 7, 254, '邵东市大禾塘严逍营销策划服务部(个体工商户)', 0.04717, 1, 1, '李哲', 26, 3, 0.05000, 0.00060,
        0.00015, 0.00600, 0.00600, 0.00943, '2024-03-12 08:38:25', '2024-03-15 13:25:28', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (233, 7, 255, '邵东市大禾塘袁芳营销策划服务部(个体工商户)', 0.04717, 1, 1, '李哲', 26, 3, 0.05000, 0.00060,
        0.00015, 0.00600, 0.00600, 0.00943, '2024-03-12 08:38:24', '2024-03-15 13:25:20', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (234, 7, 256, '邵东市大禾塘钟旺财营销策划服务部(个体工商户)', 0.04717, 1, 1, '李哲', 26, 3, 0.05000, 0.00060,
        0.00015, 0.00600, 0.00600, 0.00943, '2024-03-12 08:38:23', '2024-03-15 13:25:12', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (235, 7, 324, '中山市澳博营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 27, 3, 0.06000, 0.00000, 0.00000,
        0.00540, 0.00500, 0.00943, '2024-03-12 08:38:22', '2024-03-15 13:25:08', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (236, 7, 326, '中山市驰普营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 27, 3, 0.06000, 0.00000, 0.00000,
        0.00540, 0.00500, 0.00943, '2024-03-12 08:38:21', '2024-03-15 13:25:03', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (237, 7, 328, '中山市金语营销策划中心（个体工商户）', 0.04717, 1, 1, '李哲', 27, 3, 0.06000, 0.00000, 0.00000,
        0.00540, 0.00500, 0.00943, '2024-03-12 08:38:20', '2024-03-15 13:24:58', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (238, 7, 329, '中山市金众营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 27, 3, 0.06000, 0.00000, 0.00000,
        0.00540, 0.00500, 0.00943, '2024-03-12 08:38:19', '2024-03-15 13:24:54', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (239, 7, 330, '中山市景悦营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 27, 3, 0.06000, 0.00000, 0.00000,
        0.00540, 0.00500, 0.00943, '2024-03-12 08:38:18', '2024-03-15 13:24:50', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (240, 7, 331, '中山市久源营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 27, 3, 0.06000, 0.00000, 0.00000,
        0.00540, 0.00500, 0.00943, '2024-03-12 08:38:17', '2024-03-15 13:24:44', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (241, 7, 332, '中山市科天营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 27, 3, 0.06000, 0.00000, 0.00000,
        0.00540, 0.00500, 0.00943, '2024-03-12 08:38:16', '2024-03-15 13:24:40', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (242, 7, 333, '中山市睿宇营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 27, 3, 0.06000, 0.00000, 0.00000,
        0.00540, 0.00500, 0.00943, '2024-03-12 08:38:15', '2024-03-15 13:24:33', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (243, 7, 334, '中山市万拓营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 27, 3, 0.06000, 0.00000, 0.00000,
        0.00540, 0.00500, 0.00943, '2024-03-12 08:38:14', '2024-03-15 13:24:28', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (244, 7, 335, '中山市鑫光营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 27, 3, 0.06000, 0.00000, 0.00000,
        0.00540, 0.00500, 0.00943, '2024-03-12 08:38:13', '2024-03-15 13:24:18', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (245, 7, 336, '中山市妍乐营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 27, 3, 0.06000, 0.00000, 0.00000,
        0.00540, 0.00500, 0.00943, '2024-03-12 08:38:12', '2024-03-15 13:24:13', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (246, 7, 337, '中山市耀远营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 27, 3, 0.06000, 0.00000, 0.00000,
        0.00540, 0.00500, 0.00943, '2024-03-12 08:38:11', '2024-03-15 13:24:07', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (247, 7, 338, '中山市语乐营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 27, 3, 0.06000, 0.00000, 0.00000,
        0.00540, 0.00500, 0.00943, '2024-03-12 08:38:10', '2024-03-15 13:24:03', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (248, 7, 339, '中山市源立营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 27, 3, 0.06000, 0.00000, 0.00000,
        0.00540, 0.00500, 0.00943, '2024-03-12 08:38:09', '2024-03-15 13:23:59', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (249, 7, 340, '中山市龙宇营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 27, 3, 0.06000, 0.00000, 0.00000,
        0.00540, 0.00500, 0.00943, '2024-03-12 08:38:08', '2024-03-15 13:23:54', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (250, 7, 341, '中山市创凯营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 27, 3, 0.06000, 0.00000, 0.00000,
        0.00540, 0.00500, 0.00943, '2024-03-12 08:38:07', '2024-03-15 13:23:48', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (251, 7, 342, '天津中新生态城云尚卢志亮零零壹信息服务部（个体工商户）', 0.04762, 1, 1, '李哲', 23, 2, 0.06000,
        0.00000, 0.00000, 0.12000, 0.00700, 0.00952, '2024-03-12 14:13:11', '2024-03-15 13:43:03', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (252, 7, 343, '天津中新生态城云尚张丽红零零壹信息服务部（个体工商户）', 0.04762, 1, 1, '李哲', 23, 2, 0.06000,
        0.00000, 0.00000, 0.12000, 0.00700, 0.00952, '2024-03-12 14:13:10', '2024-03-15 13:43:07', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (253, 7, 344, '天津中新生态城云尚赵立水零零壹信息服务部（个体工商户）', 0.04762, 1, 1, '李哲', 23, 2, 0.06000,
        0.00000, 0.00000, 0.12000, 0.00700, 0.00952, '2024-03-12 14:13:09', '2024-03-15 13:43:10', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (254, 7, 345, '天津中新生态城云尚郭丽辉零零壹信息服务部（个体工商户）', 0.04762, 1, 1, '李哲', 23, 2, 0.06000,
        0.00000, 0.00000, 0.12000, 0.00700, 0.00952, '2024-03-12 14:13:08', '2024-03-15 13:43:14', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (255, 7, 346, '天津中新生态城云尚郑富磊零零壹信息服务部（个体工商户）', 0.04762, 1, 1, '李哲', 23, 2, 0.06000,
        0.00000, 0.00000, 0.12000, 0.00700, 0.00952, '2024-03-12 14:13:07', '2024-03-15 13:43:19', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (256, 7, 347, '崂山区鑫德林营销策划中心(个体工商户)', 0.04717, 1, 1, '鑫德林', 18, 3, 0.06000, 0.00000, 0.00000,
        0.01120, 0.00000, 0.00943, '2024-03-12 14:13:06', '2024-03-15 13:42:52', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (257, 7, 348, '市南区恒南河营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 18, 3, 0.06000, 0.00000, 0.00000,
        0.01120, 0.00000, 0.00943, '2024-03-12 14:13:05', '2024-03-15 13:42:48', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (258, 7, 349, '城阳区宁安信营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 18, 3, 0.06000, 0.00000, 0.00000,
        0.01120, 0.00000, 0.00943, '2024-03-12 14:13:04', '2024-03-15 13:42:40', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (259, 7, 350, '市北区世坦邦营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 18, 3, 0.06000, 0.00000, 0.00000,
        0.01120, 0.00000, 0.00943, '2024-03-12 14:13:03', '2024-03-15 13:42:37', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (260, 7, 351, '崂山区君硕营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 18, 3, 0.06000, 0.00000, 0.00000,
        0.01120, 0.00000, 0.00943, '2024-03-12 14:13:02', '2024-03-15 13:42:32', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (261, 7, 352, '城阳区自正贤营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 18, 3, 0.06000, 0.00000, 0.00000,
        0.01120, 0.00000, 0.00943, '2024-03-12 14:13:01', '2024-03-15 13:42:25', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (262, 7, 353, '市南区开驰恒营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 18, 3, 0.06000, 0.00000, 0.00000,
        0.01120, 0.00000, 0.00943, '2024-03-12 14:13:00', '2024-03-15 13:42:22', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (263, 7, 354, '市北区民亨顺营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 18, 3, 0.06000, 0.00000, 0.00000,
        0.01120, 0.00000, 0.00943, '2024-03-12 14:12:59', '2024-03-29 00:16:44', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (264, 7, 355, '市南区和驰通营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 18, 3, 0.06000, 0.00000, 0.00000,
        0.01120, 0.00000, 0.00943, '2024-03-12 14:12:58', '2024-03-15 13:42:18', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (265, 7, 356, '泗洪菲萌营销策划中心', 0.04717, 1, 1, '李哲', 30, 3, 0.06000, 0.00000, 0.00000, 0.01240, 0.00000,
        0.00943, '2024-03-12 14:12:57', '2024-03-15 13:42:14', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (266, 7, 357, '泗洪峰同营销策划中心', 0.04717, 1, 1, '李哲', 30, 3, 0.06000, 0.00000, 0.00000, 0.01240, 0.00000,
        0.00943, '2024-03-12 14:12:56', '2024-03-15 13:42:10', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (267, 7, 358, '泗洪荷凝营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 30, 3, 0.06000, 0.00000, 0.00000,
        0.01240, 0.00000, 0.00943, '2024-03-12 14:12:55', '2024-03-15 13:42:04', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (268, 7, 359, '泗洪惠努力营销策划中心', 0.04717, 1, 1, '李哲', 30, 3, 0.06000, 0.00000, 0.00000, 0.01240,
        0.00000, 0.00943, '2024-03-12 14:12:54', '2024-03-15 13:42:00', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (269, 7, 360, '泗洪娟福营销策划中心', 0.04717, 1, 1, '李哲', 30, 3, 0.06000, 0.00000, 0.00000, 0.01240, 0.00000,
        0.00943, '2024-03-12 14:12:53', '2024-03-15 13:41:56', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (270, 7, 361, '泗洪明鹿咨营销策划中心', 0.04717, 1, 1, '李哲', 30, 3, 0.06000, 0.00000, 0.00000, 0.01240,
        0.00000, 0.00943, '2024-03-12 14:12:52', '2024-03-15 13:41:53', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (271, 7, 362, '泗洪奇益咨询服务中心', 0.04717, 1, 1, '李哲', 30, 3, 0.06000, 0.00000, 0.00000, 0.01240, 0.00000,
        0.00943, '2024-03-12 14:12:51', '2024-03-15 13:41:46', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (272, 7, 363, '泗洪首诚咨询服务中心', 0.04717, 1, 1, '李哲', 30, 3, 0.06000, 0.00000, 0.00000, 0.01240, 0.00000,
        0.00943, '2024-03-12 14:12:50', '2024-03-15 13:41:43', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (273, 7, 364, '泗洪素径咨询服务中心', 0.04717, 1, 1, '李哲', 30, 3, 0.06000, 0.00000, 0.00000, 0.01240, 0.00000,
        0.00943, '2024-03-12 14:12:49', '2024-03-15 13:41:39', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (274, 7, 365, '泗洪雅森咨询服务中心', 0.04717, 1, 1, '李哲', 30, 3, 0.06000, 0.00000, 0.00000, 0.01240, 0.00000,
        0.00943, '2024-03-12 14:12:48', '2024-03-15 13:41:35', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (275, 7, 366, '泗洪博司咨询服务中心', 0.04717, 1, 1, '李哲', 30, 3, 0.06000, 0.00000, 0.00000, 0.01240, 0.00000,
        0.00943, '2024-03-12 14:12:47', '2024-03-15 13:41:32', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (276, 7, 367, '泗洪霏展咨询服务中心', 0.04717, 1, 1, '李哲', 30, 3, 0.06000, 0.00000, 0.00000, 0.01240, 0.00000,
        0.00943, '2024-03-12 14:12:46', '2024-03-15 13:41:26', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (277, 7, 368, '泗洪江雅咨询服务中心', 0.04717, 1, 1, '李哲', 30, 3, 0.06000, 0.00000, 0.00000, 0.01240, 0.00000,
        0.00943, '2024-03-12 14:12:45', '2024-03-15 13:41:22', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (278, 7, 369, '泗洪思浣咨询服务中心', 0.04762, 1, 1, '李哲', 30, 2, 0.06000, 0.00000, 0.00000, 0.01240, 0.00000,
        0.00952, '2024-03-12 14:12:44', '2024-03-15 13:44:25', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (279, 7, 370, '泗洪彤津咨询服务中心', 0.04717, 1, 1, '李哲', 30, 3, 0.06000, 0.00000, 0.00000, 0.01240, 0.00000,
        0.00943, '2024-03-12 14:12:43', '2024-03-15 13:41:18', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (280, 7, 371, '泗洪讯阳咨询服务中心', 0.04717, 1, 1, '李哲', 30, 3, 0.06000, 0.00000, 0.00000, 0.01240, 0.00000,
        0.00943, '2024-03-12 14:12:42', '2024-03-15 13:41:15', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (281, 7, 124, '安阳市殷都区迈易营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 2, 3, 0.06000, 0.00000, 0.00000,
        0.00350, 0.00400, 0.00943, '2024-03-19 16:09:00', '2024-03-19 16:10:14', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (282, 7, 137, '安阳市殷都区聿炽樊营销策划中心(个体工商户)', 0.04717, 1, 1, '李哲', 2, 3, 0.06000, 0.00000,
        0.00000, 0.00350, 0.00400, 0.00943, '2024-03-19 16:50:37', '2024-03-20 14:17:33', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (283, 7, 372, '南县南洲张璐文艺创作工作室（个体工商户）', 0.08500, 1, 3, '何浩淼', 8, 4, 0.05000, 0.00060, 0.00000,
        0.01960, 0.00000, 0.03000, '2024-03-28 11:41:33', '2024-03-28 11:59:01', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (284, 3, 82, '南县南洲驰元营销策划中心', 0.03000, 1, 2, '何浩淼', 8, 5, 0.05000, 0.00060, 0.00000, 0.00970,
        0.00000, 0.00000, '2024-03-28 11:55:20', '2024-03-28 14:23:39', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (285, 3, 84, '南县南洲青齐文艺创作工作室', 0.04000, 1, 2, '何浩淼', 8, 5, 0.05000, 0.00060, 0.00000, 0.00970,
        0.00000, 0.00000, '2024-03-28 14:28:06', '2024-05-22 16:26:24', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (286, 3, 83, '南县南洲韩冰文艺创作工作室', 0.04000, 1, 2, '何浩淼', 8, 5, 0.05000, 0.00060, 0.00000, 0.00970,
        0.00000, 0.00000, '2024-03-28 14:29:11', '2024-05-22 16:26:15', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (287, 7, 381, '南县南洲嘉联营销策划中心', 0.04000, 1, 2, '立华', 8, 8, 0.05000, 0.00060, 0.00000, 0.00800,
        0.00000, 0.01200, '2024-03-28 19:11:50', '2024-03-29 18:12:53', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (288, 7, 382, '南县南洲暮然信息服务中心', 0.02500, 1, 2, '立华', 8, 8, 0.05000, 0.00060, 0.00000, 0.00800,
        0.00000, 0.01200, '2024-03-28 23:23:22', '2024-03-29 18:14:31', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (289, 7, 383, '南县南洲思良科技中心', 0.03000, 1, 2, '鲁浩然', 8, 5, 0.05000, 0.00060, 0.00000, 0.00800, 0.00000,
        0.00000, '2024-03-29 11:02:10', '2024-03-29 11:05:19', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (290, 7, 384, '南县南洲顺通汽车服务工作室', 0.04000, 1, 2, '鲁浩然', 8, 9, 0.05000, 0.00060, 0.00000, 0.00800,
        0.00000, 0.01600, '2024-03-29 11:39:24', '2024-03-29 18:19:36', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (291, 7, 385, '南县南洲通顺汽车服务中心', 0.04000, 1, 2, '鲁浩然', 8, 9, 0.05000, 0.00060, 0.00000, 0.00800,
        0.00000, 0.01600, '2024-03-29 11:53:06', '2024-03-29 18:19:26', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (292, 7, 386, '安阳市殷都区立咏营销策划中心（个体工商户）', 0.04717, 2, 1, '李哲', 2, 3, 0.06000, 0.00000, 0.00000,
        0.00350, 0.00400, 0.00943, '2024-03-29 16:59:03', '2024-03-30 20:16:32', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (294, 7, 388, '南县南洲峰乐科技工作室', 0.02000, 1, 2, '何浩淼', 8, 5, 0.05000, 0.00060, 0.00000, 0.00970,
        0.00000, 0.00000, '2024-03-30 11:53:22', '2024-03-30 12:34:02', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (295, 7, 387, '南县南洲永勤科技工作室', 0.02000, 1, 2, '何浩淼', 8, 5, 0.05000, 0.00060, 0.00000, 0.00970,
        0.00000, 0.00000, '2024-03-30 11:54:31', '2024-03-30 12:34:17', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (296, 7, 389, '吕梁市离石区思傲信息服务部(个体工商户)', 0.04762, 1, 1, '李哲', 14, 2, 0.06000, 0.00000, 0.00030,
        0.10000, 0.00200, 0.00952, '2024-03-30 16:55:15', '2024-03-30 16:57:11', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (297, 7, 390, '固镇县新马桥镇荟文市场营销策划工作室（个体工商户）', 0.04717, 2, 1, '李哲', 29, 3, 0.06000, 0.00000,
        0.00000, 0.00500, 0.00200, 0.00943, '2024-03-30 19:42:57', '2024-03-30 19:43:35', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (298, 7, 391, '固镇县新马桥镇洁音市场营销策划工作室（个体工商户）', 0.04717, 1, 1, '李哲', 29, 3, 0.06000, 0.00000,
        0.00000, 0.00500, 0.00200, 0.00943, '2024-03-30 19:52:04', '2024-03-30 19:53:39', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (299, 7, 392, '固镇县新马桥镇音素市场营销策划工作室（个体工商户）', 0.04717, 1, 1, '李哲', 29, 3, 0.06000, 0.00000,
        0.00000, 0.00500, 0.00200, 0.00943, '2024-03-30 19:52:09', '2024-03-30 19:53:17', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (300, 7, 393, '固镇县新马桥镇巡之市场营销策划工作室（个体工商户）', 0.04717, 1, 1, '李哲', 29, 3, 0.06000, 0.00000,
        0.00000, 0.00500, 0.00200, 0.00943, '2024-03-30 19:52:13', '2024-03-30 19:52:49', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (301, 7, 394, '吕梁市离石区宇卓信息服务部（个体工商户）', 0.04762, 1, 1, '李哲', 14, 2, 0.06000, 0.00000, 0.00030,
        0.10000, 0.00200, 0.00952, '2024-03-30 20:02:17', '2024-03-30 20:03:11', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (302, 7, 395, '安阳市殷都区丹隆福茂服务部(个体工商户)', 0.03000, 1, 2, '李哲', 3, 5, 0.06000, 0.00000, 0.00000,
        0.00350, 0.00200, 0.00000, '2024-04-03 15:36:09', '2024-04-03 15:47:29', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (303, 7, 407, '南县南洲顺基科技工作室 （个体工商户）', 0.06000, 1, 2, '鲁浩然', 8, 21, 0.05000, 0.00060, 0.00000,
        0.00970, 0.00000, 0.03200, '2024-04-08 15:41:55', '2024-04-08 16:00:15', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (304, 1, 409, '工商注册企业测试', 0.10000, NULL, 3, '罗灿', 40, 20, 0.01000, 0.01000, 0.01000, 0.01000, 0.01000,
        0.01000, '2024-04-08 18:29:01', '2024-04-08 18:31:29', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (305, 14, 410, '成都胜殊川云企业管理咨询服务中心', 0.10000, 1, 3, '罗灿', 43, 22, 0.02000, 0.02000, 0.02000,
        0.02000, 0.02000, 0.02000, '2024-04-08 19:24:14', '2024-05-29 17:17:14', 1, 0.00000, 0.00000);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (306, 7, 423, '天津市河西区荣华欣商务服务工作室（个体工商户）', 0.04762, 1, 1, '李哲', 41, 2, 0.06000, 0.00000,
        0.00000, 0.10000, 0.00500, 0.00952, '2024-04-17 18:32:24', '2024-04-17 18:33:54', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (307, 7, 426, '固镇县王庄镇思升市场营销策划服务部', 0.04762, 1, 1, '李哲', 29, 2, 0.06000, 0.00000, 0.00000,
        0.00500, 0.00200, 0.00952, '2024-04-18 17:57:14', '2024-04-18 17:58:10', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (308, 7, 427, '固镇县王庄镇丰季市场营销策划服务部（个体工商户）', 0.04717, 1, 1, NULL, 29, 3, 0.06000, 0.00000,
        0.00000, 0.00500, 0.00200, 0.00943, '2024-04-18 18:16:00', '2024-04-18 18:16:37', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (309, 7, 429, '固镇县王庄镇飞绍市场营销策划服务部（个体工商户）', 0.04717, 1, 1, '李哲', 29, 3, 0.06000, 0.00000,
        0.00000, 0.00500, 0.00200, 0.00943, '2024-04-19 18:48:05', '2024-04-19 18:48:54', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (310, 7, 430, '天津市南开区嘉雅商务服务工作室（个体工商户）', 0.04717, 1, 1, '李哲', 41, 3, 0.06000, 0.00000,
        0.00000, 0.10000, 0.00500, 0.00943, '2024-04-22 11:40:02', '2024-04-22 11:41:17', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (311, 7, 431, '天津市南开区儒欣商务服务部(个体工商户)', 0.04717, 1, 1, '李哲', 41, 3, 0.06000, 0.00000, 0.00000,
        0.10000, 0.00500, 0.00943, '2024-04-23 15:42:47', '2024-04-23 15:43:59', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (312, 7, 432, '南县南洲洋立营销策划中心', 0.02800, 1, 2, '鲁浩然', 8, 5, 0.05000, 0.00060, 0.00000, 0.00970,
        0.00000, 0.00000, '2024-04-23 16:56:15', '2024-04-23 17:05:13', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (313, 7, 434, '庆云君盛营销策划服务部（个体工商户）', 0.04717, 1, 1, '李哲', 17, 3, 0.05000, 0.00000, 0.00000,
        0.01100, 0.00000, 0.00943, '2024-04-24 19:38:56', '2024-04-24 19:39:22', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (314, 7, 448, '天津市南开区粮好商务服务工作室（个体工商户）', 0.04762, 1, 1, '李哲', 41, 2, 0.06000, 0.00000,
        0.00000, 0.10000, 0.00500, 0.00952, '2024-04-29 10:37:32', '2024-04-29 10:38:25', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (315, 7, 449, '固镇县王庄镇智良市场营销策划工作室（个体工商户）', 0.04762, 1, 1, '李哲', 29, 2, 0.06000, 0.00000,
        0.00000, 0.00500, 0.00200, 0.00952, '2024-04-29 18:58:57', '2024-04-29 19:00:01', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (316, 7, 450, '固镇县王庄镇立回市场营销策划工作室（个体工商户）', 0.04762, NULL, 1, '李哲', 29, 2, 0.06000,
        0.00000, 0.00000, 0.00500, 0.00200, 0.00952, '2024-04-30 20:21:04', '2024-04-30 20:21:42', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (317, 7, 459, '安阳市殷都区兆楠营销策划中心（个体工商户）', 0.04717, 1, 1, '李哲', 3, 3, 0.06000, 0.00000, 0.00000,
        0.00350, 0.00200, 0.00943, '2024-05-14 17:01:28', '2024-05-14 17:02:29', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (318, 7, 453, '安阳市殷都区绿盛营销策划中心（个体工商户）', 0.04762, 1, 1, '李哲', 3, 2, 0.06000, 0.00000, 0.00000,
        0.00350, 0.00200, 0.00952, '2024-05-14 19:32:04', '2024-05-14 19:33:08', 2, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (319, 7, 462, '固镇县王庄镇超纪市场营销策划服务部（个体工商户）', 0.04717, 1, 1, '李哲', 29, 3, 0.06000, 0.00000,
        0.00000, 0.00500, 0.00200, 0.00943, '2024-05-16 14:53:34', '2024-05-16 14:54:05', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (320, 7, 469, '新宾满族自治县优蜜福贝营销策划工作室（个体工商户）', 0.04717, 1, 1, '李哲', 28, 3, 0.05000, 0.00000,
        0.00000, 0.10000, 0.00200, 0.00943, '2024-05-22 12:22:09', '2024-05-22 12:22:33', 1, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (321, 7, 471, '固镇县王庄镇飞陇市场营销策划服务部（个体工商户）', 0.04717, 1, 1, '李哲', 29, 3, 0.06000, 0.00000,
        0.00000, 0.00500, 0.00200, 0.00943, '2024-05-24 14:05:17', '2024-05-24 14:05:49', 1, 0.00000, 0.00000);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (322, 7, 472, '固镇县王庄镇旋火市场营销策划服务部（个体工商户）', 0.04717, NULL, 1, '李哲', 29, 3, 0.06000,
        0.00000, 0.00000, 0.00500, 0.00200, 0.00943, '2024-05-24 14:08:51', '2024-05-24 14:09:10', 1, 0.00000, 0.00000);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (323, 7, 473, '天津市滨海新区贝越商务服务工作室（个体工商户）', 0.04762, 1, 1, '李哲', 41, 2, 0.06000, 0.00000,
        0.00000, 0.10000, 0.00500, 0.00952, '2024-05-24 14:50:10', '2024-05-24 14:50:56', 1, 0.00000, 0.00000);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (324, 7, 474, '安阳市殷都区榕禾营销策划中心（个体工商户）', 0.04762, 1, 1, '李哲', 2, 2, 0.06000, 0.00000, 0.00000,
        0.00350, 0.00400, 0.00952, '2024-05-24 15:13:11', '2024-05-24 15:13:39', 2, 0.00000, 0.00000);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (325, 7, 480, '安阳市殷都区曾仔营销策划中心（个体工商户）', 0.04762, 1, 1, '李哲', 2, 2, 0.06000, 0.00000, 0.00000,
        0.00350, 0.00400, 0.00952, '2024-05-27 16:23:13', '2024-05-27 16:24:17', 2, 0.00000, 0.00000);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (326, 7, 479, '安阳市殷都区晨妍营销策划中心（个体工商户）', 0.04762, 1, 1, '李哲', 2, 2, 0.06000, 0.00000, 0.00000,
        0.00350, 0.00400, 0.00952, '2024-05-27 16:23:22', '2024-05-27 16:23:55', 2, 0.00000, 0.00000);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (327, 7, 483, '天津市滨海新区亿鸣商务服务工作室（个体工商户）', 0.04717, 1, 1, '李哲', 41, 3, 0.06000, 0.00000,
        0.00000, 0.10000, 0.00500, 0.00943, '2024-05-28 16:44:37', '2024-05-28 16:47:27', 1, 0.00000, 0.00000);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (328, 7, 482, '固镇县王庄镇君文市场营销策划服务部（个体工商户）', 0.04717, 1, 1, '李哲', 29, 3, 0.06000, 0.00000,
        0.00000, 0.00500, 0.00200, 0.00943, '2024-05-28 16:45:07', '2024-05-28 16:45:47', 1, 0.00000, 0.00000);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (329, 7, 481, '南县南洲汉礼信息服务工作室（个体工商户）', 0.03000, 1, 2, '张露', 8, NULL, 0.05000, 0.00060,
        0.00000, 0.00970, 0.00000, 0.00000, '2024-05-28 16:52:01', '2024-05-28 17:05:02', 1, 0.00000, 0.03000);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (330, 1, 1, '成都胜殊川云企业管理咨询服务中心', 0.00000, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2024-06-05 10:26:02', '2024-06-05 10:26:02', NULL, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (331, 1, 1040, 'jlkdjf', 0.00000, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        '2024-06-05 15:17:14', '2024-06-05 15:17:14', NULL, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (332, 1007, 1047, '成都胜殊川云企业管理咨询服务中心', 0.00000, NULL, NULL, NULL, 45, 23, 0.00000, 0.00000,
        0.00000, 0.00000, 0.12000, 0.01000, '2024-06-17 10:23:46', '2024-06-17 11:11:34', NULL, 0.00000, 0.10000);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (336, 1007, 1048, '测试1', 0.01000, NULL, NULL, NULL, 45, 23, 0.00000, 0.00000, 0.00000, 0.00000, 0.12000,
        0.01000, '2024-06-17 10:24:33', '2024-06-17 10:45:36', NULL, 0.00000, 0.10000);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (337, 1, 2, '罗数科技（开封）有限公司', 0.00000, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        '2024-07-07 16:57:02', '2024-07-07 16:57:02', NULL, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (338, 2, 3, '罗数科技（开封）有限公司', 0.00000, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        '2024-07-07 17:15:15', '2024-07-07 17:15:15', NULL, NULL, NULL);
INSERT INTO `inv_park_enterprise` (`id`, `org_id`, `enterprise_id`, `enterprise_name`, `service_fee_rate`,
                                   `service_fee_payer_id`, `customer_id`, `customer_manager`, `park_provider_id`,
                                   `distributor_id`, `park_provider_additional_tax_rate`,
                                   `park_provider_water_tax_rate`, `park_provider_stamp_tax_rate`,
                                   `park_provider_income_tax_rate`, `park_provider_service_fee_rate`,
                                   `distributor_service_fee_rate`, `create_time`, `update_time`, `value_added_tax_type`,
                                   `park_provider_value_added_tax_rate`, `include_tax_rate`)
VALUES (339, 2, 4, '成都胜殊川云企业管理咨询服务中心', 0.00000, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2024-07-07 17:15:15', '2024-07-07 17:15:15', NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for inv_park_enterprise_customer
-- ----------------------------
DROP TABLE IF EXISTS `inv_park_enterprise_customer`;
CREATE TABLE `inv_park_enterprise_customer`
(
    `id`   bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '客户名称',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 5
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

-- ----------------------------
-- Records of inv_park_enterprise_customer
-- ----------------------------
BEGIN;
INSERT INTO `inv_park_enterprise_customer` (`id`, `name`)
VALUES (1, '石药集团-个体户');
INSERT INTO `inv_park_enterprise_customer` (`id`, `name`)
VALUES (2, '非KA');
INSERT INTO `inv_park_enterprise_customer` (`id`, `name`)
VALUES (3, '抖音主播');
INSERT INTO `inv_park_enterprise_customer` (`id`, `name`)
VALUES (4, '海南鲲腾');
COMMIT;

-- ----------------------------
-- Table structure for inv_park_enterprise_distributor
-- ----------------------------
DROP TABLE IF EXISTS `inv_park_enterprise_distributor`;
CREATE TABLE `inv_park_enterprise_distributor`
(
    `id`                bigint                                                       NOT NULL AUTO_INCREMENT,
    `name`              varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '渠道商名称',
    `remark`            text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '渠道商描述',
    `status`            int                                                          NOT NULL COMMENT '渠道商状态 1-启用 2-停用',
    `account_name`      varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '收款公司名',
    `account_open_bank` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '开户银行',
    `account_bank`      varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '收款银行',
    `account_no`        varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '收款银行账号',
    `fee_rate`          decimal(10, 5)                                               NOT NULL COMMENT '佣金费率',
    `create_time`       datetime                                                     NOT NULL COMMENT '创建时间',
    `update_time`       datetime                                                     NOT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 25
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='渠道商';

-- ----------------------------
-- Records of inv_park_enterprise_distributor
-- ----------------------------
BEGIN;
INSERT INTO `inv_park_enterprise_distributor` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`,
                                               `account_bank`, `account_no`, `fee_rate`, `create_time`, `update_time`)
VALUES (2, '尚凡药品', NULL, 1, NULL, NULL, NULL, NULL, 0.00952, '2024-03-12 09:52:51', '2024-03-15 12:00:38');
INSERT INTO `inv_park_enterprise_distributor` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`,
                                               `account_bank`, `account_no`, `fee_rate`, `create_time`, `update_time`)
VALUES (3, '尚凡非药品', NULL, 1, NULL, NULL, NULL, NULL, 0.00943, '2024-03-12 09:53:03', '2024-03-15 12:00:00');
INSERT INTO `inv_park_enterprise_distributor` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`,
                                               `account_bank`, `account_no`, `fee_rate`, `create_time`, `update_time`)
VALUES (4, '煎饼娱乐', NULL, 1, NULL, NULL, NULL, NULL, 0.03000, '2024-03-13 15:01:14', '2024-03-13 15:01:14');
INSERT INTO `inv_park_enterprise_distributor` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`,
                                               `account_bank`, `account_no`, `fee_rate`, `create_time`, `update_time`)
VALUES (5, '默认渠道', '用于管理真实业务渠道的企业，费率设置为0。', 1, NULL, NULL, NULL, NULL, 0.00000,
        '2024-03-28 13:47:02', '2024-03-28 13:47:02');
INSERT INTO `inv_park_enterprise_distributor` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`,
                                               `account_bank`, `account_no`, `fee_rate`, `create_time`, `update_time`)
VALUES (6, '河北楠茜科技有限公司', NULL, 1, NULL, NULL, NULL, NULL, 0.02000, '2024-03-29 18:02:12',
        '2024-03-29 18:02:12');
INSERT INTO `inv_park_enterprise_distributor` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`,
                                               `account_bank`, `account_no`, `fee_rate`, `create_time`, `update_time`)
VALUES (7, '诺藤', NULL, 1, NULL, NULL, NULL, NULL, 0.01000, '2024-03-29 18:08:05', '2024-03-29 18:11:10');
INSERT INTO `inv_park_enterprise_distributor` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`,
                                               `account_bank`, `account_no`, `fee_rate`, `create_time`, `update_time`)
VALUES (8, '军辉', NULL, 1, NULL, NULL, NULL, NULL, 0.01200, '2024-03-29 18:12:36', '2024-03-29 18:12:36');
INSERT INTO `inv_park_enterprise_distributor` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`,
                                               `account_bank`, `account_no`, `fee_rate`, `create_time`, `update_time`)
VALUES (9, '易礼民', NULL, 1, NULL, NULL, NULL, NULL, 0.01600, '2024-03-29 18:19:04', '2024-03-29 18:19:04');
INSERT INTO `inv_park_enterprise_distributor` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`,
                                               `account_bank`, `account_no`, `fee_rate`, `create_time`, `update_time`)
VALUES (10, '田丽', NULL, 1, NULL, NULL, NULL, NULL, 0.00800, '2024-03-29 18:24:39', '2024-03-29 18:24:39');
INSERT INTO `inv_park_enterprise_distributor` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`,
                                               `account_bank`, `account_no`, `fee_rate`, `create_time`, `update_time`)
VALUES (11, '北京阳光领域', NULL, 1, NULL, NULL, NULL, NULL, 0.01000, '2024-03-29 18:56:18', '2024-03-29 18:56:18');
INSERT INTO `inv_park_enterprise_distributor` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`,
                                               `account_bank`, `account_no`, `fee_rate`, `create_time`, `update_time`)
VALUES (20, '北京测试渠道', NULL, 1, '北京测试渠道', '知春路', '招商', '45454545454', 0.01000, '2024-04-07 18:40:05',
        '2024-04-07 18:40:05');
INSERT INTO `inv_park_enterprise_distributor` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`,
                                               `account_bank`, `account_no`, `fee_rate`, `create_time`, `update_time`)
VALUES (21, '魏来', NULL, 1, NULL, NULL, NULL, NULL, 0.03200, '2024-04-08 15:56:56', '2024-04-08 15:56:56');
INSERT INTO `inv_park_enterprise_distributor` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`,
                                               `account_bank`, `account_no`, `fee_rate`, `create_time`, `update_time`)
VALUES (22, '渠道A', '渠道A', 1, '渠道A', '渠道A', '渠道A', '23232323233', 0.02000, '2024-05-29 15:28:24',
        '2024-05-29 15:28:24');
INSERT INTO `inv_park_enterprise_distributor` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`,
                                               `account_bank`, `account_no`, `fee_rate`, `create_time`, `update_time`)
VALUES (23, '辅导费', NULL, 1, NULL, NULL, NULL, NULL, 0.01000, '2024-06-05 10:25:43', '2024-06-05 10:25:43');
INSERT INTO `inv_park_enterprise_distributor` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`,
                                               `account_bank`, `account_no`, `fee_rate`, `create_time`, `update_time`)
VALUES (24, '测试', '渠道', 2, '北海', '1424', '中国', '154', 0.10000, '2024-06-17 10:18:05', '2024-06-17 10:18:43');
COMMIT;

-- ----------------------------
-- Table structure for inv_park_enterprise_payer
-- ----------------------------
DROP TABLE IF EXISTS `inv_park_enterprise_payer`;
CREATE TABLE `inv_park_enterprise_payer`
(
    `id`   bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '客户名称',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

-- ----------------------------
-- Records of inv_park_enterprise_payer
-- ----------------------------
BEGIN;
INSERT INTO `inv_park_enterprise_payer` (`id`, `name`)
VALUES (1, '法人');
INSERT INTO `inv_park_enterprise_payer` (`id`, `name`)
VALUES (2, '石药集团-个体户');
COMMIT;

-- ----------------------------
-- Table structure for inv_park_provider
-- ----------------------------
DROP TABLE IF EXISTS `inv_park_provider`;
CREATE TABLE `inv_park_provider`
(
    `id`                             bigint                                                       NOT NULL AUTO_INCREMENT,
    `name`                           varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '服务商名称',
    `remark`                         text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '园区服务商描述',
    `status`                         int                                                                   DEFAULT NULL COMMENT '渠道商状态 1-启用 2-停用',
    `account_name`                   varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '收款公司',
    `account_open_bank`              varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '开户银行',
    `account_bank`                   varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '收款银行',
    `account_no`                     varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '收款银行账号',
    `service_fee_rate`               decimal(10, 5)                                               NOT NULL COMMENT '服务费费率',
    `additional_tax_rate`            decimal(10, 5)                                                        DEFAULT NULL COMMENT '个体工商户附加税税率',
    `water_tax_rate`                 decimal(10, 5)                                                        DEFAULT NULL COMMENT '个体工商户水利基金税率',
    `stamp_tax_rate`                 decimal(10, 5)                                                        DEFAULT NULL COMMENT '个体工商户印花税税率',
    `income_tax_rate`                decimal(10, 5)                                                        DEFAULT NULL COMMENT '个体工商户个人所得税税率',
    `income_tax_type`                int                                                                   DEFAULT NULL COMMENT '个人所得税计算方式  1-附征率 2-应税所得，累计减半',
    `registration_fee`               decimal(18, 2)                                                        DEFAULT NULL COMMENT '应收工商注册费',
    `park_provider_registration_fee` decimal(18, 2)                                                        DEFAULT NULL COMMENT '应付园区服务商注册费',
    `is_mini_app_show`               varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci           DEFAULT '0' COMMENT '移动端是否可见',
    `create_time`                    datetime                                                     NOT NULL COMMENT '创建时间',
    `update_time`                    datetime                                                     NOT NULL COMMENT '更新时间',
    `value_added_tax_type`           int                                                                   DEFAULT '1' COMMENT '增值税类型： 1、30万阈值； 2、每张票都缴纳',
    `value_added_tax_formula_id`     int                                                                   DEFAULT NULL COMMENT '增值税计算公式',
    `additional_tax_formula_id`      int                                                                   DEFAULT NULL COMMENT '附加税计算公式',
    `water_tax_formula_id`           int                                                                   DEFAULT NULL COMMENT '水利基金计算公式',
    `stamp_tax_formula_id`           int                                                                   DEFAULT NULL COMMENT '印花税计算公式',
    `income_tax_formula_id`          int                                                                   DEFAULT NULL COMMENT '个人所得税计算公式',
    `value_added_tax_rate`           decimal(10, 5)                                                        DEFAULT NULL COMMENT '个体工商户增值税税率',
    `is_include_tax`                 varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '0' COMMENT '是否包税 ',
    `include_tax_rate`               decimal(10, 5)                                                        DEFAULT NULL COMMENT '包税税率',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 46
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='园区服务商';

-- ----------------------------
-- Records of inv_park_provider
-- ----------------------------
BEGIN;
INSERT INTO `inv_park_provider` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`, `account_bank`,
                                 `account_no`, `service_fee_rate`, `additional_tax_rate`, `water_tax_rate`,
                                 `stamp_tax_rate`, `income_tax_rate`, `income_tax_type`, `registration_fee`,
                                 `park_provider_registration_fee`, `is_mini_app_show`, `create_time`, `update_time`,
                                 `value_added_tax_type`, `value_added_tax_formula_id`, `additional_tax_formula_id`,
                                 `water_tax_formula_id`, `stamp_tax_formula_id`, `income_tax_formula_id`,
                                 `value_added_tax_rate`, `is_include_tax`, `include_tax_rate`)
VALUES (2, '河南安阳石药', NULL, 1, '安阳汇朋企业管理服务有限责任公司', NULL, NULL, NULL, 0.00400, 0.06000, 0.00000,
        0.00000, 0.00350, NULL, NULL, NULL, '0', '2024-03-07 11:50:01', '2024-05-27 10:24:46', 2, 1, 3, 5, 6, 7,
        0.00000, '0', 0.00000);
INSERT INTO `inv_park_provider` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`, `account_bank`,
                                 `account_no`, `service_fee_rate`, `additional_tax_rate`, `water_tax_rate`,
                                 `stamp_tax_rate`, `income_tax_rate`, `income_tax_type`, `registration_fee`,
                                 `park_provider_registration_fee`, `is_mini_app_show`, `create_time`, `update_time`,
                                 `value_added_tax_type`, `value_added_tax_formula_id`, `additional_tax_formula_id`,
                                 `water_tax_formula_id`, `stamp_tax_formula_id`, `income_tax_formula_id`,
                                 `value_added_tax_rate`, `is_include_tax`, `include_tax_rate`)
VALUES (3, '河南安阳', '', 1, '安阳汇朋企业管理服务有限责任公司', NULL, NULL, NULL, 0.00200, 0.06000, 0.00000, 0.00000,
        0.00350, NULL, NULL, NULL, '0', '2024-03-07 11:55:03', '2024-05-27 10:23:44', 2, 1, 3, 5, 6, 7, 0.00000, '0',
        0.00000);
INSERT INTO `inv_park_provider` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`, `account_bank`,
                                 `account_no`, `service_fee_rate`, `additional_tax_rate`, `water_tax_rate`,
                                 `stamp_tax_rate`, `income_tax_rate`, `income_tax_type`, `registration_fee`,
                                 `park_provider_registration_fee`, `is_mini_app_show`, `create_time`, `update_time`,
                                 `value_added_tax_type`, `value_added_tax_formula_id`, `additional_tax_formula_id`,
                                 `water_tax_formula_id`, `stamp_tax_formula_id`, `income_tax_formula_id`,
                                 `value_added_tax_rate`, `is_include_tax`, `include_tax_rate`)
VALUES (8, '湖南益阳', NULL, 1, '浏阳罗数云网络科技有限公司', NULL, NULL, NULL, 0.00000, 0.05000, 0.00060, 0.00000,
        0.00970, 1, NULL, NULL, '0', '2024-03-07 11:58:51', '2024-03-28 19:34:31', 1, 2, 4, 5, 6, 7, NULL, '0', NULL);
INSERT INTO `inv_park_provider` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`, `account_bank`,
                                 `account_no`, `service_fee_rate`, `additional_tax_rate`, `water_tax_rate`,
                                 `stamp_tax_rate`, `income_tax_rate`, `income_tax_type`, `registration_fee`,
                                 `park_provider_registration_fee`, `is_mini_app_show`, `create_time`, `update_time`,
                                 `value_added_tax_type`, `value_added_tax_formula_id`, `additional_tax_formula_id`,
                                 `water_tax_formula_id`, `stamp_tax_formula_id`, `income_tax_formula_id`,
                                 `value_added_tax_rate`, `is_include_tax`, `include_tax_rate`)
VALUES (12, '湖南长沙天心', NULL, 1, '浏阳罗数云网络科技有限公司', NULL, NULL, NULL, 0.00500, 0.06000, 0.00060, 0.00000,
        0.00500, 1, NULL, NULL, '0', '2024-03-07 12:01:01', '2024-03-28 19:35:22', 1, 2, 4, 5, 6, 7, NULL, '0', NULL);
INSERT INTO `inv_park_provider` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`, `account_bank`,
                                 `account_no`, `service_fee_rate`, `additional_tax_rate`, `water_tax_rate`,
                                 `stamp_tax_rate`, `income_tax_rate`, `income_tax_type`, `registration_fee`,
                                 `park_provider_registration_fee`, `is_mini_app_show`, `create_time`, `update_time`,
                                 `value_added_tax_type`, `value_added_tax_formula_id`, `additional_tax_formula_id`,
                                 `water_tax_formula_id`, `stamp_tax_formula_id`, `income_tax_formula_id`,
                                 `value_added_tax_rate`, `is_include_tax`, `include_tax_rate`)
VALUES (13, '湖南长沙雨花', NULL, 1, '浏阳罗数云网络科技有限公司', NULL, NULL, NULL, 0.00500, 0.06000, 0.00060, 0.00000,
        0.00500, 1, NULL, NULL, '0', '2024-03-07 12:01:23', '2024-03-28 19:35:29', 1, 2, 4, 5, 6, 7, NULL, '0', NULL);
INSERT INTO `inv_park_provider` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`, `account_bank`,
                                 `account_no`, `service_fee_rate`, `additional_tax_rate`, `water_tax_rate`,
                                 `stamp_tax_rate`, `income_tax_rate`, `income_tax_type`, `registration_fee`,
                                 `park_provider_registration_fee`, `is_mini_app_show`, `create_time`, `update_time`,
                                 `value_added_tax_type`, `value_added_tax_formula_id`, `additional_tax_formula_id`,
                                 `water_tax_formula_id`, `stamp_tax_formula_id`, `income_tax_formula_id`,
                                 `value_added_tax_rate`, `is_include_tax`, `include_tax_rate`)
VALUES (14, '山西吕梁离石', NULL, 1, '山西华兴信创数字科技有限公司', NULL, NULL, NULL, 0.00200, 0.06000, 0.00000,
        0.00015, 0.10000, 2, NULL, NULL, '0', '2024-03-07 12:02:04', '2024-04-10 21:04:35', 1, 2, 4, 5, 6, 9, NULL, '0',
        NULL);
INSERT INTO `inv_park_provider` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`, `account_bank`,
                                 `account_no`, `service_fee_rate`, `additional_tax_rate`, `water_tax_rate`,
                                 `stamp_tax_rate`, `income_tax_rate`, `income_tax_type`, `registration_fee`,
                                 `park_provider_registration_fee`, `is_mini_app_show`, `create_time`, `update_time`,
                                 `value_added_tax_type`, `value_added_tax_formula_id`, `additional_tax_formula_id`,
                                 `water_tax_formula_id`, `stamp_tax_formula_id`, `income_tax_formula_id`,
                                 `value_added_tax_rate`, `is_include_tax`, `include_tax_rate`)
VALUES (15, '山西吕梁方山', NULL, 1, '山西华兴信创数字科技有限公司', NULL, NULL, NULL, 0.00200, 0.06000, 0.00000,
        0.00015, 0.10000, 2, NULL, NULL, '0', '2024-03-07 12:02:30', '2024-04-10 21:04:26', 1, 2, 4, 5, 6, 9, NULL, '0',
        NULL);
INSERT INTO `inv_park_provider` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`, `account_bank`,
                                 `account_no`, `service_fee_rate`, `additional_tax_rate`, `water_tax_rate`,
                                 `stamp_tax_rate`, `income_tax_rate`, `income_tax_type`, `registration_fee`,
                                 `park_provider_registration_fee`, `is_mini_app_show`, `create_time`, `update_time`,
                                 `value_added_tax_type`, `value_added_tax_formula_id`, `additional_tax_formula_id`,
                                 `water_tax_formula_id`, `stamp_tax_formula_id`, `income_tax_formula_id`,
                                 `value_added_tax_rate`, `is_include_tax`, `include_tax_rate`)
VALUES (16, '山西大同灵丘', NULL, 1, '山西华兴信创数字科技有限公司', NULL, NULL, NULL, 0.00200, 0.06000, 0.00000,
        0.00015, 0.10000, 2, NULL, NULL, '0', '2024-03-07 12:03:14', '2024-04-10 21:04:17', 1, 2, 4, 5, 6, 9, NULL, '0',
        NULL);
INSERT INTO `inv_park_provider` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`, `account_bank`,
                                 `account_no`, `service_fee_rate`, `additional_tax_rate`, `water_tax_rate`,
                                 `stamp_tax_rate`, `income_tax_rate`, `income_tax_type`, `registration_fee`,
                                 `park_provider_registration_fee`, `is_mini_app_show`, `create_time`, `update_time`,
                                 `value_added_tax_type`, `value_added_tax_formula_id`, `additional_tax_formula_id`,
                                 `water_tax_formula_id`, `stamp_tax_formula_id`, `income_tax_formula_id`,
                                 `value_added_tax_rate`, `is_include_tax`, `include_tax_rate`)
VALUES (17, '山东德州', NULL, 1, '青岛鹏泽松企业服务有限公司', NULL, NULL, NULL, 0.00000, 0.05000, 0.00000, 0.00000,
        0.01100, 1, NULL, NULL, '0', '2024-03-07 12:07:03', '2024-03-28 19:37:28', 1, 2, 4, 5, 6, 7, NULL, '0', NULL);
INSERT INTO `inv_park_provider` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`, `account_bank`,
                                 `account_no`, `service_fee_rate`, `additional_tax_rate`, `water_tax_rate`,
                                 `stamp_tax_rate`, `income_tax_rate`, `income_tax_type`, `registration_fee`,
                                 `park_provider_registration_fee`, `is_mini_app_show`, `create_time`, `update_time`,
                                 `value_added_tax_type`, `value_added_tax_formula_id`, `additional_tax_formula_id`,
                                 `water_tax_formula_id`, `stamp_tax_formula_id`, `income_tax_formula_id`,
                                 `value_added_tax_rate`, `is_include_tax`, `include_tax_rate`)
VALUES (18, '山东青岛', NULL, 1, '青岛鹏泽松企业服务有限公司', NULL, NULL, NULL, 0.00000, 0.06000, 0.00000, 0.00000,
        0.01120, 1, NULL, NULL, '0', '2024-03-07 12:07:32', '2024-03-28 19:37:16', 1, 2, 4, 5, 6, 7, NULL, '0', NULL);
INSERT INTO `inv_park_provider` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`, `account_bank`,
                                 `account_no`, `service_fee_rate`, `additional_tax_rate`, `water_tax_rate`,
                                 `stamp_tax_rate`, `income_tax_rate`, `income_tax_type`, `registration_fee`,
                                 `park_provider_registration_fee`, `is_mini_app_show`, `create_time`, `update_time`,
                                 `value_added_tax_type`, `value_added_tax_formula_id`, `additional_tax_formula_id`,
                                 `water_tax_formula_id`, `stamp_tax_formula_id`, `income_tax_formula_id`,
                                 `value_added_tax_rate`, `is_include_tax`, `include_tax_rate`)
VALUES (19, '贵州贵阳', NULL, 1, '湖南智启云链科技有限公司', NULL, NULL, NULL, 0.00000, 0.03000, 0.00000, 0.00015,
        0.01000, 1, NULL, NULL, '0', '2024-03-07 12:08:09', '2024-04-18 11:58:01', 1, 2, 4, 5, 6, 7, NULL, '0', NULL);
INSERT INTO `inv_park_provider` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`, `account_bank`,
                                 `account_no`, `service_fee_rate`, `additional_tax_rate`, `water_tax_rate`,
                                 `stamp_tax_rate`, `income_tax_rate`, `income_tax_type`, `registration_fee`,
                                 `park_provider_registration_fee`, `is_mini_app_show`, `create_time`, `update_time`,
                                 `value_added_tax_type`, `value_added_tax_formula_id`, `additional_tax_formula_id`,
                                 `water_tax_formula_id`, `stamp_tax_formula_id`, `income_tax_formula_id`,
                                 `value_added_tax_rate`, `is_include_tax`, `include_tax_rate`)
VALUES (20, '河南林州', NULL, 1, '安阳红树林产业园管理有限公司', NULL, NULL, NULL, 0.00000, 0.05000, 0.00000, 0.00000,
        0.01150, 1, NULL, NULL, '0', '2024-03-07 12:08:47', '2024-03-28 19:38:08', 1, 2, 4, 5, 6, 7, NULL, '0', NULL);
INSERT INTO `inv_park_provider` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`, `account_bank`,
                                 `account_no`, `service_fee_rate`, `additional_tax_rate`, `water_tax_rate`,
                                 `stamp_tax_rate`, `income_tax_rate`, `income_tax_type`, `registration_fee`,
                                 `park_provider_registration_fee`, `is_mini_app_show`, `create_time`, `update_time`,
                                 `value_added_tax_type`, `value_added_tax_formula_id`, `additional_tax_formula_id`,
                                 `water_tax_formula_id`, `stamp_tax_formula_id`, `income_tax_formula_id`,
                                 `value_added_tax_rate`, `is_include_tax`, `include_tax_rate`)
VALUES (21, '天津红桥', NULL, 1, '天津兴融达科技有限公司', NULL, NULL, NULL, 0.00000, 0.06000, 0.00000, 0.00000,
        0.10000, 2, NULL, NULL, '0', '2024-03-07 12:09:17', '2024-04-10 12:26:57', 1, 2, 4, 5, 6, 9, NULL, '0', NULL);
INSERT INTO `inv_park_provider` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`, `account_bank`,
                                 `account_no`, `service_fee_rate`, `additional_tax_rate`, `water_tax_rate`,
                                 `stamp_tax_rate`, `income_tax_rate`, `income_tax_type`, `registration_fee`,
                                 `park_provider_registration_fee`, `is_mini_app_show`, `create_time`, `update_time`,
                                 `value_added_tax_type`, `value_added_tax_formula_id`, `additional_tax_formula_id`,
                                 `water_tax_formula_id`, `stamp_tax_formula_id`, `income_tax_formula_id`,
                                 `value_added_tax_rate`, `is_include_tax`, `include_tax_rate`)
VALUES (22, '天津河东', NULL, 1, '北科极限（天津）科技信息咨询有限公司', NULL, NULL, NULL, 0.00200, 0.06000, 0.00000,
        0.00000, 0.10000, 2, NULL, NULL, '0', '2024-03-07 12:10:05', '2024-03-28 19:38:23', 1, 2, 4, 5, 6, 9, NULL, '0',
        NULL);
INSERT INTO `inv_park_provider` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`, `account_bank`,
                                 `account_no`, `service_fee_rate`, `additional_tax_rate`, `water_tax_rate`,
                                 `stamp_tax_rate`, `income_tax_rate`, `income_tax_type`, `registration_fee`,
                                 `park_provider_registration_fee`, `is_mini_app_show`, `create_time`, `update_time`,
                                 `value_added_tax_type`, `value_added_tax_formula_id`, `additional_tax_formula_id`,
                                 `water_tax_formula_id`, `stamp_tax_formula_id`, `income_tax_formula_id`,
                                 `value_added_tax_rate`, `is_include_tax`, `include_tax_rate`)
VALUES (23, '天津滨海', NULL, 1, '云尚共享经济信息咨询 (天津) 有限公司', NULL, NULL, NULL, 0.00700, 0.06000, 0.00000,
        0.00000, 0.12000, 2, NULL, NULL, '0', '2024-03-07 12:10:32', '2024-03-28 19:38:29', 1, 2, 4, 5, 6, 9, NULL, '0',
        NULL);
INSERT INTO `inv_park_provider` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`, `account_bank`,
                                 `account_no`, `service_fee_rate`, `additional_tax_rate`, `water_tax_rate`,
                                 `stamp_tax_rate`, `income_tax_rate`, `income_tax_type`, `registration_fee`,
                                 `park_provider_registration_fee`, `is_mini_app_show`, `create_time`, `update_time`,
                                 `value_added_tax_type`, `value_added_tax_formula_id`, `additional_tax_formula_id`,
                                 `water_tax_formula_id`, `stamp_tax_formula_id`, `income_tax_formula_id`,
                                 `value_added_tax_rate`, `is_include_tax`, `include_tax_rate`)
VALUES (24, '湖南娄底涟源', NULL, 1, '湖南一起进步企业服务合伙企业（有限合伙）', NULL, NULL, NULL, 0.00600, 0.05000,
        0.00060, 0.00015, 0.00500, 1, NULL, NULL, '0', '2024-03-07 12:11:05', '2024-03-28 19:38:58', 1, 2, 4, 5, 6, 7,
        NULL, '0', NULL);
INSERT INTO `inv_park_provider` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`, `account_bank`,
                                 `account_no`, `service_fee_rate`, `additional_tax_rate`, `water_tax_rate`,
                                 `stamp_tax_rate`, `income_tax_rate`, `income_tax_type`, `registration_fee`,
                                 `park_provider_registration_fee`, `is_mini_app_show`, `create_time`, `update_time`,
                                 `value_added_tax_type`, `value_added_tax_formula_id`, `additional_tax_formula_id`,
                                 `water_tax_formula_id`, `stamp_tax_formula_id`, `income_tax_formula_id`,
                                 `value_added_tax_rate`, `is_include_tax`, `include_tax_rate`)
VALUES (25, '湖南娄底高新', NULL, 1, '湖南一起进步企业服务合伙企业（有限合伙）', NULL, NULL, NULL, 0.00600, 0.05000,
        0.00060, 0.00015, 0.00600, 1, NULL, NULL, '0', '2024-03-07 12:11:30', '2024-03-28 19:38:49', 1, 2, 4, 5, 6, 7,
        NULL, '0', NULL);
INSERT INTO `inv_park_provider` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`, `account_bank`,
                                 `account_no`, `service_fee_rate`, `additional_tax_rate`, `water_tax_rate`,
                                 `stamp_tax_rate`, `income_tax_rate`, `income_tax_type`, `registration_fee`,
                                 `park_provider_registration_fee`, `is_mini_app_show`, `create_time`, `update_time`,
                                 `value_added_tax_type`, `value_added_tax_formula_id`, `additional_tax_formula_id`,
                                 `water_tax_formula_id`, `stamp_tax_formula_id`, `income_tax_formula_id`,
                                 `value_added_tax_rate`, `is_include_tax`, `include_tax_rate`)
VALUES (26, '湖南邵阳邵东', NULL, 1, '湖南一起进步企业服务合伙企业（有限合伙）', NULL, NULL, NULL, 0.00600, 0.05000,
        0.00060, 0.00015, 0.00600, 1, NULL, NULL, '0', '2024-03-07 12:11:49', '2024-03-28 19:39:07', 1, 2, 4, 5, 6, 7,
        NULL, '0', NULL);
INSERT INTO `inv_park_provider` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`, `account_bank`,
                                 `account_no`, `service_fee_rate`, `additional_tax_rate`, `water_tax_rate`,
                                 `stamp_tax_rate`, `income_tax_rate`, `income_tax_type`, `registration_fee`,
                                 `park_provider_registration_fee`, `is_mini_app_show`, `create_time`, `update_time`,
                                 `value_added_tax_type`, `value_added_tax_formula_id`, `additional_tax_formula_id`,
                                 `water_tax_formula_id`, `stamp_tax_formula_id`, `income_tax_formula_id`,
                                 `value_added_tax_rate`, `is_include_tax`, `include_tax_rate`)
VALUES (27, '广东中山', NULL, 1, '中山顺利办东润会计有限公司', NULL, NULL, NULL, 0.00000, 0.06000, 0.00000, 0.00000,
        0.01051, 1, NULL, NULL, '0', '2024-03-07 12:12:16', '2024-04-10 12:28:10', 1, 2, 4, 5, 6, 7, NULL, '0', NULL);
INSERT INTO `inv_park_provider` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`, `account_bank`,
                                 `account_no`, `service_fee_rate`, `additional_tax_rate`, `water_tax_rate`,
                                 `stamp_tax_rate`, `income_tax_rate`, `income_tax_type`, `registration_fee`,
                                 `park_provider_registration_fee`, `is_mini_app_show`, `create_time`, `update_time`,
                                 `value_added_tax_type`, `value_added_tax_formula_id`, `additional_tax_formula_id`,
                                 `water_tax_formula_id`, `stamp_tax_formula_id`, `income_tax_formula_id`,
                                 `value_added_tax_rate`, `is_include_tax`, `include_tax_rate`)
VALUES (28, '辽宁抚顺', NULL, 1, '抚顺市鑫欣向荣企业信息咨询有限公司', NULL, NULL, NULL, 0.00200, 0.05000, 0.00000,
        0.00000, 0.10000, 2, NULL, NULL, '0', '2024-03-07 12:12:50', '2024-04-08 21:24:07', 1, 2, 4, 5, 6, 9, NULL, '0',
        NULL);
INSERT INTO `inv_park_provider` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`, `account_bank`,
                                 `account_no`, `service_fee_rate`, `additional_tax_rate`, `water_tax_rate`,
                                 `stamp_tax_rate`, `income_tax_rate`, `income_tax_type`, `registration_fee`,
                                 `park_provider_registration_fee`, `is_mini_app_show`, `create_time`, `update_time`,
                                 `value_added_tax_type`, `value_added_tax_formula_id`, `additional_tax_formula_id`,
                                 `water_tax_formula_id`, `stamp_tax_formula_id`, `income_tax_formula_id`,
                                 `value_added_tax_rate`, `is_include_tax`, `include_tax_rate`)
VALUES (29, '安徽蚌埠固镇', NULL, 1, '安徽蓝创数字产业园管理有限公司', NULL, NULL, NULL, 0.00200, 0.06000, 0.00000,
        0.00000, 0.00500, 1, NULL, NULL, '0', '2024-03-07 12:13:25', '2024-03-28 19:39:46', 1, 2, 4, 5, 6, 7, NULL, '0',
        NULL);
INSERT INTO `inv_park_provider` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`, `account_bank`,
                                 `account_no`, `service_fee_rate`, `additional_tax_rate`, `water_tax_rate`,
                                 `stamp_tax_rate`, `income_tax_rate`, `income_tax_type`, `registration_fee`,
                                 `park_provider_registration_fee`, `is_mini_app_show`, `create_time`, `update_time`,
                                 `value_added_tax_type`, `value_added_tax_formula_id`, `additional_tax_formula_id`,
                                 `water_tax_formula_id`, `stamp_tax_formula_id`, `income_tax_formula_id`,
                                 `value_added_tax_rate`, `is_include_tax`, `include_tax_rate`)
VALUES (30, '江苏宿迁泗洪', NULL, 1, '江西企服加科技有限公司', NULL, NULL, NULL, 0.00000, 0.06000, 0.00000, 0.00000,
        0.01240, 1, NULL, NULL, '0', '2024-03-07 12:17:27', '2024-03-28 19:39:52', 1, 2, 4, 5, 6, 7, NULL, '0', NULL);
INSERT INTO `inv_park_provider` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`, `account_bank`,
                                 `account_no`, `service_fee_rate`, `additional_tax_rate`, `water_tax_rate`,
                                 `stamp_tax_rate`, `income_tax_rate`, `income_tax_type`, `registration_fee`,
                                 `park_provider_registration_fee`, `is_mini_app_show`, `create_time`, `update_time`,
                                 `value_added_tax_type`, `value_added_tax_formula_id`, `additional_tax_formula_id`,
                                 `water_tax_formula_id`, `stamp_tax_formula_id`, `income_tax_formula_id`,
                                 `value_added_tax_rate`, `is_include_tax`, `include_tax_rate`)
VALUES (31, '江西南昌', NULL, 1, '南昌市金达云企业服务有限公司', NULL, NULL, NULL, 0.00300, 0.06000, 0.00000, 0.00000,
        0.10000, 2, NULL, NULL, '0', '2024-03-07 12:18:02', '2024-03-28 19:39:58', 1, 2, 4, 5, 6, 9, NULL, '0', NULL);
INSERT INTO `inv_park_provider` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`, `account_bank`,
                                 `account_no`, `service_fee_rate`, `additional_tax_rate`, `water_tax_rate`,
                                 `stamp_tax_rate`, `income_tax_rate`, `income_tax_type`, `registration_fee`,
                                 `park_provider_registration_fee`, `is_mini_app_show`, `create_time`, `update_time`,
                                 `value_added_tax_type`, `value_added_tax_formula_id`, `additional_tax_formula_id`,
                                 `water_tax_formula_id`, `stamp_tax_formula_id`, `income_tax_formula_id`,
                                 `value_added_tax_rate`, `is_include_tax`, `include_tax_rate`)
VALUES (40, '北京测试园区', NULL, 1, '北京测试园区', '招商', '招商', '56789444444333', 0.01000, 0.01000, 0.01000,
        0.01000, 0.01000, 1, 1000.00, 100.00, '1', '2024-04-07 18:39:29', '2024-04-07 18:39:29', 1, 2, 4, 5, 6, 7, NULL,
        '0', NULL);
INSERT INTO `inv_park_provider` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`, `account_bank`,
                                 `account_no`, `service_fee_rate`, `additional_tax_rate`, `water_tax_rate`,
                                 `stamp_tax_rate`, `income_tax_rate`, `income_tax_type`, `registration_fee`,
                                 `park_provider_registration_fee`, `is_mini_app_show`, `create_time`, `update_time`,
                                 `value_added_tax_type`, `value_added_tax_formula_id`, `additional_tax_formula_id`,
                                 `water_tax_formula_id`, `stamp_tax_formula_id`, `income_tax_formula_id`,
                                 `value_added_tax_rate`, `is_include_tax`, `include_tax_rate`)
VALUES (41, '新天津', NULL, 1, NULL, NULL, NULL, NULL, 0.00500, 0.06000, 0.00000, 0.00000, 0.10000, 2, NULL, NULL, '0',
        '2024-04-17 11:59:23', '2024-04-17 12:00:24', 1, 2, 4, 5, 6, 9, NULL, '0', NULL);
INSERT INTO `inv_park_provider` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`, `account_bank`,
                                 `account_no`, `service_fee_rate`, `additional_tax_rate`, `water_tax_rate`,
                                 `stamp_tax_rate`, `income_tax_rate`, `income_tax_type`, `registration_fee`,
                                 `park_provider_registration_fee`, `is_mini_app_show`, `create_time`, `update_time`,
                                 `value_added_tax_type`, `value_added_tax_formula_id`, `additional_tax_formula_id`,
                                 `water_tax_formula_id`, `stamp_tax_formula_id`, `income_tax_formula_id`,
                                 `value_added_tax_rate`, `is_include_tax`, `include_tax_rate`)
VALUES (42, '重庆开州', NULL, 1, NULL, NULL, NULL, NULL, 0.00300, 0.06000, 0.00000, 0.00000, 0.00600, NULL, NULL,
        3100.00, '0', '2024-05-10 10:29:39', '2024-05-23 09:58:23', 1, 2, 4, 5, 6, 7, 0.00000, '0', 0.00000);
INSERT INTO `inv_park_provider` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`, `account_bank`,
                                 `account_no`, `service_fee_rate`, `additional_tax_rate`, `water_tax_rate`,
                                 `stamp_tax_rate`, `income_tax_rate`, `income_tax_type`, `registration_fee`,
                                 `park_provider_registration_fee`, `is_mini_app_show`, `create_time`, `update_time`,
                                 `value_added_tax_type`, `value_added_tax_formula_id`, `additional_tax_formula_id`,
                                 `water_tax_formula_id`, `stamp_tax_formula_id`, `income_tax_formula_id`,
                                 `value_added_tax_rate`, `is_include_tax`, `include_tax_rate`)
VALUES (43, 'PLAN A园区', NULL, 1, 'PLAN A园区', '五一大道', '招商', '123456789012345677896855', 0.10000, 0.02000,
        0.02000, 0.02000, 0.02000, NULL, 2000.00, 1000.00, '1', '2024-05-29 15:27:59', '2024-05-31 09:35:31', 1, 2, 4,
        5, 6, 7, 0.00000, '0', 0.00000);
INSERT INTO `inv_park_provider` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`, `account_bank`,
                                 `account_no`, `service_fee_rate`, `additional_tax_rate`, `water_tax_rate`,
                                 `stamp_tax_rate`, `income_tax_rate`, `income_tax_type`, `registration_fee`,
                                 `park_provider_registration_fee`, `is_mini_app_show`, `create_time`, `update_time`,
                                 `value_added_tax_type`, `value_added_tax_formula_id`, `additional_tax_formula_id`,
                                 `water_tax_formula_id`, `stamp_tax_formula_id`, `income_tax_formula_id`,
                                 `value_added_tax_rate`, `is_include_tax`, `include_tax_rate`)
VALUES (44, '辅导费', NULL, 1, NULL, NULL, NULL, NULL, 0.02000, 0.00000, 0.00000, 0.00000, 0.00000, NULL, NULL, NULL,
        '0', '2024-06-05 10:25:22', '2024-06-05 10:25:22', NULL, NULL, NULL, NULL, NULL, NULL, 0.00000, '1', 0.01000);
INSERT INTO `inv_park_provider` (`id`, `name`, `remark`, `status`, `account_name`, `account_open_bank`, `account_bank`,
                                 `account_no`, `service_fee_rate`, `additional_tax_rate`, `water_tax_rate`,
                                 `stamp_tax_rate`, `income_tax_rate`, `income_tax_type`, `registration_fee`,
                                 `park_provider_registration_fee`, `is_mini_app_show`, `create_time`, `update_time`,
                                 `value_added_tax_type`, `value_added_tax_formula_id`, `additional_tax_formula_id`,
                                 `water_tax_formula_id`, `stamp_tax_formula_id`, `income_tax_formula_id`,
                                 `value_added_tax_rate`, `is_include_tax`, `include_tax_rate`)
VALUES (45, '测试', NULL, 1, NULL, NULL, NULL, NULL, 0.12000, 0.00000, 0.00000, 0.00000, 0.00000, NULL, 1000.00, 110.00,
        '1', '2024-06-17 10:17:26', '2024-06-17 10:17:44', NULL, NULL, NULL, NULL, NULL, NULL, 0.00000, '1', 0.10000);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
