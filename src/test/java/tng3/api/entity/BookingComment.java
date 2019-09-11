package tng3.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;


@Configuration
@ComponentScan("tng3.api")
@PropertySource({"data.properties"})
public class BookingComment implements Entity {

    @JsonIgnore
    @Value("${booking.comment}")
    private String data;

    private final Logger log = LogManager.getLogger();


    public String comment;



    @PostConstruct
    public void init() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        try {
            this.comment = mapper.readValue(data, BookingComment.class).comment;
        } catch (IOException e) {
            log.error(e.getStackTrace());
        }
    }


    @Override
    public String asJsonString() {
        return data;
    }

    public BookingComment(){}

}
