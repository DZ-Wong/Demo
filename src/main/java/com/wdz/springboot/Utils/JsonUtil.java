package com.wdz.springboot.Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.DoubleSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * FastJson 自定义配置类。
 * 双重锁模式单例。
 */
public class JsonUtil {
//    private static Map<Integer, SerializeConfig> mapping = null;
     private static Map<Integer, SerializeConfig> mapping = new ConcurrentHashMap<>();

    /**
     * 双重锁机制确保单例模式生成唯一SerializeConfig。
     *
     * @return SerializeConfig
     */
    public static SerializeConfig getFormateConfig() {
        SerializeConfig config = mapping.get(0);
        if (config == null) {
            synchronized(JsonUtil.class) {
                if (!mapping.containsKey(0)) {
                    config = new SerializeConfig();
                    /**配置了Double类型默认格式化形式*/
                    config.put(Double.class, new DoubleSerializer(new DecimalFormat("#.##")));
                    mapping.put(0, config);
                }
            }
        }
        return config;
    }

    /**
     * 让自定义配置生效的实际调用方法。
     * @param obj
     * @param config
     * @return
     */
    public static String toJSONString(Object obj, SerializeConfig config) {
        return JSON.toJSONString(obj, config);
    }

    /**
     * 饱汉模式。
     * 线程不安全，延时加载，减少空间代价。
     */
    public static synchronized SerializeConfig getConfig() {
        SerializeConfig config = mapping.get(0);
        if (config == null) {
            config = new SerializeConfig();
            config.put(Double.class, new DoubleSerializer("#.##"));
            mapping.put(0, config);
        }
        return config;

    }
}
