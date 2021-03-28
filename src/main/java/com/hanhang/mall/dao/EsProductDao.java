package com.hanhang.mall.dao;

import com.hanhang.mall.nosql.elasticsearch.document.EsProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 搜索系统中的商品管理自定义Dao
 * Created by macro on 2018/6/19.
 */
@Mapper
public interface EsProductDao {
    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
