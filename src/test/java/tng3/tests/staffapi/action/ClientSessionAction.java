package tng3.tests.staffapi.action;

import io.restassured.http.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tng3.base.APIResponse;
import tng3.base.Action;
import tng3.helper.RequestHelper;

import java.util.HashMap;

@Component
public class ClientSessionAction extends Action {

    final private String endpoint = "/staffapi/client_session_key";



    public APIResponse getClientSession(String clientEmail){
        HashMap<String, String> additional = new HashMap<>();
            if (clientEmail != null) {
                additional.put("email", clientEmail);
            }
            if (additional.isEmpty()) {
                additional = null;
            }
        return requestHelper.go(endpoint, Method.GET, null, additional);
    }


    @Autowired private RequestHelper requestHelper;
}
