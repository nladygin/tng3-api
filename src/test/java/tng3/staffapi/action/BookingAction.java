package tng3.staffapi.action;

import io.restassured.http.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tng3.base.Action;
import tng3.base.APIResponse;
import tng3.helper.RequestHelper;

import java.util.HashMap;

@Component
public class BookingAction extends Action {

    final private String endpoint = "/staffapi/bookings";



    public APIResponse getBookings(String from, String to){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("from", from);
            additional.put("to", to);
        return requestHelper.go(endpoint, Method.GET, null, additional);
    }



    public APIResponse createBookingMS(int offerId, int cardId, int outletId, long fromMs){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("outlet_id", String.valueOf(outletId));
            additional.put("offer_id", String.valueOf(offerId));
            additional.put("card_id", String.valueOf(cardId));
            additional.put("from_ms", String.valueOf(fromMs));
        return requestHelper.go(endpoint, Method.POST, null, additional);
    }


    public APIResponse createBooking(int offerId, int cardId, int outletId, String from){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("outlet_id", String.valueOf(outletId));
            additional.put("offer_id", String.valueOf(offerId));
            additional.put("card_id", String.valueOf(cardId));
            additional.put("from", String.valueOf(from));
        return requestHelper.go(endpoint, Method.POST, null, additional);
    }


    public APIResponse completeBooking(int bookingId){
        return requestHelper.go(endpoint + "/" + bookingId + "/complete", Method.POST, null, null);
    }






    @Autowired private RequestHelper requestHelper;
}
