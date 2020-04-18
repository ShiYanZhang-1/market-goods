package top.shiyana.marketgoods.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ProjectName: market-goods
 * @Package: top.shiyana.marketgoods.pojo.dto
 * @ClassName: ResponseDto
 * @Author: dangerous
 * @Description:
 * @Date: 2020/4/18 13:04
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {

    /**
     * 返回用户的结果
     *    true 成功
     *    false 失败
     */
    private Boolean res;

    /**
     * 返回的提示信息
     */
    private String msg;

    /**
     * 返回的数据
     */
    private Object data;

    /**
     * 返回的状态码
     */
    private Integer status = 200;

    /**
     * 错误的返回状态码
     */
    private Integer errorCode;

    /**
     * 返回简单的成功信息
     * @param msg
     * @return
     */
    public static ResponseDto ok(String msg){
        return new ResponseDto(true,msg,null,200,null);
    }

    /**
     * 返回带有相应数据成功结果
     * @param msg
     * @param data
     * @return
     */
    public static ResponseDto ok(String msg,Object data){
        return new ResponseDto(true,msg,data,200,null);
    }

    /**
     * 返回带有结果以及响应状态的
     * @param msg
     * @param data
     * @param status
     * @param errorCode
     * @return
     */
    public static ResponseDto fail(String msg,Object data,Integer status,Integer errorCode){
        return new ResponseDto(false,msg,data,status,errorCode);
    }

    /**
     * 返回仅有错误信息的结果
     * @param msg
     * @return
     */
    public static ResponseDto fail(String msg){
        return new ResponseDto(false,msg,null,null,null);
    }

}
