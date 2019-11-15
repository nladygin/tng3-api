package tng3.guestapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("tng3.guestapi, tng3.base, tng3.helper, tng3.auth")
@PropertySource({"config.properties"})
public class Config {


    @Value("${guest_app_id}")   public String guestAppID;


    public Config(){}
}
