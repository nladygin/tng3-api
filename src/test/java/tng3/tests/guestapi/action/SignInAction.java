package tng3.tests.guestapi.action;

import io.restassured.http.Method;
import org.springframework.stereotype.Component;
import tng3.base.APIResponse;
import tng3.base.Action;
import tng3.tests.guestapi.entity.Credentials;

@Component
public class SignInAction extends Action {

    private final String endpoint = "/api/signin";



    public APIResponse signIn(Credentials credentials){
        return requestHelper.go(endpoint, Method.POST, credentials, null);
    }


}
