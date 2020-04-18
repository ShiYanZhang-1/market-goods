package top.shiyana.marketgoods.controller.pages.back.goods;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.shiyana.marketgoods.pojo.dto.ResponseDto;
import top.shiyana.marketgoods.pojo.entity.Goods;
import top.shiyana.marketgoods.service.GoodsService;
import top.shiyana.marketgoods.service.TypeService;
import top.shiyana.marketgoods.sys.SysConstant;
import top.shiyana.marketgoods.sys.UploadFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: market-goods
 * @Package: top.shiyana.marketgoods.controller.pages.back.goods
 * @ClassName: GoodsController
 * @Author: dangerous
 * @Description:
 * @Date: 2020/4/17 08:47
 * @Version: 1.0
 */
@Controller
@RequestMapping("/pages/back/goods")
public class GoodsController {


    @Autowired
    private GoodsService goodsService;

    @Autowired
    private TypeService typeService;

    @RequestMapping("addGoods")
    public String addGoods(Model model){
        model.addAttribute("types",typeService.getTypesByParentId(-1));
        return "/pages/back/goods/addGoods";
    }

    @ResponseBody
    @PostMapping("add")
    public Map<String,Object> add(Goods goods, MultipartFile pic){
//        System.err.println(goods);
        //前段春来onSale字段为on代表在售
        if("on".equals(goods.getOnSale())){
            goods.setOnSale(SysConstant.IS_ON_SALE_TRUE);
        }else{
            goods.setOnSale(SysConstant.IS_ON_SALE_FALSE);
        }
        Map<String, Object> map = goodsService.addGoods(goods, pic);
        return map;
    }


    @PostMapping("getGoodsBytypiId/{id}")
    @ResponseBody
    public ResponseDto getGoodsBytypiId(@PathVariable("id") Integer id){
         return goodsService.getGoodsBytypiId(id);
    }


    @ResponseBody
    @RequestMapping("test")
    public Map<String,Object> test(String text){

        Map<String, Object> map = new HashMap<>();

        if ("123".equals(text)){
            map.put("data","成功");
        }else{
            map.put("data","失败");
        }
        return map;
    }
}
