package tng3.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.api.entity.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
public class BillTest extends BaseTest {

    @Autowired
    private Bill bill;

    @Autowired
    private ItemForSale itemForSale;

    @Autowired
    private ItemForAdd itemForAdd;

    @Autowired
    private AccountTopUp accountTopUp;

    @Autowired
    private Payment payment;

    @Autowired
    private Reason reason;


    @Autowired
    private Utils utils;

    private final String endpoint = "/bills";


    @Test
    public void getBills(){
        APIResponse response = utils.go(endpoint, Method.GET);
        assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void saleItem(){
        APIResponse response = utils.go(endpoint, Method.POST, itemForSale);
        assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void accountTopUp(){
        APIResponse response = utils.go(endpoint, Method.POST, accountTopUp);
        assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void addItem(){
        APIResponse response = utils.go(endpoint, Method.POST, itemForSale);
        assertThat(response.getSuccess(), equalTo(true));

            Bill bill = new Bill();
            bill.load((LinkedHashMap<String, Object>) response.getPayload());

                response = utils.go(endpoint + "/" + bill.id + "/items", Method.POST, itemForAdd);
                assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void voidItem(){
        APIResponse response = utils.go(endpoint, Method.POST, itemForSale);
        assertThat(response.getSuccess(), equalTo(true));

            Bill bill = new Bill();
            bill.load((LinkedHashMap<String, Object>) response.getPayload());

                response = utils.go(endpoint + "/" + bill.id + "/items/" + itemForSale.items.get(0).id, Method.DELETE, reason);
                assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void fetchBillById(){
        APIResponse response = utils.go(endpoint, Method.POST, itemForSale);
        assertThat(response.getSuccess(), equalTo(true));

            Bill bill = new Bill();
            bill.load((LinkedHashMap<String, Object>) response.getPayload());

                response = utils.go(endpoint + "/" + bill.id, Method.GET);
                assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void paymentBill(){
        APIResponse response = utils.go(endpoint, Method.POST, itemForSale);
        assertThat(response.getSuccess(), equalTo(true));

            Bill bill = new Bill();
            bill.load((LinkedHashMap<String, Object>) response.getPayload());
                Payment payment = new Payment();
                payment
                        .setTenderId(4)
                        .setAmount(bill.total);
                    BillPayments payments = new BillPayments();
                    payments.addPayment(payment);

                response = utils.go(endpoint + "/" + bill.id + "/payments", Method.POST, payments);
                assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void paymentBillByDeposit(){
        APIResponse response = utils.go(endpoint, Method.POST, itemForSale);
        assertThat(response.getSuccess(), equalTo(true));

            Bill bill = new Bill();
            bill.load((LinkedHashMap<String, Object>) response.getPayload());
                Payment payment = new Payment();
                payment
                        .setTenderId(3)
                        .setAmount(bill.total);
                    BillPayments payments = new BillPayments();
                    payments.addPayment(payment);

                response = utils.go(endpoint + "/" + bill.id + "/payments", Method.POST, payments);
                assertThat(response.getSuccess(), equalTo(true));
    }


}
