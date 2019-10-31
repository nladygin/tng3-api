package tng3.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("tng3.api, tng3.helper")
@PropertySource({"config.properties"})
public class AppConfig {

    @Value("${server.url}")
    public String serverURL;

    @Value("${app_id}")
    public String appID;

//    @Value("${lang}")
//    public String lang;




/*
    public String getServerURL() {
        return this.serverURL;
    }

    public String getAppID() {
        return this.appID;
    }
*/



    public AppConfig(){}
}
