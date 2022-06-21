package com.neighborpil.unittesting.unittesting.business;

import com.neighborpil.unittesting.unittesting.model.Item;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ItemBusinessService {

    public Item retrieveHardcodedItem() {
        return new Item(1, "Ball", 10, 100);
    }
}
