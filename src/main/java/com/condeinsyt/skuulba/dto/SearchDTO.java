package com.condeinsyt.skuulba.dto;

public class SearchDTO {

    private int param;
    private String value;


    public int getParam() {
        return param;
    }

    public void setParam(int param) {
        this.param = param;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SearchDTO{" +
                "param=" + param +
                ", value='" + value + '\'' +
                '}';
    }
}
