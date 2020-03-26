package tng3.staffapi.action;

import io.restassured.http.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tng3.base.APIResponse;
import tng3.base.Action;
import tng3.helper.RequestHelper;

import java.util.HashMap;

@Component
public class OfferAction extends Action {

    final private String endpoint = "/staffapi/offers";



    public APIResponse getOffers(String cardId, Boolean upsell, String barcode) {
        HashMap<String, String> additional = new HashMap<>();
        if (cardId != null) {
            additional.put("card_id", cardId);
        }
        if (upsell != null) {
            additional.put("upsell", "true");
        }
        if (barcode != null) {
            additional.put("barcode", barcode);
        }
        if (additional.isEmpty()) additional = null;
        return requestHelper.go(endpoint, Method.GET, null, additional);
    }


    public APIResponse getOffers(String cardId) {
        return getOffers(cardId, null, null);
    }


    public APIResponse getOfferByBarcode(String barcode) {
        return getOffers(null, null, barcode);
    }


    public APIResponse getOffersForUpSale() {
        return getOffers(null, true, null);
    }


    public APIResponse getOfferAvailability(int offerId, Integer cardId, String from, String to, Long fromMs, Long toMs) {
        HashMap<String, String> additional = new HashMap<>();
            if (cardId != null) {
                additional.put("card_id", String.valueOf(cardId));
            }
            if (from != null) {
                additional.put("from", from);
            }
            if (to != null) {
                additional.put("to", to);
            }
            if (fromMs != null) {
                additional.put("from_ms", String.valueOf(fromMs));
            }
            if (toMs != null) {
                additional.put("to_ms", String.valueOf(toMs));
            }
            if (additional.isEmpty()) {
                additional = null;
            }
        return requestHelper.go(endpoint + "/" + offerId + "/availability", Method.GET, null, additional);
    }




    @Autowired private RequestHelper requestHelper;
}
