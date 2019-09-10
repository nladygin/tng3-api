package tng3.api.entity;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.List;


@Configuration
@ComponentScan("tng3.api")
@PropertySource({"data.properties"})
public class Membership implements Entity {

    public String name1;
    public String name2;
    public String start;
    public String end;
    public String status;
    public String issueDate;
    public float price;
    public float value;
    public List<MembershipHold> holds;
    public List<SubscriptionItem> subscriptionItems;



    @Override
    public String asJsonString() {
        return null;
    }

    public Membership(){}

}
