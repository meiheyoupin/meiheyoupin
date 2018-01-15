package com.meiheyoupin.service.Impl;

import com.meiheyoupin.dao.SalerMapper;
import com.meiheyoupin.entity.Saler;
import com.meiheyoupin.entity.SalerExample;
import com.meiheyoupin.service.SalerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalerServiceImpl implements SalerService {

    @Autowired
    SalerMapper salerMapper;

    @Override
    public List<Saler> getSaler() {
        return salerMapper.selectByExample(new SalerExample());
    }


}
