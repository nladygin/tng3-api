package tng3.tests.staffapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.base.APIResponse;
import tng3.tests.staffapi.action.OutletAction;
import tng3.tests.staffapi.entity.EmployeeOutlet;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
public class OutletTest extends BaseTest {


    @Test
    public void changeOutlet() throws IOException {
        APIResponse response = outletAction.changeOutlet(data.outletID);
        outletAction.checkResponseSuccess(response, true);
        outletAction.validateResponsePayload(response, EmployeeOutlet.class, false);
        EmployeeOutlet employeeOutlet = (EmployeeOutlet) utils.toEntity(response, EmployeeOutlet.class);
        outletAction.checkOutletId(employeeOutlet, data.outletID);
    }


    @Test
    public void changeToWrongOutlet() {
        APIResponse response = outletAction.changeOutlet(666);
        outletAction.checkResponseSuccess(response, false);
        outletAction.checkResponseErrorCode(response, 404);
    }





    @Autowired private OutletAction outletAction;
}
