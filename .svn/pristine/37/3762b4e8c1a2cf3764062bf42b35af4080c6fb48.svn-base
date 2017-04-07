package com.fang.fangshop.dao.impl;

import com.fang.fangshop.core.common.PageModel;
import com.fang.fangshop.core.dao.BaseDao;
import com.fang.fangshop.core.system.been.Privilege;
import com.fang.fangshop.dao.IPrivilegeDao;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangyantao on 2017/3/16.
 */

@Repository("privilegeDao")
public class PrivilegeDaoImpl implements IPrivilegeDao {
    @Resource
    private BaseDao baseDao;
    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }
    @Override
    public int insert(Privilege privilege) {
        return baseDao.insert("manage.privilege.insert",privilege);
    }

    @Override
    public int delete(Privilege privilege) {
        return  baseDao.delete("manage.privilege.deleteById",privilege.getId());
    }

    @Override
    public int update(Privilege privilege) {
       return baseDao.update("manage.privilege.updateById",privilege);
    }

    @Override
    public Privilege selectOne(Privilege privilege) {
        return baseDao.selectOne("manage.privilege.selectById",privilege.getId());
    }

    @Override
    public PageModel selectPageList(Privilege privilege) {
        return null;
    }

    @Override
    public List<Privilege> selectList(Privilege privilege) {
        return baseDao.selectList("manage.privilege.selectList",privilege);
    }

    @Override
    public int deleteById(int id) {
        return 0;
    }

    @Override
    public Privilege selectById(String id) {
        return null;
    }

    @Override
    public int deleteByRid(int rid) {
        return baseDao.delete("manage.privilege.deleteByRid",rid);
    }

    @Override
    public int isExistsByMidAndRid(Privilege privilege) {
        return baseDao.selectOne("manage.privilege.isExistsByMidAndRid",privilege);
    }
}
