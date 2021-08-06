package tng3.tests.guestapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.base.APIResponse;
import tng3.tests.guestapi.action.MembershipAction;
import tng3.tests.guestapi.entity.Membership;


@RunWith(SpringJUnit4ClassRunner.class)
public class MembershipTest extends BaseTest {



    @Test
    public void getMemberships() {
        APIResponse response = membershipAction.getMemberships();
        membershipAction.checkResponseSuccess(response, true);
        membershipAction.validateResponsePayload(response, Membership.class, true);
    }



    @Autowired private MembershipAction membershipAction;
}
