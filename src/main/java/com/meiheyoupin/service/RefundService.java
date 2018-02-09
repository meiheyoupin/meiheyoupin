package com.meiheyoupin.service;


import com.meiheyoupin.entity.Refund;

import java.util.List;

public interface RefundService {

    List<Refund> getRefundsByState(Integer state);

    int auditRefund(Integer id);

    int unAuditRefund(Integer id,String reason);
}
