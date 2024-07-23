-- bos 相关用户
CREATE USER 'op_user'@'%' IDENTIFIED BY 'op_user';
GRANT ALL PRIVILEGES ON bos_op.* TO 'op_user'@'%';
GRANT ALL PRIVILEGES ON bos_uc.* TO 'op_user'@'%';

-- 发票用户
CREATE USER 'invoice_user'@'%' IDENTIFIED BY 'invoice_user';
-- 授予新用户对数据库 a 中所有表的读写权限
GRANT ALL PRIVILEGES ON ns_invoice.* TO 'invoice_user'@'%';


-- uc用户
CREATE USER 'uc_user'@'%' IDENTIFIED BY 'uc_user';
-- 授予新用户对数据库 a 中所有表的读写权限
GRANT ALL PRIVILEGES ON ns_uc.* TO 'uc_user'@'%';

-- 刷新权限，使更改生效
FLUSH PRIVILEGES;