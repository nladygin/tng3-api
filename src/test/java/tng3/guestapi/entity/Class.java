package tng3.guestapi.entity;

import tng3.base.Entity;
import tng3.common.entity.Therapist;


public class Class implements Entity {

    public int id;
    public String startTime;
    public String endTime;
    public String name;
    public String classLevel;
    public String classNumber;
    public int outletId;
    public Float price;
    public Therapist trainer;
    public String facility;
    public int availability;
    public boolean subscribed;
    public int offerId;
    public int docId;

}
