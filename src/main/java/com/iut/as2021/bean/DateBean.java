package com.iut.as2021.bean;

import static java.time.LocalTime.now;

public class DateBean {

    private String dateTimeString = now().toString();

    public String getDateTime() {
        return dateTimeString;
    }
}
