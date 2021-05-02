package com.zjy.job.carrental.enumerate;

public enum OrderStatusEnum {
    TOPAY("P","topay"),
    TOGET("G","toget"),
    ACTIVE("A","active"),
    RETURNED("R","returned"),
    CANCELLED("C","cancelled");

    private String key;
    private String value;

    OrderStatusEnum(String key,String value){
        this.key = key;
        this.value = value;
    }
    public String getKey(){
        return key;
    }
    public String getValue(){
        return value;
    }
}
