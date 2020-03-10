package tng3.guestapi;

import org.apache.logging.log4j.LogManager;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.base.APIResponse;
import tng3.base.Data;
import tng3.common.action.ItemsAction;
import tng3.common.entity.Bill;
import tng3.common.entity.Payment;
import tng3.common.entity.Payments;
import tng3.guestapi.action.BillAction;
import tng3.helper.Utils;

import java.io.IOException;


@RunWith(SpringJUnit4ClassRunner.class)
public class XxxTest extends BaseTest {


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





    @Autowired private BillAction billAction;
    @Autowired private Utils utils;
    @Autowired private Data data;
    @Autowired private ItemsAction itemsAction;
}
