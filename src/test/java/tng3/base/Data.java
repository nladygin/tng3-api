package tng3.base;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({"data.properties"})
public class Data {

    @Value("${outlet_id}")                      public int outletID;
    @Value("${offset}")                         public int offset;
    @Value("${count}")                          public int count;

    @Value("${card_id}")                        public int cardID;
    @Value("${card_magstripe}")                 public String cardMagstripe;
    @Value("${card_email}")                     public String cardEmail;
    @Value("${card_phone}")                     public String cardPhone;
    @Value("${card_password}")                  public String cardPassword;
    @Value("${card_type}")                      public String cardType;

    @Value("${therapist_id}")                   public int therapistID;
    @Value("${empl_magstripe}")                 public String emplMagstripe;
    @Value("${empl_username}")                  public String emplUsername;
    @Value("${empl_password}")                  public String emplPassword;

    @Value("${facility_id}")                   public int facilityID;

    @Value("${spa_package_id}")                 public int spaPackageID;
    @Value("${offer_id}")                       public int offerID;
    @Value("${offer_barcode}")                  public String offerBarcode;
    @Value("${class_id}")                       public int classID;
    @Value("${cancelled_class_id}")             public int cancelledClassID;
    @Value("${voucher_num}")                    public String voucherNum;
    @Value("${offer_ticket_id}")                public int offerTicketID;

    @Value("${tender_id}")                      public int tenderID;
    @Value("${tender_name}")                    public String tenderName;
    @Value("${deposit_tender_id}")              public int depositTenderID;
    @Value("${deposit_tender_name}")            public String depositTenderName;
    @Value("${online_tender_id}")               public int onlineTenderID;
    @Value("${online_tender_name}")             public String onlineTenderName;
    @Value("${online_tender_token}")            public String onlineTenderToken;
    @Value("${online_tender_token_poor}")       public String onlineTenderTokenPoor;
    @Value("${online_tender_token_3ds}")        public String onlineTenderToken3Ds;
    @Value("${online_tender_token_poor_3ds}")   public String onlineTenderTokenPoor3Ds;
    @Value("${cardholder_name}")                public String cardholderName;

    @Value("${med_registry_id}")                public int medRegistryId;
    @Value("${med_emr_id}")                     public long medEMRId;
    @Value("${med_sign_employee}")              public String medSignEmployee;
    @Value("${med_sign_organization}")          public String medSignOrganization;


    public Data(){}
}
