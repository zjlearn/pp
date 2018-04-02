-- 基本的开户信息单据
CREATE TABLE `tb_open_account_bill` (
  `id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT '主键 自增',
  `billNo` VARCHAR (32) NULL COMMENT '单据的单号',
  `userId` BIGINT (20) NULL COMMENT '用户Id',
  `status` TINYINT DEFAULT 0 COMMENT  '单据的状态',
  `createTime` BIGINT (20) NULL COMMENT '单据创建时间',
  PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COLLATE = utf8_general_ci COMMENT = '开户信息表';