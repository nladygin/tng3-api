package tng3.guestapi.entity;

import tng3.base.Entity;


public class Ticket implements Entity {

    public long ticketId;
    public String number;
    public String description;
    public String status;
    public long profileId;
    public long docId;
    public long outletId;
    public long offerId;
    public long purchaseDate;
    public long activateDate;
    public long releaseDate;

}
