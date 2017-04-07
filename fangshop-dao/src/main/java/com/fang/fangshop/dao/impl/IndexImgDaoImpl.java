package com.fang.fangshop.dao.impl;

import com.fang.fangshop.core.been.IndexImg;
import com.fang.fangshop.core.common.PageModel;
import com.fang.fangshop.core.dao.BaseDao;
import com.fang.fangshop.dao.IIdexImgDao;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("indexImgDao")
public class IndexImgDaoImpl implements IIdexImgDao {
	@Resource
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	@Override
	public int insert(IndexImg e) {
		return baseDao.insert("manage.indeximg.insert", e);
	}

	@Override
	public int delete(IndexImg e) {
		return baseDao.delete("manage.indeximg.deleteById", e.getId());
	}

	@Override
	public int update(IndexImg e) {
		return baseDao.update("manage.indeximg.updateById", e);
	}

	@Override
	public IndexImg selectOne(IndexImg e) {
		return baseDao.selectOne("manage.indeximg.selectById", e);
	}

	@Override
	public PageModel selectPageList(IndexImg e) {
		return baseDao.selectPageList("manage.indeximg.selectPageList",
				"manage.indeximg.selectPageCount", e);
	}

	@Override
	public List<IndexImg> selectList(IndexImg e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(int id) {
		return baseDao.delete("manage.indeximg.deleteById", id);
	}

	@Override
	public IndexImg selectById(String id) {
		return baseDao.selectOne("manage.indeximg.selectById", Integer.parseInt(id));
	}

}
