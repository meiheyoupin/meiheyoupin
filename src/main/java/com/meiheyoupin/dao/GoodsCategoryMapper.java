package com.meiheyoupin.dao;

import com.meiheyoupin.entity.GoodsCategory;
import org.springframework.stereotype.Repository;

/**
 * @author vincent
 */
@Repository
public interface GoodsCategoryMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsCategory record);

    int insertSelective(GoodsCategory record);

    GoodsCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsCategory record);

    int updateByPrimaryKey(GoodsCategory record);
}