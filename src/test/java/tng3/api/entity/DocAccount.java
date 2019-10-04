package tng3.api.entity;



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
