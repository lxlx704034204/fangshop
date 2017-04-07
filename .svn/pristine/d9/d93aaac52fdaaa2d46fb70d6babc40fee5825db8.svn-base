package com.fang.fangshop.services.impl;

import javax.annotation.Resource;

import com.fang.fangshop.core.been.Email;
import com.fang.fangshop.core.service.ServicesManager;
import org.springframework.stereotype.Service;
import com.fang.fangshop.dao.IEmailDao;
import com.fang.fangshop.services.IEmailService;

@Service("emailService")
public class EmailServiceImpl extends ServicesManager<Email, IEmailDao> implements IEmailService {

	@Resource(name="emailDao")
	@Override
	protected void setDao(IEmailDao dao) {
		this.dao = dao;
	}

}
