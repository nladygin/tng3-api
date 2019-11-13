package tng3.guestapi.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import tng3.base.Entity;

import java.util.ArrayList;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Items extends ArrayList<Item> implements Entity {


    public Items(ArrayList<Item> items) {
        addAll(items);
    }


    public Items() {
    }

}
