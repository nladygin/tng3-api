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


@Configuration
@ComponentScan("tng3.api")
@PropertySource({"data.properties"})
public class Payment implements Entity {

    @JsonIgnore
    @Value("${bill.payment}")
    private String data;

    private final Logger log = LogManager.getLogger();



    public int tenderId;
    public String name;
    public double amount;
    public String reference;
    public String exUid;
    public String account;
    public String voucher;



    @PostConstruct
    public void init() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        try {
            this.tenderId = mapper.readValue(data, Payment.class).tenderId;
            this.name = mapper.readValue(data, Payment.class).name;
            this.amount = mapper.readValue(data, Payment.class).amount;
            this.reference = mapper.readValue(data, Payment.class).reference;
            this.exUid = mapper.readValue(data, Payment.class).exUid;
            this.account = mapper.readValue(data, Payment.class).account;
            this.voucher = mapper.readValue(data, Payment.class).voucher;
        } catch (IOException e) {
            log.error(e.getStackTrace());
        }
    }


    public Payment setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public Payment setTenderId(int tenderId) {
        this.tenderId = tenderId;
        return this;
    }

    @Override
    public String asJsonString() {
        return data;
    }

    public Payment(){}

}
