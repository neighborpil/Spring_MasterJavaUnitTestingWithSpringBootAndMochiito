package com.neighborpil.unittesting.unittesting.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse = "{\"quantity\":100,\"id\":1,\"name\":\"Ball\",\"price\":10}";

    @Test
    public void jsonAssertStrictTrue_ExactMatchExceptFopSpaces() throws JSONException {
        String expectedResponse = "{\"quantity\":100,\"id\": 1,\"name\" : \"Ball\",\"price\":10}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true); // space tab 등이 있어도 상관없다. 값이 다 있어야 한다
        // true
    }

    @Test
    public void jsonAssertStrictFalse() throws JSONException {
        String expectedResponse = "{\"id\": 1,\"name\" : \"Ball\",\"price\":10}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false); // 일부 값이 없어도 괜찮다
        // true
    }

    @Test
    public void jsonAssertStrictFalse_WrongValue() throws JSONException {
        String expectedResponse = "{\"id\": 11,\"name\" : \"Ball\",\"price\":10}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false); // 일부 값이 없더라도 있는 값은 모두 정답과 동일해야 한다
        // false
    }

    @Test
    public void jsonAssert_WithoutEscapeCharacters() throws JSONException {
        String expectedResponse = "{id: 1,name:\"Ball\",price:10}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false); // 아이디 등의 escape 문자 등은 없어도 된다
        //
    }
}
