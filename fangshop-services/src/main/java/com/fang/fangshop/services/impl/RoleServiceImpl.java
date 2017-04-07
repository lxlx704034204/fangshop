package com.fang.fangshop.services.impl;

import javax.annotation.Resource;

import com.fang.fangshop.core.service.ServicesManager;
import com.fang.fangshop.core.system.been.Role;
import com.fang.fangshop.dao.IRoleDao;
import org.springframework.stereotype.Service;
import com.fang.fangshop.dao.impl.RoleDaoImpl;
import com.fang.fangshop.services.IRoleService;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl extends ServicesManager<Role, IRoleDao> implements IRoleService {
	@Resource(name="roleDao")
	@Override
	protected void setDao(IRoleDao dao) {
		super.dao = dao; 
	}

	@Override
	public List<Role> getAllRoles() {
		return dao.getAllRoles();
	}
}
