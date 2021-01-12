package com.arsenev.employees.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

//TODO: create description

@UtilityClass
public class JsonUtil {
    private static ObjectMapper mapper;

    public static void setMapper(ObjectMapper mapper){
        JsonUtil.mapper = mapper;
    }
}
