package tng3.guestapi.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import tng3.base.Entity;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class TenderParams implements Entity {

    public String fiscalSettleType;
    public String sendZeroPayment;
    public String depositCode;
    public String provider;
    public String publicKey;

}
