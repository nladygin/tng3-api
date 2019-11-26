package tng3.guestapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.base.APIResponse;
import tng3.guestapi.action.BillAction;
import tng3.guestapi.action.ItemsAction;
import tng3.guestapi.entity.*;
import tng3.helper.PurchaseType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;


@RunWith(SpringJUnit4ClassRunner.class)
public class BillTest extends BaseTest {



    @Test
    public void getBills() {
        APIResponse response = billAction.getBills(null);
        billAction.checkResponseSuccess(response, true);
        billAction.validateResponsePayload(response, Bill.class, true);
    }


    @Test
    public void getBillById() throws IOException {
        APIResponse response = billAction.createBill(data.outletID, null);
            billAction.checkResponseSuccess(response, true);
            billAction.validateResponsePayload(response, Bill.class, false);

            Bill bill = (Bill) utils.toEntity(response, Bill.class);

                response = billAction.getBills(bill.id);
                billAction.checkResponseSuccess(response, true);
                billAction.validateResponsePayload(response, Bill.class, false);

                    Bill bill2 = (Bill) utils.toEntity(response, Bill.class);
                    billAction.checkForEquals(bill, bill2);
    }


    @Test
    public void createEmptyBill() {
        APIResponse response = billAction.createBill(data.outletID, null);
        billAction.checkResponseSuccess(response, true);
        billAction.validateResponsePayload(response, Bill.class, false);
    }


    @Test
    public void createBillWithItem() {
        APIResponse response = billAction.createBill(
                data.outletID,
                itemsAction.addItem(
                        data.offerID,
                        1,
                        null,
                        "item for sale (API test)"
                )
        );
        billAction.checkResponseSuccess(response, true);
        billAction.validateResponsePayload(response, Bill.class, false);
    }


    @Test
    public void createBillWithItemAndAddAnotherItem() throws IOException {
        APIResponse response = billAction.createBill(
                data.outletID,
                itemsAction.addItem(
                        data.offerID,
                        1,
                        null,
                        "item for sale (API test)"
                )
        );
        billAction.checkResponseSuccess(response, true);
        billAction.validateResponsePayload(response, Bill.class, false);

            Bill bill = (Bill) utils.toEntity(response, Bill.class);

            response = billAction.appendItem(
                    bill,
                    itemsAction.addItem(
                            data.offerID,
                            2,
                            null,
                            "item for adding"
                    )
            );

            billAction.checkResponseSuccess(response, true);
            billAction.validateResponsePayload(response, Bill.class, false);
    }


    @Test
    public void topUpDeposit() {
        ArrayList<Payment> payments = new ArrayList<>();
            payments.add(new Payment(data.tenderID, data.tenderName, 13.0, "deposit topup", null, null, null, null, null, null));
        APIResponse response = billAction.depositTopUp(
                data.outletID,
                13.0,
                payments
        );
        billAction.checkResponseSuccess(response, true);
        billAction.validateResponsePayload(response, Bill.class, false);
    }


    @Test
    public void topUpVoucher() {
        ArrayList<Payment> payments = new ArrayList<>();
            payments.add(new Payment(data.tenderID, data.tenderName, 13.0, "deposit topup", null, null, null, null, null, null));
        APIResponse response = billAction.voucherTopUp(
                data.outletID,
                13.0,
                payments,
                data.voucherNum
        );
        billAction.checkResponseSuccess(response, true);
        billAction.validateResponsePayload(response, Bill.class, false);
    }


    @Test
    public void voidItem() throws IOException {
        APIResponse response = billAction.createBill(
                data.outletID,
                itemsAction.addItem(
                        data.offerID,
                        1,
                        null,
                        "item for sale (API test)"
                )
        );
        billAction.checkResponseSuccess(response, true);
        billAction.validateResponsePayload(response, Bill.class, false);

            Bill bill = (Bill) utils.toEntity(response, Bill.class);

            response = billAction.voidItem(
                    bill,
                    0,
                    new Reason("void 0 item")
            );
            billAction.checkResponseSuccess(response, true);
            billAction.validateResponsePayload(response, Bill.class, false);
    }


    @Test
    public void paymentBill() throws IOException {
        APIResponse response = billAction.createBill(
                data.outletID,
                itemsAction.addItem(
                        data.offerID,
                        1,
                        null,
                        "item for sale (API test)"
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


    @Test
    public void partialPaymentBill() throws IOException {
        APIResponse response = billAction.createBill(
                data.outletID,
                itemsAction.addItem(
                        data.offerID,
                        1,
                        null,
                        "item for sale (API test)"
                )
        );
        billAction.checkResponseSuccess(response, true);
        billAction.validateResponsePayload(response, Bill.class, false);

            Bill bill = (Bill) utils.toEntity(response, Bill.class);

            Payments payments = new Payments();
                payments.add(new Payment(data.tenderID, bill.total - 1.0));
                payments.add(new Payment(data.depositTenderID, 1.0));

                response = billAction.paymentBill(bill, payments);
                    bill = (Bill) utils.toEntity(response, Bill.class);

                billAction.checkResponseSuccess(response, true);
                billAction.validateResponsePayload(response, Bill.class, false);
                billAction.isClosed(bill, true);
    }


    @Test
    public void getAllowedTendersForBill() throws IOException {
        APIResponse response = billAction.createBill(
                data.outletID,
                itemsAction.addItem(
                        data.offerID,
                        1,
                        null,
                        "item for sale (API test)"
                )
        );
        billAction.checkResponseSuccess(response, true);
        billAction.validateResponsePayload(response, Bill.class, false);

            Bill bill = (Bill) utils.toEntity(response, Bill.class);

            response = billAction.getAllowedTenders(bill);
            billAction.checkResponseSuccess(response, true);
            billAction.validateResponsePayload(response, Tender.class, true);
    }


    @Test
    public void paymentAllBills() throws IOException {
        APIResponse response = billAction.getBills(null);
        billAction.checkResponseSuccess(response, true);
        billAction.validateResponsePayload(response, Bill.class, true);

        ArrayList bills = new ArrayList<>();
        bills.addAll((ArrayList) response.getPayload());

        for (int i = 0; i < bills.size()-1; i++) {
            Bill bill = (Bill) utils.toEntity((LinkedHashMap) bills.get(i), Bill.class);
            Payments payments = new Payments();
                payments.add(new Payment(data.tenderID, bill.ttlDue));

            response = billAction.paymentBill(bill, payments);
                bill = (Bill) utils.toEntity(response, Bill.class);
            billAction.checkResponseSuccess(response, true);
            billAction.validateResponsePayload(response, Bill.class, false);
            billAction.isClosed(bill, true);
        }

    }


    @Test
    public void paymentBillByCreditCard() throws IOException {
        APIResponse response = billAction.createBill(
                data.outletID,
                itemsAction.addItem(
                        data.offerID,
                        1,
                        null,
                        "item for sale (API test)"
                )
        );
        billAction.checkResponseSuccess(response, true);
        billAction.validateResponsePayload(response, Bill.class, false);

            Bill bill = (Bill) utils.toEntity(response, Bill.class);

            Payments payments = new Payments();
                payments.add(new Payment(data.onlineTenderID, bill.ttlDue, data.cardholderName, data.onlineTenderToken, true));

            response = billAction.paymentBill(bill, payments);
                bill = (Bill) utils.toEntity(response, Bill.class);
            billAction.checkResponseSuccess(response, true);
            billAction.validateResponsePayload(response, Bill.class, false);
            billAction.isClosed(bill, true);
    }


    @Test
    public void paymentBillByPoorCreditCard() throws IOException {
        APIResponse response = billAction.createBill(
                data.outletID,
                itemsAction.addItem(
                        data.offerID,
                        1,
                        null,
                        "item for sale (API test)"
                )
        );
        billAction.checkResponseSuccess(response, true);
        billAction.validateResponsePayload(response, Bill.class, false);

            Bill bill = (Bill) utils.toEntity(response, Bill.class);

            Payments payments = new Payments();
                payments.add(new Payment(data.onlineTenderID, bill.ttlDue, data.cardholderName, data.onlineTenderTokenPoor, true));

            response = billAction.paymentBill(bill, payments);
                bill = (Bill) utils.toEntity(response, Bill.class);
            billAction.checkResponseSuccess(response, false);
            billAction.checkResponseErrorCode(response, 350);
    }


    @Test
    public void paymentBillByCreditCard3D() throws IOException {
        APIResponse response = billAction.createBill(
                data.outletID,
                itemsAction.addItem(
                        data.offerID,
                        1,
                        null,
                        "item for sale (API test)"
                )
        );
        billAction.checkResponseSuccess(response, true);
        billAction.validateResponsePayload(response, Bill.class, false);

            Bill bill = (Bill) utils.toEntity(response, Bill.class);

            Payments payments = new Payments();
                payments.add(new Payment(data.onlineTenderID, bill.ttlDue, data.cardholderName, data.onlineTenderToken3Ds, true));

            response = billAction.paymentBill(bill, payments);
            billAction.checkResponseSuccess(response, false);
            billAction.checkResponseErrorCode(response, 800);

                billAction.pass3DSecure(response.getErrorMessage(), "4", "Оплата успешно проведена");

                    response = billAction.getBills(bill.id);
                    bill = (Bill) utils.toEntity(response, Bill.class);

                    billAction.checkResponseSuccess(response, true);
                    billAction.validateResponsePayload(response, Bill.class, false);
                    billAction.isClosed(bill, true);
    }


    @Test
    public void paymentBillByCreditCard3DWithWrong3DCode() throws IOException {
        APIResponse response = billAction.createBill(
                data.outletID,
                itemsAction.addItem(
                        data.offerID,
                        1,
                        null,
                        "item for sale (API test)"
                )
        );
        billAction.checkResponseSuccess(response, true);
        billAction.validateResponsePayload(response, Bill.class, false);

            Bill bill = (Bill) utils.toEntity(response, Bill.class);

            Payments payments = new Payments();
                payments.add(new Payment(data.onlineTenderID, bill.ttlDue, data.cardholderName, data.onlineTenderToken3Ds, true));

            response = billAction.paymentBill(bill, payments);
            billAction.checkResponseSuccess(response, false);
            billAction.checkResponseErrorCode(response, 800);

                billAction.pass3DSecure(response.getErrorMessage(), "3", "Авторизация не пройдена");

                response = billAction.getBills(bill.id);
                bill = (Bill) utils.toEntity(response, Bill.class);

                    billAction.checkResponseSuccess(response, true);
                    billAction.validateResponsePayload(response, Bill.class, false);
                    billAction.isClosed(bill, false);
    }


    @Test
    public void paymentBillByPoorCreditCard3D() throws IOException {
        APIResponse response = billAction.createBill(
                data.outletID,
                itemsAction.addItem(
                        data.offerID,
                        1,
                        null,
                        "item for sale (API test)"
                )
        );
        billAction.checkResponseSuccess(response, true);
        billAction.validateResponsePayload(response, Bill.class, false);

            Bill bill = (Bill) utils.toEntity(response, Bill.class);

            Payments payments = new Payments();
                payments.add(new Payment(data.onlineTenderID, bill.ttlDue, data.cardholderName, data.onlineTenderTokenPoor3Ds, true));

            response = billAction.paymentBill(bill, payments);
            billAction.checkResponseSuccess(response, false);
            billAction.checkResponseErrorCode(response, 800);

                billAction.pass3DSecure(response.getErrorMessage(), "4", "Недостаточно средств на карте");

                response = billAction.getBills(bill.id);
                bill = (Bill) utils.toEntity(response, Bill.class);

                    billAction.checkResponseSuccess(response, true);
                    billAction.validateResponsePayload(response, Bill.class, false);
                    billAction.isClosed(bill, false);
    }











    @Autowired private BillAction billAction;
    @Autowired private ItemsAction itemsAction;

}
