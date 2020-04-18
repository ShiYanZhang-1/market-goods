package top.shiyana.marketgoods.pojo.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * goods_type
 * @author 
 */
@Data
public class GoodsType implements Serializable {
    /**
     * 商品类型id
     */
    private Integer goodsTypeId;

    /**
     * 父级类型id
     */
    private Integer parentTypeId;

    /**
     * 类型名称
     */
    private String typeName;

    /**
     * 类型序号，排序
     */
    private Integer sort;

    /**
     * 图标样式
     */
    private String iconClass;

    private static final long serialVersionUID = 1L;
}