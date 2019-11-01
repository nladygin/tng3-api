package tng3.staffapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.base.APIResponse;
import tng3.staffapi.action.ClientAction;
import tng3.staffapi.action.ScheduleAction;
import tng3.staffapi.entity.Client;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public class ClientTest extends BaseTest {


    @Test
    public void getClients(){
        APIResponse response = clientAction.getClients();
        clientAction.checkResponseSuccess(response, true);
        clientAction.validateResponsePayload(response, Client.class, true);
    }


    @Test
    public void getClientsByName(){
        APIResponse response = clientAction.getClientsByName("API");
        clientAction.checkResponseSuccess(response, true);
        clientAction.validateResponsePayload(response, Client.class, true);
    }


    @Test
    public void getClientsByWrongName(){
        APIResponse response = clientAction.getClientsByName("WRONGCLIENTNAME");
        clientAction.checkResponseSuccess(response, true);
        clientAction.checkResponsePayloadIsEmptyList(response);
    }





    @Autowired private ClientAction clientAction;
}
