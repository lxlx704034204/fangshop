package com.fang.fangshop.core.service;

import com.fang.fangshop.core.common.PageModel;
import com.fang.fangshop.core.dao.IDaoManager;
import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * 实现 Services 接口，其他的业务类 services 就不用每一个都去实现一遍 Services 了
 * @author huangmx
 *
 * @param <T>
 * @param <Dao>
 */
public abstract class ServicesManager<T extends PageModel,DAO extends IDaoManager<T>> implements IServices<T> {

	protected DAO dao;
	
	protected DAO getDAO(){
		return dao;
	}
	
	protected abstract void setDao(DAO dao);
	
	public int insert(T t){
		return dao.insert(t);
	}
	
	public int update(T t){
		return dao.update(t);
	}
	
	public int delete(T t){
		return dao.delete(t);
	}
	
	public int delete(String[] ids){
		if (ids == null || ids.length == 0) {
			throw new NullPointerException("id不能全为空！");
		}

		for (int i = 0; i < ids.length; i++) {
			if(StringUtils.isBlank(ids[i])){
				throw new NullPointerException("id不能为空！");
			}
			dao.deleteById(Integer.parseInt(ids[i]));
		}
		return 0;
	}
	
	public T selectOne(T t){
		return dao.selectOne(t);
	}
	
	public List<T> selectList(T t){
		return dao.selectList(t);
	}
	
	public T selectById(String id){
		return dao.selectById(id);
	}

	public PageModel selectPageList(T t) {
		return dao.selectPageList(t);
	}
}
