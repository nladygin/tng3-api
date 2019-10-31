package tng3.base;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({"config.properties"})
public class AppConfig {

    @Value("${server.url}") public String serverURL;
    @Value("${lang}")       public String lang;

}
