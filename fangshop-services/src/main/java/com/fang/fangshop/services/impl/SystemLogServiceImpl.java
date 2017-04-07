package com.fang.fangshop.services.impl;

import com.fang.fangshop.core.been.SystemLog;
import com.fang.fangshop.core.service.ServicesManager;
import com.fang.fangshop.dao.ISystemLogDao;
import com.fang.fangshop.services.ISystemLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by wangyantao on 2017/4/6.
 */
@Service("systemLogService")
public class SystemLogServiceImpl extends ServicesManager<SystemLog,ISystemLogDao> implements ISystemLogService {
    @Resource(name="systemLogDao")
    @Override
    protected void setDao(ISystemLogDao iSystemLogDao) {
        this.dao = iSystemLogDao;
    }
}
