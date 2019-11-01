package tng3.staffapi.entity;

import tng3.base.Entity;

import java.util.List;

public class Booking implements Entity {

    public int id;
    public String treatmentStart;
    public String treatmentEnd;
    public String treatmentName;
    public Outlet outlet;
    public Double price;
    public List<Therapist> therapists;
    public String facility;
    public String createDate;
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
    public String therapistImage;
    public String treatmentImage;

}
