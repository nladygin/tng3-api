package tng3.api.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
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
    public String confirmationRequired;
    public int docId;
    public String therapistImage;
    public String treatmentImage;




    public Booking(){}



    @Override
    public String asJsonString() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        String json = null;
        try {
            json = mapper.writeValueAsString(this);
        } catch (IOException e) {
            log.error(e.getStackTrace());
        }
        return json;
    }





    private final Logger log = LogManager.getLogger();
}
