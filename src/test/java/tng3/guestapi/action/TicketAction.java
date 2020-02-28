package tng3.guestapi.action;

import io.restassured.http.Method;
import org.springframework.stereotype.Component;
import tng3.base.APIResponse;
import tng3.base.Action;

import java.util.HashMap;

@Component
public class TicketAction extends Action {

    private final String endpoint = "/api/tickets";



    public APIResponse getTickets() {
        return requestHelper.go(endpoint, Method.GET, null, null);
    }


    public APIResponse replaceTicketMediaNonAuthorized(String originalCode, String newCode, String emplMagstripe) {
        HashMap<String, String> additional = new HashMap<>();
            additional.put("empl", emplMagstripe);
        return requestHelper.go(endpoint + "/replace/" + originalCode + "/" + newCode, Method.POST, null, additional, false);
    }


    public APIResponse replaceTicketMediaAuthorized(String originalCode, String newCode) {
        return requestHelper.go(endpoint + "/replace/" + originalCode + "/" + newCode, Method.POST, null, null, true);
    }



}
