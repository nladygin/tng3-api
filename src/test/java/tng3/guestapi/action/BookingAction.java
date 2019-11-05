package tng3.guestapi.action;

import io.restassured.http.Method;
import org.springframework.stereotype.Component;
import tng3.base.APIResponse;
import tng3.base.Action;
import tng3.base.Entity;
import tng3.guestapi.entity.BookingComment;

import java.util.HashMap;

@Component
public class BookingAction extends Action {

    private final String endpoint = "/api/bookings";




    public APIResponse getBookings(String from, String to) {
        HashMap<String, String> additional = new HashMap<>();
        if (from != null) {
            additional.put("from", from);
        }
        if (to != null) {
            additional.put("to", to);
        }
        if (additional.isEmpty()) {
            additional = null;
        }
        return requestHelper.go(endpoint, Method.GET, null, additional);
    }


    public APIResponse createBooking(Integer outletID, Integer therapistID, int offerID, String from, Long fromMS, Boolean verbose) {
        HashMap<String, String> additional = new HashMap<>();
            additional.put("outlet_id", String.valueOf(outletID));
            if (therapistID != null) {
                additional.put("therapist_id", String.valueOf(therapistID));
            }
            additional.put("offer_id", String.valueOf(offerID));
            if (from != null) {
                additional.put("from", from);
            }
            if (fromMS != null) {
                additional.put("from_ms", String.valueOf(fromMS));
            }
            additional.put("verbose", String.valueOf(verbose));

        return requestHelper.go(endpoint, Method.POST, null, additional);
    }


    public APIResponse deleteBooking(int id, Entity bookingComment) {
        return  requestHelper.go(endpoint + "/" + id, Method.DELETE, bookingComment, null);
    }


}
