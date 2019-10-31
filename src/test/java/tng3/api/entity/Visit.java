package tng3.api.entity;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tng3.base.Entity;

import java.io.IOException;


public class Visit implements Entity {

    public String clockIn;
    public String clockOut;
    public Outlet outlet;




    public Visit(
                    String clockIn,
                    String clockOut,
                    Outlet outlet
    ){

    }

    public Visit(){
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
