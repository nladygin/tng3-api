package tng3.guestapi.action;

import io.restassured.http.Method;
import org.springframework.stereotype.Component;
import tng3.base.APIResponse;
import tng3.base.Action;

import java.util.HashMap;

@Component
public class OfferAction extends Action {

    private final String endpoint = "/api/offers";



    public APIResponse getOffers(int outletID, int offset, int count) {
        HashMap<String, String> additional = new HashMap<>();
            additional.put("outlet_id", String.valueOf(outletID));
            additional.put("offset", String.valueOf(offset));
            additional.put("count", String.valueOf(count));
        return requestHelper.go(endpoint, Method.GET, null, additional);
    }


    public APIResponse getOfferTherapists(int outletID, int offset, int count, int offerID) {
        HashMap<String, String> additional = new HashMap<>();
            additional.put("outlet_id", String.valueOf(outletID));
            additional.put("offset", String.valueOf(offset));
            additional.put("count", String.valueOf(count));
        return requestHelper.go(endpoint +"/" + offerID + "/therapists", Method.GET, null, additional);
    }


    public APIResponse getOfferAvailability(int outletID, int offset, int count, int offerID, String from, String to, Integer therapistID) {
        HashMap<String, String> additional = new HashMap<>();
            additional.put("outlet_id", String.valueOf(outletID));
            additional.put("offset", String.valueOf(offset));
            additional.put("count", String.valueOf(count));
            additional.put("from", from);
            additional.put("to", to);
            if (therapistID != null) {
                additional.put("therapist_id", String.valueOf(therapistID));
            }
        return requestHelper.go(endpoint +"/" + offerID + "/availability", Method.GET, null, additional);
    }


    public APIResponse getOfferCapacity(int outletID, int offset, int count, int offerID, String from, Long fromMS) {
        HashMap<String, String> additional = new HashMap<>();
            additional.put("outlet_id", String.valueOf(outletID));
            additional.put("offset", String.valueOf(offset));
            additional.put("count", String.valueOf(count));
            if (from != null) {
                additional.put("from", from);
            }
            if (fromMS != null) {
                additional.put("from_ms", String.valueOf(fromMS));
            }
        return requestHelper.go(endpoint +"/" + offerID + "/capacity", Method.GET, null, additional);
    }




}
