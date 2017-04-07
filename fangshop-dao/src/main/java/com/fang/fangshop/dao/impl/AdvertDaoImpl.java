package com.fang.fangshop.dao.impl;

import com.fang.fangshop.core.been.Advert;
import com.fang.fangshop.core.common.PageModel;
import com.fang.fangshop.core.dao.BaseDao;
import com.fang.fangshop.dao.IAdvertDao;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("advertDao")
public class AdvertDaoImpl implements IAdvertDao {
	@Resource
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	@Override
	public int insert(Advert e) {
		return baseDao.insert("manage.advert.insert", e);
	}

	@Override
	public int delete(Advert e) {
		return baseDao.delete("manage.advert.deleteById", e.getId());
	}

	@Override
	public int update(Advert e) {
		return baseDao.update("manage.advert.updateById", e);
	}

	@Override
	public Advert selectOne(Advert e) {
		return baseDao.selectOne("manage.advert.selectById", e);
	}

	@Override
	public PageModel selectPageList(Advert e) {
		return baseDao.selectPageList("manage.advert.selectPageList",
				"manage.advert.selectPageCount", e);
	}

	@Override
	public List<Advert> selectList(Advert e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(int id) {
		return baseDao.delete("manage.advert.deleteById", id);
	}

	@Override
	public Advert selectById(String id) {
		return baseDao.selectOne("manage.advert.selectById", Integer.parseInt(id));
	}

}
