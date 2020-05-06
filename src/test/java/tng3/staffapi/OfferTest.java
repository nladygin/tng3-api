package tng3.staffapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.base.APIResponse;
import tng3.staffapi.action.OfferAction;
import tng3.common.entity.Offer;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
public class OfferTest extends BaseTest {



    @Test
    public void getOffers(){
        APIResponse response = offerAction.getOffers(null);
        offerAction.checkResponseSuccess(response, true);
        offerAction.validateResponsePayload(response, Offer.class, true);
    }


    @Test
    public void getOffersForClient(){
        APIResponse response = offerAction.getOffers(String.valueOf(data.cardID));
        offerAction.checkResponseSuccess(response, true);
        offerAction.validateResponsePayload(response, Offer.class, true);
    }


    @Test
    public void getOffersForUpSell(){
        APIResponse response = offerAction.getOffersForUpSale();
        offerAction.checkResponseSuccess(response, true);
        offerAction.validateResponsePayload(response, Offer.class, true);
    }


    @Test
    public void getOfferByBarcode(){
        APIResponse response = offerAction.getOfferByBarcode(data.offerBarcode);
            offerAction.checkResponseSuccess(response, true);
            offerAction.validateResponsePayload(response, Offer.class, true);
    }


    @Test
    public void getOfferByWrongBarcode(){
        APIResponse response = offerAction.getOfferByBarcode("666");
        offerAction.checkResponseSuccess(response, true);
        offerAction.checkResponsePayloadIsEmptyList(response);
    }


    @Test
    public void getOfferFullAvailability(){
        APIResponse response = offerAction.getOfferAvailability(
                data.offerID,
                null,
                null,
                null,
                null,
                null,
                null
        );
        offerAction.checkResponseSuccess(response, true);
        offerAction.validateResponsePayload(response, Date.class, true);
    }


    @Test
    public void getOfferAvailabilityForClient(){
        APIResponse response = offerAction.getOfferAvailability(
                data.offerID,
                data.cardID,
                null,
                null,
                null,
                null,
                null
        );
        offerAction.checkResponseSuccess(response, true);
        offerAction.validateResponsePayload(response, Date.class, true);
    }


    @Test
    public void getOfferAvailabilityFrom(){
        APIResponse response = offerAction.getOfferAvailability(
                data.offerID,
                null,
                utils.generateDate("ddMMyyy", 1),
                null,
                null,
                null,
                null
        );
        offerAction.checkResponseSuccess(response, true);
        offerAction.validateResponsePayload(response, Date.class, true);
    }


    @Test
    public void getOfferAvailabilityFromTo(){
        APIResponse response = offerAction.getOfferAvailability(
                data.offerID,
                null,
                utils.generateDate("ddMMyyy", 1),
                utils.generateDate("ddMMyyy", 1),
                null,
                null,
                null
        );
        offerAction.checkResponseSuccess(response, true);
        offerAction.validateResponsePayload(response, Date.class, true);
    }


    @Test
    public void getOfferAvailabilityFromMS(){
        APIResponse response = offerAction.getOfferAvailability(
                data.offerID,
                null,
                null,
                null,
                utils.generateDateMS(1),
                null,
                null
        );
        offerAction.checkResponseSuccess(response, true);
        offerAction.validateResponsePayload(response, Date.class, true);
    }


    @Test
    public void getOfferAvailabilityFromMSToMS(){
        APIResponse response = offerAction.getOfferAvailability(
                data.offerID,
                null,
                null,
                null,
                utils.generateDateMS(1),
                utils.generateDateMS(1),
                null
        );
        offerAction.checkResponseSuccess(response, true);
        offerAction.validateResponsePayload(response, Date.class, true);
    }


    @Test
    public void getOfferAvailabilityWithAllResources(){
        APIResponse response = offerAction.getOfferAvailability(
                data.offerID,
                null,
                null,
                null,
                null,
                null,
                true
        );
        offerAction.checkResponseSuccess(response, true);
        offerAction.validateResponsePayload(response, Date.class, true);
    }



    @Autowired private OfferAction offerAction;
}
