package tng3.guestapi.entity;

import tng3.base.Entity;


public class Credentials implements Entity {

    public String username;
    public String password;


    public Credentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Credentials() {
        this(null, null);
    }
}
