package top.shiyana.marketgoods.pojo.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * shop_car
 * @author 
 */
@Data
public class ShopCar implements Serializable {
    /**
     * 购物车id
     */
    private Integer shopCarId;

    /**
     * 用户的id
     */
    private Integer userId;

    /**
     * 商品id
     */
    private Integer goodsId;

    /**
     * 商品数量
     */
    private Integer count;

    private static final long serialVersionUID = 1L;
}