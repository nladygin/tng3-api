package tng3.guestapi;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.base.APIResponse;
import tng3.guestapi.action.PasswordAction;
import tng3.guestapi.action.PinCodeAction;
import tng3.guestapi.entity.PinCode;
import tng3.guestapi.entity.PinCodeRequest;


@RunWith(SpringJUnit4ClassRunner.class)
public class PinCodeTest extends BaseTest {



    @Test @Ignore("Sending the email to the following server failed : smtp.yandex.ru:465")
    public void requestPinCodeByEmail() {
        PinCodeRequest pinCodeRequest = new PinCodeRequest(data.cardEmail, null);
        APIResponse response = pinCodeAction.requestPinCode(pinCodeRequest);
        pinCodeAction.checkResponseSuccess(response, true);
        pinCodeAction.validateResponsePayload(response, PinCode.class, false);
            response = passwordAction.changePassword(data.cardPassword);
            passwordAction.checkResponseSuccess(response, true);
            passwordAction.checkResponsePayloadIsEmpty(response);
    }


    @Ignore
    @Test
    public void requestPinCodeByPhone() {
        PinCodeRequest pinCodeRequest = new PinCodeRequest(null, data.cardPhone);
        APIResponse response = pinCodeAction.requestPinCode(pinCodeRequest);
        pinCodeAction.checkResponseSuccess(response, true);
        pinCodeAction.validateResponsePayload(response, PinCode.class, false);
            response = passwordAction.changePassword(data.cardPassword);
            passwordAction.checkResponseSuccess(response, true);
            passwordAction.checkResponsePayloadIsEmpty(response);
    }


    @Test
    public void requestPinCodeByWrongEmail() {
        PinCodeRequest pinCodeRequest = new PinCodeRequest("wrongemail@email.email", null);
        APIResponse response = pinCodeAction.requestPinCode(pinCodeRequest);
        pinCodeAction.checkResponseSuccess(response, false);
        pinCodeAction.checkResponseErrorCode(response, 121);
    }


    @Test
    public void requestPinCodeByWrongPhone() {
        PinCodeRequest pinCodeRequest = new PinCodeRequest(null, "12345678900");
        APIResponse response = pinCodeAction.requestPinCode(pinCodeRequest);
        pinCodeAction.checkResponseSuccess(response, false);
        pinCodeAction.checkResponseErrorCode(response, 121);
    }




    @Autowired private PinCodeAction pinCodeAction;
    @Autowired private PasswordAction passwordAction;
}
