package top.shiyana.marketgoods.controller.pages.back.type;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.shiyana.marketgoods.pojo.dto.ResponseDto;
import top.shiyana.marketgoods.pojo.entity.GoodsType;
import top.shiyana.marketgoods.service.TypeService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: market-goods
 * @Package: top.shiyana.marketgoods.controller.pages.back.type
 * @ClassName: TypeController
 * @Author: dangerous
 * @Description:
 * @Date: 2020/4/18 11:53
 * @Version: 1.0
 */
@Controller
@RequestMapping("/pages/back/type")
public class TypeController {

    @Resource
    private TypeService service;


    @RequestMapping("addType")
    public String addTypes(Model model) {
        model.addAttribute("typeList",service.getTypesByParentId(-1));
        return "/pages/back/types/addTypes";
    }

    @ResponseBody
    @PostMapping("add")
    public ResponseDto add(GoodsType type) {
        return service.add(type);
    }

}
