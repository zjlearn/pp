-- 基本的订单信息表
CREATE TABLE `tb_open_account_bill` (
  `id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT '主键 自增',
  `billCode` VARCHAR (32) NULL COMMENT '单据Code',
  `billName` VARCHAR (32) NULL COMMENT '单据名称',
  `amount` VARCHAR (32) NULL COMMENT '项目金额',
  `status` TINYINT DEFAULT 0 COMMENT  '项目状态',
  `createTime` BIGINT (20) NULL COMMENT '配置创建时间',
  `updateTime` TIMESTAMP NULL COMMENT '配置的更新时间',
  `deleteTime` BIGINT (20) NULL COMMENT '配置的删除时间，揽收时效时间区域删除时 会使用到该字段',
  `deleteFlag` INT (11) NULL COMMENT '删除标志',
  PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COLLATE = utf8_general_ci COMMENT = '项目信息表';