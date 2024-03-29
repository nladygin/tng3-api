package tng3.tests.staffapi.action;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.Method;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;
import tng3.base.APIResponse;
import tng3.base.Action;
import tng3.common.entity.Bill;
import tng3.common.entity.Payment;
import tng3.common.entity.Payments;
import tng3.common.entity.Reason;
import tng3.tests.guestapi.entity.*;
import tng3.helper.PurchaseType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class BillAction extends Action {

    private final String endpoint = "/staffapi/bills";




    public APIResponse getBills(Long id, Integer profileId) {
        HashMap<String, String> additional = new HashMap<>();
        if (profileId != null) {
            additional.put("profileId", String.valueOf(profileId));
        } else {
            additional = null;
        }
        return requestHelper.go(endpoint + (id != null ? "/"+id : ""), Method.GET, null, additional);
    }


    public APIResponse getBills(Long id) {
        return getBills(id, null);
    }


    public APIResponse createBill(int outletID, Integer profileId, ArrayList<Item> items) {
        return requestHelper.go(endpoint, Method.POST, new Bill(outletID, profileId, items), null);
    }


    public APIResponse appendItem(Bill bill, ArrayList<Item> items, String voucher, Integer bookingId) {
        HashMap<String, String> additional = new HashMap<>();
        if (voucher != null) {
            additional.put("coupon", voucher);
        }
        if (bookingId != null) {
            additional.put("refbooking", String.valueOf(bookingId));
        }
        if (additional.isEmpty()) additional = null;
        return requestHelper.go(endpoint + "/" + bill.id + "/items", Method.POST, new Items(items), additional);
    }


    public APIResponse depositTopUp(int outletID, Integer profileId, Double amount, ArrayList<Payment> payments) {
            return requestHelper.go(endpoint, Method.POST, new Bill(outletID, profileId, PurchaseType.DEPOSIT, amount, payments), null);
    }


    public APIResponse voucherTopUp(int outletID, Integer profileId, Double amount, ArrayList<Payment> payments, String voucherNum) {
        return requestHelper.go(endpoint, Method.POST, new Bill(outletID, profileId, PurchaseType.VOUCHER, voucherNum, amount, payments), null);
    }


    public APIResponse voidItem(Bill bill, int itemIndex, Reason reason) {
        return requestHelper.go(endpoint + "/" + bill.id + "/items/" + itemIndex, Method.DELETE, reason, null);
    }


    public APIResponse paymentBill(Bill bill, Payments payments) {
        return requestHelper.go(endpoint + "/" + bill.id + "/payments", Method.POST, payments, null);
    }


    public APIResponse getAllowedTenders(Bill bill) {
        return requestHelper.go(endpoint + "/" + bill.id + "/allowed_tenders", Method.GET, null, null);
    }


    public void checkForEquals(Bill bill1, Bill bill2) {
        assertThat(bill1, equalTo(bill2));
    }


    public void isClosed(Bill bill, boolean expectedStatus) {
        assertThat(bill.closed, equalTo(expectedStatus));
    }


    public void pass3DSecure(String link, String answer, String expectedStatus) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(4L, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(13L, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(4L, TimeUnit.SECONDS);

            driver.get(link);
            driver.findElement(By.id("password")).sendKeys(answer);
            driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
                String url = driver.getCurrentUrl();
                String status = url.substring(url.lastIndexOf("/")+1);
                    assertThat(status, CoreMatchers.equalTo(expectedStatus));
            driver.quit();
            driver = null;
    }





}
