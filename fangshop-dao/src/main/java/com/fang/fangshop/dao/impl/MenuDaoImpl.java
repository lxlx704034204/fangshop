package com.fang.fangshop.dao.impl;

import com.fang.fangshop.core.common.PageModel;
import com.fang.fangshop.core.dao.BaseDao;
import com.fang.fangshop.dao.IMenuDao;
import com.fang.fangshop.core.system.been.Menu;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("menuDao")
public class MenuDaoImpl implements IMenuDao {
	@Resource
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public int insert(Menu t) {
		return baseDao.insert("manage.menu.insert",t);
	}

	@Override
	public int update(Menu t) {
		return  baseDao.update("manage.menu.update",t);
	}

	@Override
	public int delete(Menu t) {
		return baseDao.delete("manage.menu.deleteById",t.getId());
	}

	@Override
	public int deleteById(int id) {
		return baseDao.delete("manage.menu.deleteById",id);
	}

	@Override
	public Menu selectById(String id) {
		return null;
	}

	@Override
	public Menu selectOne(Menu t) {
		return baseDao.selectOne("manage.menu.selectById",t.getId());
	}

	@Override
	public List<Menu> selectList(Menu t) {
		return baseDao.selectList("manage.menu.selectList");
	}

	@Override
	public List<Menu> selectAll() {
		return baseDao.selectList("manage.menu.selectAll");
	}

	@Override
	public List<Menu> selectList(Object param) {
		return baseDao.selectList("manage.menu.selectList", param);
	}

	@Override
	public int updateById(Menu menu) {
		return  baseDao.update("manage.menu.updateById",menu);
	}

	@Override
	public PageModel selectPageList(Menu e) {
		// TODO Auto-generated method stub
		return null;
	}
}
