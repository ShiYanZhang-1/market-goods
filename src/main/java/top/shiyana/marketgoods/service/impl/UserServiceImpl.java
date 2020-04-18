package top.shiyana.marketgoods.service.impl;

import com.alibaba.druid.sql.dialect.db2.visitor.DB2SchemaStatVisitor;
import org.springframework.stereotype.Service;
import top.shiyana.marketgoods.dao.UserDao;
import top.shiyana.marketgoods.pojo.entity.User;
import top.shiyana.marketgoods.service.UserService;

import javax.annotation.Resource;

/**
 * @ProjectName: market-goods
 * @Package: top.shiyana.marketgoods.service.impl
 * @ClassName: UserServiceImpl
 * @Author: dangerous
 * @Description:
 * @Date: 2020/4/16 21:07
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    /**
     * 用户登录
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        User dbuser = userDao.selectByPhone(user.getPhone());
//        System.out.println(dbuser+"查询结果");
        if(dbuser == null){ //查询为空 代表数据库没有这个人
            return null;
        }else {  //查询不为空进行下一步
            if(user.getPassword()==null){ //如果输入的密码为空 查询失败
                return null;
            }else{ //如果输入密码不为空就判断是否相等
                if(dbuser.getPassword().equals(user.getPassword())){ //如果查询的密码和输入密码一样就代表登录成功
                    return user;
                }
            }
        }
        return null;
    }
}
