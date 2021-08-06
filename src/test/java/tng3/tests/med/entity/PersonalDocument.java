package tng3.tests.med.entity;

import tng3.common.entity.Value;

import java.time.LocalDate;

public class PersonalDocument {
    public Value documentType;
    public String notes;
    public String number;
    public LocalDate issuedDate;
    public LocalDate expiryDate;
    public String issuedPlace;
    public String issuedCountry;
    public String issuedEntityCode;
}
