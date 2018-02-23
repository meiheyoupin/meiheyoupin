package com.meiheyoupin.service.Impl;


import com.meiheyoupin.dao.DemandMapper;
import com.meiheyoupin.entity.Demand;
import com.meiheyoupin.entity.DemandExample;
import com.meiheyoupin.service.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author vincent
 */
@Service
@Transactional
public class DemandServiceImpl implements DemandService{

    @Autowired
    DemandMapper demandMapper;

    @Override
    public List<Demand> getDemands() {
        List<Map<String,Object>> list = new ArrayList<>();






        DemandExample example = new DemandExample();
        DemandExample.Criteria criteria = example.createCriteria();
        criteria.andStateEqualTo((byte)1);
        return demandMapper.selectByExample(example);
    }
}
