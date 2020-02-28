package tng3.guestapi.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import tng3.base.Entity;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class Item implements Entity {

    public Integer offerId;
    public String name;
    public Integer count;
    public Double amount;
    public Double discount;
    public Integer bookingId;
    public String ticketNum;
    public Integer id;
    public String reference;


    public Item(Integer offerId, Integer count, String reference) {
        this.offerId = offerId;
        this.count = count;
        this.reference = reference;
    }


    public Item(Integer offerId, Integer count, String ticketNum, String reference) {
        this.offerId = offerId;
        this.count = count;
        this.ticketNum = ticketNum;
        this.reference = reference;
    }

    public Item(Integer offerId, Integer count, Integer bookingId, String reference) {
        this.offerId = offerId;
        this.count = count;
        this.bookingId = bookingId;
        this.reference = reference;
    }


    public Item(Integer offerId, Integer count, Integer bookingId, String ticketNumber, String reference) {
        this.offerId = offerId;
        this.count = count;
        this.bookingId = bookingId;
        this.ticketNum = ticketNumber;
        this.reference = reference;
    }


    public Item() {
    }

}
