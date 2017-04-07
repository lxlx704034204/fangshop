package com.fang.fangshop.core.system.been;

import com.fang.fangshop.core.cache.RedisCache;
import com.fang.fangshop.core.cache.RedisFieldNotCache;
import com.fang.fangshop.core.common.PageModel;

@RedisCache
public class Role extends PageModel {
	@RedisFieldNotCache
	private static final String className = "role";
	@RedisFieldNotCache
	private static final String primaryKey = "id";

	private int id;
	private String rolename;
	private String roledesc;
	private String roledbprivilege;
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRoledesc() {
		return roledesc;
	}

	public void setRoledesc(String roledesc) {
		this.roledesc = roledesc;
	}

	public String getRoledbprivilege() {
		return roledbprivilege;
	}

	public void setRoledbprivilege(String roledbprivilege) {
		this.roledbprivilege = roledbprivilege;
	}

	public Role() {

	}

	public Role(int id, String rolename, String roledesc, String roledbprivilege, String status) {
		super();
		this.id = id;
		this.rolename = rolename;
		this.roledesc = roledesc;
		this.roledbprivilege = roledbprivilege;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", rolename=" + rolename + ", roledesc=" + roledesc + ", roledbprivilege="
				+ roledbprivilege + ", status=" + status + "]";
	}
}