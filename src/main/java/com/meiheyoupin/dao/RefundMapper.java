package com.meiheyoupin.dao;

import com.meiheyoupin.entity.Refund;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author vincent
 */
@Repository
public interface RefundMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Refund record);

    int insertSelective(Refund record);

    Refund selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Refund record);

    int updateByPrimaryKey(Refund record);

    List<Refund> selectRefundsToAuditByAdmin(Map map);

    int updateRefund(Refund refund);
}