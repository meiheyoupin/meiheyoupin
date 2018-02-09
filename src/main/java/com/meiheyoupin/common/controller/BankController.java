package com.meiheyoupin.common.controller;


import com.meiheyoupin.common.utils.BankInfo;
import com.meiheyoupin.common.utils.R1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {

    /**
     * 检查银行卡号
     * @param cardId    银行卡号
     * @return  如果卡号正确，返回所在银行名      如果卡号错误，返回500
     */
    @GetMapping("checkBankCard")
    public R1 checkBankCard(@RequestParam String cardId){
        if (!BankInfo.checkBankCard(cardId)){
            return R1.error("银行卡号错误");
        }
        return R1.success(BankInfo.getname(cardId));
    }

}
