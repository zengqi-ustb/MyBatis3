package com.zeng;

import com.zeng.domain.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

/**
 * Created by zeng on 17-3-1.
 */
@Mapper
public interface GoodsMapper {
        @SelectProvider(type = GoodsDaoSelectProvider.class, method = "findGoods")
        List<Goods> selectGoods(@Param(value = "pageNum")int pageNum, @Param(value = "pageSize")int pageSize, @Param(value = "platform")String platform, @Param(value = "fundType") String fundType);
}
