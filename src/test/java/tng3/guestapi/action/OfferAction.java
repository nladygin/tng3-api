package tng3.guestapi.action;

import io.restassured.http.Method;
import org.hamcrest.CoreMatchers;
import org.springframework.stereotype.Component;
import tng3.base.APIResponse;
import tng3.base.Action;
import tng3.guestapi.entity.Offers;
import tng3.guestapi.entity.TicketAvailability;
import tng3.guestapi.entity.TimeSlotsDetails;
import tng3.helper.Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

import static org.hamcrest.MatcherAssert.assertThat;

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


    public APIResponse getTicketAvailability(int outletID, int offset, int count, int ticketOfferID, String from, String to, Integer guestCount) {
        return getTicketAvailability(outletID, offset, count, ticketOfferID, from, to, guestCount, true);
    }


    public APIResponse getTicketAvailability(int outletID, int offset, int count, int ticketOfferID, String from, String to, Integer guestCount, Boolean session) {
        HashMap<String, String> additional = new HashMap<>();
        additional.put("outlet_id", String.valueOf(outletID));
        additional.put("offset", String.valueOf(offset));
        additional.put("count", String.valueOf(count));
        additional.put("from", from);
        additional.put("to", to);
        if (guestCount != null) {
            additional.put("guests", String.valueOf(guestCount));
        }
        return requestHelper.go(endpoint +"/" + ticketOfferID + "/availability", Method.GET, null, additional, session);
    }


    public APIResponse getTicketAvailabilityByOutletAndDateRange(int outletID, Long availableFromMs, Long availableToMs, Boolean ti, Integer guestCount) {
        return getTicketAvailabilityByOutletAndDateRange(outletID, availableFromMs, availableToMs, ti, guestCount, true);
    }


    public APIResponse getTicketAvailabilityByOutletAndDateRange(int outletID, Long availableFromMs, Long availableToMs, Boolean ti, Integer guestCount, Boolean session) {
        HashMap<String, String> additional = new HashMap<>();
        additional.put("outlet_id", String.valueOf(outletID));
        additional.put("available_from_ms", String.valueOf(availableFromMs));
        additional.put("available_to_ms", String.valueOf(availableToMs));
        additional.put("ti", String.valueOf(ti));
        if (guestCount != null) {
            additional.put("guests", String.valueOf(guestCount));
        }
        return requestHelper.go(endpoint, Method.GET, null, additional, session);
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





    public void checkOnEmptyTimeSlotDetails(APIResponse response) {
        Utils utils = new Utils();
        TimeSlotsDetails tsd = null;
        try {
             tsd = (TimeSlotsDetails) utils.toEntity(response, TimeSlotsDetails.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(tsd.timeSlotDetails.size(), CoreMatchers.equalTo(0));
    }


    public void checkOnNotEmptyTimeSlotDetails(APIResponse response) {
        Utils utils = new Utils();
        TimeSlotsDetails tsd = null;
        try {
            tsd = (TimeSlotsDetails) utils.toEntity(response, TimeSlotsDetails.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(tsd.timeSlotDetails.size() > 0, CoreMatchers.equalTo(true));
    }


    public void checkOnOffersNumber(APIResponse response, int expectedCount) {
        Utils utils = new Utils();
        Offers offers = null;
        try {
            offers = (Offers) utils.toEntity(response, Offers.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(offers.offers.size(), CoreMatchers.equalTo(expectedCount));
    }

}
