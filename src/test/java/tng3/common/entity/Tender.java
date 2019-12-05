package tng3.common.entity;

import tng3.base.Entity;
import tng3.guestapi.entity.Account;
import tng3.guestapi.entity.CreditCard;
import tng3.guestapi.entity.TenderParams;

import java.util.List;


public class Tender implements Entity {

    public int tenderId;
    public String type;
    public String name;
    public String reference;
    public String account;
    public String authUrl;
    public TenderParams params;
    public List<Account> accounts;
    public List<CreditCard> creditCards;

}
