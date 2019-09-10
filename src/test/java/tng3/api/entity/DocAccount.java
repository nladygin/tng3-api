package tng3.api.entity;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan("tng3.api")
@PropertySource({"data.properties"})
public class DocAccount implements Entity {

    public String code;
    public String name;
    public float amount;



    @Override
    public String asJsonString() {
        return null;
    }

    public DocAccount(){}

}
