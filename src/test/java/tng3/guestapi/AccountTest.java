package tng3.guestapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.base.APIResponse;
import tng3.guestapi.action.AccountAction;
import tng3.guestapi.entity.Accounts;


@RunWith(SpringJUnit4ClassRunner.class)
public class AccountTest extends BaseTest {



    @Test
    public void getAccounts() {
        APIResponse response = accountAction.getAccounts();
        accountAction.checkResponseSuccess(response, true);
        accountAction.validateResponsePayload(response, Accounts.class, false);
    }



    @Autowired private AccountAction accountAction;
}
