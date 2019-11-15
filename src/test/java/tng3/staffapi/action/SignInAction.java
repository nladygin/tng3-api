package tng3.staffapi.action;

import io.restassured.http.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tng3.base.APIResponse;
import tng3.base.Action;
import tng3.helper.RequestHelper;

import java.util.HashMap;

@Component
public class SignInAction extends Action {

    final private String endpoint = "/staffapi/signin";



    public APIResponse signIn(String username, String password, String magstripe){
        HashMap<String, String> additional = new HashMap<>();
            if (username != null) {
                additional.put("username", username);
            }
            if (password != null) {
                additional.put("password", password);
            }
            if (magstripe != null) {
                additional.put("magstripe", magstripe);
            }
            if (additional.isEmpty()) {
                additional = null;
            }
        return requestHelper.go(endpoint, Method.POST, null, additional);
    }


    @Autowired private RequestHelper requestHelper;
}
