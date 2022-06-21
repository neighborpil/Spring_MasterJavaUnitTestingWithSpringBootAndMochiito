package com.neighborpil.unittesting.unittesting.business;

import com.neighborpil.unittesting.unittesting.data.ItemRepository;
import com.neighborpil.unittesting.unittesting.data.SomeDataService;
import com.neighborpil.unittesting.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ItemBusinessServiceTest {

    @InjectMocks
    private ItemBusinessService business;
    @Mock
    private ItemRepository repository;

    @Test
    public void retrieveAllItems_basic() {
        when(repository.findAll()).thenReturn(
                Arrays.asList(new Item(2, "Item 2", 10, 10),
                        new Item(3, "Item 3", 20, 20))
        );

        List<Item> items = business.retrieveAllItems();
        assertEquals(items.get(0).getValue(), 100);
        assertEquals(items.get(1).getValue(), 400);
    }
}
