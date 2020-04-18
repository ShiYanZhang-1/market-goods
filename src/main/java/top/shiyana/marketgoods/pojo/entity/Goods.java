package top.shiyana.marketgoods.pojo.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * goods
 * @author 
 */
@Data
public class Goods implements Serializable {
    /**
     * 商品id
     */
    private Integer goodsId;

    /**
     * 商品类型id
     */
    private Integer goodsTypeId;

    /**
     * 商品名称标题
     */
    private String title;

    /**
     * 图片保存路径
     */
    private String img;

    /**
     * 商品原价
     */
    private Double oldPrice;

    /**
     * 现价
     */
    private Double price;

    /**
     * 是否在售 YES 或者NO
     */
    private String onSale;

    /**
     * 商品详情
     */
    private String detail;

    /**
     * 库存
     */
    private Integer count;

    /**
     * 商家名称
     */
    private String merchantName;

    /**
     * 评价数量
     */
    private Integer evaluationCount;

    private static final long serialVersionUID = 1L;
}