package com.fang.fangshop.services.impl;

import javax.annotation.Resource;

import com.fang.fangshop.core.been.SystemSetting;
import com.fang.fangshop.core.service.ServicesManager;
import org.springframework.stereotype.Service;
import com.fang.fangshop.dao.ISystemSettingDao;
import com.fang.fangshop.services.ISystemSettingService;

@Service("systemSettingService")
public class SystemSettingServiceImpl extends ServicesManager<SystemSetting, ISystemSettingDao> implements ISystemSettingService {
	@Resource(name="systemSettingDao")
	@Override
	protected void setDao(ISystemSettingDao dao) {
		this.dao=dao;
	}
}
