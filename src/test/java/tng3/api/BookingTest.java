package tng3.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.api.config.Config;
import tng3.api.entity.*;
import tng3.api.helper.Method;
import tng3.api.helper.Utils;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
public class BookingTest extends BaseTest {

    private final String endpoint = "/bookings";




    @Test
    public void getBookings(){
        APIResponse response = utils.go(endpoint, Method.GET);
        assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void getBookingsByRange(){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("from", utils.generateDate("ddMMYYYY", 0));
            additional.put("to", utils.generateDate("ddMMYYYY", 7));

                APIResponse response = utils.go(endpoint, Method.GET, null, additional);
                assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void createBookingFrom(){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("outlet_id", String.valueOf(config.outletID));
            additional.put("therapist_id", config.therapistID);
            additional.put("offer_id", String.valueOf(config.offerID));
            additional.put("from", utils.generateDate("dd.MM.YYYY HH:mm", 0));
            additional.put("verbose", String.valueOf(true));

                APIResponse response = utils.go(endpoint, Method.POST, null, additional);
                assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void createBookingFromMS(){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("outlet_id", String.valueOf(config.outletID));
            additional.put("therapist_id", config.therapistID);
            additional.put("offer_id", String.valueOf(config.offerID));
            additional.put("from_ms", utils.generateDateMS(0));

                APIResponse response = utils.go(endpoint, Method.POST, null, additional);
                assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void createSpaPackageFromMS(){
        HashMap<String, String> additional = new HashMap<>();
        additional.put("outlet_id", String.valueOf(config.outletID));
        additional.put("therapist_id", config.therapistID);
        additional.put("offer_id", String.valueOf(config.spaPackageID));
        additional.put("from_ms", utils.generateDateMS(0));

        APIResponse response = utils.go(endpoint, Method.POST, null, additional);
        assertThat(response.getSuccess(), equalTo(true));
    }



    @Test
    public void createAndDeleteBooking(){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("outlet_id", String.valueOf(config.outletID));
            additional.put("therapist_id", config.therapistID);
            additional.put("offer_id", String.valueOf(config.offerID));
            additional.put("from_ms", utils.generateDateMS(0));

                APIResponse response = utils.go(endpoint, Method.POST, null, additional);
                assertThat(response.getSuccess(), equalTo(true));

                    int bookingID = (int) response.getPayload();

                        response = utils.go(endpoint + "/" + bookingID, Method.DELETE, bookingComment);
                        assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void createGetFeeAndDeleteBooking(){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("outlet_id", String.valueOf(config.outletID));
            additional.put("therapist_id", config.therapistID);
            additional.put("offer_id", String.valueOf(config.offerID));
            additional.put("from_ms", utils.generateDateMS(0));

                APIResponse response = utils.go(endpoint, Method.POST, null, additional);
                assertThat(response.getSuccess(), equalTo(true));

                    int bookingID = (int) response.getPayload();

                        response = utils.go(endpoint + "/" + bookingID + "/fee", Method.GET);
                        assertThat(response.getSuccess(), equalTo(true));

                            response = utils.go(endpoint + "/" + bookingID, Method.DELETE, bookingComment);
                            assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void createRateAndDeleteBooking(){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("outlet_id", String.valueOf(config.outletID));
            additional.put("therapist_id", config.therapistID);
            additional.put("offer_id", String.valueOf(config.offerID));
            additional.put("from_ms", utils.generateDateMS(0));

                APIResponse response = utils.go(endpoint, Method.POST, null, additional);
                assertThat(response.getSuccess(), equalTo(true));

                    int bookingID = (int) response.getPayload();

                        response = utils.go(endpoint + "/" + bookingID + "/rate", Method.POST, bookingRate);
                        assertThat(response.getSuccess(), equalTo(true));

                            response = utils.go(endpoint + "/" + bookingID, Method.DELETE, bookingComment);
                            assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void deleteNonexistentBooking(){
        APIResponse response = utils.go(endpoint + "/" + "666", Method.DELETE, bookingComment);
        assertThat(response.getSuccess(), equalTo(false));
        assertThat(utils.getErrorCode(response.getError()), equalTo(121));
    }


    @Test
    public void createBadBooking(){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("outlet_id", String.valueOf(config.outletID));
            additional.put("therapist_id", config.therapistID);
            additional.put("offer_id", String.valueOf(config.offerID));
            additional.put("from", utils.generateDate("dd.MM.YYYY HH:mm", 365));

                APIResponse response = utils.go(endpoint, Method.POST, null, additional);
                assertThat(response.getSuccess(), equalTo(false));
                assertThat(utils.getErrorCode(response.getError()), equalTo(200));
    }


    @Test
    public void getFeeBadBooking(){
        APIResponse response = utils.go(endpoint + "/" + "666" + "/fee", Method.GET);
        assertThat(response.getSuccess(), equalTo(false));
        assertThat(utils.getErrorCode(response.getError()), equalTo(121));
    }


    @Test
    public void rateBadBooking(){
        APIResponse response = utils.go(endpoint + "/" + "666" + "/rate", Method.POST, bookingRate);
        assertThat(response.getSuccess(), equalTo(false));
        assertThat(utils.getErrorCode(response.getError()), equalTo(121));
    }


    @Test
    public void createWrongRateAndDeleteBooking(){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("outlet_id", String.valueOf(config.outletID));
            additional.put("therapist_id", config.therapistID);
            additional.put("offer_id", String.valueOf(config.offerID));
            additional.put("from_ms", utils.generateDateMS(0));

                APIResponse response = utils.go(endpoint, Method.POST, null, additional);
                assertThat(response.getSuccess(), equalTo(true));

                    int bookingID = (int) response.getPayload();

                        response = utils.go(endpoint + "/" + bookingID + "/rate", Method.POST, new BookingRate(10, "WOW"));
                        assertThat(response.getSuccess(), equalTo(false));
                        assertThat(utils.getErrorCode(response.getError()), equalTo(124));

                            response = utils.go(endpoint + "/" + bookingID, Method.DELETE, bookingComment);
                            assertThat(response.getSuccess(), equalTo(true));
    }








    private BookingComment bookingComment = new BookingComment();
    private BookingRate bookingRate = new BookingRate();

    @Autowired
    private Utils utils;

    @Autowired
    private Config config;
}
