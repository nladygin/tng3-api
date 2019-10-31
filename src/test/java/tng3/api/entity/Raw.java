package tng3.api.entity;

import tng3.base.Entity;

public class Raw implements Entity {

    private String body;



    @Override
    public String asJsonString() {
        return body;
    }

    public Raw() {}

    public Raw(String body){
        this.body = body;
    }
}
