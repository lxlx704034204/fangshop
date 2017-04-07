package com.fang.fangshop.dao.impl;

import com.fang.fangshop.core.been.Email;
import com.fang.fangshop.core.common.PageModel;
import com.fang.fangshop.core.dao.BaseDao;
import com.fang.fangshop.dao.IEmailDao;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("emailDao")
public class EmailDaoImpl implements IEmailDao {
	@Resource
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	@Override
	public int insert(Email e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Email e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Email e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Email selectOne(Email e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageModel selectPageList(Email e) {
		return baseDao.selectPageList("manage.email.selectPageList",
				"manage.email.selectPageCount", e);
	}

	@Override
	public List<Email> selectList(Email e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Email selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
