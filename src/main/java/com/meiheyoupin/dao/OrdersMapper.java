package com.meiheyoupin.dao;

import com.meiheyoupin.entity.MonthlyCount;
import com.meiheyoupin.entity.Orders;
import com.meiheyoupin.entity.WithdrawCash;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author vincent
 */
@Repository
public interface OrdersMapper {

    List<Orders> listOrderByObj(Orders orders);

    List<Orders> selectByState(Integer state);

    int selectOrderSize(Integer state);

    Orders selectOrderById(String id);

    int updateOrderById(Orders orders);

    MonthlyCount selectMonthlySalesByStoreId(Integer storeId);

    double selectMonthlyCarriageByStoreId(Integer storeId);

    List<WithdrawCash>  selectAvaiableWithdrawCash();

    List<Orders> selectOrdersForSalerInviteCode(String inviteCode);
}