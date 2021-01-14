package com.arsenev.employees.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

import java.io.IOException;

/**
 * Утильный класс для использования в тестах.
 */
@UtilityClass
public class JsonUtil {

    private static ObjectMapper mapper;

    public static void setMapper(ObjectMapper mapper) {
        JsonUtil.mapper = mapper;
    }

    /**
     * Метод для парсинга Java объекта в объект в формате Json.
     * @param obj - преобразовываемый объект
     * @return - строка в Json формате
     */
    public static <T> String writeValue(T obj) {
        try {
            return getMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Invalid write to JSON:\n'" + obj + "'", e);
        }
    }

    /**
     * Метод для преобразовывания Json строки в Java объект.
     * @param json - преобразуемая строка
     * @param clazz - класс, из которого следует создать объект.
     * @return объект класса T.
     */
    public static <T> T readValue(String json, Class<T> clazz) {
        try {
            return getMapper().readValue(json, clazz);
        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid read from JSON:\n'" + json + "'", e);
        }
    }

    public static ObjectMapper getMapper() {
        return JsonUtil.mapper;
    }
}
