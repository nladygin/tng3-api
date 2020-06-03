package tng3.guestapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.base.APIResponse;
import tng3.guestapi.action.SignInAction;
import tng3.guestapi.entity.Credentials;
import tng3.guestapi.entity.Session;


@RunWith(SpringJUnit4ClassRunner.class)
public class SignInTest extends BaseTest {



    @Test
    public void signInByEmail() {
        Credentials credentials = new Credentials(data.cardEmail, data.cardPassword);
        APIResponse response = signInAction.signIn(credentials);
        signInAction.checkResponseSuccess(response, true);
        signInAction.validateResponsePayload(response, Session.class, false);
    }


    @Test
    public void signInByWrongEmail() {
        Credentials credentials = new Credentials("wrongemail@email.email", data.cardPassword);
        APIResponse response = signInAction.signIn(credentials);
        signInAction.checkResponseSuccess(response, false);
        signInAction.checkResponseErrorCode(response, 3);
    }


    @Test
    public void signInByEmailWithWrongPassword() {
        Credentials credentials = new Credentials(data.cardEmail, "666");
        APIResponse response = signInAction.signIn(credentials);
        signInAction.checkResponseSuccess(response, false);
        signInAction.checkResponseErrorCode(response, 3);
    }


    @Test
    public void signInByPhone() {
        Credentials credentials = new Credentials(data.cardPhone, data.cardPassword);
        APIResponse response = signInAction.signIn(credentials);
        signInAction.checkResponseSuccess(response, true);
        signInAction.validateResponsePayload(response, Session.class, false);
    }


    @Test
    public void signInByWrongPhone() {
        Credentials credentials = new Credentials("89226666666", data.cardPassword);
        APIResponse response = signInAction.signIn(credentials);
        signInAction.checkResponseSuccess(response, false);
        signInAction.checkResponseErrorCode(response, 3);
    }


    @Test
    public void signInByPhoneWithWrongPassword() {
        Credentials credentials = new Credentials(data.cardPhone, "666");
        APIResponse response = signInAction.signIn(credentials);
        signInAction.checkResponseSuccess(response, false);
        signInAction.checkResponseErrorCode(response, 3);
    }


    @Test
    public void signInByMagstripe() {
        Credentials credentials = new Credentials(data.cardMagstripe, null, data.cardPassword);
        APIResponse response = signInAction.signIn(credentials);
        signInAction.checkResponseSuccess(response, true);
        signInAction.validateResponsePayload(response, Session.class, false);
    }


    @Test
    public void signInByWrongMagstripe() {
        Credentials credentials = new Credentials("MS666666666", null, data.cardPassword);
        APIResponse response = signInAction.signIn(credentials);
        signInAction.checkResponseSuccess(response, false);
        signInAction.checkResponseErrorCode(response, 3);
    }


    @Test
    public void signInByMagstripeWithWrongPassword() {
        Credentials credentials = new Credentials(data.cardMagstripe, null,"666");
        APIResponse response = signInAction.signIn(credentials);
        signInAction.checkResponseSuccess(response, false);
        signInAction.checkResponseErrorCode(response, 3);
    }








    @Autowired private SignInAction signInAction;
}
