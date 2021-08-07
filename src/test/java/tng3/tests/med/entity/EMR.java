package tng3.tests.med.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EMR {
    public long id;
    public String type;
    public long openDate;
    public long closeDate;
    public long employeeId;
    public List<EMRSection> sections;
    public List<EMRValue> records;
    public byte[] pdf;
    public byte[] doctorSignature;
    public byte[] organizationSignature;

}
