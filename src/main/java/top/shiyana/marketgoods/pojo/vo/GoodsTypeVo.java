package top.shiyana.marketgoods.pojo.vo;

import lombok.Data;
import top.shiyana.marketgoods.pojo.entity.GoodsType;

import java.util.List;

/**
 * @ProjectName: market-goods
 * @Package: top.shiyana.marketgoods.pojo.vo
 * @ClassName: GoodsTypeVo
 * @Author: dangerous
 * @Description:
 * @Date: 2020/4/18 14:08
 * @Version: 1.0
 */
@Data
public class GoodsTypeVo extends GoodsType {

    private List<GoodsTypeVo> childrenTypes;

}
