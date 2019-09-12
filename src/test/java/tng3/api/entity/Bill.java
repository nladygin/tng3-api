package tng3.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;


@Configuration
@ComponentScan("tng3.api")
@PropertySource({"data.properties"})
public class Bill implements Entity {

    @JsonIgnore
    private String data;

    private final Logger log = LogManager.getLogger();




    public int id;
    public String checkNum;
    public long date;
    public int outletID;
    public double total;
    public double ttlDue;
    public double discount;
    public String coupon;
    public boolean closed;
    public List<Item> items;
    public List<Payment> payments;
    public String purchaseType;
    public String account;
    public String voucherTypeID;
    public String voucherNum;
    public String reference;



    public void load(LinkedHashMap<String, Object> payload) {
        this.id = (int) payload.get("id");
        this.checkNum = (String) payload.get("checkNum");
        this.date = (long) payload.get("date");
        this.outletID = (int) payload.get("outletId");
        this.total = (double) payload.get("total");
        this.ttlDue = (double) payload.get("ttlDue");
        this.discount = (double) payload.get("discount");
        this.coupon = (String) payload.get("coupon");
        this.closed = (boolean) payload.get("closed");
        this.items = (List<Item>) payload.get("items");
        this.payments = (List<Payment>) payload.get("payments");
        this.purchaseType = (String) payload.get("purchaseType");
        this.account = (String) payload.get("account");
        this.voucherTypeID = (String) payload.get("voucherTypeId");
        this.voucherNum = (String) payload.get("voucherNum");
        this.reference = (String) payload.get("reference");
    }


/*
    public void load() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        try {
            this.id = mapper.readValue(data, Bill.class).id;
            this.checkNum = mapper.readValue(data, Bill.class).checkNum;
            this.date = mapper.readValue(data, Bill.class).date;
            this.outletID = mapper.readValue(data, Bill.class).outletID;
            this.total = mapper.readValue(data, Bill.class).total;
            this.ttlDue = mapper.readValue(data, Bill.class).ttlDue;
            this.discount = mapper.readValue(data, Bill.class).discount;
            this.coupon = mapper.readValue(data, Bill.class).coupon;
            this.closed = mapper.readValue(data, Bill.class).closed;
            this.items = mapper.readValue(data, Bill.class).items;
            this.payments = mapper.readValue(data, Bill.class).payments;
            this.purchaseType = mapper.readValue(data, Bill.class).purchaseType;
            this.account = mapper.readValue(data, Bill.class).account;
            this.voucherTypeID = mapper.readValue(data, Bill.class).voucherTypeID;
            this.voucherNum = mapper.readValue(data, Bill.class).voucherNum;
            this.reference = mapper.readValue(data, Bill.class).reference;
        } catch (IOException e) {
            log.error(e.getStackTrace());
        }
    }
*/



    @Override
    public String asJsonString() {
        return null;
    }

    public Bill(){}

}
