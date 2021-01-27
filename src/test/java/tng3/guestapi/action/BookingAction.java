package tng3.guestapi.action;

import io.restassured.http.Method;
import org.hamcrest.CoreMatchers;
import org.springframework.stereotype.Component;
import tng3.base.APIResponse;
import tng3.base.Action;
import tng3.base.Entity;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;

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



    public APIResponse getBooking(int id) {
        return requestHelper.go(endpoint + "/" + id, Method.GET, null, null);
    }



    public APIResponse createBooking(Integer outletID, Integer therapistID, Integer facilityID, int offerID, String from, Long fromMS, String comment, Boolean verbose) {
        HashMap<String, String> additional = new HashMap<>();
            additional.put("outlet_id", String.valueOf(outletID));
            if (therapistID != null) {
                additional.put("therapist_id", String.valueOf(therapistID));
            }
            if (facilityID != null) {
                additional.put("facility_id", String.valueOf(facilityID));
            }
            additional.put("offer_id", String.valueOf(offerID));
            if (from != null) {
                additional.put("from", from);
            }
            if (fromMS != null) {
                additional.put("from_ms", String.valueOf(fromMS));
            }
            if (comment != null) {
                additional.put("comment", comment);
            }
            additional.put("verbose", String.valueOf(verbose));

        return requestHelper.go(endpoint, Method.POST, null, additional);
    }


    public APIResponse deleteBooking(int id, Entity bookingComment) {
        return  requestHelper.go(endpoint + "/" + id, Method.DELETE, bookingComment, null);
    }


    public APIResponse getBookingFee(int id){
        return requestHelper.go(endpoint + "/" + id + "/fee", Method.GET, null, null);
    }


    public APIResponse rateBooking(int id, Entity rate){
        return requestHelper.go(endpoint + "/" + id + "/rate", Method.POST, rate, null);
    }


    public APIResponse confirmBooking(int id){
        return requestHelper.go(endpoint + "/" + id + "/confirm", Method.POST, null, null);
    }


    public void validateStatus(String actualResult, String expectedStatus) {
        assertThat(actualResult, CoreMatchers.equalTo(expectedStatus));
    }


}
