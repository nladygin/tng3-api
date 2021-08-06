package tng3.common.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import tng3.base.Entity;

@JsonInclude(JsonInclude.Include.NON_NULL) //TODO remove after refactor for consistency
public class Value implements Entity {

    public String code;
    public String value; //TODO remove after refactor for consistency
    public String description;

    public Value(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public Value(){

    }
}
