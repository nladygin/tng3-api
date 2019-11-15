package tng3.staffapi.action;

import io.restassured.http.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tng3.base.Action;
import tng3.base.APIResponse;
import tng3.helper.RequestHelper;

import java.util.HashMap;

@Component
public class ScheduleAction extends Action {

    final private String endpoint = "/staffapi/schedules";



    public APIResponse getSchedule(String from, String to){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("from", from);
            additional.put("to", to);
        return requestHelper.go(endpoint, Method.GET, null, additional);
    }


    @Autowired private RequestHelper requestHelper;
}
