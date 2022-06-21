package com.neighborpil.unittesting.unittesting.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.neighborpil.unittesting.unittesting.business.ItemBusinessService;
import com.neighborpil.unittesting.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService businessService;

    @Test
    public void dummyItem_basic() throws Exception{
        // call "/hello-world"  GET application/json

        RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item")
            .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request)
            .andExpect(status().isOk())
//            .andExpect(content().string("{\"quantity\":100,\"id\":1,\"name\":\"Ball\",\"price\":10}")) // 스페이스까지 완벽하게 동일해야 한다
//            .andExpect(content().json("{\"quantity\": 100,\"id\":1,\"name\":\"Ball\",\"price\":10}")) // 값만 동일하면 된다, 스페이스 있어도 괜찮음
            .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10}")) // 값만 일부 빠져도 상관 없다
            .andReturn();

//        String expected = "{\"quantity\": 100,\"id\":1,\"name\":\"Ball\",\"price\":10}";
//        JsonAssertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void itemFromBusinessService_basic() throws Exception{

        when(businessService.retrieveHardcodedItem()).thenReturn(new Item(2, "Item 2", 10, 10));

        RequestBuilder request = MockMvcRequestBuilders.get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{quantity:10,id:2,name:\"Item 2\",price:10}")) // 스페이스까지 완벽하게 동일해야 한다
                .andReturn();

    }

    @Test
    public void itemtFromBusinessService_basic() throws Exception{

        when(businessService.retrieveAllItems()).thenReturn(
                Arrays.asList(new Item(2, "Item 2", 10, 10))
        );

        RequestBuilder request = MockMvcRequestBuilders.get("/all-items-from-database")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{quantity:10,id:2,name:\"Item 2\",price:10}]")) // 스페이스까지 완벽하게 동일해야 한다
                .andReturn();

    }
    @Test
    public void itemtFromBusinessService_towItems() throws Exception{

        when(businessService.retrieveAllItems()).thenReturn(
                Arrays.asList(new Item(2, "Item 2", 10, 10),
                        new Item(3, "Item 3", 20, 20))
        );

        RequestBuilder request = MockMvcRequestBuilders.get("/all-items-from-database")
            .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request)
            .andExpect(status().isOk())
            .andExpect(content().json("[{quantity:10,id:2,name:\"Item 2\",price:10},{quantity:20,id:3,name:\"Item 3\",price:20}]")) // 스페이스까지 완벽하게 동일해야 한다
            .andReturn();

    }

}
