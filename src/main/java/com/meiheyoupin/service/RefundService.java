package com.meiheyoupin.service;


import com.meiheyoupin.entity.Refund;

import java.util.List;

public interface RefundService {

    List<Refund> getRefundsByState(Integer state);

    void modifyRefundById(Integer id);

}
