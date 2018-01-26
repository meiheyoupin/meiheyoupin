package com.meiheyoupin.dao;

import com.meiheyoupin.entity.Refund;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RefundMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Refund record);

    int insertSelective(Refund record);

    Refund selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Refund record);

    int updateByPrimaryKey(Refund record);

    List<Refund> selectByState(Integer state);

    int updateRefund(Refund refund);
}