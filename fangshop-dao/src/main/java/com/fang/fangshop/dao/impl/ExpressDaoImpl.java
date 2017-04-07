package com.fang.fangshop.dao.impl;

import com.fang.fangshop.core.been.Express;
import com.fang.fangshop.core.common.PageModel;
import com.fang.fangshop.core.dao.BaseDao;
import com.fang.fangshop.dao.IExpressDao;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangyantao on 2017/4/5.
 */
@Repository("expressDao")
public class ExpressDaoImpl implements IExpressDao {
    @Resource
    private BaseDao baseDao;
    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public int insert(Express express) {
        return baseDao.insert("manage.express.insert",express);
    }

    @Override
    public int delete(Express express) {
        return baseDao.delete("manage.express.deleteById",express.getId());
    }

    @Override
    public int update(Express express) {
        return baseDao.update("manage.express.updateById",express);
    }

    @Override
    public Express selectOne(Express express) {
        return baseDao.selectOne("manage.express.selectById",express.getId());
    }

    @Override
    public PageModel selectPageList(Express express) {
        return baseDao.selectPageList("manage.express.selectPageList","manage.express.selectPageCount",express);
    }

    @Override
    public List<Express> selectList(Express express) {
        return null;
    }

    @Override
    public int deleteById(int id) {
        return baseDao.delete("manage.express.deleteById",id);
    }

    @Override
    public Express selectById(String id) {
        return baseDao.selectOne("manage.express.selectById",id);
    }
}
