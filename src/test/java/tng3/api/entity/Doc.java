package tng3.api.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tng3.api.Config;
import tng3.api.Utils;

import java.io.IOException;
import java.util.List;


public class Doc implements Entity {

    public String date;
    public Outlet outlet;
    public Double total;
    public Double discount;
    public String image;
    public int id;
    public List<DocAccount> accounts;



    public Doc(){}



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
