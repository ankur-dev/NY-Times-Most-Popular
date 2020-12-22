package com.xebia.assigenment;
/*
 * Created by ankur.khandelwal on 10-01-2018.
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ParseUtil<T> {

    public static <T> T getObject(String json, Class<T> className) {
        if (json != null) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                return mapper.readValue(json, className);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String getJson(Object object) {
        if (object != null) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                return mapper.writeValueAsString(object);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
