package top.shiyana.marketgoods.service;

import top.shiyana.marketgoods.pojo.entity.User;

/**
 * @ProjectName: market-goods
 * @Package: top.shiyana.marketgoods.service
 * @ClassName: UserService
 * @Author: dangerous
 * @Description:
 * @Date: 2020/4/16 21:05
 * @Version: 1.0
 */
public interface UserService {

    User login(User user);
}
