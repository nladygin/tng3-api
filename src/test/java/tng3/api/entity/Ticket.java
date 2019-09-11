package tng3.api.entity;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan("tng3.api")
@PropertySource({"data.properties"})
public class Ticket implements Entity {

    public int number;
    public int card;
    public String name;



    @Override
    public String asJsonString() {
        return null;
    }

    public Ticket(){}

}
