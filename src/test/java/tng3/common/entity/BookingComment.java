package tng3.common.entity;

import org.springframework.stereotype.Component;
import tng3.base.Entity;


public class BookingComment implements Entity {

    public String comment;



    public BookingComment(String comment) {
        this.comment = (comment == null) ? "booking comment" : comment;
    }

    public BookingComment(){
        this(null);
    }
}
