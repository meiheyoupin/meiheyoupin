package com.meiheyoupin.service;

import com.meiheyoupin.common.utils.R;

import java.util.Map;

public interface RefundService {

    R getRefundsByState();

    Map<String, Object> auditRefund(Integer id);

    R unAuditRefund(Integer id,String reason);
}
