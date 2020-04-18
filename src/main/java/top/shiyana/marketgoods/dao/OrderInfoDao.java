package top.shiyana.marketgoods.dao;

import top.shiyana.marketgoods.pojo.entity.OrderInfo;

public interface OrderInfoDao {
    int deleteByPrimaryKey(Integer orderInfoId);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(Integer orderInfoId);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);
}