package tng3.tests.guestapi.action;

import io.restassured.http.Method;
import org.springframework.stereotype.Component;
import tng3.base.APIResponse;
import tng3.base.Action;

@Component
public class AccountAction extends Action {

    private final String endpoint = "/api/accounts";



    public APIResponse getAccounts(){
        return requestHelper.go(endpoint, Method.GET, null, null);
    }


}
