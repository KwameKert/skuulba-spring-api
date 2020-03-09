package com.condeinsyt.skuulba.service;

import com.condeinsyt.skuulba.model.DailyFees;

import java.util.HashMap;

public interface DailyFeeService {

    HashMap<String, Object> addFee(DailyFees dailyFees);
}
