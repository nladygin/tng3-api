package tng3.tests.guestapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.base.APIResponse;
import tng3.common.entity.Outlet;
import tng3.tests.guestapi.action.OutletAction;


@RunWith(SpringJUnit4ClassRunner.class)
public class OutletTest extends BaseTest {



    @Test
    public void getOutlets() {
        APIResponse response = outletAction.getOutlets();
        outletAction.checkResponseSuccess(response, true);
        outletAction.validateResponsePayload(response, Outlet.class, true);
    }



    @Autowired private OutletAction outletAction;
}
