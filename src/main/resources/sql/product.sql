-- 基本的项目信息表
CREATE TABLE `tb_product` (
  `id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT '主键 自增',
  `productName` VARCHAR (32) NULL COMMENT '项目名称',
  `productType` INT (11) NULL COMMENT '项目类别',
  `productDetailId` INT(11) NOT NULL COMMENT  '项目详细信息ID',
  `amount` INT (11) NULL COMMENT '项目金额',
  `rateReturn` DOUBLE DEFAULT  0 COMMENT '预期收益率',
  `duration` INT DEFAULT  0 COMMENT  '项目期限，单位为月。 0 表示随时可取',
  `lowerLimit` INT DEFAULT 0 COMMENT  '投资的下限，单位为元',
  `autoInvest` INT(11) COMMENT  '是否可自动续投',
  `remainder` INT(11) COMMENT '剩余可投的数目',
  `status` TINYINT DEFAULT 0 COMMENT  '项目状态',
  `createTime` BIGINT (20) NULL COMMENT '项目创建时间',
  `updateTime` TIMESTAMP NULL COMMENT '项目更新时间',
  `deleteTime` BIGINT (20) NULL COMMENT '项目删除时间',
  `deleteFlag` INT (11) NULL COMMENT '删除标志',
  PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COLLATE = utf8_general_ci COMMENT = '项目信息表';