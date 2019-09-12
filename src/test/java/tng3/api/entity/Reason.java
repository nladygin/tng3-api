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
public class Reason implements Entity {

    @JsonIgnore
    @Value("${bill.reason}")
    private String data;

    private final Logger log = LogManager.getLogger();


    public String reason;



    @PostConstruct
    public void init() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        try {
            this.reason = mapper.readValue(data, Reason.class).reason;
        } catch (IOException e) {
            log.error(e.getStackTrace());
        }
    }


    @Override
    public String asJsonString() {
        return data;
    }

    public Reason(){}

}
