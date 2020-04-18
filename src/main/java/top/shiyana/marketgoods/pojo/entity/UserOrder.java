package top.shiyana.marketgoods.pojo.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * user_order
 * @author 
 */
@Data
public class UserOrder implements Serializable {
    /**
     * 订单id根据时间戳生成
     */
    private String orderId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 总金额
     */
    private Double allCost;

    /**
     * 下单时间
     */
    private Date createTime;

    /**
     * 付款时间
     */
    private Date payTime;

    /**
     * 收货人电话
     */
    private String receiverPhone;

    /**
     * 收货人名字
     */
    private String receiverName;

    /**
     * 收货地址
     */
    private String receiverAddress;

    /**
     * 付款方式 支付宝微信或者银行卡
     */
    private String payType;

    /**
     * 订单状态  代付款，待收货，待评价，已退款，已取消
     */
    private String status;

    /**
     * 实际付款
     */
    private Double actualPayment;

    /**
     * 总减免金额
     */
    private Double totalDeduction;

    private static final long serialVersionUID = 1L;
}