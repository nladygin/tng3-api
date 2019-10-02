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

    @Value("${offer.offset}")
    public String offerOffset;

    @Value("${offer.count}")
    public String offerCount;

    @Value("${offer.id}")
    public String offerID;

    @Value("${offer.therapist_id}")
    public String offerTherapistID;

    @Value("${booking.therapist_id}")
    public String bookingTherapistID;

    @Value("${booking.offer_id}")
    public String bookingOfferID;

}
