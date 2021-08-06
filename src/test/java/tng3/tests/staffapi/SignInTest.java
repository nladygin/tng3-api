package tng3.tests.staffapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.base.APIResponse;
import tng3.tests.staffapi.action.SignInAction;

@RunWith(SpringJUnit4ClassRunner.class)
public class SignInTest extends BaseTest {


    @Test
    public void signInByUsernameAndPassword(){
        APIResponse response = signInAction.signIn(data.emplUsername, data.emplPassword, null);
        signInAction.checkResponseSuccess(response, true);
        signInAction.validateResponsePayload(response, String.class, false);
    }


    @Test
    public void signInByMagstripe(){
        APIResponse response = signInAction.signIn( null, null, data.emplMagstripe);
        signInAction.checkResponseSuccess(response, true);
        signInAction.validateResponsePayload(response, String.class, false);
    }


    @Test
    public void signInByWrongUsernameAndPassword(){
        APIResponse response = signInAction.signIn("WRONGUSERNAME", data.emplPassword, null);
        signInAction.checkResponseSuccess(response, false);
        signInAction.checkResponseErrorCode(response, 3);
    }


    @Test
    public void signInByUsernameAndWrongPassword(){
        APIResponse response = signInAction.signIn(data.emplUsername, "WRONGPASSWORD", null);
        signInAction.checkResponseSuccess(response, false);
        signInAction.checkResponseErrorCode(response, 3);
    }


    @Test
    public void signInByWrongUsernameAndWrongPassword(){
        APIResponse response = signInAction.signIn("WRONGUSERNAME", "WRONGPASSWORD", null);
        signInAction.checkResponseSuccess(response, false);
        signInAction.checkResponseErrorCode(response, 3);
    }


    @Test
    public void signInByWrongMagstripe(){
        APIResponse response = signInAction.signIn( null, null, "WRONGMAGSTRIPE");
        signInAction.checkResponseSuccess(response, false);
        signInAction.checkResponseErrorCode(response, 5);
    }







    @Autowired private SignInAction signInAction;

}
