package tng3.api.entity;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;


@Configuration
@ComponentScan("tng3.api")
@PropertySource({"data.properties"})
public class Doc implements Entity {

    public String date;
    public Outlet outlet;
    public float total;
    public float discount;
    public String image;
    public int id;
    public List<DocAccount> accounts;



    @Override
    public String asJsonString() {
        return null;
    }

    public Doc(){}

}
