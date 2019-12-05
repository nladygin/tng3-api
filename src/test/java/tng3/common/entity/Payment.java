package tng3.common.entity;

import tng3.base.Entity;


public class Payment implements Entity {

    public Integer tenderId;
    public String name;
    public Double amount;
    public String reference;
    public String exUid;
    public String account;
    public String voucher;
    public String cardHolderName;
    public String cryptogram;
    public Boolean saveCard;





    public Payment(Integer tenderId, String name, Double amount, String reference, String exUid, String account, String voucher, String cardHolderName, String cryptogram, Boolean saveCard) {
        this.tenderId = tenderId;
        this.name = name;
        this.amount = amount;
        this.reference = reference;
        this.exUid = exUid;
        this.account = account;
        this.voucher = voucher;
        this.cardHolderName = cardHolderName;
        this.cryptogram = cryptogram;
        this.saveCard = saveCard;
    }


    public Payment(Integer tenderId, Double amount) {
        this.tenderId = tenderId;
        this.amount = amount;
    }


    public Payment(Integer tenderId, Double amount, String cardHolderName, String cryptogram, Boolean saveCard) {
        this.tenderId = tenderId;
        this.amount = amount;
        this.cardHolderName = cardHolderName;
        this.cryptogram = cryptogram;
        this.saveCard = saveCard;
    }




    public Payment() {

    }
}
