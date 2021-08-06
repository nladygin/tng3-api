package tng3.tests.med.action;

import io.restassured.http.Method;
import org.springframework.stereotype.Component;
import tng3.base.APIResponse;
import tng3.base.Action;
import tng3.common.entity.PlainText;

import java.util.HashMap;

@Component
public class MedAction extends Action {

    private final String endpoint = "/api/med";  // "/directory/{name}/content";



    public APIResponse getProfile(int profileId){
        return requestHelper.go(endpoint + "/profile/" + profileId, Method.GET, null, null);
    }

    public APIResponse getRegistryByRange(String from, String to){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("from", from);
            additional.put("to", to);
        return requestHelper.go(endpoint + "/registry", Method.GET, null, additional);
    }

    public APIResponse getRegistryByID(long id){
        return requestHelper.go(endpoint + "/registry/" + id, Method.GET, null, null);
    }

    public APIResponse getEMRByID(long id){
        return requestHelper.go(endpoint + "/emr/" + id, Method.GET, null, null);
    }

    public APIResponse getEMRPdfByID(long id){
        return requestHelper.go(endpoint + "/emr/" + id + "/" + id + ".pdf", Method.GET, null, null);
    }

    public APIResponse signEMR(long id, String type, String sign){
        return requestHelper.go(endpoint + "/sign/" + id + "/" + type, Method.POST, new PlainText(sign), null);
    }

    public APIResponse getEmployeeByID(long id){
        return requestHelper.go(endpoint + "/employee/" + id, Method.GET, null, null);
    }



}
