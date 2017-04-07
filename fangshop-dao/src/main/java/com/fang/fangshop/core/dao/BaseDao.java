package com.fang.fangshop.core.dao;

import com.fang.fangshop.core.common.PageModel;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * 手动实现 SqlSessionDaoSupport 是为了弥补通过 generator 生成的  UserMapper  接口中的操作方法的局限性，
 * 手动实现后，我们可以在后续开发中根据业务需要，灵活的添加操作方法
 * @author huangmx
 *
 */
public class BaseDao extends SqlSessionDaoSupport{
	public SqlSession sqlSession;
	
	public void openSqlSession(){
		this.sqlSession = getSqlSession();
	}
	
	public <T> T selectOne(String statement){
		return getSqlSession().selectOne(statement);
	}
	
	public <T> T selectOne(String statement,Object param){
		return getSqlSession().selectOne(statement, param);
	}
	
	public <E> List<E> selectList(String statement){
		return getSqlSession().selectList(statement);
	}
	
	public <E> List<E> selectList(String statement,Object param){
		return getSqlSession().selectList(statement, param);
	}
	
	/**
	 * 分页查询
	 * @param listStatement 
	 * @param totalStatement
	 * @param param
	 * @return
	 */
	public PageModel selectPageList(String listStatement,String totalStatement,Object param){
		PageModel pager = new PageModel();
		pager.setList(getSqlSession().selectList(listStatement, param));
		Object objOne = getSqlSession().selectOne(totalStatement,param);
		if(objOne != null){
			pager.setTotal(Integer.parseInt(objOne.toString()));
		}else{
			pager.setTotal(0);
		}
		return pager;
	}
	
	/**
	 * 查询多条记录
	 * @param statement
	 * @param pamram
	 * @param rowBounds 分页参数
	 * @return
	 */
	public <E> List<E> selectList(String statement,Object pamram,RowBounds rowBounds){
		return getSqlSession().selectList(statement, pamram, rowBounds);
	}
	
	public int insert(String statement){
		return getSqlSession().insert(statement);
	}
	
	public int insert(String statement,Object param){
		return getSqlSession().insert(statement, param);
	}
	
	public int update(String statement){
		return getSqlSession().update(statement);
	}
	
	public int update(String statement,Object parma){
		return getSqlSession().update(statement, parma);
	}
	
	public int delete(String statement){
		return getSqlSession().delete(statement);
	}
	
	public int delete(String statement,Object param){
		return getSqlSession().delete(statement, param);
	}
	
}
