package tng3.guestapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.base.APIResponse;
import tng3.common.entity.Therapist;
import tng3.guestapi.action.OfferAction;
import tng3.guestapi.entity.Offers;
import tng3.guestapi.entity.TimeSlotsDetails;

import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)
public class OfferTest extends BaseTest {



    @Test
    public void getOffers() {
        APIResponse response = offerAction.getOffers(
                data.outletID,
                data.offset,
                data.count
        );
        offerAction.checkResponseSuccess(response, true);
        offerAction.validateResponsePayload(response, Offers.class, false);
    }


    @Test
    public void getOffersWithoutOutlet() {
        APIResponse response = offerAction.getOffers(
                null,
                data.offset,
                data.count
        );
        offerAction.checkResponseSuccess(response, true);
        offerAction.validateResponsePayload(response, Offers.class, false);
    }


    @Test
    public void getTherapistForOffer() {
        APIResponse response = offerAction.getOfferTherapists(
                data.outletID,
                data.offset,
                data.count,
                data.offerID
        );
        offerAction.checkResponseSuccess(response, true);
        offerAction.validateResponsePayload(response, Therapist.class, true);
    }


    @Test
    public void getTherapistForWrongOffer() {
        APIResponse response = offerAction.getOfferTherapists(
                data.outletID,
                data.offset,
                data.count,
                666
        );
        offerAction.checkResponseSuccess(response, true);
        offerAction.checkResponsePayloadIsEmptyList(response);
    }


    @Test
    public void getAvailabilityForOffer() {
        APIResponse response = offerAction.getOfferAvailability(
                data.outletID,
                data.offset,
                data.count,
                data.offerID,
                utils.generateDate("ddMMYYYY", 0),
                utils.generateDate("ddMMYYYY", 7),
                null
        );
        offerAction.checkResponseSuccess(response, true);
        offerAction.validateResponsePayload(response, Date.class, true);
    }


    @Test
    public void getAvailabilityForOfferWithTherapist() {
        APIResponse response = offerAction.getOfferAvailability(
                data.outletID,
                data.offset,
                data.count,
                data.offerID,
                utils.generateDate("ddMMYYYY", 0),
                utils.generateDate("ddMMYYYY", 7),
                data.therapistID
        );
        offerAction.checkResponseSuccess(response, true);
        offerAction.validateResponsePayload(response, Date.class, true);
    }


    @Test
    public void getAvailabilityForOfferWithWrongTherapist() {
        APIResponse response = offerAction.getOfferAvailability(
                data.outletID,
                data.offset,
                data.count,
                data.offerID,
                utils.generateDate("ddMMYYYY", 0),
                utils.generateDate("ddMMYYYY", 7),
                666
        );
        offerAction.checkResponseSuccess(response, true);
        offerAction.checkResponsePayloadIsEmptyList(response);
    }


    @Test
    public void getOfferCapacityFrom() {
        APIResponse response = offerAction.getOfferCapacity(
                data.outletID,
                data.offset,
                data.count,
                data.offerID,
                utils.generateDate("dd.MM.YYYY HH:mm", 0),
                null
        );
        offerAction.checkResponseSuccess(response, true);
        offerAction.validateResponsePayload(response, Integer.class, false);
    }


    @Test
    public void getWrongOfferCapacityFrom() {
        APIResponse response = offerAction.getOfferCapacity(
                data.outletID,
                data.offset,
                data.count,
                666,
                utils.generateDate("dd.MM.YYYY HH:mm", 0),
                null
        );
        offerAction.checkResponseSuccess(response, false);
        offerAction.checkResponsePayloadIsEmpty(response);
        offerAction.checkResponseErrorCode(response, 0);
    }


    @Test
    public void getOfferCapacityFromMS() {
        APIResponse response = offerAction.getOfferCapacity(
                data.outletID,
                data.offset,
                data.count,
                data.offerID,
                null,
                utils.generateDateMS(0)
        );
        offerAction.checkResponseSuccess(response, true);
        offerAction.validateResponsePayload(response, Integer.class, false);
    }


    @Test
    public void getWrongOfferCapacityFromMS() {
        APIResponse response = offerAction.getOfferCapacity(
                data.outletID,
                data.offset,
                data.count,
                666,
                null,
                utils.generateDateMS(0)
        );
        offerAction.checkResponseSuccess(response, false);
        offerAction.checkResponsePayloadIsEmpty(response);
        offerAction.checkResponseErrorCode(response, 0);
    }


    @Test
    public void getAvailabilityForTicket() {
        APIResponse response = offerAction.getTicketAvailability(
                data.outletID,
                data.offset,
                data.count,
                data.offerTicketID,
                utils.generateDate("ddMMYYYY", 0),
                utils.generateDate("ddMMYYYY", 7),
                null
        );
        offerAction.checkResponseSuccess(response, true);
        offerAction.validateResponsePayload(response, TimeSlotsDetails.class, false);
        offerAction.checkOnNotEmptyTimeSlotDetails(response);
    }


    @Test
    public void getAvailabilityForTicketWithGuests() {
        APIResponse response = offerAction.getTicketAvailability(
                data.outletID,
                data.offset,
                data.count,
                data.offerTicketID,
                utils.generateDate("ddMMYYYY", 0),
                utils.generateDate("ddMMYYYY", 7),
                10
        );
        offerAction.checkResponseSuccess(response, true);
        offerAction.validateResponsePayload(response, TimeSlotsDetails.class, false);
        offerAction.checkOnNotEmptyTimeSlotDetails(response);
    }


    @Test
    public void getAvailabilityForTicketWithHugeCrowd() {
        APIResponse response = offerAction.getTicketAvailability(
                data.outletID,
                data.offset,
                data.count,
                data.offerTicketID,
                utils.generateDate("ddMMYYYY", 0),
                utils.generateDate("ddMMYYYY", 7),
                1000
        );
        offerAction.checkResponseSuccess(response, true);
        offerAction.validateResponsePayload(response, TimeSlotsDetails.class, false);
        offerAction.checkOnEmptyTimeSlotDetails(response);
    }


    @Test
    public void getAvailabilityForTicketWithoutUserSession() {
        APIResponse response = offerAction.getTicketAvailability(
                data.outletID,
                data.offset,
                data.count,
                data.offerTicketID,
                utils.generateDate("ddMMYYYY", 0),
                utils.generateDate("ddMMYYYY", 7),
                null,
                false
        );
        offerAction.checkResponseSuccess(response, true);
        offerAction.validateResponsePayload(response, TimeSlotsDetails.class, false);
        offerAction.checkOnNotEmptyTimeSlotDetails(response);
    }


    @Test
    public void getTicketsByOutletAndDateRange() {
        APIResponse response = offerAction.getTicketsByOutletAndDateRange(
                data.outletID,
                utils.generateDateMS(0),
                utils.generateDateMS(1),
                10
        );
        offerAction.checkResponseSuccess(response, true);
        offerAction.validateResponsePayload(response, Offers.class, false);
        offerAction.checkOnOffersNumber(response, 5);
    }


    @Test
    public void getTicketsByOutletDateRangeAndHugeCrowd() {
        APIResponse response = offerAction.getTicketsByOutletAndDateRange(
                data.outletID,
                utils.generateDateMS(0),
                utils.generateDateMS(1),
                1000
        );
        offerAction.checkResponseSuccess(response, true);
        offerAction.validateResponsePayload(response, Offers.class, false);
        offerAction.checkOnOffersNumber(response, 0);
    }


    @Test
    public void getTicketsByOutletAndDateRangeWithoutSession() {
        APIResponse response = offerAction.getTicketsByOutletAndDateRange(
                data.outletID,
                utils.generateDateMS(0),
                utils.generateDateMS(1),
                10,
                false
        );
        offerAction.checkResponseSuccess(response, true);
        offerAction.validateResponsePayload(response, Offers.class, false);
        offerAction.checkOnOffersNumber(response, 5);
    }


    @Test
    public void getVouchers() {
        APIResponse response = offerAction.getVouchers(
                data.outletID
        );
        offerAction.checkResponseSuccess(response, true);
        offerAction.validateResponsePayload(response, Offers.class, false);
        offerAction.checkOnOffersNumber(response, 2);
    }


    @Test
    public void getVouchersWithoutSession() {
        APIResponse response = offerAction.getVouchers(
                data.outletID,
                false
        );
        offerAction.checkResponseSuccess(response, true);
        offerAction.validateResponsePayload(response, Offers.class, false);
        offerAction.checkOnOffersNumber(response, 2);
    }


    @Test
    public void getCombos() {
        APIResponse response = offerAction.getCombo(
                data.outletID
        );
        offerAction.checkResponseSuccess(response, true);
        offerAction.validateResponsePayload(response, Offers.class, false);
        offerAction.checkOnOffersNumber(response, 6);
    }


    @Test
    public void getCombosWithoutSession() {
        APIResponse response = offerAction.getCombo(
                data.outletID,
                false
        );
        offerAction.checkResponseSuccess(response, true);
        offerAction.validateResponsePayload(response, Offers.class, false);
        offerAction.checkOnOffersNumber(response, 6);
    }






    @Autowired private OfferAction offerAction;
}
