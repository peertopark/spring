/*
 * Copyright 2017 Peer to Park.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.peertopark.spring.commons;

import java.net.URI;
import java.net.URISyntaxException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hector Espert
 */
public class UriBuilderTest {
    
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of init method, of class UriBuilder.
     */
    @Test
    public void testInit() {
        UriBuilder uriBuilder = UriBuilder.init();
        assertNotNull(uriBuilder);
    }

    /**
     * Test of fromUriString method, of class UriBuilder.
     * @throws java.lang.Exception
     */
    @Test
    public void testFromUriString() throws Exception {
        String uri = "https://www.google.es";
        UriBuilder uriBuilder = UriBuilder.fromUriString(uri);
        assertNotNull(uriBuilder);
    }

    /**
     * Test of fromUri method, of class UriBuilder.
     */
    @Test
    public void testFromUri() {
        URI uri = URI.create("https://www.google.es");
        UriBuilder uriBuilder = UriBuilder.fromUri(uri);
        assertNotNull(uriBuilder);
    }

    /**
     * Test of addParameter method, of class UriBuilder.
     * @throws java.net.URISyntaxException
     */
    @Test
    public void testAddParameter() throws URISyntaxException {
        String url = "https://www.google.es";
        String param = "key";
        String value = "value";
        UriBuilder uriBuilder = UriBuilder.fromUriString(url).addParameter(param, value);
        assertNotNull(uriBuilder);
        assertEquals("https://www.google.es?key=value", uriBuilder.buildToString());
    }

    /**
     * Test of build method, of class UriBuilder.
     * @throws java.lang.Exception
     */
    @Test
    public void testBuild() throws Exception {
        String url = "https://www.google.es";
        URI uri = UriBuilder.fromUriString(url).build();
        assertNotNull(uri);
        URI expected = URI.create(url);
        assertEquals(expected, uri);
    }

    /**
     * Test of buildToString method, of class UriBuilder.
     * @throws java.lang.Exception
     */
    @Test
    public void testBuildToString() throws Exception {
        String expected = "https://www.google.es";
        String url = UriBuilder.fromUriString(expected).buildToString();
        assertNotNull(url);
        assertEquals(expected, url);
    }
    
    
    /**
     * Test of addParameter method, of class UriBuilder.
     * @throws java.net.URISyntaxException
     */
    @Test
    public void testAddUrlParameter() throws URISyntaxException {
        String url = "https://www.google.es";
        
        String urlValue = UriBuilder.fromUriString(url).buildToString();
        assertNotNull(urlValue);
        
        String param = "returnUrl";
        String anotherUrlValue = UriBuilder.fromUriString(url).addParameter(param, urlValue).buildToString();

        assertEquals("https://www.google.es?returnUrl=https%3A%2F%2Fwww.google.es", anotherUrlValue);
        
        String resultUrl = UriBuilder.fromUriString(url).addParameter(param, anotherUrlValue).addParameter("test", "true").buildToString();
        System.out.println(resultUrl);
        assertEquals("https://www.google.es?returnUrl=https%3A%2F%2Fwww.google.es%3FreturnUrl%3Dhttps%253A%252F%252Fwww.google.es&test=true", resultUrl);
    }
    
    @Test
    public void testBuildWithQuery() throws Exception {
        String url = "https://www.google.es?returnUrl=https%3A%2F%2Fwww.google.es%3FreturnUrl%3Dhttps%253A%252F%252Fwww.google.es&test=true";
        URI uri = UriBuilder.fromUriString(url).build();
        assertNotNull(uri);
        URI expected = URI.create(url);
        assertEquals(expected, uri);  
    }
    
    @Test
    public void testInitBuild() throws Exception {
        String result = UriBuilder.init().setScheme("http").setHost("www.peertopark.com").setPath("/test").addParameter("key", "value").buildToString();
        assertNotNull(result);
        assertEquals("http://www.peertopark.com/test?key=value", result);
    }
    
}
