package com.fang.fangshop.dao.impl;

import com.fang.fangshop.been.AreaModel;
import com.fang.fangshop.core.common.PageModel;
import com.fang.fangshop.core.dao.BaseDao;
import com.fang.fangshop.dao.IAreaDao;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("areaDao")
public class AreaDaoImpl implements IAreaDao {
	@Resource
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public int insert(AreaModel e) {
		return baseDao.insert("manage.area.insert",e);
	}

	@Override
	public int delete(AreaModel e) {
		return baseDao.delete("manage.area.deleteById",e.getId());
	}

	@Override
	public int update(AreaModel e) {
		return baseDao.update("manage.area.updateById",e);
	}

	@Override
	public AreaModel selectOne(AreaModel e) {
		return baseDao.selectOne("manage.area.selectById",e.getId());
	}

	@Override
	public PageModel selectPageList(AreaModel e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AreaModel> selectList(AreaModel e) {
		return baseDao.selectList("manage.area.selectAll");
	}

	@Override
	public int deleteById(int id) {
		return baseDao.delete("manage.area.deleteById",id);
	}

	@Override
	public AreaModel selectById(String id) {
		return baseDao.selectOne("manage.area.selectById", id);
	}

	@Override
	public List<AreaModel> getListAll() {
		return baseDao.selectList("manage.area.selectAll");
	}

	@Override
	public List<AreaModel> getAreaByCode(String code) {
		return baseDao.selectList("manage.area.selectByCode", code);
	}

    @Override
    public boolean exists(String code){
        int count = baseDao.selectOne("manage.area.exists",code);
        if(count>0){
            return true;
        } else {
            return false;
        }
    }
}
