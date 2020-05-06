package tng3.staffapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.base.APIResponse;
import tng3.staffapi.action.ClientSessionAction;
import tng3.staffapi.action.SignInAction;
import tng3.staffapi.entity.ClientSession;

@RunWith(SpringJUnit4ClassRunner.class)
public class ClientSessionTest extends BaseTest {


    @Test
    public void getClientSession(){
        APIResponse response = clientSessionAction.getClientSession(data.cardEmail);
        clientSessionAction.checkResponseSuccess(response, true);
        clientSessionAction.validateResponsePayload(response, ClientSession.class, false);
    }








    @Autowired private ClientSessionAction clientSessionAction;

}
