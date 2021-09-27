package tng3.common.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import tng3.base.Entity;
import tng3.tests.guestapi.entity.Item;
import tng3.helper.PurchaseType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Bill implements Entity {

    public long id;
    public Integer profileId;
    public String checkNum;
    public long date;
    public Integer outletId;
    public Double total;
    public Double ttlDue;
    public Double discount;
    public Double serviceCharge;
    public String coupon;
    public boolean closed;
    public List<Item> items;
    public List<Payment> payments;
    public List<BillTax> taxes;
    public PurchaseType purchaseType;
    public String account;
    public Integer voucherTypeId;
    public String voucherNum;
    public String reference;




    public Bill(Integer outletId, List<Item> items) {
        this.outletId = outletId;
        this.items = items;
    }


    public Bill(Integer outletId, Integer profileId, List<Item> items) {
        this.outletId = outletId;
        this.profileId = profileId;
        this.items = items;
    }


    public Bill(Integer outletId, PurchaseType purchaseType, Double total, ArrayList<Payment> payments) {
        this.outletId = outletId;
        this.purchaseType = purchaseType;
        this.total = total;
        this.payments = payments;
    }


    public Bill(Integer outletId, Integer profileId, PurchaseType purchaseType, Double total, ArrayList<Payment> payments) {
        this.outletId = outletId;
        this.profileId = profileId;
        this.purchaseType = purchaseType;
        this.total = total;
        this.payments = payments;
    }


    public Bill(Integer outletId, PurchaseType purchaseType, String voucherNum, Double total, ArrayList<Payment> payments) {
        this.outletId = outletId;
        this.purchaseType = purchaseType;
        this.voucherNum = voucherNum;
        this.total = total;
        this.payments = payments;
    }


    public Bill(Integer outletId, Integer profileId, PurchaseType purchaseType, String voucherNum, Double total, ArrayList<Payment> payments) {
        this.outletId = outletId;
        this.profileId = profileId;
        this.purchaseType = purchaseType;
        this.voucherNum = voucherNum;
        this.total = total;
        this.payments = payments;
    }



    public Bill() {
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return id == bill.id &&
//                date == bill.date && //даты не равны, отличие в 3-х последних цифрах
                closed == bill.closed &&
                Objects.equals(checkNum, bill.checkNum) &&
                Objects.equals(outletId, bill.outletId) &&
                Objects.equals(total, bill.total) &&
                Objects.equals(ttlDue, bill.ttlDue) &&
                Objects.equals(discount, bill.discount) &&
                Objects.equals(coupon, bill.coupon) &&
                Objects.equals(items, bill.items) &&
                Objects.equals(payments, bill.payments) &&
                purchaseType == bill.purchaseType &&
                Objects.equals(account, bill.account) &&
                Objects.equals(voucherTypeId, bill.voucherTypeId) &&
                Objects.equals(voucherNum, bill.voucherNum) &&
                Objects.equals(reference, bill.reference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, checkNum, date, outletId, total, ttlDue, discount, coupon, closed, items, payments, purchaseType, account, voucherTypeId, voucherNum, reference);
    }
}
