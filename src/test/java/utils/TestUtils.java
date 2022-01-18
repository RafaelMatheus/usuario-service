package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtils {
    private TestUtils() {
    }

    public static String toJson(Object object) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(object);
    }
}
