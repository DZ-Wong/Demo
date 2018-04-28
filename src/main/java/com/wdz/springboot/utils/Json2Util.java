package com.wdz.springboot.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.DoubleSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;

/**
 * 饿汉模式实现单例。
 *
 */
public class Json2Util {
    private static SerializeConfig config = new SerializeConfig();

//    private Json2Util() {
//
//    }
//
//    public static SerializeConfig getConfig() {
//        return config;
//    }

    static {
        config.put(Double.class, new DoubleSerializer("#.##"));
    }

    public static String toJSONString(Object obj) {
        return JSONObject.toJSONString(obj, config);
    }
}
