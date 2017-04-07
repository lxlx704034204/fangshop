package com.fang.fangshop.services.impl;

import com.fang.fangshop.core.service.ServicesManager;
import com.fang.fangshop.core.system.been.Privilege;
import com.fang.fangshop.dao.IPrivilegeDao;
import com.fang.fangshop.services.IPrivilegeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by wangyantao on 2017/3/16.
 */
@Service("privilegeService")
public class PrivilegeServiceImpl extends ServicesManager<Privilege,IPrivilegeDao> implements IPrivilegeService {
    @Resource(name="privilegeDao")
    @Override
    protected void setDao(IPrivilegeDao iPrivilegeDao) {
        this.dao = iPrivilegeDao;
    }

    @Override
    public int deleteByRid(int rid) {
        return dao.deleteByRid(rid);
    }

    @Override
    public boolean isExistsByMidAndRid(Privilege privilege) {
        int num = dao.isExistsByMidAndRid(privilege);
        if (num > 0) {
            return true;
        } else {
            return false;
        }
    }
}
