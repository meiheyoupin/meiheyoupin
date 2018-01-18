package com.meiheyoupin.service.Impl;

import com.meiheyoupin.common.utils.ConvertUtil;
import com.meiheyoupin.dao.RegionMapper;
import com.meiheyoupin.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    RegionMapper regionMapper;

    @Override
    public List<Map<String, Object>> getChildRegionList(Map<String, Object> param) {
        List<Map<String, Object>> regions=regionMapper.getChildRegionList(param);
        ConvertUtil.convertDataBaseMapToJavaMap(regions);
        return regions;
    }

    @Override
    public String getDetailAddress(long regionId, String address) {
        Map query=new HashMap();
        query.put("regionId",regionId);
        String res=regionMapper.getRegionDetailName(query)+" "+address;
        return res;
    }
}