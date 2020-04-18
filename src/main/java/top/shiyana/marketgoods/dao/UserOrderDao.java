package top.shiyana.marketgoods.dao;

import top.shiyana.marketgoods.pojo.entity.UserOrder;

public interface UserOrderDao {
    int deleteByPrimaryKey(String orderId);

    int insert(UserOrder record);

    int insertSelective(UserOrder record);

    UserOrder selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(UserOrder record);

    int updateByPrimaryKey(UserOrder record);
}