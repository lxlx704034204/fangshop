package com.fang.fangshop.client;

import com.fang.fangshop.been.SystemLog;

public interface SystemLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemLog record);

    int insertSelective(SystemLog record);

    SystemLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemLog record);

    int updateByPrimaryKey(SystemLog record);
}