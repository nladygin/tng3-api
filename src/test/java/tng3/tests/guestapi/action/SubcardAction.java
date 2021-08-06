package tng3.tests.guestapi.action;

import io.restassured.http.Method;
import org.springframework.stereotype.Component;
import tng3.base.APIResponse;
import tng3.base.Action;
import tng3.tests.guestapi.entity.Subcard;

@Component
public class SubcardAction extends Action {

    private final String endpoint = "/api/profile/subcards";



    public APIResponse getSubcards(){
        return requestHelper.go(endpoint, Method.GET, null, null);
    }


    public APIResponse addSubcard(Subcard subcard) {
        return requestHelper.go(endpoint, Method.POST, subcard, null);
    }


    public APIResponse editSubcard(int id, Subcard subcard) {
        return requestHelper.go(endpoint + "/" + id, Method.POST, subcard, null);
    }


    public APIResponse deleteSubcard(int id) {
        return requestHelper.go(endpoint + "/" + id, Method.DELETE, null, null);
    }


}
