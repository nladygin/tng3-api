package tng3.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.api.config.Config;
import tng3.api.entity.*;
import tng3.helper.Method;
import tng3.helper.Utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
public class BillTest extends BaseTest {

    private final String endpoint = "/api/bills";





    @Test
    public void getBills(){
        APIResponse response = utils.go(endpoint, Method.GET);
        assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void saleItem(){
        APIResponse response = utils.go(endpoint, Method.POST, makeItemForSale());
        assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void depositTopUp(){
        ArrayList<Payment> payments = new ArrayList<>();
            payments.add(makePayment(config.tenderID, config.tenderName, 13.0));

        APIResponse response = utils.go(endpoint, Method.POST, new Bill(config.outletID, "DEPOSIT", 13.0, payments));
        assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void voucherTopUp(){
        ArrayList<Payment> payments = new ArrayList<>();
            payments.add(makePayment(config.tenderID, config.tenderName, 13.0));

        APIResponse response = utils.go(endpoint, Method.POST, new Bill(config.outletID, "VOUCHER", config.voucherCode, 13.0, payments));
        assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void addItem(){
        APIResponse response = utils.go(endpoint, Method.POST, makeItemForSale());
        assertThat(response.getSuccess(), equalTo(true));

            Bill bill = new Bill();
            bill.load((LinkedHashMap<String, Object>) response.getPayload());

                response = utils.go(endpoint + "/" + bill.id + "/items", Method.POST, new ItemForAdd());
                assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void voidItem(){
        APIResponse response = utils.go(endpoint, Method.POST, makeItemForSale());
        assertThat(response.getSuccess(), equalTo(true));

            Bill bill = new Bill();
            bill.load((LinkedHashMap<String, Object>) response.getPayload());

                Reason reason = new Reason();
                response = utils.go(endpoint + "/" + bill.id + "/items/" + 0, Method.DELETE, reason);
                assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void fetchBillById(){
        APIResponse response = utils.go(endpoint, Method.POST, makeItemForSale());
        assertThat(response.getSuccess(), equalTo(true));

            Bill bill = new Bill();
            bill.load((LinkedHashMap<String, Object>) response.getPayload());

                response = utils.go(endpoint + "/" + bill.id, Method.GET);
                assertThat(response.getSuccess(), equalTo(true));
                Bill result = new Bill();
                    result.load((LinkedHashMap<String, Object>) response.getPayload());
                assertThat(bill.equals(result), equalTo(true));
    }


    @Test
    public void paymentBill(){
        APIResponse response = utils.go(endpoint, Method.POST, makeItemForSale());
        assertThat(response.getSuccess(), equalTo(true));

            Bill bill = new Bill();
            bill.load((LinkedHashMap<String, Object>) response.getPayload());
                BillPayments payments = new BillPayments();
                    payments.add(makePayment(config.tenderID, config.tenderName, bill.total));

                response = utils.go(endpoint + "/" + bill.id + "/payments", Method.POST, payments);
                assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void paymentBillByDeposit(){
        APIResponse response = utils.go(endpoint, Method.POST, makeItemForSale());
        assertThat(response.getSuccess(), equalTo(true));

            Bill bill = new Bill();
            bill.load((LinkedHashMap<String, Object>) response.getPayload());
                BillPayments payments = new BillPayments();
                    payments.add(makePayment(config.depositTenderID, config.depositTenderName, bill.total));

                response = utils.go(endpoint + "/" + bill.id + "/payments", Method.POST, payments);
                assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void partialPaymentBill(){
        APIResponse response = utils.go(endpoint, Method.POST, makeItemForSale());
        assertThat(response.getSuccess(), equalTo(true));

            Bill bill = new Bill();
            bill.load((LinkedHashMap<String, Object>) response.getPayload());
                BillPayments payments = new BillPayments();
                    payments.add(makePayment(config.depositTenderID, config.depositTenderName, 1.0));
                    payments.add(makePayment(config.depositTenderID, config.depositTenderName, bill.total-1.0));

                response = utils.go(endpoint + "/" + bill.id + "/payments", Method.POST, payments);
                assertThat(response.getSuccess(), equalTo(true));
    }



    @Test
    public void payAllOpenedBills(){
        APIResponse response = utils.go(endpoint, Method.GET);
        assertThat(response.getSuccess(), equalTo(true));

            ArrayList bills = new ArrayList<>();
                bills.addAll(((ArrayList) response.getPayload()));

                bills.forEach(b -> {
                    Bill bill = new Bill();
                        bill.load((LinkedHashMap<String, Object>) b);

//                        if (bill.total != 0.0) {
                            BillPayments payments = new BillPayments();
                                payments.add(makePayment(config.tenderID, config.tenderName, bill.ttlDue));

                            APIResponse response1 = utils.go(endpoint + "/" + bill.id + "/payments", Method.POST, payments);
                            assertThat(response1.getSuccess(), equalTo(true));
//                        }
                });
    }



    @Test
    public void getBillsTenders(){
        APIResponse response = utils.go(endpoint, Method.GET);
        assertThat(response.getSuccess(), equalTo(true));

            ArrayList<LinkedHashMap<String, Object>> bills = new ArrayList<>();
                bills.addAll(((ArrayList) response.getPayload()));
                Bill bill = new Bill();
                bill.load (bills.get(0));

                    response = utils.go(endpoint + "/" + bill.id + "/allowed_tenders", Method.GET);
                    assertThat(response.getSuccess(), equalTo(true));
    }












    private Bill makeItemForSale(){
        Item item = new Item();
        ArrayList<Item> items = new ArrayList<>();
            items.add(item);
        return new Bill(config.outletID, items);
    }

    private Payment makePayment(Integer tenderId, String tenderName, Double amount){
        return new Payment(
                (tenderId == null) ? config.tenderID : tenderId,
                (tenderName == null) ? config.tenderName : tenderName,
                amount,
                "payment",
                null,
                null,
                null);
    }







    @Autowired
    private Utils utils;
    @Autowired
    private Config config;
}
