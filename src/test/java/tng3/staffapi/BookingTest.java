package tng3.staffapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.base.APIResponse;
import tng3.staffapi.action.BookingAction;
import tng3.staffapi.entity.Booking;

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










    @Autowired private BookingAction bookingAction;
}
