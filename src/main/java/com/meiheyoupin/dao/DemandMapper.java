package com.meiheyoupin.dao;

import com.meiheyoupin.entity.Demand;
import com.meiheyoupin.entity.DemandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DemandMapper {
    long countByExample(DemandExample example);

    int deleteByExample(DemandExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Demand record);

    int insertSelective(Demand record);

    List<Demand> selectByExample(DemandExample example);

    Demand selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Demand record, @Param("example") DemandExample example);

    int updateByExample(@Param("record") Demand record, @Param("example") DemandExample example);

    int updateByPrimaryKeySelective(Demand record);

    int updateByPrimaryKey(Demand record);
}