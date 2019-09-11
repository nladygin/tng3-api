package tng3.api.entity;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan("tng3.api")
@PropertySource({"data.properties"})
public class Offer implements Entity {

    public int id;
    public String folder;
    public int folderID;
    public String folderImage;
    public String name;
    public String description;
    public int duration;
    public float price;
    public boolean pakkage;
    public String type;
    public String image;



    @Override
    public String asJsonString() {
        return null;
    }

    public Offer(){}

}
