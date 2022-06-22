package com.neighborpil.unittesting.unittesting.controller;

import static org.mockito.Mockito.when;

import com.neighborpil.unittesting.unittesting.data.ItemRepository;
import com.neighborpil.unittesting.unittesting.model.Item;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private ItemRepository repository; // 여러 외부 디펜던시에서 목빈으로 설정한 것만 목으로 동작한다.

    @Test
    public void contextLoads() throws JSONException {

        // 실제 DB에서 불러오려고 한다면 when 부분을 삭제하거나 주석처리하면 된다
        when(repository.findAll()).thenReturn(
            Arrays.asList(new Item(10001, "Item 2", 10, 10),
                new Item(10002, "Item 2", 10, 10),
                new Item(10003, "Item 3", 20, 20))
        );

        String response = this.restTemplate.getForObject("/all-items-from-database", String.class);
        JSONAssert.assertEquals("[{id:10001}, {id:10002}, {id:10003}]", response, false);
    }

}
