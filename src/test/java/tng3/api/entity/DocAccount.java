package tng3.api.entity;


import tng3.base.Entity;

public class DocAccount implements Entity {

    public String code;
    public String name;
    public float amount;



    @Override
    public String asJsonString() {
        return null;
    }

    public DocAccount(){}

}
