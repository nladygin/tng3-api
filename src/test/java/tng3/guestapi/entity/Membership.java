package tng3.guestapi.entity;

import tng3.base.Entity;

import java.util.List;


public class Membership implements Entity {

    public int id;
    public String name1;
    public String name2;
    public String start;
    public String end;
    public String status;
    public String issueDate;
    public Double price;
    public Double value;
    public List<MembershipHold> holds;
    public List<SubscriptionItem> subscriptionItems;

}
