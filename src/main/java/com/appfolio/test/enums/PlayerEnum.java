package com.appfolio.test.enums;

public enum  PlayerEnum {

    HUMAN("HUMAN"),
    COMPUTER("COMPUTER");

    private String player;
    PlayerEnum(String player) {
        this.player = player;
    }

    public String value(){
        return this.player;
    }

}
