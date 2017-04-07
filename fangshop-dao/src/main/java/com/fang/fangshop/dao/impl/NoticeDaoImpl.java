package com.fang.fangshop.dao.impl;

import com.fang.fangshop.core.been.Notice;
import com.fang.fangshop.core.common.PageModel;
import com.fang.fangshop.core.dao.BaseDao;
import com.fang.fangshop.dao.INoticeDao;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("noticeDao")
public class NoticeDaoImpl implements INoticeDao {
	@Resource
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	@Override
	public int insert(Notice e) {
		return baseDao.insert("manage.notice.insert", e);
	}

	@Override
	public int delete(Notice e) {
		return baseDao.delete("manage.notice.delete",e);
	}

	@Override
	public int update(Notice e) {
		return baseDao.update("manage.notice.update", e);
	}

	@Override
	public Notice selectOne(Notice e) {
		return baseDao.selectOne("manage.notice.selectById", e);
	}

	@Override
	public PageModel selectPageList(Notice e) {
		return baseDao.selectPageList("manage.notice.selectPageList",
				"manage.notice.selectPageCount", e);
	}

	@Override
	public List<Notice> selectList(Notice e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(int id) {
		return baseDao.delete("manage.notice.delete",id);
	}

	@Override
	public Notice selectById(String id) {
		return baseDao.selectOne("manage.notice.selectById", id);
	}

}
