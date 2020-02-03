package tng3.guestapi.action;

import io.restassured.http.Method;
import org.springframework.stereotype.Component;
import tng3.base.APIResponse;
import tng3.base.Action;

import java.util.HashMap;

@Component
public class ClassAction extends Action {

    private final String endpoint = "/api/classes";



    public APIResponse getClasses(Integer outletID, String from, String till, Integer offset, Integer count) {
        HashMap<String, String> additional = new HashMap<>();
        if (outletID != null) {
            additional.put("outlet_id", String.valueOf(outletID));
        }
        if (from != null) {
            additional.put("from", from);
        }
        if (till != null) {
            additional.put("till", till);
        }
        if (offset != null) {
            additional.put("offset", String.valueOf(offset));
        }
        if (count != null) {
            additional.put("count", String.valueOf(count));
        }
        if (additional.isEmpty()) {
            additional = null;
        }
        return requestHelper.go(endpoint, Method.GET, null, additional);
    }


    public APIResponse getClasses(Integer outletID) {
        return getClasses(outletID, null, null,null, null);
    }


    public APIResponse getClasses(Integer outletID, String from, String till) {
        return getClasses(outletID, from, till,null, null);
    }


    public APIResponse getClasses(Integer outletID, Integer offset, Integer count) {
        return getClasses(outletID, null, null,offset, count);
    }



    public APIResponse subscribeClass(Integer classID, boolean verbose){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("verbose", String.valueOf(verbose));
        return requestHelper.go(endpoint + "/" + classID + "/subscribe", Method.POST, null, additional);
    }




}
