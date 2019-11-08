package tng3.guestapi.action;

import io.restassured.http.Method;
import org.springframework.stereotype.Component;
import tng3.base.APIResponse;
import tng3.base.Action;

import java.util.HashMap;

@Component
public class ClassAction extends Action {

    private final String endpoint = "/api/classes";



    public APIResponse getClasses(Integer outletID){
        HashMap<String, String> additional = new HashMap<>();
        if (outletID != null) {
            additional.put("outlet_id", String.valueOf(outletID));
        }
        if (additional.isEmpty()) {
            additional = null;
        }
        return requestHelper.go(endpoint, Method.GET, null, additional);
    }


    public APIResponse subscribeClass(Integer classID, boolean verbose){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("verbose", String.valueOf(verbose));
        return requestHelper.go(endpoint + "/" + classID + "/subscribe", Method.POST, null, additional);
    }




}
