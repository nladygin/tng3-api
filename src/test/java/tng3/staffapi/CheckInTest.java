package tng3.staffapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.base.APIResponse;
import tng3.staffapi.action.CheckInAction;

@RunWith(SpringJUnit4ClassRunner.class)
public class CheckInTest extends BaseTest {


    @Test
    public void checkInGuest(){
        APIResponse response = checkInAction.checkInGuest(String.valueOf(data.cardID));
        checkInAction.checkResponseSuccess(response, true);
    }


    @Test
    public void checkInWrongGuest(){
        APIResponse response = checkInAction.checkInGuest("999999999");
        checkInAction.checkResponseSuccess(response, false);
        checkInAction.checkResponseErrorCode(response, 13);
    }


    @Test
    public void checkInGuestByMagstripe(){
        APIResponse response = checkInAction.checkInGuest(data.cardMagstripe);
        checkInAction.checkResponseSuccess(response, false);
        checkInAction.checkResponseErrorCode(response, 13);
    }


    @Test
    public void checkInEmptyGuest(){
        APIResponse response = checkInAction.checkInGuest("");
        checkInAction.checkResponseSuccess(response, false);
        checkInAction.checkResponseErrorCode(response, 13);
    }



    @Autowired private CheckInAction checkInAction;
}
