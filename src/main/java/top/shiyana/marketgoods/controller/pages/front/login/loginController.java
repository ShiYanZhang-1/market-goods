package top.shiyana.marketgoods.controller.pages.front.login;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.shiyana.marketgoods.pojo.entity.User;
import top.shiyana.marketgoods.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: market-goods
 * @Package: top.shiyana.marketgoods.controller.pages.front
 * @ClassName: loginController
 * @Author: dangerous
 * @Description:
 * @Date: 2020/4/16 16:06
 * @Version: 1.0
 */
@Controller
@RequestMapping("/pages/front")
public class loginController {

    @Resource
    private UserService userService;

    @RequestMapping("loginPage")
    public String loginPage(){
        return "/pages/front/login/loginPage";
    }


    @RequestMapping("login")
    public String login(User user, Model model, HttpServletRequest request){

        //如果手机号格式正确 非空
        if(StringUtils.isNotBlank(user.getPhone())){
            User loginUser = userService.login(user);
            if(loginUser!=null){ //如果查询出用户 返回首页并将用户信息放入session中
                request.getSession().setAttribute("loginUser",loginUser);
                return "redirect:/pages/back/index";
            }
            model.addAttribute("errMsg","⚠️警告：手机号或者密码有误，请重试！");
            return "/pages/front/login/loginPage";

        }
        model.addAttribute("errMsg","⚠️警告：请输入手机号在登录！");
        return "/pages/front/login/loginPage";
    }

}
