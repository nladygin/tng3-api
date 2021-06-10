package tng3.guestapi.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import tng3.base.Entity;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class TenderParams implements Entity {

    public String fiscalSettleType;
    public String fiscalAgentSendAlways;
    public String sendZeroPayment;
    public String fiscalSkipZeroLines;
    public String sendZeroPaymentFiscal;
    public String depositCode;
    public String provider;
    public String publicKey;
    public String web_secret;
    @JsonProperty("FCC TerminalId") public String fccTerminalId;
    @JsonProperty("HPC TerminalId") public String hpcTerminalId;

}
