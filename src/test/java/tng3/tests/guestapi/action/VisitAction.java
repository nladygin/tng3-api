package tng3.tests.guestapi.action;

import io.restassured.http.Method;
import org.springframework.stereotype.Component;
import tng3.base.APIResponse;
import tng3.base.Action;

import java.util.HashMap;

@Component
public class VisitAction extends Action {

    private final String endpoint = "/api/visit";



    public APIResponse getVisits(boolean isHotel){
        HashMap<String, String> additional = new HashMap<>();
        if (isHotel) {
            additional.put("hotel", "true");
        }
        if (additional.isEmpty()) {
            additional = null;
        }
        return requestHelper.go(endpoint, Method.GET, null, additional);
    }


}
