package tng3.tests.guestapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.base.APIResponse;
import tng3.tests.guestapi.action.CouponAction;
import tng3.tests.guestapi.entity.Coupon;


@RunWith(SpringJUnit4ClassRunner.class)
public class CouponTest extends BaseTest {



    @Test
    public void getCoupons() {
        APIResponse response = couponAction.getCoupons();
        couponAction.checkResponseSuccess(response, true);
        couponAction.validateResponsePayload(response, Coupon.class, true);
    }



    @Autowired private CouponAction couponAction;
}
