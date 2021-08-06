package tng3.tests.staffapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.base.APIResponse;
import tng3.tests.guestapi.entity.Account;
import tng3.tests.guestapi.entity.Coupon;
import tng3.tests.guestapi.entity.Profile;
import tng3.tests.staffapi.action.ClientAction;
import tng3.tests.staffapi.entity.Client_;

@RunWith(SpringJUnit4ClassRunner.class)
public class ClientTest extends BaseTest {


    @Test
    public void getClients(){
        APIResponse response = clientAction.getClients();
        clientAction.checkResponseSuccess(response, true);
        clientAction.validateResponsePayload(response, Client_.class, true);
    }


    @Test
    public void getClientsByName(){
        APIResponse response = clientAction.getClientsByName("API");
        clientAction.checkResponseSuccess(response, true);
        clientAction.validateResponsePayload(response, Client_.class, true);
    }


    @Test
    public void getClientsByWrongName(){
        APIResponse response = clientAction.getClientsByName("WRONGCLIENTNAME");
        clientAction.checkResponseSuccess(response, true);
        clientAction.checkResponsePayloadIsEmptyList(response);
    }


    @Test
    public void searchClients(){
        APIResponse response = clientAction.searchClients("Smith");
        clientAction.checkResponseSuccess(response, true);
        clientAction.validateResponsePayload(response, Client_.class, true);
    }


    @Test
    public void searchWrongClients(){
        APIResponse response = clientAction.searchClients("WRONGCLIENTSEARCH");
        clientAction.checkResponseSuccess(response, true);
        clientAction.checkResponsePayloadIsEmptyList(response);
    }


    @Test
    public void getClientInfo(){
        APIResponse response = clientAction.getClientInfo(data.cardID);
        clientAction.checkResponseSuccess(response, true);
        clientAction.validateResponsePayload(response, Profile.class, false);
    }


    @Test
    public void getWrongClientInfo(){
        APIResponse response = clientAction.getClientInfo(666);
        clientAction.checkResponseSuccess(response, false);
        clientAction.checkResponseErrorCode(response, 404);
    }


    @Test
    public void getClientAccounts(){
        APIResponse response = clientAction.getClientAccounts(data.cardID);
        clientAction.checkResponseSuccess(response, true);
        clientAction.validateResponsePayload(response, Account.class, true);
    }


    @Test
    public void getWrongClientAccounts(){
        APIResponse response = clientAction.getClientAccounts(666);
        clientAction.checkResponseSuccess(response, false);
        clientAction.checkResponseErrorCode(response,404);
    }


    @Test
    public void getClientVouchers(){
        APIResponse response = clientAction.getClientVouchers(data.cardID);
        clientAction.checkResponseSuccess(response, true);
        clientAction.validateResponsePayload(response, Coupon.class, true);
    }


    @Test
    public void getWrongClientVouchers(){
        APIResponse response = clientAction.getClientVouchers(666);
        clientAction.checkResponseSuccess(response, false);
        clientAction.checkResponseErrorCode(response, 404);
    }


    @Autowired private ClientAction clientAction;
}
