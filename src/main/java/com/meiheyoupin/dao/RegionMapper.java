package com.meiheyoupin.dao;

import com.meiheyoupin.entity.Region;
import com.meiheyoupin.entity.RegionExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author vincent
 */
@Repository
public interface RegionMapper {

    List<Region> selectByExample(RegionExample example);

    List<Map<String, Object>> getChildRegionList(Map<String, Object> param);

    String getRegionDetailName(Map map);
}