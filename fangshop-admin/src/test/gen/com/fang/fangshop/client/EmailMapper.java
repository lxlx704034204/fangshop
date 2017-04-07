package com.fang.fangshop.client;

import com.fang.fangshop.been.Email;

public interface EmailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Email record);

    int insertSelective(Email record);

    Email selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Email record);

    int updateByPrimaryKey(Email record);
}