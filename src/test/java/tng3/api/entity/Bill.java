package tng3.api.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tng3.base.Entity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Bill implements Entity {

    public int id;
    public String checkNum;
    public long date;
    public Integer outletId;
    public Double total;
    public Double ttlDue;
    public Double discount;
    public String coupon;
    public boolean closed;
    public List<Item> items;
    public List<Payment> payments;
    public String purchaseType;
    public String account;
    public Integer voucherTypeId;
    public String voucherNum;
    public String reference;



    public Bill(){}

    public Bill(
                int id,
                String checkNum,
                long date,
                Integer outletId,
                Double total,
                Double ttlDue,
                Double discount,
                String coupon,
                boolean closed,
                List<Item> items,
                List<Payment> payments,
                String purchaseType,
                String account,
                Integer voucherTypeId,
                String voucherNum,
                String reference
    ) {
        this.id = id;
        this.checkNum = checkNum;
        this.date = date;
        this.outletId = outletId;
        this.total = total;
        this.ttlDue = ttlDue;
        this.discount = discount;
        this.coupon = coupon;
        this.closed = closed;
        this.items = items;
        this.payments = payments;
        this.purchaseType = purchaseType;
        this.account = account;
        this.voucherTypeId = voucherTypeId;
        this.voucherNum = voucherNum;
        this.reference = reference;
    }

    public Bill(Integer outletId, String purchaseType, Double total, ArrayList<Payment> payments) {
        this.outletId = outletId;
        this.purchaseType = purchaseType;
        this.total = total;
        this.payments = payments;
    }

    public Bill(Integer outletId, List<Item> items) {
        this.outletId = outletId;
        this.items = items;
    }

    public Bill(Integer outletId, String purchaseType, String voucherNum, Double total, ArrayList<Payment> payments) {
        this.outletId = outletId;
        this.purchaseType = purchaseType;
        this.voucherNum = voucherNum;
        this.total = total;
        this.payments = payments;
    }

    public void load(LinkedHashMap<String, Object> payload) {
        this.id = (int) payload.get("id");
        this.checkNum = (String) payload.get("checkNum");
        this.date = (long) payload.get("date");
        this.outletId = (int) payload.get("outletId");
        this.total = (double) payload.get("total");
        this.ttlDue = (double) payload.get("ttlDue");
        this.discount = (double) payload.get("discount");
        this.coupon = (String) payload.get("coupon");
        this.closed = (boolean) payload.get("closed");
        this.items = (List<Item>) payload.get("items");
        this.payments = (List<Payment>) payload.get("payments");
        this.purchaseType = (String) payload.get("purchaseType");
        this.account = (String) payload.get("account");
        this.voucherTypeId = (Integer) payload.get("voucherTypeId");
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
                outletId == bill.outletId &&
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
                Objects.equals(voucherTypeId, bill.voucherTypeId) &&
                Objects.equals(voucherNum, bill.voucherNum) &&
                Objects.equals(reference, bill.reference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, checkNum, date, outletId, total, ttlDue, discount, coupon, closed, items, payments, purchaseType, account, voucherTypeId, voucherNum, reference);
    }





    private final Logger log = LogManager.getLogger();
}
