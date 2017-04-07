//package com.fang.fangshop.dao.impl;
//
//import com.fang.fangshop.core.been.Account;
//import com.fang.fangshop.core.common.PageModel;
//import com.fang.fangshop.core.dao.BaseDao;
//import com.fang.fangshop.dao.IAccountDao;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository("accountDao")
//public class AccountDaoImpl implements IAccountDao {
//
//	@Autowired
//	private BaseDao dao;
//	public void setBaseDao(BaseDao dao){
//		this.dao=dao;
//	}
//
//	@Override
//	public int insert(Account e) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int delete(Account e) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int update(Account e) {
//		String statement="account.update";
//		return dao.update(statement, e);
//	}
//
//	@Override
//	public Account selectOne(Account e) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public PageModel selectPageList(Account e) {
//		String listStatement="account.selectAll";
//		String totalStatement="account.selectTotalCount";
//		return dao.selectPageList(listStatement, totalStatement, e);
//	}
//
//	@Override
//	public List<Account> selectList(Account e) {
//		String statement="account.selectAll";
//		return dao.selectList(statement, e);
//	}
//
//	@Override
//	public int deleteById(int id) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public Account selectById(String id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public int updateFreeze(Account e){
//		String statement="account.updateFreeze";
//		return dao.delete(statement, e);
//	}
//
//}
