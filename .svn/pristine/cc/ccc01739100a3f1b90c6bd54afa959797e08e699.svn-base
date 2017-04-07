package com.fang.fangshop.services;

import com.fang.fangshop.core.service.IServices;
import com.fang.fangshop.core.system.been.Menu;
import com.fang.fangshop.core.system.been.MenuItem;
import com.fang.fangshop.core.system.been.User;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface IMenuService extends IServices<Menu> {
	/**
	 * 查询指定用户拥有的全部菜单资源
	 * @param param
	 * @return
	 */
	public List<Menu> selectList(Map<String, Integer> param);
	/**
	 * 加载顶级目录或页面菜单
	 * @param user
	 * @return
	 */
    public Collection<MenuItem> getMenus(User user);

	/**
	 * 获取所有菜单
	 * @return
	 */
	public List<Menu> selectAll(int rid);
	public int updateById(Menu menu);
}
