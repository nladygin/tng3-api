package tng3.api.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;


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
