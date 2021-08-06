package tng3.tests.guestapi.entity;

import tng3.base.Entity;

import java.util.List;


public class Subscription implements Entity {

    public String name1;
    public String name2;
    public String status;
    public String validTill;
    public List<SubscriptionItem> subscriptionItems;

}
