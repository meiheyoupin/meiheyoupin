package com.meiheyoupin.dao;

import com.meiheyoupin.entity.Saler;
import com.meiheyoupin.entity.SalerExample;
import com.meiheyoupin.entity.SalerKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalerMapper {

    List<Saler> selectByExample(SalerExample example);

}