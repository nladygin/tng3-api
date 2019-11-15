package tng3.guestapi.action;

import io.restassured.http.Method;
import org.springframework.stereotype.Component;
import tng3.base.APIResponse;
import tng3.base.Action;
import tng3.guestapi.entity.PlainText;

@Component
public class PasswordAction extends Action {

    private final String endpoint = "/api/profile/password";



    public APIResponse restorePassword(String email){
        return requestHelper.go(endpoint, Method.PUT, new PlainText(email), null);
    }


    public APIResponse changePassword(String password){
        return requestHelper.go(endpoint, Method.POST, new PlainText(password), null);
    }



}
