package com.fang.fangshop.dao.impl;

import com.fang.fangshop.core.common.PageModel;
import com.fang.fangshop.core.dao.BaseDao;
import com.fang.fangshop.dao.IRoleDao;
import com.fang.fangshop.core.system.been.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("roleDao")
public class RoleDaoImpl implements IRoleDao{
	@Resource
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public int insert(Role t) {
		return baseDao.insert("manage.role.insert", t);
	}

	@Override
	public int update(Role t) {
		return baseDao.update("manage.role.updateById", t);
	}

	@Override
	public int delete(Role t) {
		return baseDao.delete("manage.role.deleteById", t.getId());
	}

	@Override
	public int deleteById(int id) {
		return baseDao.delete("manage.role.deleteById", id);
	}

	@Override
	public Role selectOne(Role t) {
		return  baseDao.selectOne("manage.role.selectById",t.getId());
	}

	@Override
	public List<Role> selectList(Role t) {
		String statement="manage.user.selectList";
		return baseDao.selectList(statement,t);
	}
	
	@Override
	public PageModel selectPageList(Role t) {
		String listStatement = "manage.role.selectList";
		String totalStatement = "manage.role.selectTotalCount";
		return baseDao.selectPageList(listStatement, totalStatement, t);
	}

	@Override
	public Role selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> getAllRoles() {
		return baseDao.selectList("manage.role.selectListAll");
	}
}
