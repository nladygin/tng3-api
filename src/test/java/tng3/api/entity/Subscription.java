package tng3.api.entity;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;


@Configuration
@ComponentScan("tng3.api")
@PropertySource({"data.properties"})
public class Subscription implements Entity {

    public String name1;
    public String name2;
    public String status;
    public String validTill;
    public List<SubscriptionItem> subscriptionItems;



    @Override
    public String asJsonString() {
        return null;
    }

    public Subscription(){}

}
