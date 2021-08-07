package tng3.tests.med.entity;

import tng3.common.entity.Value;

import java.util.List;

public class Employee {
    public long id;
    public String firstName;
    public String lastName;
    public Gender gender;
    public Value medicalPosition;
    public Value medicalSpeciality;
    public List<PersonalDocument> documents;
}
