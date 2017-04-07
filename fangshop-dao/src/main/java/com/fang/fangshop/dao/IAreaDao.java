package com.fang.fangshop.dao;

import com.fang.fangshop.been.AreaModel;
import com.fang.fangshop.core.dao.IDaoManager;

import java.util.List;

public interface IAreaDao extends IDaoManager<AreaModel> {
    public List<AreaModel> getListAll();
    public List<AreaModel> getAreaByCode(String code);
    public boolean exists(String code);
}
