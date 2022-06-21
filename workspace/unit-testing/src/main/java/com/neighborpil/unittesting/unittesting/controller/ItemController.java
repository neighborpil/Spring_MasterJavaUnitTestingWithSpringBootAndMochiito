package com.neighborpil.unittesting.unittesting.controller;

import com.neighborpil.unittesting.unittesting.business.ItemBusinessService;
import com.neighborpil.unittesting.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemBusinessService itemBusinessService;

    @GetMapping("/dummy-item")
    public Item dummyItem() {
        return new Item(1, "Ball", 10, 100);
    }

    @GetMapping("/item-from-business-service")
    public Item itemFromBusinessService() {
        return itemBusinessService.retrieveHardcodedItem();
    }

    @GetMapping("/all-items-from-database")
    public List<Item> retrieveAllItems() {
        return itemBusinessService.retrieveAllItems();
    }
}
