package tng3.guestapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.base.APIResponse;
import tng3.entity.Therapist;
import tng3.guestapi.action.AccountAction;
import tng3.guestapi.action.TherapistAction;
import tng3.guestapi.entity.Accounts;


@RunWith(SpringJUnit4ClassRunner.class)
public class TherapistTest extends BaseTest {



    @Test
    public void getTherapists() {
        APIResponse response = therapistAction.getTherapists(data.outletID);
        therapistAction.checkResponseSuccess(response, true);
        therapistAction.validateResponsePayload(response, Therapist.class, true);
    }


    @Test
    public void getTherapistsWithWrongOutlet() {
        APIResponse response = therapistAction.getTherapists(666);
        therapistAction.checkResponseSuccess(response, true);
        therapistAction.checkResponsePayloadIsEmptyList(response);
    }






    @Autowired private TherapistAction therapistAction;
}
