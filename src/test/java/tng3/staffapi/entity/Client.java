package tng3.staffapi.entity;

import tng3.base.Entity;

public class Client implements Entity {

    private int id;
    private String first_name;
    private String second_name;
    private String last_name;
    private String membership;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }
}
