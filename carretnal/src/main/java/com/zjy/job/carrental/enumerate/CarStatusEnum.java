package com.zjy.job.carrental.enumerate;

public enum CarStatusEnum {
    AVAILABLE("A","available"),
    MAINTAINING("M","maintainng"),
    RENTED("R","RENTED"),
    INVALID("I","invalid");

    private String key;
    private String value;

    CarStatusEnum(String key,String value){
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
