package com.galaxy.moon.pp.dao;

import com.galaxy.moon.pp.model.bean.RedPacket;

public interface RedPacketMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RedPacket record);

    int insertSelective(RedPacket record);

    RedPacket selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RedPacket record);

    int updateByPrimaryKey(RedPacket record);
}