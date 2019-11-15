package tng3.guestapi.entity;

import tng3.base.Entity;
import tng3.entity.Outlet;


public class Coupon implements Entity {

    public String campaingName;
    public String code;
    public String validTill;
    public Double balance;
    public String lastUse;
    public Outlet outlet;
    public String type;
    public String description;

}
