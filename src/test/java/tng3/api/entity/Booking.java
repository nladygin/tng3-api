package tng3.api.entity;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;


@Configuration
@ComponentScan("tng3.api")
@PropertySource({"data.properties"})
public class Booking implements Entity {

    public int id;
    public String treatmentStart;
    public String treatmentEnd;
    public String treatmentName;
    public Outlet outlet;
    public float price;
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
    public int docId;
    public String therapistImage;
    public String treatmentImage;



    @Override
    public String asJsonString() {
        return null;
    }

    public Booking(){}

}
