package tng3.api.entity;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tng3.base.Entity;

import java.io.IOException;
import java.util.List;

public class Tender implements Entity {

    public int id;
    public String type;
    public String reference;
    public String account;
    public String authUrl;
    public TenderParams params;
    public List<Account> accounts;


    public Tender(){}



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
