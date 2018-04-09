package com.galaxy.moon.pp.service;

import com.galaxy.moon.pp.model.bean.Project;

public interface ProjectService {
    int deleteByPrimaryKey(Long id);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);
}
