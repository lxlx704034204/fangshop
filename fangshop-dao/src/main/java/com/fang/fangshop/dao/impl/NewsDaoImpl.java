package com.fang.fangshop.dao.impl;

import com.fang.fangshop.core.been.News;
import com.fang.fangshop.core.common.PageModel;
import com.fang.fangshop.core.dao.BaseDao;
import com.fang.fangshop.dao.INewsDao;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("newsDao")
public class NewsDaoImpl implements INewsDao {
	@Resource
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	@Override
	public int insert(News e) {
		return baseDao.insert("manage.news.insert", e);
	}

	@Override
	public int delete(News e) {
		return baseDao.delete("manage.news.deleteById", e.getId());
	}

	@Override
	public int update(News e) {
		return baseDao.update("manage.news.updateById", e);
	}

	@Override
	public News selectOne(News e) {
		return baseDao.selectOne("manage.news.selectById", e);
	}

	@Override
	public PageModel selectPageList(News e) {
		return baseDao.selectPageList("manage.news.selectPageList",
				"manage.news.selectPageCount", e);
	}

	@Override
	public List<News> selectList(News e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(int id) {
		return baseDao.delete("manage.news.deleteById", id);
	}

	@Override
	public News selectById(String id) {
		return baseDao.selectOne("manage.news.selectById", Integer.parseInt(id));
	}

}
