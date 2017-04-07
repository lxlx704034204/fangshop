package com.fang.fangshop.dao;

import com.fang.fangshop.core.dao.IDaoManager;
import com.fang.fangshop.core.system.been.User;


public interface IUserDao extends IDaoManager<User> {
    public int getByField(User user);
    public int updateById(Integer id);
}
