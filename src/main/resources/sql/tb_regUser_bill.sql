-- 记录开户的单据信息
CREATE TABLE `tb_regUser_bill` (
  `id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT '主键 自增',
  `billNo` VARCHAR (32) NULL COMMENT '单据的单号',
  `ipsBillNo` VARCHAR(32) NULL COMMENT '存管订单号',
  `userId` BIGINT (20) NULL COMMENT '用户Id',
  `ipsDoTime` VARCHAR(32) DEFAULT  NULL COMMENT  '存管操作时间',
  `ipsAcctNo` VARCHAR(32) DEFAULT  NULL COMMENT  '存管的账户号',
  `status` TINYINT DEFAULT 0 COMMENT  '单据的状态，失败或者成功',
  `createTime` BIGINT (20) NULL COMMENT '创建时间',
  `updateTime` BIGINT (20) NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COLLATE = utf8_general_ci COMMENT = '用户开户的单据信息';