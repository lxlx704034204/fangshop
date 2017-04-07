package com.fang.fangshop.core.system.been;

import com.fang.fangshop.core.cache.RedisCache;
import com.fang.fangshop.core.cache.RedisFieldNotCache;
import com.fang.fangshop.core.cache.RedisQuery;
import com.fang.fangshop.core.cache.RedisQueryByScope;
import com.fang.fangshop.core.common.PageModel;

import java.util.Calendar;
import java.util.Date;

@RedisCache
public class User extends PageModel{
	@RedisFieldNotCache
	private static final String className = "user";
	@RedisFieldNotCache
	private static final String primaryKey = "id";
	
	private String id;
	private String username;
	private String password;
	@RedisQueryByScope
	private Date createtime;
	private Date updatetime;
	private String createaccount;
	private String updateaccount;
	@RedisQuery
	private String status;
	private int rid;
	private String nickname;
	private String email;
	@RedisFieldNotCache
	private Date beginDate;
	private Byte deleted;
	/**
	 * 用户角色
	 */
	@RedisFieldNotCache
	private Role role;

	public Date getBeginDate() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, -1);
		beginDate = c.getTime();
		return beginDate;
	}

	public static String getClassName() {
		return className;
	}

	public static String getPrimaryKey() {
		return primaryKey;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getCreateaccount() {
		return createaccount;
	}

	public void setCreateaccount(String createaccount) {
		this.createaccount = createaccount;
	}

	public String getUpdateaccount() {
		return updateaccount;
	}

	public void setUpdateaccount(String updateaccount) {
		this.updateaccount = updateaccount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Byte getDeleted() {
		return deleted;
	}

	public void setDeleted(Byte deleted) {
		this.deleted = deleted;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User(String id, String username, String password, Date createtime, Date updatetime, String createaccount, String updateaccount, String status, int rid, String nickname, String email, Date beginDate, Byte deleted, Role role) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.createaccount = createaccount;
		this.updateaccount = updateaccount;
		this.status = status;
		this.rid = rid;
		this.nickname = nickname;
		this.email = email;
		this.beginDate = beginDate;
		this.deleted = deleted;
		this.role = role;
	}

	public User() {
	}

	@Override
	public String toString() {
		return "User{" +
				"id='" + id + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", createtime=" + createtime +
				", updatetime=" + updatetime +
				", createaccount='" + createaccount + '\'' +
				", updateaccount='" + updateaccount + '\'' +
				", status='" + status + '\'' +
				", rid=" + rid +
				", nickname='" + nickname + '\'' +
				", email='" + email + '\'' +
				", beginDate=" + beginDate +
				", deleted=" + deleted +
				", role=" + role +
				'}';
	}
}
