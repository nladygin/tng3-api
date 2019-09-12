package tng3.api.entity;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan("tng3.api")
@PropertySource({"data.properties"})
public class Item implements Entity {

    public int offerId;
    public String name;
    public int count;
    public float amount;
    public float discount;
    public int bookingId;
    public int id;
    public String reference;



    @Override
    public String asJsonString() {
        return null;
    }

    public Item(){}

}
