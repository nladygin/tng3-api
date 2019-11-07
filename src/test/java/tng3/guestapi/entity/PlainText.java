package tng3.guestapi.entity;

import tng3.base.Entity;

public class PlainText implements Entity {

    private String body;


    @Override
    public String asJsonString() {
        return body;
    }

    public PlainText() {}

    public PlainText(String body){
        this.body = body;
    }

}
