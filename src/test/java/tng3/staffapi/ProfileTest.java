package tng3.staffapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.base.APIResponse;
import tng3.staffapi.action.ProfileAction;
import tng3.staffapi.action.ScheduleAction;
import tng3.staffapi.entity.EmployeeProfile;
import tng3.staffapi.entity.Schedule;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProfileTest extends BaseTest {


    @Test
    public void getProfile(){
        APIResponse response = profileAction.getProfile();
        profileAction.checkResponseSuccess(response, true);
        profileAction.validateResponsePayload(response, EmployeeProfile.class, false);
    }



    @Autowired private ProfileAction profileAction;
}
