package com.dbcoding.mall.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.*;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.*;

/**
 * @ClassName: AAA
 * @Description: TODO
 * @Author: Stephen.Zhang
 * @CreateDate: 2020-05-15 11:02
 * @Version: 1.0
 **/
@Slf4j
public class PropertiesUtil {
    private static Map<String, Properties> propertiesMap;

    static {
        PropertiesUtil.propertiesMap = new HashMap<String, Properties>();
    }

    public static String getProperties(final String path, final String key) throws IOException {
        log.info("path is " + path);
        Properties properties = PropertiesUtil.propertiesMap.get(path);
        if (properties == null || properties.isEmpty()) {
            final Resource resource = (Resource) new ClassPathResource(path);
            properties = PropertiesLoaderUtils.loadProperties(resource);
            log.info("properties is " + properties);
            if (properties == null || properties.isEmpty()) {
                throw new IOException(String.valueOf(path) + " not found");
            }
            PropertiesUtil.propertiesMap.put(path, properties);
        }
        log.info("getProperty(key) is " + key + properties.getProperty(key));
        return properties.getProperty(key);
    }

    public static void main(final String[] args) {
        for (int i = 0; i < 10; ++i) {
            try {
                log.info(getProperties("/key/system", "secret.key"));
                log.info(getProperties("/key/system", "aes.password"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
