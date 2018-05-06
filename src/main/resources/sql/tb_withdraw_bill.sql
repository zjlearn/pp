-- 充值单据
CREATE TABLE `tb_withdraw_bill` (
  `id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT '主键 自增',
  `billNo` VARCHAR (32) NULL COMMENT '单据的单号',
  `ipsBillNo` VARCHAR (32) NULL COMMENT '存管订单号',
  `userId` BIGINT (20) NULL COMMENT '用户Id',
  `amount` DECIMAL (15,2) NULL COMMENT '充值金额',
  `ipsTrdAmt` DECIMAL (15,2) NULL COMMENT '实际到账金额',
  `merFee` DECIMAL (15,2) DEFAULT  0 COMMENT  '充值的手续费',
  `ipsFee` DECIMAL (15,2) DEFAULT  0 COMMENT  '支付通道手续费',
  `ipsDoTime` VARCHAR(32) DEFAULT  NULL COMMENT  '存管操作时间',
  `status` TINYINT DEFAULT 0 COMMENT  '单据的状态',
  `createTime` BIGINT (20) NULL COMMENT '创建时间',
  `updateTime` BIGINT (20) NULL COMMENT '更新时间',
   PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COLLATE = utf8_general_ci COMMENT = '充值单据';