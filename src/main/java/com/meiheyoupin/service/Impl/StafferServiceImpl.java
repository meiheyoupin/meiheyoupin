package com.meiheyoupin.service.Impl;

import com.meiheyoupin.dao.StafferMapper;
import com.meiheyoupin.entity.Staffer;
import com.meiheyoupin.entity.StafferExample;
import com.meiheyoupin.service.StafferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StafferServiceImpl implements StafferService{

    @Autowired
    StafferMapper stafferMapper;

    @Override
    public List<Staffer> getStaffers() {
        return stafferMapper.selectByExample(new StafferExample());
    }

    @Override
    public List<String> getBirthdays() {
        return stafferMapper.selectBirthdays();
    }
}
