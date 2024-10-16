CREATE TABLE `inv_industry` (
                                `id` bigint NOT NULL AUTO_INCREMENT,
                                `name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '行业名称',
    `example_enterprise` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '示例商户名称',
    `invoice_items` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '发票类目列表',
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='开票行业类型';

INSERT INTO `ns_invoice`.`inv_industry` (`id`, `name`, `example_enterprise`, `invoice_items`) VALUES (1, '建筑工程服务', '***建筑服务部', '建筑服务*安装服务,建筑服务*工程项目管理服务,建筑服务*工程服务,建筑服务*其他建筑服务,建筑服务*建筑工程服务,物流辅助服务*运输装卸服务,劳务*维修服务');
INSERT INTO `ns_invoice`.`inv_industry` (`id`, `name`, `example_enterprise`, `invoice_items`) VALUES (2, '商务中介服务', '***商务服务部', '其他咨询服务*商务信息咨询,其他咨询服务*信息咨询,其他咨询服务*市场调研服务,经纪代理服务*商务代理,现代服务*推广服务费,现代服务*营销策划服务,经纪代理服务*中介服务,会展服务*会议服务,会展服务*展览服务');
INSERT INTO `ns_invoice`.`inv_industry` (`id`, `name`, `example_enterprise`, `invoice_items`) VALUES (3, '营销推广', '***市场营销中心', '现代服务*营销策划,现代服务*市场推广,现代服务*策划服务,现代服务*推广服务费,现代服务*服务费');
INSERT INTO `ns_invoice`.`inv_industry` (`id`, `name`, `example_enterprise`, `invoice_items`) VALUES (4, '科技行业', '***软件开发服务部', '');
INSERT INTO `ns_invoice`.`inv_industry` (`id`, `name`, `example_enterprise`, `invoice_items`) VALUES (5, '咨询服务', '***咨询服务部', '企业管理服务*市场管理服务,其他咨询服务*企业管理咨询,现代服务*企业管理服务,现代服务*营销咨询服务,企业管理服务*其他企业管理服务,经纪代理服务*代理代办');
INSERT INTO `ns_invoice`.`inv_industry` (`id`, `name`, `example_enterprise`, `invoice_items`) VALUES (6, '设计服务', '***设计服务部', '设计服务*设计服务,设计服务*其他设计服务,设计服务*文印晒图服务,生活服务*摄影服务,设计服务*室内装修工程设计,会展服务*展览展示服务,设计服务*专业设计服务,设计服务*图文设计,设计服务*图文打印服务');
INSERT INTO `ns_invoice`.`inv_industry` (`id`, `name`, `example_enterprise`, `invoice_items`) VALUES (7, '文化传媒', '***文化传媒中心', '现代服务*演出服务,现代服务*文化服务,现代服务*策划创意服务,设计服务*专业设计服务,现代服务*策划服务费');
INSERT INTO `ns_invoice`.`inv_industry` (`id`, `name`, `example_enterprise`, `invoice_items`) VALUES (8, '文化服务业', '***文化艺术咨询服务部', '文化服务*文艺创作服务,现代服务*演出服务,现代服务*文化服务,现代服务*策划服务');
INSERT INTO `ns_invoice`.`inv_industry` (`id`, `name`, `example_enterprise`, `invoice_items`) VALUES (9, '零售业', '***百货经营部', '日杂用品*日用百货,纸制品*办公用品');
INSERT INTO `ns_invoice`.`inv_industry` (`id`, `name`, `example_enterprise`, `invoice_items`) VALUES (10, '保洁服务', '***家政服务部', '生活服务*家庭服务,生活服务*家政服务,生活服务*清洁服务');
INSERT INTO `ns_invoice`.`inv_industry` (`id`, `name`, `example_enterprise`, `invoice_items`) VALUES (11, '机械技术', '***机械技术咨询服务部', '其他咨询服务*机械设备技术咨询,研发和技术服务*机械设备技术服务,其他咨询服务*技术咨询,研发和技术服务*硬件开发服务,研发和技术服务*设备研发服务,设计服务*设计服务,设计服务*模具设计,设计服务*包装设计,研发和技术服务*技术开发,研发和技术服务*技术服务');
INSERT INTO `ns_invoice`.`inv_industry` (`id`, `name`, `example_enterprise`, `invoice_items`) VALUES (12, '设备租赁', '***仪器设备服务部', '劳务*仪器设备维修,劳务*设备维修,经营租赁*设备租赁');
INSERT INTO `ns_invoice`.`inv_industry` (`id`, `name`, `example_enterprise`, `invoice_items`) VALUES (13, '物流运输、仓储和邮政、快递业', '***运输服务部', '现代服务*物流信息服务,运输服务*普通货物运输,经纪代理服务*物流代理服务,物流辅助服务*装卸包装服务物流,物流辅助服务*装卸搬运服务');
INSERT INTO `ns_invoice`.`inv_industry` (`id`, `name`, `example_enterprise`, `invoice_items`) VALUES (14, '建筑安装', '***建材经营部', '建筑服务*安装服务,建筑服务*建筑材料销售');
INSERT INTO `ns_invoice`.`inv_industry` (`id`, `name`, `example_enterprise`, `invoice_items`) VALUES (15, '居民服务', '***水电安装服务部', '建筑服务*水电安装服务,建筑服务*安装服务,建筑服务*空调设备安装');
INSERT INTO `ns_invoice`.`inv_industry` (`id`, `name`, `example_enterprise`, `invoice_items`) VALUES (16, '居民服务、修理和其他服务业', '***居民服务部', '劳务*修理修配劳务');
INSERT INTO `ns_invoice`.`inv_industry` (`id`, `name`, `example_enterprise`, `invoice_items`) VALUES (17, '婚庆服务', '***摄影服务部', '生活服务*摄影服务,生活服务*婚庆服务,生活服务*礼仪服务');
INSERT INTO `ns_invoice`.`inv_industry` (`id`, `name`, `example_enterprise`, `invoice_items`) VALUES (18, '汽车维修', '***汽车配件经营部', '现代服务*汽车美容,现代服务*汽车保养,其他咨询服务*汽车信息咨询');