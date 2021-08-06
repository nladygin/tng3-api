package tng3.tests.guestapi.action;

import io.restassured.http.Method;
import org.springframework.stereotype.Component;
import tng3.base.APIResponse;
import tng3.base.Action;

import java.util.HashMap;

@Component
public class TherapistAction extends Action {

    private final String endpoint = "/api/therapist";



    public APIResponse getTherapists(int outletID){
        HashMap<String, String> additional = new HashMap<>();
        additional.put("outlet_id", String.valueOf(outletID));
        return requestHelper.go(endpoint, Method.GET, null, additional);
    }


}
