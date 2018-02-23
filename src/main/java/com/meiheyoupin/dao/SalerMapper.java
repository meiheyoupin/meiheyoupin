package com.meiheyoupin.dao;

import com.meiheyoupin.entity.Saler;
import com.meiheyoupin.entity.SalerExample;
import com.meiheyoupin.entity.SalerKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author vincent
 */
public interface SalerMapper {

    List<Saler> selectSalers();

    int insertSaler(Saler saler);

    Integer selectSalerByCode(String invitationCode);

    int updateSaler(Saler saler);

    int deleteSaler(Integer id);
}