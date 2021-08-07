package tng3.common.entity;

import tng3.base.Entity;

public class Value implements Entity {

    public String code;
    public String description;

    public Value(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public Value(){

    }
}
