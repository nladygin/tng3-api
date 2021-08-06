package tng3.tests.directory.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(value = {"tng3.tests.directory", "tng3.base", "tng3.helper", "tng3.auth", "tng3.common"})
@PropertySource({"config.properties"})
public class Config {


    @Value("${staff_app_id}")   public String staffAppID;
//    @Value("${guest_app_id}")   public String guestAppID;


    public Config(){}
}
