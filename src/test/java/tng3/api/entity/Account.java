package tng3.api.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Objects;


public class Account implements Entity {

    public String code;
    public String name;
    public Double balance;
    public Double loan;
    public Boolean transfer;
    public String type;
    public Object payment_calendar;




    public Account(
                    String code,
                    String name,
                    Double balance,
                    Double loan,
                    Boolean transfer,
                    String type,
                    Object payment_calendar
    ){

    }

    public Account(){
        this(null, null, null, null, null, null, null);
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
        Account account = (Account) o;
        return Objects.equals(code, account.code) &&
                Objects.equals(name, account.name) &&
                Objects.equals(balance, account.balance) &&
                Objects.equals(loan, account.loan) &&
                Objects.equals(transfer, account.transfer) &&
                Objects.equals(type, account.type) &&
                Objects.equals(payment_calendar, account.payment_calendar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, balance, loan, transfer, type, payment_calendar);
    }



    private final Logger log = LogManager.getLogger();
}
