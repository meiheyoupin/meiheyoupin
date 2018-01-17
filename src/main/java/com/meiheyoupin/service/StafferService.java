package com.meiheyoupin.service;

import com.meiheyoupin.entity.Staffer;

import java.util.List;

/**
 * Created by w2tto on 2018/1/17.
 */
public interface StafferService {

    List<Staffer> getStaffers();

    List<String> getBirthdays();
}
