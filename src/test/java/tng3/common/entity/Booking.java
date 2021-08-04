package tng3.common.entity;

import tng3.base.Entity;
import tng3.staffapi.entity.Client;

import java.util.Date;
import java.util.List;

public class Booking implements Entity {

    public int id;
    public Date treatmentStart;
    public Date treatmentEnd;
    public String treatmentName;
    public Outlet outlet;
    public Double price;
    public List<Therapist> therapists;
    public String facility;
    public Date createDate;
    public int userRating;
    public String userComment;
    public String comment;
    public int offerId;
    public String color;
    public Client client;
    public String status;
    public String paymentRequired;
    public String paymentTimeLimit;
    public String paymentStatus;
    public boolean confirmationRequired;
    public int docId;
    public String bodyMap;
    public boolean assignPending;
    public String therapistImage;
    public String treatmentImage;

}
