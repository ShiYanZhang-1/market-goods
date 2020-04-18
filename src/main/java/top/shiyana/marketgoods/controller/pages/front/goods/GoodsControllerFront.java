package top.shiyana.marketgoods.controller.pages.front.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import top.shiyana.marketgoods.pojo.dto.ResponseDto;
import top.shiyana.marketgoods.service.GoodsService;

/**
 * @ProjectName: market-goods
 * @Package: top.shiyana.marketgoods.controller.pages.front.goods
 * @ClassName: GoodsControllerFront
 * @Author: dangerous
 * @Description:
 * @Date: 2020/4/18 21:28
 * @Version: 1.0
 */
@Controller
@RequestMapping("/pages/front/goods")
public class GoodsControllerFront {

    @Autowired
    private GoodsService service;

    @RequestMapping("goodsDetail/{id}")
    public String goodsDetail(@PathVariable("id") Integer id, Model model){

        model.addAttribute("goodsDetail",service.goodsDetail(id));
        return "/pages/front/goods/goodsDetail";

    }
}
