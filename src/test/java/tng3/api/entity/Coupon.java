package tng3.api.entity;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan("tng3.api")
@PropertySource({"data.properties"})
public class Coupon implements Entity {

    public String campaignName;
    public String code;
    public String validTill;
    public float balance;
    public Outlet outlet;
    public String type;
    public String description;



    @Override
    public String asJsonString() {
        return null;
    }

    public Coupon(){}

}
