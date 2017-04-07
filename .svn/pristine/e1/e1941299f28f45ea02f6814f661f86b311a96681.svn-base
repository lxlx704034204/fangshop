package com.fang.fangshop.services.impl;

import javax.annotation.Resource;

import com.fang.fangshop.core.been.Notice;
import com.fang.fangshop.core.common.PageModel;
import com.fang.fangshop.core.service.ServicesManager;
import org.springframework.stereotype.Service;
import com.fang.fangshop.dao.INoticeDao;
import com.fang.fangshop.services.INoticeService;

@Service("noticeService")
public class NoticeServiceImpl extends ServicesManager<Notice, INoticeDao> implements INoticeService {

	@Resource(name="noticeDao")
	@Override
	protected void setDao(INoticeDao dao) {
		this.dao = dao;
	}

	@Override
	public PageModel selectPageList(Notice t) {
		// TODO Auto-generated method stub
		return super.selectPageList(t);
	}

}
