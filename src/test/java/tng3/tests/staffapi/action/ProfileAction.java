package tng3.tests.staffapi.action;

import io.restassured.http.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tng3.base.APIResponse;
import tng3.base.Action;
import tng3.helper.RequestHelper;

@Component
public class ProfileAction extends Action {

    final private String endpoint = "/staffapi/profile";



    public APIResponse getProfile(){
        return requestHelper.go(endpoint, Method.GET, null, null);
    }


    @Autowired private RequestHelper requestHelper;
}
