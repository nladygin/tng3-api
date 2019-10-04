package tng3.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({"data.properties"})
public class Config {

    @Value("${lang}")           public String lang;
    @Value("${outlet_id}")      public Integer outletID;
    @Value("${empl_magstripe}") public String emplMagstripe;
    @Value("${offset}")         public String offset;
    @Value("${count}")          public String count;
    @Value("${account}")        public String account;
    @Value("${offer_id}")       public Integer offerID;
    @Value("${therapist_id}")   public String therapistID;
    @Value("${tender_id}")      public Integer tenderID;

}
