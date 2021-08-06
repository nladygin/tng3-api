package tng3.tests.guestapi.action;

import io.restassured.http.Method;
import org.springframework.stereotype.Component;
import tng3.base.APIResponse;
import tng3.base.Action;

import java.util.HashMap;

@Component
public class DocAction extends Action {

    private final String endpoint = "/api/docs";



    public APIResponse getDocs(int offset, int count, String account, String from, String to){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("offset", String.valueOf(offset));
            additional.put("count", String.valueOf(count));
            if (account != null) {
                additional.put("acc", account);
            }
            if (from != null) {
                additional.put("from", from);
            }
            if (to != null) {
                additional.put("to", to);
            }
        return requestHelper.go(endpoint, Method.GET, null, additional);
    }


}
