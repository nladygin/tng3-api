package tng3.api.entity;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;


@Configuration
@ComponentScan("tng3.api")
@PropertySource({"data.properties"})
public class CheckIn implements Entity {

    public HashMap<String, Object> outlet;
    public String lastCheckinDate;
    public String countThisMonth;
    public String countLastMonth;


    @Override
    public String asJsonString() {
        return null;
    }

    public CheckIn(){}

}
