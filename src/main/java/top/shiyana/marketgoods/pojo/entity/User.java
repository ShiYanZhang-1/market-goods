package top.shiyana.marketgoods.pojo.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * user
 * @author 
 */
@Data
public class User implements Serializable {
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 真是名字
     */
    private String realName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 最后登录时间
     */
    private Date lastLoginTime;

    /**
     * 最后登录ip
     */
    private String lastLoginIp;

    private static final long serialVersionUID = 1L;
}