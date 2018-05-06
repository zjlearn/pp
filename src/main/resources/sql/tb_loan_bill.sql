-- 借款单据的真实信息
CREATE TABLE `tb_loan_bill` (
  `id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT '主键 自增',
  `userId` BIGINT (20) NULL COMMENT '用户Id',
  `userName` VARCHAR (32) NULL COMMENT '用户姓名',
  `mobile` VARCHAR (32) NULL COMMENT '电话号码',
  `projectId` BIGINT (20) NULL COMMENT '关联的项目ID',
  `loanAmount` DECIMAL (15,2) NULL COMMENT '借款金额',
  `expectRate` DECIMAL (15,2) NULL COMMENT '年华利率',
  `loanType` TINYINT NULL COMMENT  '借款类型',
  `duration` INT(11) DEFAULT  0 COMMENT  '借款周期',
  `asssetId` BIGINT DEFAULT NULL COMMENT  '资产ID',
  `district` VARCHAR(32) DEFAULT NULL COMMENT  '借款区域',
  `status` TINYINT DEFAULT 0 COMMENT '状态',
  `loanRemark` VARCHAR(32) DEFAULT NULL COMMENT '借款说明',
  `statusRemark` VARCHAR(32) DEFAULT NULL COMMENT '状态说明',
  `createTime` BIGINT (20) NULL COMMENT '创建时间',

  PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COLLATE = utf8_general_ci COMMENT = '借款的单据信息';