package tng3.guestapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.base.APIResponse;
import tng3.common.action.ItemsAction;
import tng3.common.entity.Bill;
import tng3.common.entity.Booking;
import tng3.common.entity.Payment;
import tng3.common.entity.Payments;
import tng3.guestapi.action.BillAction;
import tng3.guestapi.action.BookingAction;
import tng3.common.entity.BookingComment;
import tng3.guestapi.entity.BookingRate;

import java.io.IOException;


@RunWith(SpringJUnit4ClassRunner.class)
public class BookingTest extends BaseTest {



    @Test
    public void getBookings() {
        APIResponse response = bookingAction.getBookings(null, null);
        bookingAction.checkResponseSuccess(response, true);
        bookingAction.validateResponsePayload(response, Booking.class, true);
    }


    @Test
    public void getUpcomingBookings() {
        APIResponse response = bookingAction.getBookings(utils.generateDate("ddMMyyyy", 0), null);
        bookingAction.checkResponseSuccess(response, true);
        bookingAction.validateResponsePayload(response, Booking.class, true);
    }


    @Test
    public void getTodayBookings() {
        APIResponse response = bookingAction.getBookings(
                utils.generateDate("ddMMyyyy", 0),
                utils.generateDate("ddMMyyyy",0)
        );
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
                null,
                data.offerID,
                utils.generateDate("dd.MM.yyyy HH:mm", 0),
                null,
                "autotest API booking",
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
                null,
                data.offerID,
                utils.generateDate("dd.MM.yyyy HH:mm", 0),
                null,
                "autotest API booking",
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
                null,
                data.offerID,
                null,
                utils.generateDateMS(0),
                "autotest API booking",
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
                null,
                data.offerID,
                null,
                utils.generateDateMS(0),
                "autotest API booking",
                true
        );
        bookingAction.checkResponseSuccess(response, true);
        bookingAction.validateResponsePayload(response, Booking.class, false);
    }


    @Test
    public void createBookingWithFacilityFrom() {
        APIResponse response = bookingAction.createBooking(
                data.outletID,
                null,
                data.facilityID,
                data.offerID,
                utils.generateDate("dd.MM.yyyy HH:mm", 0),
                null,
                "autotest API booking",
                true
        );
        bookingAction.checkResponseSuccess(response, true);
        bookingAction.validateResponsePayload(response, Booking.class, false);
    }


    @Test
    public void createBookingWithFacilityFromMS() {
        APIResponse response = bookingAction.createBooking(
                data.outletID,
                null,
                data.facilityID,
                data.offerID,
                null,
                utils.generateDateMS(0),
                "autotest API booking",
                true
        );
        bookingAction.checkResponseSuccess(response, true);
        bookingAction.validateResponsePayload(response, Booking.class, false);
    }


    @Test
    public void createBookingWithTherapistAndFacilityFrom() {
        APIResponse response = bookingAction.createBooking(
                data.outletID,
                data.therapistID,
                data.facilityID,
                data.offerID,
                utils.generateDate("dd.MM.yyyy HH:mm", 0),
                null,
                "autotest API booking",
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
                null,
                data.spaPackageID,
                utils.generateDate("dd.MM.yyyy HH:mm", 0),
                null,
                "autotest API booking",
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
                null,
                data.spaPackageID,
                null,
                utils.generateDateMS(0),
                "autotest API booking",
                true
        );
        bookingAction.checkResponseSuccess(response, true);
        bookingAction.validateResponsePayload(response, Booking.class, false);
    }


    @Test
    public void createGetFeeAndDeleteBooking() throws IOException {
        APIResponse response = bookingAction.createBooking(
                data.outletID,
                null,
                null,
                data.offerID,
                null,
                utils.generateDateMS(0),
                "autotest API booking",
                true
        );
        bookingAction.checkResponseSuccess(response, true);
        bookingAction.validateResponsePayload(response, Booking.class, false);

            Booking booking = (Booking) utils.toEntity(response, Booking.class);

            response = bookingAction.getBookingFee(booking.id);
            bookingAction.checkResponseSuccess(response, true);
            bookingAction.validateResponsePayload(response, Double.class, false);

                response = bookingAction.deleteBooking(booking.id, new BookingComment("delete"));
                bookingAction.checkResponseSuccess(response, true);
                bookingAction.checkResponsePayloadIsEmpty(response);
    }


    @Test
    public void createRateAndDeleteBooking() throws IOException {
        APIResponse response = bookingAction.createBooking(
                data.outletID,
                null,
                null,
                data.offerID,
                null,
                utils.generateDateMS(0),
                "autotest API booking",
                true
        );
        bookingAction.checkResponseSuccess(response, true);
        bookingAction.validateResponsePayload(response, Booking.class, false);

            Booking booking = (Booking) utils.toEntity(response, Booking.class);

                response = bookingAction.rateBooking(booking.id, new BookingRate(3, "so-so"));
                bookingAction.checkResponseSuccess(response, true);
                bookingAction.validateResponsePayload(response, Double.class, false);

                    response = bookingAction.deleteBooking(booking.id, new BookingComment("delete"));
                    bookingAction.checkResponseSuccess(response, true);
                    bookingAction.checkResponsePayloadIsEmpty(response);
    }


    @Test
    public void createBadBooking() {
        APIResponse response = bookingAction.createBooking(
                data.outletID,
                null,
                null,
                666,
                null,
                utils.generateDateMS(0),
                "autotest API booking",
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
    public void createWrongRateAndDeleteBooking() throws IOException {
        APIResponse response = bookingAction.createBooking(
                data.outletID,
                null,
                null,
                data.offerID,
                null,
                utils.generateDateMS(0),
                "autotest API booking",
                true
        );
        bookingAction.checkResponseSuccess(response, true);
        bookingAction.validateResponsePayload(response, Booking.class, false);

            Booking booking = (Booking) utils.toEntity(response, Booking.class);

                response = bookingAction.rateBooking(booking.id, new BookingRate(10, "wow"));
                bookingAction.checkResponseSuccess(response, false);
                bookingAction.checkResponseErrorCode(response, 124);

                    response = bookingAction.deleteBooking(booking.id, new BookingComment("delete"));
                    bookingAction.checkResponseSuccess(response, true);
                    bookingAction.checkResponsePayloadIsEmpty(response);
    }


    @Test
    public void createAndConfirmBooking() throws IOException {
        APIResponse response = bookingAction.createBooking(
                data.outletID,
                null,
                null,
                data.offerID,
                null,
                utils.generateDateMS(0),
                "autotest API booking",
                true
        );
        bookingAction.checkResponseSuccess(response, true);
        bookingAction.validateResponsePayload(response, Booking.class, false);

            Booking booking = (Booking) utils.toEntity(response, Booking.class);

                response = bookingAction.confirmBooking(booking.id);
                bookingAction.checkResponseSuccess(response, true);

                    response = bookingAction.getBooking(booking.id);
                    bookingAction.checkResponseSuccess(response, true);
                    bookingAction.validateResponsePayload(response, Booking.class, false);

                        booking = (Booking) utils.toEntity(response, Booking.class);
                        bookingAction.validateStatus(booking.status, "CONFIRMED");
    }


    @Test
    public void getWrongBooking() {
        APIResponse response = bookingAction.getBooking(666);
        bookingAction.checkResponseSuccess(response, false);
        bookingAction.checkResponseErrorCode(response, 121);
    }


    @Test
    public void createPayDepositAndCancelBooking() throws IOException {
        APIResponse response = bookingAction.createBooking(
                data.outletID,
                null,
                null,
                data.offerID,
                utils.generateDate("dd.MM.yyyy HH:mm", 0),
                null,
                "autotest API booking",
                true
        );
        bookingAction.checkResponseSuccess(response, true);
        bookingAction.validateResponsePayload(response, Booking.class, false);

            Booking booking = (Booking) utils.toEntity(response, Booking.class);

                response = billAction.createBill(
                        data.outletID,
                        itemsAction.addItem(
                                null,
                                1,
                                booking.id,
                                "booking deposit payment (API test)"
                        )
                );
                billAction.checkResponseSuccess(response, true);
                billAction.validateResponsePayload(response, Bill.class, false);

                    Bill bill = (Bill) utils.toEntity(response, Bill.class);

                    Payments payments = new Payments();
                    payments.add(new Payment(data.depositTenderID, bill.ttlDue));

                        response = billAction.paymentBill(bill, payments);
                        billAction.checkResponseSuccess(response, true);
                        billAction.validateResponsePayload(response, Bill.class, false);

                        bill = (Bill) utils.toEntity(response, Bill.class);
                        billAction.isClosed(bill, true);

                            response = bookingAction.deleteBooking(booking.id, new BookingComment("delete"));
                            bookingAction.checkResponseSuccess(response, true);
                            bookingAction.checkResponsePayloadIsEmpty(response);
    }


    @Test
    public void createPayNonDepositAndCancelBooking() throws IOException {
        APIResponse response = bookingAction.createBooking(
                data.outletID,
                null,
                null,
                data.offerID,
                utils.generateDate("dd.MM.yyyy HH:mm", 0),
                null,
                "autotest API booking",
                true
        );
        bookingAction.checkResponseSuccess(response, true);
        bookingAction.validateResponsePayload(response, Booking.class, false);

            Booking booking = (Booking) utils.toEntity(response, Booking.class);

                response = billAction.createBill(
                        data.outletID,
                        itemsAction.addItem(
                                null,
                                1,
                                booking.id,
                                "booking non deposit payment (API test)"
                        )
                );
                billAction.checkResponseSuccess(response, true);
                billAction.validateResponsePayload(response, Bill.class, false);

                    Bill bill = (Bill) utils.toEntity(response, Bill.class);

                        Payments payments = new Payments();
                        payments.add(new Payment(data.tenderID, bill.ttlDue));

                            response = billAction.paymentBill(bill, payments);
                            billAction.checkResponseSuccess(response, true);
                            billAction.validateResponsePayload(response, Bill.class, false);

                            bill = (Bill) utils.toEntity(response, Bill.class);
                            billAction.isClosed(bill, true);

                                response = bookingAction.deleteBooking(booking.id, new BookingComment("delete"));
                                bookingAction.checkResponseSuccess(response, true);
                                bookingAction.checkResponsePayloadIsEmpty(response);
    }


    @Test
    public void createPartialPayAndCancelBooking() throws IOException {
        APIResponse response = bookingAction.createBooking(
                data.outletID,
                null,
                null,
                data.offerID,
                utils.generateDate("dd.MM.yyyy HH:mm", 0),
                null,
                "autotest API booking",
                true
        );
        bookingAction.checkResponseSuccess(response, true);
        bookingAction.validateResponsePayload(response, Booking.class, false);

            Booking booking = (Booking) utils.toEntity(response, Booking.class);

                response = billAction.createBill(
                        data.outletID,
                        itemsAction.addItem(
                                null,
                                1,
                                booking.id,
                                "booking partial payment (API test)"
                        )
                );
                billAction.checkResponseSuccess(response, true);
                billAction.validateResponsePayload(response, Bill.class, false);

                    Bill bill = (Bill) utils.toEntity(response, Bill.class);

                        Payments payments = new Payments();
                        payments.add(new Payment(data.tenderID, bill.total - 1.0));
                        payments.add(new Payment(data.depositTenderID, 1.0));

                            response = billAction.paymentBill(bill, payments);
                            billAction.checkResponseSuccess(response, true);
                            billAction.validateResponsePayload(response, Bill.class, false);

                            bill = (Bill) utils.toEntity(response, Bill.class);
                            billAction.isClosed(bill, true);

                                response = bookingAction.deleteBooking(booking.id, new BookingComment("delete"));
                                bookingAction.checkResponseSuccess(response, true);
                                bookingAction.checkResponsePayloadIsEmpty(response);
    }








    @Autowired private BookingAction bookingAction;
    @Autowired private BillAction billAction;
    @Autowired private ItemsAction itemsAction;
}
