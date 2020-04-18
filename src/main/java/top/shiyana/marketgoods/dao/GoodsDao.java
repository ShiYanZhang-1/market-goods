package top.shiyana.marketgoods.dao;

import top.shiyana.marketgoods.pojo.entity.Goods;

import java.util.List;

public interface GoodsDao {
    int deleteByPrimaryKey(Integer goodsId);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer goodsId);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    /**
     * 根据类型id查询所有商品
     * @param id
     * @return
     */
    List<Goods> getGoodsBytypiId(Integer id);
}