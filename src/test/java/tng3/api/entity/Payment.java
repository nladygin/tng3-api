package tng3.api.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import tng3.api.Config;
import tng3.api.ContextHelper;
import tng3.api.Utils;

import java.io.IOException;


public class Payment implements Entity {

    public Integer tenderId;
    public String name;
    public Double amount;
    public String reference;
    public String exUid;
    public String account;
    public String voucher;






    public Payment(
                    Integer tenderId,
                    String name,
                    Double amount,
                    String reference,
                    String exUid,
                    String account,
                    String voucher
    ){
        this.tenderId       = (tenderId == null) ? config.tenderID : tenderId;
        this.name           = (name == null) ? "DUMMY" : name;
        this.amount         = (amount == null) ? 0 : amount;
        this.reference      = (reference == null) ? "payment reference" : reference;
        this.exUid          = (exUid == null) ? "7645-3476-asd" : exUid;
        this.account        = (account == null) ? null : account;
        this.voucher        = (voucher == null) ? null : voucher;
    }

    public Payment(){
        this(null,null,null,null,null,null,null);
    }




    public Payment setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public Payment setTenderId(int tenderId) {
        this.tenderId = tenderId;
        return this;
    }

    public Payment setTenderName(String name) {
        this.name = name;
        return this;
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
    private Config config = ContextHelper.getBean(Config.class);
}
