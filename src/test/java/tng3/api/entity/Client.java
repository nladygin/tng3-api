package tng3.api.entity;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan("tng3.api")
@PropertySource({"data.properties"})
public class Client implements Entity {

    public int id;
    public String lastName;
    public String firstName;
    public String secondName;



    @Override
    public String asJsonString() {
        return null;
    }

    public Client(){}

}
