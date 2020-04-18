package top.shiyana.marketgoods.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.shiyana.marketgoods.pojo.entity.GoodsType;
import top.shiyana.marketgoods.pojo.vo.GoodsTypeVo;

import java.util.List;

@Mapper
public interface GoodsTypeDao {
    int deleteByPrimaryKey(Integer goodsTypeId);

    int insert(GoodsType record);

    int insertSelective(GoodsType record);

    GoodsType selectByPrimaryKey(Integer goodsTypeId);

    int updateByPrimaryKeySelective(GoodsType record);

    int updateByPrimaryKey(GoodsType record);


    List<GoodsTypeVo> getTypesByParentId(Integer id);

    List<GoodsTypeVo> getTypesByParentIds(@Param("ids") List<GoodsTypeVo> parentId);
}