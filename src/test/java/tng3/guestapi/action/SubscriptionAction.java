package tng3.guestapi.action;

import io.restassured.http.Method;
import org.springframework.stereotype.Component;
import tng3.base.APIResponse;
import tng3.base.Action;

@Component
public class SubscriptionAction extends Action {

    private final String endpoint = "/api/subscriptions";



    public APIResponse getSubscriptions(){
        return requestHelper.go(endpoint, Method.GET, null, null);
    }


}
