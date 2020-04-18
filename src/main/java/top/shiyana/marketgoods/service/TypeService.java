package top.shiyana.marketgoods.service;

import top.shiyana.marketgoods.pojo.dto.ResponseDto;
import top.shiyana.marketgoods.pojo.entity.GoodsType;
import top.shiyana.marketgoods.pojo.vo.GoodsTypeVo;

import java.util.List;

/**
 * @ProjectName: market-goods
 * @Package: top.shiyana.marketgoods.service
 * @ClassName: TypeService
 * @Author: dangerous
 * @Description:
 * @Date: 2020/4/18 13:02
 * @Version: 1.0
 */
public interface TypeService {

    ResponseDto add(GoodsType type);

    List<GoodsTypeVo> getTypesByParentId(Integer id);
}
