package tng3.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({"data.properties"})
public class Config {

    @Value("${lang}")
    public String lang;

    @Value("${outlet_id}")
    public String outletID;

    @Value("${emplMagstripe}")
    public String emplMagstripe;

    @Value("${doc.offset}")
    public String docOffset;

    @Value("${doc.count}")
    public String docCount;

    @Value("${doc.account}")
    public String docAccount;

}
