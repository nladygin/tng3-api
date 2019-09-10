package tng3.api.entity;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan("tng3.api")
@PropertySource({"data.properties"})
public class SubscriptionItem implements Entity {

    public String name1;
    public String name2;
    public int initialCount;
    public int left;
    public float value;



    @Override
    public String asJsonString() {
        return null;
    }

    public SubscriptionItem(){}

}
