package tng3.staffapi.action;

import io.restassured.http.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tng3.base.APIResponse;
import tng3.base.Action;
import tng3.helper.RequestHelper;

import java.util.HashMap;

@Component
public class ClientAction extends Action {

    final private String endpointList = "/staffapi/clients";
    final private String endpointSearch = "/staffapi/client";



    public APIResponse getClients(){
        return requestHelper.go(endpointList, Method.GET, null, null);
    }


    public APIResponse getClientsByName(String name){
        return requestHelper.go(endpointSearch + "/" + name, Method.GET, null, null);
    }


    public APIResponse searchClients(String searchString){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("search", searchString);
        return requestHelper.go(endpointList, Method.GET, null, additional);
    }


    public APIResponse getClientInfo(int cardId){
        return requestHelper.go(endpointList + "/" + cardId, Method.GET, null, null);
    }


    public APIResponse getClientAccounts(int cardId){
        return requestHelper.go(endpointList + "/" + cardId + "/accounts", Method.GET, null, null);
    }


    public APIResponse getClientVouchers(int cardId){
        return requestHelper.go(endpointList + "/" + cardId + "/vouchers", Method.GET, null, null);
    }



    @Autowired private RequestHelper requestHelper;
}
