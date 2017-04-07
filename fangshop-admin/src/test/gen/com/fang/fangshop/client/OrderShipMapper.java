package com.fang.fangshop.client;

import com.fang.fangshop.been.OrderShip;

public interface OrderShipMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderShip record);

    int insertSelective(OrderShip record);

    OrderShip selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderShip record);

    int updateByPrimaryKey(OrderShip record);
}