package tng3.tests.med.entity;

import java.util.Date;
import java.util.List;

public class Profile {
    public int id;
    public Date birthDate;
    public String lastName;
    public String firstName;
    public String middleName;
    public Gender gender;
    public List<Address> addresses;
    public List<PersonalDocument> documents;
}
