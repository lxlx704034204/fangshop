package com.fang.fangshop.dao.impl;

import com.fang.fangshop.core.been.SystemLog;
import com.fang.fangshop.core.common.PageModel;
import com.fang.fangshop.core.dao.BaseDao;
import com.fang.fangshop.dao.ISystemLogDao;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangyantao on 2017/4/6.
 */
@Repository("systemLogDao")
public class SystemLogDaoImpl implements ISystemLogDao {
    @Resource
    private BaseDao baseDao;
    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public int insert(SystemLog systemLog) {
        return baseDao.insert("manage.systemlog.insert",systemLog);
    }

    @Override
    public int delete(SystemLog systemLog) {
        return baseDao.delete("manage.systemloy.deleteById",systemLog.getId());
    }

    @Override
    public int update(SystemLog systemLog) {
        return baseDao.update("manage.systemlog.updateById",systemLog);
    }

    @Override
    public SystemLog selectOne(SystemLog systemLog) {
        return baseDao.selectOne("manage.systemlog.selectById",systemLog.getId());
    }

    @Override
    public PageModel selectPageList(SystemLog systemLog) {
        return baseDao.selectPageList("manage.systemlog.selectPageList","manage.systemlog.selectPageCount",systemLog);
    }

    @Override
    public List<SystemLog> selectList(SystemLog systemLog) {
        return null;
    }

    @Override
    public int deleteById(int id) {
        return baseDao.delete("manage.systemloy.deleteById",id);
    }

    @Override
    public SystemLog selectById(String id) {
        return baseDao.selectOne("manage.systemlog.selectById",id);
    }
}
