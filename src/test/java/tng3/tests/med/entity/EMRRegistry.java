package tng3.tests.med.entity;

import java.util.Date;
import java.util.List;

public class EMRRegistry {
    private int id;
    private int num;
    private Date openDate;
    private Date closeDate;
    private EMRRegistryType type;
    private long openEmployeeId;
    private long closeEmployeeId;
    private long assignedDoctorId;
    private String diagnosis;
    private long personId;
    private List<EMR> emrList;
}
