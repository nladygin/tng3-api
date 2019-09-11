package tng3.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.api.entity.*;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource({"data.properties"})
public class BookingTest extends BaseTest {

    @Autowired
    private Booking booking;

    @Autowired
    private BookingComment bookingComment;

    @Autowired
    private BookingRate bookingRate;

    @Autowired
    private Utils utils;

    @Value("${outlet_id}")
    private String outletID;

    @Value("${booking.therapist_id}")
    private String therapistID;

    @Value("${booking.offer_id}")
    private String offerID;


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
            additional.put("outlet_id", outletID);
            additional.put("therapist_id", therapistID);
            additional.put("offer_id", offerID);
            additional.put("from", utils.generateDate("dd.MM.YYYY HH:mm", 0));

                APIResponse response = utils.go(endpoint, Method.POST, null, additional);
                assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void createBookingFromMS(){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("outlet_id", outletID);
            additional.put("therapist_id", therapistID);
            additional.put("offer_id", offerID);
            additional.put("from_ms", utils.generateDateMS(0));

                APIResponse response = utils.go(endpoint, Method.POST, null, additional);
                assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void createAndDeleteBooking(){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("outlet_id", outletID);
            additional.put("therapist_id", therapistID);
            additional.put("offer_id", offerID);
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
            additional.put("outlet_id", outletID);
            additional.put("therapist_id", therapistID);
            additional.put("offer_id", offerID);
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
            additional.put("outlet_id", outletID);
            additional.put("therapist_id", therapistID);
            additional.put("offer_id", offerID);
            additional.put("from_ms", utils.generateDateMS(0));

                APIResponse response = utils.go(endpoint, Method.POST, null, additional);
                assertThat(response.getSuccess(), equalTo(true));

                    int bookingID = (int) response.getPayload();

                        response = utils.go(endpoint + "/" + bookingID + "/rate", Method.POST, bookingRate);
                        assertThat(response.getSuccess(), equalTo(true));

                            response = utils.go(endpoint + "/" + bookingID, Method.DELETE, bookingComment);
                            assertThat(response.getSuccess(), equalTo(true));
    }




}
