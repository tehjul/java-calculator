package com.iut.as2021.tools;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;

public class LoaderTest extends TestCase {

    private static final String FILE_NAME_TO_TEST = "bdd.properties";

    @Test
    public void testGetProperties() throws IOException {
        assertNotNull(Loader.getProperties(FILE_NAME_TO_TEST));
    }
}