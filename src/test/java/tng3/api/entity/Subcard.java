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

@Configuration
@ComponentScan("tng3.api")
@PropertySource({"data.properties"})
public class Subcard implements Entity {

    @JsonIgnore
    @Value("${subcards}")
    private String data;

    private final Logger log = LogManager.getLogger();


    public String name;
    public String magstripe;
    public String birthDate;
    public String validTill;




    @PostConstruct
    public void init() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        try {
            this.name = mapper.readValue(data, Subcard.class).name;
            this.magstripe = mapper.readValue(data, Subcard.class).magstripe;
            this.birthDate = mapper.readValue(data, Subcard.class).birthDate;
            this.validTill = mapper.readValue(data, Subcard.class).validTill;
        } catch (IOException e) {
            log.error(e.getStackTrace());
        }
    }


    @Override
    public String asJsonString() {
        return data;
    }


    public Subcard(){}

}
