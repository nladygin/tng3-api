package tng3.api.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tng3.api.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ItemForSale implements Entity {

    public Integer outletId;
    public List<Item> items;



    public ItemForSale(
                        Integer outletId,
                        List<Item> items
    ){
        this.outletId = (outletId == null) ? defOutletID : outletId;
            List<Item> i = new ArrayList<>();
                i.add(new Item());
        this.items = (items == null) ? i : items;
    }

    public ItemForSale(){
        this(null,null);
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
    private Integer defOutletID = 81;
}
