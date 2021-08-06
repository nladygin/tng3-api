package tng3.tests.directory.action;

import io.restassured.http.Method;
import org.springframework.stereotype.Component;
import tng3.base.APIResponse;
import tng3.base.Action;
import tng3.common.entity.ListOfValues;

@Component
public class ListOfValuesAction extends Action {

    private final String endpoint = "/api/directory/";  // "/directory/{name}/content";



    public APIResponse syncLov(String dirName, ListOfValues listOfValues){
        return requestHelper.go(endpoint + dirName + "/content", Method.POST, listOfValues, null);
    }


}
