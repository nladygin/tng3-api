package tng3.api.entity;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tng3.api.Utils;

import java.io.IOException;

public class Coupon implements Entity {


    public String campaignName;
    public String code;
    public String validTill;
    public Double balance;
    public String lastUse;
    public Outlet outlet;
    public String type;
    public String description;




    public Coupon(){

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



    private Utils utils = new Utils();
    private final Logger log = LogManager.getLogger();
}
