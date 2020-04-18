package top.shiyana.marketgoods.pojo.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * order_info
 * @author 
 */
@Data
public class OrderInfo implements Serializable {
    /**
     * 订单详情id
     */
    private Integer orderInfoId;

    /**
     * 外键 订单id
     */
    private String orderId;

    /**
     * 原来商品的id
     */
    private Integer eriginGoodsId;

    /**
     * 下单时商品的价格
     */
    private Double price;

    /**
     * 当时这个商品下单数量
     */
    private Integer count;

    /**
     * 当时这个商品的图片路径
     */
    private String img;

    /**
     * 下单时的原价
     */
    private Double oldPrice;

    private static final long serialVersionUID = 1L;
}