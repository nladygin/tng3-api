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
import java.util.ArrayList;


public class BillPayments implements Entity {

    private final Logger log = LogManager.getLogger();



    @JsonIgnore
    private ArrayList<Payment> payments = new ArrayList<>();


    public BillPayments addPayment(Payment payment){
        this.payments.add(payment);
        return this;
    }



    @Override
    public String asJsonString() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        String json = null;
        try {
            json = mapper.writeValueAsString(payments);
        } catch (IOException e) {
            log.error(e.getStackTrace());
        }
        return json;
    }

    public BillPayments(){}

}
