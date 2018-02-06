package com.meiheyoupin.common;

import java.time.LocalDate;

public class test {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        date = date.minusMonths(1);
        System.out.println(date.getYear()+"-"+date.getMonthValue());
    }
}
