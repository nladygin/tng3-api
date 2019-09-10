package tng3.api.entity;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan("tng3.api")
@PropertySource({"data.properties"})
public class Class implements Entity {

    public int id;
    public String startTime;
    public String endTime;
    public String name;
    public String classLevel;
    public String classNumber;
    public Outlet outlet;
    public Float price;
    public Therapist trainer;
    public String facility;
    public int availability;
    public boolean subscribed;
    public int offerId;
    public int docId;


    @Override
    public String asJsonString() {
        return null;
    }

    public Class(){}

}
