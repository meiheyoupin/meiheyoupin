package com.meiheyoupin.service;


import java.util.List;
import java.util.Map;

public interface RegionService {

    public List<Map<String, Object>> getChildRegionList(Map<String, Object> param);

    public String getDetailAddress(long regionId, String address);
}
