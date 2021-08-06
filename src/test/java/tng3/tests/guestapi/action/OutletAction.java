package tng3.tests.guestapi.action;

import io.restassured.http.Method;
import org.springframework.stereotype.Component;
import tng3.base.APIResponse;
import tng3.base.Action;

@Component
public class OutletAction extends Action {

    private final String endpoint = "/api/outlets";



    public APIResponse getOutlets(){
        return requestHelper.go(endpoint, Method.GET, null, null);
    }


}
