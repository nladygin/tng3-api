package tng3.tests.guestapi.action;

import io.restassured.http.Method;
import org.springframework.stereotype.Component;
import tng3.base.APIResponse;
import tng3.base.Action;

@Component
public class CouponAction extends Action {

    private final String endpoint = "/api/coupons";



    public APIResponse getCoupons(){
        return requestHelper.go(endpoint, Method.GET, null, null);
    }


}
