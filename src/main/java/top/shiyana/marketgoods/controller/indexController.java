package top.shiyana.marketgoods.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.shiyana.marketgoods.dao.GoodsTypeDao;
import top.shiyana.marketgoods.dao.UserDao;
import top.shiyana.marketgoods.pojo.entity.User;
import top.shiyana.marketgoods.service.TypeService;

import javax.annotation.Resource;

/**
 * @ProjectName: market-goods
 * @Package: top.shiyana.marketgoods.controller
 * @ClassName: indexController
 * @Author: dangerous
 * @Description:
 * @Date: 2020/4/16 11:52
 * @Version: 1.0
 */
@Controller
public class indexController {

    @Resource
    private UserDao userDao;

    @Resource
    private TypeService typeService;

    @ResponseBody
    @RequestMapping("/user/{id}")
    public String idnex(@PathVariable("id") int id){
        User user = userDao.selectByPrimaryKey(1);
        System.out.println(user);
        return user.getNickName()+"Hello World!!!";
    }

    @RequestMapping("/")
    public String idnexVal(Model model){
        model.addAttribute("typeList", typeService.getTypesByParentId(-1));
        return "index";
    }
}
