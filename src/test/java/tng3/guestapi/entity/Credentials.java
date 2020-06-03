package tng3.guestapi.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import tng3.base.Entity;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Credentials implements Entity {

    public String magstripe;
    public String username;
    public String password;



    public Credentials(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public Credentials(String magstripe, String username, String password) {
        this.magstripe = magstripe;
        this.username = username;
        this.password = password;
    }

    public Credentials() {
        this(null, null);
    }
}
