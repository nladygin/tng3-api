package tng3.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({"data.properties"})
public class Config {

    @Value("${lang}")           public String lang;
    @Value("${outlet_id}")      public String outletID;
    @Value("${empl_magstripe}") public String emplMagstripe;
    @Value("${offset}")         public String offset;
    @Value("${count}")          public String count;
    @Value("${account}")        public String account;
    @Value("${offer_id}")       public String offerID;
    @Value("${therapist_id}")   public String therapistID;




//    @Value("${doc.offset}")     public String docOffset;
//    @Value("${doc.count}")      public String docCount;
//    @Value("${doc.account}")    public String docAccount;

//    @Value("${offer.offset}")       public String offerOffset;
//    @Value("${offer.count}")        public String offerCount;
//    @Value("${offer.id}")           public String offerID;
//    @Value("${offer.therapist_id}") public String offerTherapistID;

//    @Value("${booking.therapist_id}")   public String bookingTherapistID;
//    @Value("${booking.offer_id}")       public String bookingOfferID;

//    @Value("${bill.outletID}")       public Integer billOutletID;
//    @Value("${bill.item.offerID}")   public Integer billItemOfferID;
//    @Value("${bill.item.name}")      public String billItemName;
//    @Value("${bill.item.count}")     public Integer billItemCount;
//    @Value("${bill.item.amount}")    public Double billItemAmount;
//    @Value("${bill.item.discount}")  public Double billItemDiscount;
//    @Value("${bill.item.bookingID}") public Integer billItemBookingID;
//    @Value("${bill.item.id}")        public Integer billItemID;
//    @Value("${bill.item.reference}") public String billItemReference;

//    @Value("${bill.payment.tenderID}")  public Integer billPaymentTenderID;
//    @Value("${bill.payment.name}")      public String billPaymentName;
//    @Value("${bill.payment.amount}")    public Double billPaymentAmount;
//    @Value("${bill.payment.reference}") public String billPaymentReference;
//    @Value("${bill.payment.exUid}")     public String billPaymentExUid;
//    @Value("${bill.payment.account}")   public String billPaymentAccount;
//    @Value("${bill.payment.voucher}")   public String billPaymentVoucher;


}
