package com.fang.fangshop.services.impl;

import javax.annotation.Resource;

import com.fang.fangshop.core.been.CommentType;
import com.fang.fangshop.core.service.ServicesManager;
import org.springframework.stereotype.Service;
import com.fang.fangshop.dao.ICommentTypeDao;
import com.fang.fangshop.services.ICommentTypeService;

@Service("commentTypeService")
public class CommentTypeServiceImpl extends ServicesManager<CommentType, ICommentTypeDao> implements ICommentTypeService
{

	@Resource(name="commentTypeDao")
	@Override
	protected void setDao(ICommentTypeDao dao) {
		this.dao = dao;
	}

}
