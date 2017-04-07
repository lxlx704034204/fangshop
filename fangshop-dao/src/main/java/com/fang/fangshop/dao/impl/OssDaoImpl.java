package com.fang.fangshop.dao.impl;

import com.fang.fangshop.core.been.Oss;
import com.fang.fangshop.core.common.PageModel;
import com.fang.fangshop.core.dao.BaseDao;
import com.fang.fangshop.dao.IOssDao;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("ossDao")
public class OssDaoImpl implements IOssDao{
	@Resource
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	@Override
	public int insert(Oss e) {
		return baseDao.insert("manage.oss.insert", e);
	}

	@Override
	public int delete(Oss e) {
		return baseDao.delete("manage.oss.deleteById", e.getId());
	}

	@Override
	public int update(Oss e) {
		return baseDao.update("manage.oss.updateById", e);
	}

	@Override
	public Oss selectOne(Oss e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageModel selectPageList(Oss e) {
		return baseDao.selectPageList("manage.oss.selectPageList",
				"manage.oss.selectPageCount", e);
	}

	@Override
	public List<Oss> selectList(Oss e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(int id) {
		return baseDao.delete("manage.oss.deleteById", id);
	}

	@Override
	public Oss selectById(String id) {
		return baseDao.selectOne("manage.oss.selectById", Integer.parseInt(id));
	}

}
