package tng3.tests.guestapi.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import tng3.base.Entity;


public class PinCodeRequest implements Entity {

    @JsonInclude(JsonInclude.Include.NON_NULL) public String email;
    @JsonInclude(JsonInclude.Include.NON_NULL) public String phone;



    public PinCodeRequest(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    public PinCodeRequest() {
        this(null,null);
    }

}
