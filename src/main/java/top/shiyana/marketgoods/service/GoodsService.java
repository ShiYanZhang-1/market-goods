package top.shiyana.marketgoods.service;

import org.springframework.web.multipart.MultipartFile;
import top.shiyana.marketgoods.pojo.dto.ResponseDto;
import top.shiyana.marketgoods.pojo.entity.Goods;

import java.util.Map;

/**
 * @ProjectName: market-goods
 * @Package: top.shiyana.marketgoods.service
 * @ClassName: GoodsService
 * @Author: dangerous
 * @Description:
 * @Date: 2020/4/17 17:28
 * @Version: 1.0
 */
public interface GoodsService {

    Map<String,Object> addGoods(Goods goods, MultipartFile pic) ;

    /**
     * 根据类型id查询所有商品
     * @param id
     * @return
     */
    ResponseDto getGoodsBytypiId(Integer id);

    Goods goodsDetail(Integer id);
}
