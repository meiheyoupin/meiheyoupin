package com.meiheyoupin.dao;

import com.meiheyoupin.entity.BirthdayBlessings;
import com.meiheyoupin.entity.BirthdayBlessingsExample;
import java.util.List;

public interface BirthdayBlessingsMapper {

    List<BirthdayBlessings> selectByExample(BirthdayBlessingsExample example);

    String selectMsgByCompany(Integer company);
}