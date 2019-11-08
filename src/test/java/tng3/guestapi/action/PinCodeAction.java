package tng3.guestapi.action;

import io.restassured.http.Method;
import org.springframework.stereotype.Component;
import tng3.base.APIResponse;
import tng3.base.Action;
import tng3.guestapi.entity.PinCodeRequest;

@Component
public class PinCodeAction extends Action {

    private final String endpoint = "/api/pincode";



    public APIResponse requestPinCode(PinCodeRequest request){
        return requestHelper.go(endpoint, Method.POST, request, null);
    }


}
