package tng3.api.entity;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan("tng3.api")
@PropertySource({"data.properties"})
public class MembershipHold implements Entity {

    public String start;
    public String end;
    public String notes;



    @Override
    public String asJsonString() {
        return null;
    }

    public MembershipHold(){}

}
