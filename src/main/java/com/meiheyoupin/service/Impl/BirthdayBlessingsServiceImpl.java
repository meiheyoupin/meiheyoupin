package com.meiheyoupin.service.Impl;

import com.meiheyoupin.dao.BirthdayBlessingsMapper;
import com.meiheyoupin.service.BirthdayBlessingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author vincent
 */
@Service
@Transactional
public class BirthdayBlessingsServiceImpl implements BirthdayBlessingsService{

    @Autowired
    BirthdayBlessingsMapper birthdayBlessingsMapper;

    @Override
    public String getMsgByCompany(String companyCreditCode) {
        return birthdayBlessingsMapper.selectMsgByCompany(companyCreditCode);
    }
}
