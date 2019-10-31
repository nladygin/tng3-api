package tng3.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({"data.properties"})
public class Config {

    @Value("${lang}")                   public String lang;
    @Value("${outlet_id}")              public Integer outletID;
    @Value("${empl_magstripe}")         public String emplMagstripe;
    @Value("${offset}")                 public String offset;
    @Value("${count}")                  public String count;
    @Value("${account}")                public String account;
    @Value("${offer_id}")               public Integer offerID;
    @Value("${spa_package_id}")         public Integer spaPackageID;
    @Value("${therapist_id}")           public String therapistID;
    @Value("${class_id}")               public String classID;
    @Value("${tender_id}")              public Integer tenderID;
    @Value("${tender_name}")            public String tenderName;
    @Value("${deposit_tender_id}")      public Integer depositTenderID;
    @Value("${deposit_tender_name}")    public String depositTenderName;
    @Value("${voucher_code}")           public String voucherCode;

}
