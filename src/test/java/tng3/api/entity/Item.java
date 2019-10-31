package tng3.api.entity;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tng3.api.config.Config;
import tng3.api.helper.ContextHelper;

import java.io.IOException;
import java.util.Objects;


public class Item implements Entity {

    public Integer offerId;
    public String name;
    public Integer count;
    public Double amount;
    public Double discount;
    public Integer bookingId;
    public Integer id;
    public String reference;





    public Item(
                Integer offerId,
                String name,
                Integer count,
                Double amount,
                Double discount,
                Integer bookingId,
                Integer id,
                String reference
    ){
        this.offerId    = (offerId == null) ? config.offerID : offerId;
        this.name       = (name == null) ? "item for sale" : name;
        this.count      = (count == null) ? 1 : count;
        this.amount     = (amount == null) ? 13.66 : amount;
        this.discount   = (discount == null) ? 0 : discount;
        this.bookingId  = (bookingId == null) ? null : bookingId;
        this.id         = (id == null) ? null : id;
        this.reference  = (reference == null) ? "item reference" : reference;
    }

    public Item(){
        this(null,null,null,null,null,null,null,null);
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(offerId, item.offerId) &&
                Objects.equals(name, item.name) &&
                Objects.equals(count, item.count) &&
                Objects.equals(amount, item.amount) &&
                Objects.equals(discount, item.discount) &&
                Objects.equals(bookingId, item.bookingId) &&
                Objects.equals(id, item.id) &&
                Objects.equals(reference, item.reference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offerId, name, count, amount, discount, bookingId, id, reference);
    }






    private final Logger log = LogManager.getLogger();
    private Config config = ContextHelper.getBean(Config.class);
}
