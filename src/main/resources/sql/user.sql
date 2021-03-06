-- 基本的用户信息表
CREATE TABLE `tb_user` (
  `id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT '主键 自增',
  `userName` VARCHAR (32) NULL COMMENT '用户姓名',
  `nickName` VARCHAR (32) NULL COMMENT '用户昵称',
  `mobile` VARCHAR (32) NULL COMMENT '手机号码',
  `emial` VARCHAR (128) NULL COMMENT '邮箱',
  `password` VARCHAR (64) NULL COMMENT '密码',
  `sex` TINYINT  NULL COMMENT '性别',
  `idCard` VARCHAR (32) NULL COMMENT '身份证号',
  `age` INT (11) NULL COMMENT '年龄',
  `birthPlace` VARCHAR(32) NULL COMMENT '出生地',
  `marryStatus` TINYINT DEFAULT 0 COMMENT '婚姻状态, 0 未婚， 1 已婚',
  `userType` INT (11) NULL COMMENT '用户类型',
  `ipsAccount` VARCHAR (32) NULL COMMENT 'ips账号',
  `redPacketNum` INT (11) NULL COMMENT '红包数',
  `assets` DECIMAL (12,2) NULL COMMENT '总资产',
  `availableRemain` DECIMAL (12,2) NULL COMMENT '可用余额',
  `frozenRemain` DECIMAL (12,2) NULL COMMENT '冻结金额',
  `points` INT(11) DEFAULT  0 COMMENT  '积分',
  `recomReward` DECIMAL(12,2) DEFAULT  0 COMMENT '推荐奖励',
  `userRole` INT(11) DEFAULT 0 COMMENT  '用户角色， 0 : ',
  `status` TINYINT DEFAULT 0 COMMENT  '用户状态',
  `createTime` BIGINT (20) NULL COMMENT '配置创建时间',
  `updateTime` TIMESTAMP NULL COMMENT '配置的更新时间',
  `deleteTime` BIGINT (20) NULL COMMENT '配置的删除时间，揽收时效时间区域删除时 会使用到该字段',
  `deleteFlag` INT (11) NULL COMMENT '删除标志',
  PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表';