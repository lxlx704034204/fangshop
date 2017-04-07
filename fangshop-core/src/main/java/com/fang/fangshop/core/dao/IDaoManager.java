package com.fang.fangshop.core.dao;

import com.fang.fangshop.core.common.PageModel;

import java.util.List;

/**
 * 抽象出一个 DaoManager ，可以避免在所有的业务 Dao 中都要写这些  insert、update、delete、select 操作，
 * 只需要实现这个接口就可以了以及各自特有的操作方法就可以了
 * todo:这个DaoManager好像有点多余？
 * @author huangmx
 *
 */
public interface IDaoManager<E extends PageModel> {
	/**
	 * 添加
	 * 
	 * @param e
	 * @return
	 */
	public int insert(E e);

	/**
	 * 删除
	 * 
	 * @param e
	 * @return
	 */
	public int delete(E e);

	/**
	 * 修改
	 * 
	 * @param e
	 * @return
	 */
	public int update(E e);

	/**
	 * 查询一条记录
	 * 
	 * @param e
	 * @return
	 */
	public E selectOne(E e);

	/**
	 * 分页查询
	 * 
	 * @param e
	 * @return
	 */
	public PageModel selectPageList(E e);
	
	/**
	 * 根据条件查询所有
	 * @return
	 */
	public List<E> selectList(E e);

	/**
	 * 根据ID来删除一条记录
	 * @param id
	 */
	public int deleteById(int id);

	/**
	 * 根据ID查询一条记录
	 * @param id
	 * @return
	 */
	public E selectById(String id);
}
