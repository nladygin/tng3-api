package tng3.api.entity;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.List;


@Configuration
@ComponentScan("tng3.api")
@PropertySource({"data.properties"})
public class Outlet implements Entity {

    public String id;
    public HashMap<String, Float> coord;
    public String phone;
    public String email;
    public String twitter;
    public String vk;
    public String facebook;
    public String instagram;
    public String description;
    public String workHours;
    public List<String> images;
    public String logo;



    @Override
    public String asJsonString() {
        return null;
    }

    public Outlet(){}

}
