package com.meiheyoupin.service;


import com.meiheyoupin.entity.Saler;

import java.util.List;

public interface SalerService {

    List<Saler> getSalers();

    void addSaler(Saler saler);

    void putSaler(Saler saler);

    void removeSaler(Integer id);
}

