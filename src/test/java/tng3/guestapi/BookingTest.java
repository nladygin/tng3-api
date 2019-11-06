package tng3.guestapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.base.APIResponse;
import tng3.entity.Booking;
import tng3.guestapi.action.AccountAction;
import tng3.guestapi.action.BookingAction;
import tng3.guestapi.entity.Accounts;
import tng3.guestapi.entity.BookingComment;
import tng3.guestapi.entity.BookingRate;

import java.util.LinkedHashMap;


@RunWith(SpringJUnit4ClassRunner.class)
public class BookingTest extends BaseTest {



    @Test
    public void getBookings() {
        APIResponse response = bookingAction.getBookings(null, null);
        bookingAction.checkResponseSuccess(response, true);
        bookingAction.validateResponsePayload(response, Booking.class, true);
    }


    @Test
    public void getBookingsByRange() {
        APIResponse response = bookingAction.getBookings(
                utils.generateDate("ddMMyyyy", 0),
                utils.generateDate("ddMMyyyy", 7)
        );
        bookingAction.checkResponseSuccess(response, true);
        bookingAction.validateResponsePayload(response, Booking.class, true);
    }


    @Test
    public void createBookingWithTherapistFrom() {
        APIResponse response = bookingAction.createBooking(
                data.outletID,
                data.therapistID,
                data.offerID,
                utils.generateDate("dd.MM.yyyy HH:mm", 0),
                null,
                true
        );
        bookingAction.checkResponseSuccess(response, true);
        bookingAction.validateResponsePayload(response, Booking.class, false);
    }


    @Test
    public void createBookingWithoutTherapistFrom() {
        APIResponse response = bookingAction.createBooking(
                data.outletID,
                null,
                data.offerID,
                utils.generateDate("dd.MM.yyyy HH:mm", 0),
                null,
                true
        );
        bookingAction.checkResponseSuccess(response, true);
        bookingAction.validateResponsePayload(response, Booking.class, false);
    }


    @Test
    public void createBookingWithTherapistFromMS() {
        APIResponse response = bookingAction.createBooking(
                data.outletID,
                data.therapistID,
                data.offerID,
                null,
                utils.generateDateMS(0),
                true
        );
        bookingAction.checkResponseSuccess(response, true);
        bookingAction.validateResponsePayload(response, Booking.class, false);
    }


    @Test
    public void createBookingWithoutTherapistFromMS() {
        APIResponse response = bookingAction.createBooking(
                data.outletID,
                null,
                data.offerID,
                null,
                utils.generateDateMS(0),
                true
        );
        bookingAction.checkResponseSuccess(response, true);
        bookingAction.validateResponsePayload(response, Booking.class, false);
    }


    @Test
    public void createSpaPackageFrom() {
        APIResponse response = bookingAction.createBooking(
                data.outletID,
                null,
                data.offerID,
                utils.generateDate("dd.MM.yyyy HH:mm", 0),
                null,
                true
        );
        bookingAction.checkResponseSuccess(response, true);
        bookingAction.validateResponsePayload(response, Booking.class, false);
    }


    @Test
    public void createSpaPackageFromMS() {
        APIResponse response = bookingAction.createBooking(
                data.outletID,
                null,
                data.spaPackageID,
                null,
                utils.generateDateMS(0),
                true
        );
        bookingAction.checkResponseSuccess(response, true);
        bookingAction.validateResponsePayload(response, Booking.class, false);
    }


    @Test
    public void createGetFeeAndDeleteBooking() {
        APIResponse response = bookingAction.createBooking(
                data.outletID,
                null,
                data.offerID,
                null,
                utils.generateDateMS(0),
                true
        );
        bookingAction.checkResponseSuccess(response, true);
        bookingAction.validateResponsePayload(response, Booking.class, false);

            int id = (int) ((LinkedHashMap<String, Object>) response.getPayload()).get("id");

            response = bookingAction.getBookingFee(id);
            bookingAction.checkResponseSuccess(response, true);
            bookingAction.validateResponsePayload(response, Double.class, false);

                response = bookingAction.deleteBooking(id, new BookingComment("delete"));
                bookingAction.checkResponseSuccess(response, true);
                bookingAction.checkResponsePayloadIsEmpty(response);
    }


    @Test
    public void createRateAndDeleteBooking() {
        APIResponse response = bookingAction.createBooking(
                data.outletID,
                null,
                data.offerID,
                null,
                utils.generateDateMS(0),
                true
        );
        bookingAction.checkResponseSuccess(response, true);
        bookingAction.validateResponsePayload(response, Booking.class, false);

            int id = (int) ((LinkedHashMap<String, Object>) response.getPayload()).get("id");

                response = bookingAction.rateBooking(id, new BookingRate(3, "so-so"));
                bookingAction.checkResponseSuccess(response, true);
                bookingAction.validateResponsePayload(response, Double.class, false);

                    response = bookingAction.deleteBooking(id, new BookingComment("delete"));
                    bookingAction.checkResponseSuccess(response, true);
                    bookingAction.checkResponsePayloadIsEmpty(response);
    }


    @Test
    public void createBadBooking() {
        APIResponse response = bookingAction.createBooking(
                data.outletID,
                null,
                666,
                null,
                utils.generateDateMS(0),
                true
        );
        bookingAction.checkResponseSuccess(response, false);
        bookingAction.checkResponseErrorCode(response, 200);
    }


    @Test
    public void deleteNonexistentBooking(){
        APIResponse response = bookingAction.deleteBooking(666, new BookingComment("delete non existent"));
        bookingAction.checkResponseSuccess(response, false);
        bookingAction.checkResponseErrorCode(response, 121);
    }


    @Test
    public void getFeeBadBooking(){
        APIResponse response = bookingAction.getBookingFee(666);
        bookingAction.checkResponseSuccess(response, false);
        bookingAction.checkResponseErrorCode(response, 121);
    }


    @Test
    public void rateBadBooking(){
        APIResponse response = bookingAction.rateBooking(666, new BookingRate(4, "not bad"));
        bookingAction.checkResponseSuccess(response, false);
        bookingAction.checkResponseErrorCode(response, 121);
    }


    @Test
    public void createWrongRateAndDeleteBooking() {
        APIResponse response = bookingAction.createBooking(
                data.outletID,
                null,
                data.offerID,
                null,
                utils.generateDateMS(0),
                true
        );
        bookingAction.checkResponseSuccess(response, true);
        bookingAction.validateResponsePayload(response, Booking.class, false);

            int id = (int) ((LinkedHashMap<String, Object>) response.getPayload()).get("id");

                response = bookingAction.rateBooking(id, new BookingRate(10, "wow"));
                bookingAction.checkResponseSuccess(response, false);
                bookingAction.checkResponseErrorCode(response, 124);

                    response = bookingAction.deleteBooking(id, new BookingComment("delete"));
                    bookingAction.checkResponseSuccess(response, true);
                    bookingAction.checkResponsePayloadIsEmpty(response);
    }








    @Autowired private BookingAction bookingAction;
}
