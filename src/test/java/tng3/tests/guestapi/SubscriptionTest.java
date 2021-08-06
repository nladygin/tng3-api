package tng3.tests.guestapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.base.APIResponse;
import tng3.tests.guestapi.action.SubscriptionAction;
import tng3.tests.guestapi.entity.Subscription;


@RunWith(SpringJUnit4ClassRunner.class)
public class SubscriptionTest extends BaseTest {



    @Test
    public void getSubscriptions() {
        APIResponse response = subscriptionAction.getSubscriptions();
        subscriptionAction.checkResponseSuccess(response, true);
        subscriptionAction.validateResponsePayload(response, Subscription.class, true);
    }



    @Autowired private SubscriptionAction subscriptionAction;
}
