package tng3.staffapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({"data.properties"})
public class Data {

    @Value("${offer_id}")   public int offerID;
    @Value("${card_id}")    public int cardID;
    @Value("${outlet_id}")  public int outletID;



    public Data(){}
}
