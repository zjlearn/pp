-- 消息表结构
CREATE TABLE `tb_message` (
  `id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT '主键 自增',
  `messgaeName` VARCHAR (32) NULL COMMENT '消息名称',
  `messgaeType` INT (11) NULL COMMENT '消息类别',
  `messgaeContent` VARCHAR (11) NULL COMMENT '消息类别',
  `messgaeStatus` INT (11) NULL COMMENT '消息状态,是否已读，0未读， 1已读',
  `createTime` BIGINT COMMENT  '创建时间',
  PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COLLATE = utf8_general_ci COMMENT = '消息结构表';