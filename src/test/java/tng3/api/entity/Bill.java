package tng3.api.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;


public class Bill implements Entity {

    public int id;
    public String checkNum;
    public long date;
    public Integer outletID;
    public Double total;
    public Double ttlDue;
    public Double discount;
    public String coupon;
    public boolean closed;
    public List<Item> items;
    public List<Payment> payments;
    public String purchaseType;
    public String account;
    public String voucherTypeID;
    public String voucherNum;
    public String reference;



    public Bill(){}



    public void load(LinkedHashMap<String, Object> payload) {
        this.id = (int) payload.get("id");
        this.checkNum = (String) payload.get("checkNum");
        this.date = (long) payload.get("date");
        this.outletID = (int) payload.get("outletId");
        this.total = (double) payload.get("total");
        this.ttlDue = (double) payload.get("ttlDue");
        this.discount = (double) payload.get("discount");
        this.coupon = (String) payload.get("coupon");
        this.closed = (boolean) payload.get("closed");
        this.items = (List<Item>) payload.get("items");
        this.payments = (List<Payment>) payload.get("payments");
        this.purchaseType = (String) payload.get("purchaseType");
        this.account = (String) payload.get("account");
        this.voucherTypeID = (String) payload.get("voucherTypeId");
        this.voucherNum = (String) payload.get("voucherNum");
        this.reference = (String) payload.get("reference");
    }






    @Override
    public String asJsonString() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        String json = null;
        try {
            json = mapper.writeValueAsString(this);
        } catch (IOException e) {
            log.error(e.getStackTrace());
        }
        return json;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return id == bill.id &&
//                date == bill.date &&
                outletID == bill.outletID &&
                Double.compare(bill.total, total) == 0 &&
                Double.compare(bill.ttlDue, ttlDue) == 0 &&
                Double.compare(bill.discount, discount) == 0 &&
                closed == bill.closed &&
                Objects.equals(checkNum, bill.checkNum) &&
                Objects.equals(coupon, bill.coupon) &&
                Objects.equals(items, bill.items) &&
                Objects.equals(payments, bill.payments) &&
                Objects.equals(purchaseType, bill.purchaseType) &&
                Objects.equals(account, bill.account) &&
                Objects.equals(voucherTypeID, bill.voucherTypeID) &&
                Objects.equals(voucherNum, bill.voucherNum) &&
                Objects.equals(reference, bill.reference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, checkNum, date, outletID, total, ttlDue, discount, coupon, closed, items, payments, purchaseType, account, voucherTypeID, voucherNum, reference);
    }





    private final Logger log = LogManager.getLogger();
}
