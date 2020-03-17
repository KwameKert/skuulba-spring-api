package com.condeinsyt.skuulba.service.interfaces;

import com.condeinsyt.skuulba.dto.DailyFeeDTO;
import com.condeinsyt.skuulba.model.DailyFees;

import java.util.HashMap;

public interface DailyFeeService {

    HashMap<String, Object> addFee(DailyFeeDTO dailyFeeDTO );

    HashMap<String, Object> listFees();
}
