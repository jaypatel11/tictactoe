package com.appfolio.test.enums;

public enum MarkTypeEnum {

    CROSS("X"), ZERO("0"), EMPTY(" ");

    private String type;
    MarkTypeEnum(String type) {
        this.type = type;
    }

    public String value(){
        return this.type;
    }



}
