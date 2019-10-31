package tng3.api.entity;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tng3.base.Entity;

import java.io.IOException;

public class Class implements Entity {

    public int id;
    public String startTime;
    public String endTime;
    public String name;
    public String classLevel;
    public String classNumber;
    public Outlet outlet;
    public Float price;
    public Therapist trainer;
    public String facility;
    public int availability;
    public boolean subscribed;
    public int offerId;
    public int docId;


    public Class(){}


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
