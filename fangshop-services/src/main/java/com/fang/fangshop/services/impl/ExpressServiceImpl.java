package com.fang.fangshop.services.impl;

import com.fang.fangshop.core.been.Express;
import com.fang.fangshop.core.service.ServicesManager;
import com.fang.fangshop.dao.IExpressDao;
import com.fang.fangshop.services.IExpressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by wangyantao on 2017/4/5.
 */
@Service("expressService")
public class ExpressServiceImpl extends ServicesManager<Express,IExpressDao> implements IExpressService{
    @Resource(name="expressDao")
    @Override
    protected void setDao(IExpressDao iExpressDao) {
        this.dao = iExpressDao;
    }
}
