package tng3.tests.guestapi;

import org.apache.logging.log4j.LogManager;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContextManager;
import tng3.auth.Session;
import tng3.base.APIResponse;
import tng3.base.Data;
import tng3.common.action.ItemsAction;
import tng3.common.entity.Bill;
import tng3.common.entity.Payment;
import tng3.common.entity.Payments;
import tng3.tests.guestapi.action.BillAction;
import tng3.tests.guestapi.config.Config;
import tng3.helper.RequestHelper;
import tng3.helper.Utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


@ContextConfiguration(classes = Config.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(Parameterized.class)
public class ZZZTest {

    private TestContextManager testContextManager;

    @Parameterized.Parameters
    public static Object[] data() {
        return new Object[10][0];
    }



    @Before
    public void setup() throws Exception {
        this.testContextManager = new TestContextManager(getClass());
        this.testContextManager.prepareTestInstance(this);
        requestHelper.setEnv(config.guestAppID, session.getGuestSessionId());

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yy HH:mm:ss");
        LogManager.getLogger().info(formatter.format(calendar.getTime()));
    }


    @Ignore
    @Test
    @Repeat (value = 10)
    public void run() throws IOException {
        String ticketNum = String.valueOf(utils.generateDigits(8));
        LogManager.getLogger().info(ticketNum);
        sellTicket(ticketNum);
    }





    private void sellTicket(String ticketNum) throws IOException {
        APIResponse response = billAction.createBill(
                data.outletID,
                itemsAction.addItem(
                        41871,
                        1,
                        ticketNum,
                        "ungroup ticket for sale (API test)"
                )
        );
        billAction.checkResponseSuccess(response, true);
        billAction.validateResponsePayload(response, Bill.class, false);

            Bill bill = (Bill) utils.toEntity(response, Bill.class);

                Payments payments = new Payments();
                payments.add(new Payment(data.tenderID, bill.ttlDue));

                    response = billAction.paymentBill(bill, payments);
                    bill = (Bill) utils.toEntity(response, Bill.class);
                        billAction.checkResponseSuccess(response, true);
                        billAction.validateResponsePayload(response, Bill.class, false);
                        billAction.isClosed(bill, true);
    }





    @Autowired private RequestHelper requestHelper;
    @Autowired private Config config;
    @Autowired private Session session;
    @Autowired private BillAction billAction;
    @Autowired private Utils utils;
    @Autowired private Data data;
    @Autowired private ItemsAction itemsAction;
}
