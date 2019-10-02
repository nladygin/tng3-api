package tng3.api.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tng3.api.Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class Outlet implements Entity {

    public String id;
    public HashMap<String, Float> coord;
    public String phone;
    public String email;
    public String twitter;
    public String vk;
    public String facebook;
    public String instagram;
    public String description;
    public String workHours;
    public List<String> images;
    public String logo;



    public Outlet(){}


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
