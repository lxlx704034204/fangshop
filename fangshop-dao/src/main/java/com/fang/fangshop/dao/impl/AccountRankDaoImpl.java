//package com.fang.fangshop.dao.impl;
//
//import com.fang.fangshop.core.been.AccountRank;
//import com.fang.fangshop.core.common.PageModel;
//import com.fang.fangshop.core.dao.BaseDao;
//import com.fang.fangshop.dao.IAccountRankDao;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository("accountRankDao")
//public class AccountRankDaoImpl implements IAccountRankDao {
//
//	@Autowired
//	private BaseDao dao;
//	public void setBaseDao(BaseDao dao){
//		this.dao=dao;
//	}
//	@Override
//	public int insert(AccountRank e) {
//		String statement="accountrank.insert";
//		return dao.insert(statement, e);
//	}
//
//	@Override
//	public int delete(AccountRank e) {
//		String statement="accountrank.delete";
//		return dao.delete(statement, e);
//	}
//
//	@Override
//	public int update(AccountRank e) {
//		String statement="accountrank.update";
//		return dao.update(statement, e);
//	}
//
//	@Override
//	public AccountRank selectOne(AccountRank e) {
//		String statement="accountrank.selectOne";
//		return dao.selectOne(statement, e);
//	}
//
//	@Override
//	public PageModel selectPageList(AccountRank e) {
//		String listStatement="accountrank.selectAll";
//		String totalStatement="accountrank.selectTotalCount";
//		return dao.selectPageList(listStatement, totalStatement, e);
//	}
//
//	@Override
//	public List<AccountRank> selectList(AccountRank e) {
//		String statement="accountrank.selectAll";
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
//	public AccountRank selectById(String id) {
//
//		return null;
//	}
//
//}
