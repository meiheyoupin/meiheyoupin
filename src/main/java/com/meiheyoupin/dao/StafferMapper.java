package com.meiheyoupin.dao;

import com.meiheyoupin.entity.Staffer;
import com.meiheyoupin.entity.StafferExample;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author vincent
 */
@Repository
public interface StafferMapper {

    List<Staffer> selectByExample(StafferExample example);

    List<String> selectBirthdays();
}