package tng3.guestapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.base.APIResponse;
import tng3.common.entity.Booking;
import tng3.guestapi.action.BookingAction;
import tng3.guestapi.action.ClassAction;
import tng3.guestapi.entity.BookingComment;
import tng3.guestapi.entity.Class;

import java.io.IOException;


@RunWith(SpringJUnit4ClassRunner.class)
public class ClassTest extends BaseTest {



    @Test
    public void getClasses() {
        APIResponse response = classAction.getClasses(data.outletID);
        classAction.checkResponseSuccess(response, true);
        classAction.validateResponsePayload(response, Class.class, true);
    }


    @Test
    public void getClassesFromTill() {
        APIResponse response = classAction.getClasses(
                data.outletID,
                utils.generateDate("dd.MM.yyyy", 0),
                utils.generateDate("dd.MM.yyyy", 30)
        );
        classAction.checkResponseSuccess(response, true);
        classAction.validateResponsePayload(response, Class.class, true);
    }


    @Test
    public void getClassesWithOffsetAndCount() {
        APIResponse response = classAction.getClasses(data.outletID, 100, 10);
        classAction.checkResponseSuccess(response, true);
        classAction.checkResponsePayloadIsEmptyList(response);
    }


    @Test
    public void subscribeAndUnsubscribeClass() throws IOException {
        APIResponse response = classAction.subscribeClass(data.classID, true);
        classAction.checkResponseSuccess(response, true);
        classAction.validateResponsePayload(response, Booking.class, true);

            int id = ((Booking) utils.toEntity(response, Booking.class)).id;

            response = bookingAction.deleteBooking(id, new BookingComment("unsubscribe"));
            bookingAction.checkResponseSuccess(response, true);
            bookingAction.checkResponsePayloadIsEmpty(response);
    }


    @Test
    public void subscribeCancelledClass() throws IOException {
        APIResponse response = classAction.subscribeClass(data.cancelledClassID, true);
        classAction.checkResponseSuccess(response, false);
        classAction.checkResponseErrorCode(response, 200);
    }


    @Test
    public void subscribeNonexistentClass() {
        APIResponse response = classAction.subscribeClass(666, true);
        bookingAction.checkResponseSuccess(response, false);
        bookingAction.checkResponseErrorCode(response, 121);
    }








    @Autowired private ClassAction classAction;
    @Autowired private BookingAction bookingAction;
}
