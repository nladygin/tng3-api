package tng3.guestapi.entity;

import tng3.base.Entity;

import java.util.List;


public class Tender implements Entity {

    public int tenderId;
    public String type;
    public String reference;
    public String account;
    public String authUrl;
    public TenderParams params;
    public List<Account> accounts;

}
