package com.fang.fangshop.dao.impl;

import com.fang.fangshop.core.been.SystemSetting;
import com.fang.fangshop.core.common.PageModel;
import com.fang.fangshop.core.dao.BaseDao;
import com.fang.fangshop.dao.ISystemSettingDao;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("systemSettingDao")
public class SystemSettingDaoImpl implements ISystemSettingDao {
	@Resource
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	@Override
	public int insert(SystemSetting e) {
		return baseDao.insert("manage.systemSetting.insert",e);
	}

	@Override
	public int delete(SystemSetting e) {
		return baseDao.delete("manage.systemSetting.deleteById",e.getId());
	}

	@Override
	public int update(SystemSetting e) {
		return baseDao.update("manage.systemSetting.updateById",e);
	}

	@Override
	public SystemSetting selectOne(SystemSetting e) {
		return baseDao.selectOne("manage.systemSetting.selectById",e.getId());
	}

	@Override
	public PageModel selectPageList(SystemSetting e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SystemSetting> selectList(SystemSetting e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(int id) {
		return baseDao.delete("manage.systemSetting.deleteById",id);
	}

	@Override
	public SystemSetting selectById(String id) {
		return baseDao.selectOne("manage.systemSetting.selectById",id);
	}

}
