-- 充值单据
CREATE TABLE `tb_deposit_bill` (
  `id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT '主键 自增',
  `billNo` VARCHAR (32) NULL COMMENT '单据的单号',
  `ipsBillNo` VARCHAR(32) NULL COMMENT '存管订单号',
  `userId` BIGINT (20) NULL COMMENT '用户Id',
  `depositType` TINYINT COMMENT '充值类型，1：普通充值， 2，个人充值',
  `channelType` TINYINT COMMENT '充值渠道 1：个人网银， 2： 企业网银',
  `bankCode` VARCHAR(32) NULL COMMENT  '充值银行的编号',
  `bankName` VARCHAR(32) NULL COMMENT  '充值银行的名称',
  `amount` DECIMAL (15,2) NULL COMMENT '充值金额',
  `ipsTrdAmt` DECIMAL (15,2) NULL COMMENT  '实际充值到账的金额',
  `ipsFee` DECIMAL(15,2) DEFAULT  0 COMMENT  '支付通道的手续费',
  `merFee` DECIMAL (15,2) DEFAULT  0 COMMENT  '提现的平台手续费',
  `ipsDoTime` VARCHAR(32) DEFAULT  NULL COMMENT  '存管操作时间',
  `status` TINYINT DEFAULT 0 COMMENT  '单据的状态',
  `createTime` BIGINT (20) NULL COMMENT '创建时间',
  `updateTime` BIGINT (20) NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COLLATE = utf8_general_ci COMMENT = '充值';