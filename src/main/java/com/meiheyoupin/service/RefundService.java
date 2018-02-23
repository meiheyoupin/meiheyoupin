package com.meiheyoupin.service;


import com.meiheyoupin.entity.Refund;

import java.util.List;
import java.util.Map;

public interface RefundService {

    List<Refund> getRefundsByState(Integer state);

    Map<String, Object> auditRefund(Integer id);

    int unAuditRefund(Integer id,String reason);
}
