package tng3.common.action;

import org.springframework.stereotype.Component;
import tng3.guestapi.entity.Item;

import java.util.ArrayList;

@Component
public class ItemsAction extends ArrayList<Item> {





    public ItemsAction addItem(Integer offerId, int count, Integer bookingId, String reference){
            add(new Item(offerId, count, bookingId, reference));
        return this;
    }


}
