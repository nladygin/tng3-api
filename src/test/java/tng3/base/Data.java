package tng3.base;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({"data.properties"})
public class Data {

    @Value("${offer_id}")           public int offerID;
    @Value("${card_id}")            public int cardID;
    @Value("${outlet_id}")          public int outletID;
    @Value("${card_magstripe}")     public String cardMagstripe;
    @Value("${empl_magstripe}")     public String emplMagstripe;
    @Value("${empl_username}")      public String emplUsername;
    @Value("${empl_password}")      public String emplPassword;
    @Value("${therapist_id}")       public int therapistID;
    @Value("${spa_package_id}")     public int spaPackageID;



    public Data(){}
}
