package com.meiheyoupin.dao;

import com.meiheyoupin.entity.Staffer;
import com.meiheyoupin.entity.StafferExample;
import java.util.List;

public interface StafferMapper {

    List<Staffer> selectByExample(StafferExample example);

    List<String> selectBirthdays();
}