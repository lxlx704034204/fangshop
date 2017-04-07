package com.fang.fangshop.dao.impl;

import com.fang.fangshop.core.common.PageModel;
import com.fang.fangshop.core.dao.BaseDao;
import com.fang.fangshop.dao.IUserDao;
import com.fang.fangshop.core.system.been.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements IUserDao {
	@Resource
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	@Override
	public int insert(User t) {
		String statement = "manage.user.addUser";
		return baseDao.insert(statement, t);
	}

	@Override
	public int update(User t) {
		String statement = "manage.user.updateUser";
		return baseDao.update(statement, t);
	}

	@Override
	public int delete(User t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User selectOne(User t) {
		String statement = "manage.user.selectOne";
		return baseDao.selectOne(statement,t);
	}

	@Override
	public List<User> selectList(User t) {
		String statement="manage.user.selectList";
		return baseDao.selectList(statement, t);
	}
	
	/**
	 * 分页查询
	 * @param t
	 * @return
	 */
	@Override
	public PageModel selectPageList(User t){
		String listStatement = "manage.user.selectList";
		String totalStatement = "manage.user.selectTotalCount";
		return baseDao.selectPageList(listStatement, totalStatement, t);
	}

	@Override
	public User selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getByField(User user) {
		String statement = "manage.user.getByField";
		return baseDao.selectOne(statement,user);
	}

	@Override
	public int updateById(Integer id) {
		String statement = "manage.user.updateById";
		return  baseDao.update(statement,id);
	}
}
