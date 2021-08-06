package tng3.tests.staffapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.base.APIResponse;
import tng3.tests.staffapi.action.BookingAction;
import tng3.common.entity.Booking;

@RunWith(SpringJUnit4ClassRunner.class)
public class BookingTest extends BaseTest {


    @Test
    public void getBookings(){
        APIResponse response = bookingAction.getBookings(
                utils.getMonthFirstDay("ddMMyyyy"),
                utils.getMonthLastDay("ddMMyyyy")
        );
        bookingAction.checkResponseSuccess(response, true);
        bookingAction.validateResponsePayload(response, Booking.class, true);
    }


    @Test
    public void getTodayBookings(){
        APIResponse response = bookingAction.getBookings(
                utils.generateDate("ddMMyyyy", 0),
                utils.generateDate("ddMMyyyy",0)
        );
        bookingAction.checkResponseSuccess(response, true);
        bookingAction.validateResponsePayload(response, Booking.class, true);
    }



    @Test
    public void createBookingFromMS(){
        APIResponse response = bookingAction.createBookingMS(
                data.offerID,
                data.cardID,
                data.outletID,
                utils.generateDateMS(1)
        );
        bookingAction.checkResponseSuccess(response, true);
    }


    @Test
    public void createBookingFrom(){
        APIResponse response = bookingAction.createBooking(
                data.offerID,
                data.cardID,
                data.outletID,
                utils.generateDate("dd.MM.yyyy HH:mm", 1)
        );
        bookingAction.checkResponseSuccess(response, true);
    }


    @Test
    public void completeBooking(){
        APIResponse response = bookingAction.createBookingMS(
                data.offerID,
                data.cardID,
                data.outletID,
                utils.generateDateMS(1)
        );
        bookingAction.checkResponseSuccess(response, true);

            int bookingId = (int) response.getPayload();

            response = bookingAction.completeBooking(bookingId);
            bookingAction.checkResponseSuccess(response, true);
    }


    @Test
    public void completeWrongBooking(){
        APIResponse response = bookingAction.completeBooking(666);
        bookingAction.checkResponseSuccess(response, false);
        bookingAction.checkResponseErrorCode(response, 999);
    }


    @Test
    public void deleteBooking(){
        APIResponse response = bookingAction.createBookingMS(
                data.offerID,
                data.cardID,
                data.outletID,
                utils.generateDateMS(1)
        );
        bookingAction.checkResponseSuccess(response, true);

            int bookingId = (int) response.getPayload();

            response = bookingAction.deleteBooking(bookingId, "deleted by API autotest");
            bookingAction.checkResponseSuccess(response, true);
    }


    @Test
    public void deleteWrongBooking(){
        APIResponse response = bookingAction.deleteBooking(666, null);
        bookingAction.checkResponseSuccess(response, false);
        bookingAction.checkResponseErrorCode(response, 121);
    }








    @Autowired private BookingAction bookingAction;
}
