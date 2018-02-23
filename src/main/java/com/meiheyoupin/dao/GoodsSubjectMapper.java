package com.meiheyoupin.dao;

import com.meiheyoupin.entity.GoodsSubject;
import org.springframework.stereotype.Repository;

/**
 * @author vincent
 */
@Repository
public interface GoodsSubjectMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsSubject record);

    int insertSelective(GoodsSubject record);

    GoodsSubject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsSubject record);

    int updateByPrimaryKey(GoodsSubject record);
}