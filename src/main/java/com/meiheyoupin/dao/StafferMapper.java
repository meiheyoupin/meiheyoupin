package com.meiheyoupin.dao;

import com.meiheyoupin.entity.Staffer;
import com.meiheyoupin.entity.StafferExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StafferMapper {

    List<Staffer> selectByExample(StafferExample example);

    List<String> selectBirthdays();
}