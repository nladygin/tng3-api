package tng3.guestapi.entity;

import tng3.base.Entity;


public class BookingRate implements Entity {

    public Integer stars;
    public String comment;




    public BookingRate(Integer stars, String comment) {
        this.stars = (stars == null) ? 5 : stars;
        this.comment = (comment == null) ? "Excellent" : comment;
    }

    public BookingRate(){
        this(null, null);
    }
}
