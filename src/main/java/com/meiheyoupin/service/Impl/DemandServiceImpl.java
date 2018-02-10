package com.meiheyoupin.service.Impl;


import com.meiheyoupin.dao.DemandMapper;
import com.meiheyoupin.entity.Demand;
import com.meiheyoupin.entity.DemandExample;
import com.meiheyoupin.service.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandServiceImpl implements DemandService{

    @Autowired
    DemandMapper demandMapper;

    @Override
    public List<Demand> getDemands() {
        DemandExample example = new DemandExample();
        DemandExample.Criteria criteria = example.createCriteria();
        criteria.andStateEqualTo((byte)1);
        return demandMapper.selectByExample(example);
    }
}
