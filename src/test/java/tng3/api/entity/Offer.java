package tng3.api.entity;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tng3.api.Utils;

import java.io.IOException;

public class Offer implements Entity {

    public int id;
    public String folder;
    public int folderID;
    public String folderImage;
    public String name;
    public String description;
    public int duration;
    public float price;
    public boolean pakkage;
    public String type;
    public String image;



    public Offer(){}



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
