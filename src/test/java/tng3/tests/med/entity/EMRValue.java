package tng3.tests.med.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import tng3.common.entity.Value;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EMRValue {
    public long id;
    public int sectionId;
    public int sortOrder;
    public String name;
    public String alias;
    public String value;
    public Value dictionaryValue;
}
