package tng3.api.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;


public class AccountTopUp implements Entity {

    public Integer outletId;
    public String purchaseType;
    public Double total;






    public AccountTopUp(
                        Integer outletID,
                        String purchaseType,
                        Double total
    ){
        this.outletId       = (outletID == null) ? 81 : outletID;
        this.purchaseType   = (purchaseType == null) ? "DEPOSIT" : purchaseType;
        this.total          = (total == null) ? 13 : total;
    }

    public AccountTopUp(){
        this(null,null,null);
    }









    @Override
    public String asJsonString() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        String json = null;
        try {
            json = mapper.writeValueAsString(this);
        } catch (IOException e) {
            log.error(e.getStackTrace());
        }
        return json;
    }





    private final Logger log = LogManager.getLogger();
}
