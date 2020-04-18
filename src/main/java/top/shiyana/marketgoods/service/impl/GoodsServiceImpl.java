package top.shiyana.marketgoods.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.shiyana.marketgoods.dao.GoodsDao;
import top.shiyana.marketgoods.pojo.dto.ResponseDto;
import top.shiyana.marketgoods.pojo.entity.Goods;
import top.shiyana.marketgoods.service.GoodsService;
import top.shiyana.marketgoods.sys.UploadFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: market-goods
 * @Package: top.shiyana.marketgoods.service.impl
 * @ClassName: GoodsServiceImpl
 * @Author: dangerous
 * @Description:
 * @Date: 2020/4/17 17:29
 * @Version: 1.0
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private UploadFile uploadFile;

    @Resource
    private GoodsDao dao;


    @Override
    public Map<String,Object> addGoods(Goods goods, MultipartFile pic) {

        Map<String,Object> map = new HashMap<>();

        try {
            //没有上传图片 直接添加商品
            if( null==pic || pic.isEmpty()){
                dao.insertSelective(goods);
                map.put("res",true);
                map.put("msg","添加成功！！！");
                return map;
            }
            //上传文件非空 先写入本地硬盘并返回上传文件的路径
            String s = uploadFile.uploadFile(pic);
            //如果路径非空就执行保存
            if(StringUtils.isNotBlank(s)){
                goods.setImg(s);
                dao.insertSelective(goods);
                map.put("res",true);
                map.put("msg","添加成功！！！");
                return map;
            }else{ //如果上传路径为空就返回有误
                dao.insertSelective(goods);
                map.put("res",false);
                map.put("msg","添加成功！！！");
            }
        } catch (Exception e) {
            map.put("res",false);
            map.put("msg","上传文件有误，请重试");
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 根据类型id查询所有商品
     * @param id
     * @return
     */
    @Override
    public ResponseDto getGoodsBytypiId(Integer id) {
        List<Goods> list;
        try {
            list = dao.getGoodsBytypiId(id);
            return ResponseDto.ok("查询商品成功",list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.fail("查询商品失败！");
        }
    }

    @Override
    public Goods goodsDetail(Integer id) {
        return dao.selectByPrimaryKey(id);
    }
}
