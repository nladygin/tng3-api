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
public class Credentials implements Entity {

    @JsonIgnore
    @Value("${credentials}")
    private String data;

    private final Logger log = LogManager.getLogger();


    public String username;
    public String password;


    @PostConstruct
    public void init() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        try {
            this.username = mapper.readValue(data, Credentials.class).username;
            this.password = mapper.readValue(data, Credentials.class).password;
        } catch (IOException e) {
            log.error(e.getStackTrace());
        }
    }


    @Override
    public String asJsonString() {
        return data;
    }


    public Credentials(){}



    /*
    @Value("${credentials.username}") private String username;
    @Value("${credentials.password}") private String password;


    public String asJsonString(){
        return "{\"username\":\"" + username + "\"," +
                "\"password\":\"" + password + "\"}";
    }

    public Credentials(){}
*/
}
