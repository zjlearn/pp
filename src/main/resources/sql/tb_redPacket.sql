-- 红包信息表
CREATE TABLE `tb_redPacket` (
  `id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT '主键 自增',
  `userId` BIGINT(20) NOT NULL DEFAULT  0 COMMENT  '红包的所有者用户ID',
  `packetName` VARCHAR (32) NULL COMMENT '红包名称',
  `packetType` INT (11) NULL COMMENT '红包类别，0现金红包，1，抵用券红包',
  `packetAmount` DECIMAL(15,2) NOT NULL COMMENT  '红包金额',
  `periodValidity` INT DEFAULT 0 COMMENT  '有效期，单位为天',
  `durtionLimit` INT DEFAULT  0 COMMENT  '投资使用的项目时长限制，必须大于该值',
  `amountLimit`  INT DEFAULT 0 COMMENT  '投资时投资金额限制， 必须大于该值',
  `status` INT DEFAULT  0 COMMENT  '红包状态，过期， 是否使用',
  `createTime` BIGINT (20) NULL COMMENT '项目创建时间',
  PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COLLATE = utf8_general_ci COMMENT = '红包信息表';