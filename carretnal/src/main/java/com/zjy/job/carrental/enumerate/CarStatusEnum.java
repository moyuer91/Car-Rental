package com.zjy.job.carrental.enumerate;

public enum CarStatusEnum {
    AVAILABLE(0,"available"),
    MAINTAINING(1,"maintainng"),
    RENTED(2,"RENTED"),
    INVALID(3,"invalid");

    private Integer key;
    private String value;

    CarStatusEnum(Integer key,String value){
        this.key = key;
        this.value = value;
    }
    public Integer getKey(){
        return key;
    }
    public String getValue(){
        return value;
    }
}
