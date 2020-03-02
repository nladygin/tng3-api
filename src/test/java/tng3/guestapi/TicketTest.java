package tng3.guestapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.base.APIResponse;
import tng3.guestapi.action.AccountAction;
import tng3.guestapi.action.BillAction;
import tng3.guestapi.action.TicketAction;
import tng3.guestapi.entity.Accounts;
import tng3.guestapi.entity.Ticket;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
public class TicketTest extends BaseTest {



    @Test
    public void getTickets() {
        APIResponse response = ticketAction.getTickets();
        ticketAction.checkResponseSuccess(response, true);
        ticketAction.validateResponsePayload(response, Ticket.class, true);
    }


    @Test
    public void getActiveTickets() {
        APIResponse response = ticketAction.getTickets(true, null, null, null, null, null);
        ticketAction.checkResponseSuccess(response, true);
        ticketAction.validateResponsePayload(response, Ticket.class, true);
    }


    @Test
    public void getTicketsByWrongDocId() {
        APIResponse response = ticketAction.getTickets(null, 666L, null, null, null, null);
        ticketAction.checkResponseSuccess(response, true);
        ticketAction.checkResponsePayloadIsEmptyList(response);
    }


    @Test
    public void getFreshTickets() {
        APIResponse response = ticketAction.getTickets(null, null, utils.generateDate("dd.MM.YYYY", -1), null, null, null);
        ticketAction.checkResponseSuccess(response, true);
        ticketAction.validateResponsePayload(response, Ticket.class, true);
    }


    @Test
    public void getTicketByNumber() {
        APIResponse response = ticketAction.getTickets();
        ticketAction.checkResponseSuccess(response, true);
        ticketAction.validateResponsePayload(response, Ticket.class, true);

            String code = (String) ((LinkedHashMap) ((ArrayList) response.getPayload()).get(0)).get("number");

            response = ticketAction.getTickets(null, null, null, code, null, null);
            ticketAction.checkResponseSuccess(response, true);
            ticketAction.validateResponsePayload(response, Ticket.class, true);
    }


    @Test
    public void getTicketWithOrderByNumber() {
        APIResponse response = ticketAction.getTickets(null, null, null, null, "number", true);
        ticketAction.checkResponseSuccess(response, true);
        ticketAction.validateResponsePayload(response, Ticket.class, true);
    }


    @Test
    public void getTicketWithOrderByPurchaseDate() {
        APIResponse response = ticketAction.getTickets(null, null, null, null, "purchaseDate", true);
        ticketAction.checkResponseSuccess(response, true);
        ticketAction.validateResponsePayload(response, Ticket.class, true);
    }


    @Test
    public void getTicketWithOrderByReleaseDate() {
        APIResponse response = ticketAction.getTickets(null, null, null, null, "releaseDate", true);
        ticketAction.checkResponseSuccess(response, true);
        ticketAction.validateResponsePayload(response, Ticket.class, true);
    }


    @Test
    public void getTicketWithOrderByTicketId() {
        APIResponse response = ticketAction.getTickets(null, null, null, null, "ticketId", true);
        ticketAction.checkResponseSuccess(response, true);
        ticketAction.validateResponsePayload(response, Ticket.class, true);
    }


    @Test
    public void replaceTicketMediaAuthorized() {
        APIResponse response = ticketAction.getTickets();
        ticketAction.checkResponseSuccess(response, true);
        ticketAction.validateResponsePayload(response, Ticket.class, true);

            String code = (String) ((LinkedHashMap) ((ArrayList) response.getPayload()).get(0)).get("number");

                response = ticketAction.replaceTicketMediaAuthorized(
                        code,
                        String.valueOf(utils.generateDigits(8))
                );
                ticketAction.checkResponseSuccess(response, true);
    }


    @Test
    public void replaceTicketMediaNonAuthorized() {
        APIResponse response = ticketAction.getTickets();
        ticketAction.checkResponseSuccess(response, true);
        ticketAction.validateResponsePayload(response, Ticket.class, true);

            String code = (String) ((LinkedHashMap) ((ArrayList) response.getPayload()).get(0)).get("number");

                response = ticketAction.replaceTicketMediaNonAuthorized(
                        code,
                        String.valueOf(utils.generateDigits(8)),
                        data.emplMagstripe
                );
                ticketAction.checkResponseSuccess(response, true);
    }


    @Test
    public void replaceTicketMediaNonAuthorizedWithWrongEmployee() {
        APIResponse response = ticketAction.getTickets();
            ticketAction.checkResponseSuccess(response, true);
            ticketAction.validateResponsePayload(response, Ticket.class, true);

                String code = (String) ((LinkedHashMap) ((ArrayList) response.getPayload()).get(0)).get("number");

                    response = ticketAction.replaceTicketMediaNonAuthorized(
                            code,
                            String.valueOf(utils.generateDigits(8)),
                            "666"
                    );
                    ticketAction.checkResponseSuccess(response, false);
                    ticketAction.checkResponseErrorCode(response, 10);
                    ticketAction.checkResponsePayloadIsEmpty(response);
    }


    @Test
    public void replaceNonexistentTicketMediaAuthorized() {
        APIResponse response = ticketAction.replaceTicketMediaAuthorized(
                "666",
                String.valueOf(utils.generateDigits(8))
        );
        ticketAction.checkResponseSuccess(response, false);
        ticketAction.checkResponseErrorCode(response, 10);
        ticketAction.checkResponsePayloadIsEmpty(response);
    }


    @Test
    public void replaceNonexistentTicketMediaNonAuthorized() {
        APIResponse response = ticketAction.replaceTicketMediaNonAuthorized(
                "666",
                String.valueOf(utils.generateDigits(8)),
                data.emplMagstripe
        );
        ticketAction.checkResponseSuccess(response, false);
        ticketAction.checkResponseErrorCode(response, 10);
        ticketAction.checkResponsePayloadIsEmpty(response);
    }


    @Test
    public void replaceNonexistentTicketMediaNonAuthorizedWithWrongEmployee() {
        APIResponse response = ticketAction.replaceTicketMediaNonAuthorized(
                "666",
                String.valueOf(utils.generateDigits(8)),
                "666"
        );
        ticketAction.checkResponseSuccess(response, false);
        ticketAction.checkResponseErrorCode(response, 10);
        ticketAction.checkResponsePayloadIsEmpty(response);
    }


    @Test
    public void assignTicketNumberByTicketId() {
        APIResponse response = ticketAction.getTickets();
        ticketAction.checkResponseSuccess(response, true);
        ticketAction.validateResponsePayload(response, Ticket.class, true);

            String code = utils.generateDate("YYYYMMddHHmmss", 0);
            int id = (int) ((LinkedHashMap) ((ArrayList) response.getPayload()).get(0)).get("ticketId");

                response = ticketAction.assignTicketNumberByTicketId(id, code);
                ticketAction.checkResponseSuccess(response, true);
    }


    @Test
    public void assignTicketNumberByWrongTicketId() {
        APIResponse response = ticketAction.getTickets();
        ticketAction.checkResponseSuccess(response, true);
        ticketAction.validateResponsePayload(response, Ticket.class, true);

            String code = utils.generateDate("YYYYMMddHHmmss", 0);

                response = ticketAction.assignTicketNumberByTicketId(666, code);
                ticketAction.checkResponseSuccess(response, false);
                ticketAction.checkResponseErrorCode(response, 10);
                ticketAction.checkResponsePayloadIsEmpty(response);
    }






    @Autowired private TicketAction ticketAction;
}
