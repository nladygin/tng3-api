package tng3.api.entity;

import java.util.HashMap;
import java.util.Objects;

public class APIResponse {

    private boolean success;
    private Object payload;
    private HashMap<String, Object> error;


    public boolean getSuccess(){
        return success;
    }

    public Object getPayload(){
        return payload;
    }

    public HashMap<String, Object> getError(){
        return error;
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        APIResponse response = (APIResponse) o;
        return success == response.success &&
                Objects.equals(payload, response.payload) &&
                Objects.equals(error, response.error);
    }

    @Override
    public int hashCode() {
        return Objects.hash(success, payload, error);
    }
}
