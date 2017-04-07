package com.fang.fangshop.services.impl;

import java.util.*;

import javax.annotation.Resource;

import com.fang.fangshop.core.common.PageModel;
import com.fang.fangshop.core.service.ServicesManager;
import com.fang.fangshop.core.system.been.Menu;
import com.fang.fangshop.core.system.been.MenuItem;
import com.fang.fangshop.core.system.been.Privilege;
import com.fang.fangshop.core.system.been.User;
import com.fang.fangshop.services.IPrivilegeService;
import org.apache.commons.lang.StringUtils;
import org.apache.xpath.SourceTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fang.fangshop.dao.IMenuDao;
import com.fang.fangshop.services.IMenuService;

@Service("menuService")
public class MenuServiceImpl extends ServicesManager<Menu,IMenuDao> implements IMenuService {
	@Autowired
	private IPrivilegeService privilegeService;
    @Resource(name="menuDao")
	@Override
	protected void setDao(IMenuDao dao) {
    	this.dao=dao;
	}
	@Override
	public List<Menu> selectList(Map<String, Integer> param) {
		return dao.selectList(param);
	}
	@Override
	public Collection<MenuItem> getMenus(User user) {
		Map<String, Integer> param = new HashMap<String,Integer>();
		if(user != null){
			param.put("rid",user.getRid());
		}
		List<Menu> menus = selectList(param);
		//创建菜单集合
		LinkedHashMap<Integer, MenuItem> root = new LinkedHashMap<Integer,MenuItem>();
		//循环添加到订单集合
		for(Menu menu:menus){
			MenuItem menuItem = new MenuItem(menu.getName(),null);
			menuItem.setId(menu.getId());
			menuItem.setPid(menu.getPid());
			menuItem.setMenuType(menu);
			menuItem.setUrl(StringUtils.trimToEmpty(menu.getUrl()));
			if(menuItem.isRootMenu()){
				root.put(menuItem.getId(), menuItem);
			}
		}
		
		for(Menu menu:menus){
			MenuItem menuItem = new MenuItem(menu.getName(),null);
			menuItem.setId(menu.getId());
			menuItem.setPid(menu.getPid());
			menuItem.setMenuType(menu);
			menuItem.setUrl(StringUtils.trimToEmpty(menu.getUrl()));

			if(!menuItem.isRootMenu() && !menuItem.isButton()){
				MenuItem parentItem = root.get(menuItem.getPid());
				if(parentItem != null)
				{
					parentItem.addChild(menuItem);
				}
			}
		}
		return root.values();
	}

	/**
	 * 根据角色ID获取菜单集合
	 * @param rid
	 * @return
	 */
    public List<Menu> selectAll(int rid) {
		List<Menu> menus = dao.selectAll();
		menus.parallelStream().forEach(e->e.setUrl("javascript:void(0)"));
		if(rid!=0)
		{
			Privilege privilege = new Privilege();
			privilege.setRid(rid);
		    List<Privilege> privileges = privilegeService.selectList(privilege);
            for (Menu menu:menus){
				Optional<Privilege> lege = privileges.stream().filter(e->e.getMid()==menu.getId()).findFirst();
				if(lege.isPresent()){
					menu.setChecked(true);
				}
			}
		}
		return menus;
    }

	@Override
	public int updateById(Menu menu) {
		return dao.updateById(menu);
	}
}
