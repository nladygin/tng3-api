package tng3.tests.med.entity;

import java.util.Date;
import java.util.List;

public class EMRRegistry {
    public int id;
    public int num;
    public Date openDate;
    public Date closeDate;
    public EMRRegistryType type;
    public long openEmployeeId;
    public long closeEmployeeId;
    public long personId;
    public List<EMR> emrList;

}
