package tng3.tests.staffapi.entity;

import tng3.base.Entity;

public class EmployeeProfile implements Entity {

    public int id;
    public String first_name;
    public String last_name;
    public EmployeeOutlet outlet;
    public String picture;
    public String picture_thumb;
    public EmployeeRestrictions restrictions;

}
