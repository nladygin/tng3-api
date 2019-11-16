package tng3.guestapi;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.base.APIResponse;
import tng3.guestapi.action.PasswordAction;
import tng3.guestapi.action.ProfileAction;


@RunWith(SpringJUnit4ClassRunner.class)
public class PasswordTest extends BaseTest {



    @Test
    public void restorePassword() {
        APIResponse response = passwordAction.restorePassword(data.cardEmail);
        passwordAction.checkResponseSuccess(response, true);
        passwordAction.checkResponsePayloadIsEmpty(response);
    }



    @Test
    public void restorePasswordWithEmptyEmail() {
        APIResponse response = passwordAction.restorePassword("");
        passwordAction.checkResponseSuccess(response, false);
        passwordAction.checkResponseErrorCode(response, 999);
    }



    @Test
    public void changePassword() {
        APIResponse response = passwordAction.changePassword(data.cardPassword);
        passwordAction.checkResponseSuccess(response, true);
        passwordAction.checkResponsePayloadIsEmpty(response);
    }



    @Test
    public void changePasswordWithEmpty() {
        APIResponse response = passwordAction.changePassword("");
        passwordAction.checkResponseSuccess(response, false);
        passwordAction.checkResponseErrorCode(response, 162);
    }







    @Autowired private PasswordAction passwordAction;
}
