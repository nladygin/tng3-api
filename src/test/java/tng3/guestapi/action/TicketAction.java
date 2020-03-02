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
        return getTickets(null, null, null, null, null, null);
    }


    public APIResponse getTickets(Boolean onlyActive, Long docId, String releasedAfter, String ticketNum, String orderBy, Boolean orderAsc) {
        HashMap<String, String> additional = new HashMap<>();
            if (onlyActive != null) {
                additional.put("only_active", onlyActive ? "true" : "false");
            }
            if (docId != null) {
                additional.put("doc_id", String.valueOf(docId));
            }
            if (releasedAfter != null) {
                additional.put("released_after", releasedAfter);
            }
            if (ticketNum != null) {
                additional.put("ticket_num", ticketNum);
            }
            if (orderBy != null) {
                additional.put("order_by", orderBy);
            }
            if (orderAsc != null) {
                additional.put("order_asc", orderAsc ? "true":"false");
            }
        return requestHelper.go(endpoint, Method.GET, null, additional);
    }


    public APIResponse replaceTicketMediaNonAuthorized(String originalCode, String newCode, String emplMagstripe) {
        HashMap<String, String> additional = new HashMap<>();
            additional.put("empl", emplMagstripe);
        return requestHelper.go(endpoint + "/replace/" + originalCode + "/" + newCode, Method.POST, null, additional, false);
    }


    public APIResponse replaceTicketMediaAuthorized(String originalCode, String newCode) {
        return requestHelper.go(endpoint + "/replace/" + originalCode + "/" + newCode, Method.POST, null, null, true);
    }


    public APIResponse assignTicketNumberByTicketId(Integer ticketId, String ticketNum) {
        HashMap<String, String> additional = new HashMap<>();
            additional.put("ticket_num", ticketNum);
        return requestHelper.go(endpoint + "/" + ticketId, Method.POST, null, additional);
    }


}
