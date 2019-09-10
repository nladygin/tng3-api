package tng3.api.entity;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan("tng3.api")
@PropertySource({"data.properties"})
public class Account implements Entity {

    public String code;
    public String name;
    public String balance;
    public String loan;
    public String transfer;
    public String type;
    public Object payment_calendar;



    @Override
    public String asJsonString() {
        return null;
    }

    public Account(){}

}
