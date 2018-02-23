package com.meiheyoupin.dao;

import com.meiheyoupin.entity.BirthdayBlessings;
import com.meiheyoupin.entity.BirthdayBlessingsExample;
import java.util.List;

/**
 * @author vincent
 */
public interface BirthdayBlessingsMapper {

    List<BirthdayBlessings> selectByExample(BirthdayBlessingsExample example);

    String selectMsgByCompany(String companyCreditCode);

    int insertBirthdayBlessings(String companyCreditCode);
}