package top.shiyana.marketgoods.dao;

import org.apache.ibatis.annotations.Mapper;
import top.shiyana.marketgoods.pojo.entity.User;

@Mapper
public interface UserDao {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByPhone(String phone);
}