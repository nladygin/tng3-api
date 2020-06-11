package tng3.staffapi.action;

import io.restassured.http.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tng3.base.APIResponse;
import tng3.base.Action;
import tng3.helper.RequestHelper;
import tng3.staffapi.entity.EmployeeOutlet;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class OutletAction extends Action {

    final private String endpoint = "/staffapi/profile/outlet";



    public APIResponse changeOutlet(int outletId){
        return requestHelper.go(endpoint + "/" + outletId, Method.PUT, null, null);
    }


    public void checkOutletId(EmployeeOutlet outlet, int expectedOutletId) {
        assertThat(outlet.id, equalTo(expectedOutletId));
    }


    @Autowired private RequestHelper requestHelper;
}
