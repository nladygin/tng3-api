package tng3.api.entity;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;


@Configuration
@ComponentScan("tng3.api")
@PropertySource({"data.properties"})
public class Visit implements Entity {

    public HashMap<String, Object> outlet;
    public String clockIn;
    public String clockOut;



    @Override
    public String asJsonString() {
        return null;
    }

    public Visit(){}

}
