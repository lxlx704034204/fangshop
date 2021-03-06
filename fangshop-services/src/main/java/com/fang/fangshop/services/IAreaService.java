package com.fang.fangshop.services;

import com.fang.fangshop.been.AreaModel;
import com.fang.fangshop.core.been.Area;
import com.fang.fangshop.core.service.IServices;

import java.util.List;

public interface IAreaService extends IServices<AreaModel> {
     List<AreaModel> getListAll();
     List<AreaModel> getAreaByCode(String code);
     public boolean exists(String code);
}
