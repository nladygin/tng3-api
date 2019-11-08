package tng3.guestapi.action;

import io.restassured.http.Method;
import org.springframework.stereotype.Component;
import tng3.base.APIResponse;
import tng3.base.Action;

@Component
public class MembershipAction extends Action {

    private final String endpoint = "/api/memberships";



    public APIResponse getMemberships(){
        return requestHelper.go(endpoint, Method.GET, null, null);
    }


}
