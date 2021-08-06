package tng3.tests.guestapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.base.APIResponse;
import tng3.tests.guestapi.action.VisitAction;
import tng3.tests.guestapi.entity.Visit;


@RunWith(SpringJUnit4ClassRunner.class)
public class VisitTest extends BaseTest {



    @Test
    public void getSpaVisits() {
        APIResponse response = visitAction.getVisits(false);
        visitAction.checkResponseSuccess(response, true);
        visitAction.validateResponsePayload(response, Visit.class, true);
    }



    @Test
    public void getHotelVisits() {
        APIResponse response = visitAction.getVisits(true);
        visitAction.checkResponseSuccess(response, true);
        visitAction.validateResponsePayload(response, Visit.class, true);
    }





    @Autowired private VisitAction visitAction;
}
