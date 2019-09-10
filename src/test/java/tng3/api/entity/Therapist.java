package tng3.api.entity;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan("tng3.api")
@PropertySource({"data.properties"})
public class Therapist implements Entity {

    public int id;
    public String name;
    public String position;
    public String text;
    public String gender;
    public String pictureThumb;
    public String picture;



    @Override
    public String asJsonString() {
        return null;
    }

    public Therapist(){}

}
