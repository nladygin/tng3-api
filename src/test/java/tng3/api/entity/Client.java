package tng3.api.entity;


public class Client implements Entity {

    public int id;
    public String lastName;
    public String firstName;
    public String secondName;



    @Override
    public String asJsonString() {
        return null;
    }

    public Client(){}

}
