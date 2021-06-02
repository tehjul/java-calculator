package com.iut.as2021.tools;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

public class Loader {

    public static Properties getProperties (String filename) throws IOException {
        return PropertiesLoaderUtils.loadProperties(new ClassPathResource(filename));
    }
}
