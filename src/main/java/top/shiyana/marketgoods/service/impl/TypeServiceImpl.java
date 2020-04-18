package top.shiyana.marketgoods.service.impl;

import org.springframework.stereotype.Service;
import top.shiyana.marketgoods.dao.GoodsTypeDao;
import top.shiyana.marketgoods.pojo.dto.ResponseDto;
import top.shiyana.marketgoods.pojo.entity.GoodsType;
import top.shiyana.marketgoods.pojo.vo.GoodsTypeVo;
import top.shiyana.marketgoods.service.TypeService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ProjectName: market-goods
 * @Package: top.shiyana.marketgoods.service.impl
 * @ClassName: TypeServiceImpl
 * @Author: dangerous
 * @Description:
 * @Date: 2020/4/18 13:19
 * @Version: 1.0
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Resource
    private GoodsTypeDao dao;

    @Override
    public ResponseDto add(GoodsType type) {
        int i = dao.insertSelective(type);
        if(i>0){
            return ResponseDto.ok("添加成功");
        }
        return ResponseDto.fail("添加失败");
    }

    @Override
    public List<GoodsTypeVo> getTypesByParentId(Integer id) {
        //查询出顶级父类类型的集合
        List<GoodsTypeVo> parentId = dao.getTypesByParentId(id);
        //通过顶级父类查询出所有子类类型
        List<GoodsTypeVo> typesByParentIds = dao.getTypesByParentIds(parentId);
        //通过stream将所有的子类的类型根据父类的id分组
        Map<Integer, List<GoodsTypeVo>> collect = typesByParentIds.stream().collect(Collectors.groupingBy(GoodsTypeVo::getParentTypeId));
        //便利循环每一个顶级父类
        for (GoodsTypeVo goodsTypeVo : parentId) {
            //从子类map中获取当前顶级父类id的元素
            List<GoodsTypeVo> childrenTypes = collect.get(goodsTypeVo.getGoodsTypeId());
            //将有子类的添加到当前父类的子类中
            goodsTypeVo.setChildrenTypes(childrenTypes);
        }
        return parentId;
    }
}
