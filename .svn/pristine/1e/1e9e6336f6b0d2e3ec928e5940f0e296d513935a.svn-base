package com.fang.fangshop.dao.impl;

import com.fang.fangshop.core.been.CommentType;
import com.fang.fangshop.core.common.PageModel;
import com.fang.fangshop.core.dao.BaseDao;
import com.fang.fangshop.dao.ICommentTypeDao;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("commentTypeDao")
public class CommentTypeDaoImpl implements ICommentTypeDao {
    @Resource
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public int insert(CommentType e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(CommentType e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(CommentType e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CommentType selectOne(CommentType e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageModel selectPageList(CommentType e) {
		return baseDao.selectPageList("manage.commenttype.selectPageList",
				"manage.commenttype.selectPageCount", e);
	}

	@Override
	public List<CommentType> selectList(CommentType e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CommentType selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
