package org.example.utils;

import com.gilecode.yagson.YaGson;

public class SerializeUtil {
    private static final YaGson mapper = new YaGson();

    public static String serialize(Object object) {
        return mapper.toJson(object);
    }

    public static <T> T deserialize(String json, Class<T> clazz) {
        return mapper.fromJson(json, clazz);
    }
}
