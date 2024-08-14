use bos_op;

DROP TABLE IF EXISTS bos_op.inv_report_month_distributor;
DROP TABLE IF EXISTS bos_op.inv_report_month_park_enterprise;
DROP TABLE IF EXISTS bos_op.inv_report_month_park_provider;


use bos_uc;
DROP TABLE IF EXISTS bos_uc.iam_audit_log;

use ns_uc;
DROP TABLE IF EXISTS ns_uc.iam_api_key;
DROP TABLE IF EXISTS ns_uc.iam_audit_log;
DROP TABLE IF EXISTS ns_uc.iam_email_template;


delete
from iam_menu
where id in (32, 33,34,97);