package tng3.tests.med.entity;

import java.util.Date;
import java.util.List;

public class EMR {
    public long id;
    public Date openDate;
    public Date closeDate;
    public long employeeId;
    public List<EMRSection> sections;
    public List<EMRValue> records;
}
