package tng3.tests.guestapi.entity;

import tng3.base.Entity;

public class Subcard implements Entity {

    public int id;
    public String name;
    public String cardType;
    public String magstripe;
    public String birthDate;
    public String validTill;
    public String email;


    public Subcard(int id, String name, String cardType, String magstripe, String birthDate, String validTill) {
        this.id = id;
        this.name = name;
        this.cardType = cardType;
        this.magstripe = magstripe;
        this.birthDate = birthDate;
        this.validTill = validTill;
    }


    public Subcard(String name, String cardType, String magstripe, String birthDate, String validTill, String email) {
        this.name = name;
        this.cardType = cardType;
        this.magstripe = magstripe;
        this.birthDate = birthDate;
        this.validTill = validTill;
        this.email = email;
    }

    public Subcard(){}

}
