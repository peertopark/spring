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
package com.peertopark.spring.data;

import com.peertopark.spring.data.test.objects.Car;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 *
 * @author blackleg
 */
public class SerializedMemoryDataStoreTest {
    
    
    private SerializedMemoryDataStore<Integer, Car> dataStore;

    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        dataStore = new SerializedMemoryDataStore<>(Car.class);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testEntityType() throws Exception {
        assertEquals(dataStore.getEntityType(), Car.class);
    }
    
    @Test
    public void testSaveAndRetrieve() throws Exception {
        assertTrue(dataStore.retrieveAll().isEmpty());
        Car car = new Car(1);
        dataStore.save(1, car);
        assertEquals(1, dataStore.retrieveAll().size());
        assertFalse(dataStore.retrieveAll().isEmpty());
        car = new Car(2);
        dataStore.save(2, car);
        assertEquals(2, dataStore.retrieveAll().size());
        assertFalse(dataStore.retrieveAll().isEmpty());
    }
    
    
    @Test
    public void testRetrievalByKey() throws Exception {
        Integer key = 1;
        Car car = new Car(key);
        System.out.println(car);
        assertTrue(dataStore.retrieveAll().isEmpty());
        assertNull(dataStore.retrieve(key));
        dataStore.save(key, car);
        assertEquals(1, dataStore.retrieveAll().size());
        Car savedCar = dataStore.retrieve(key);
        assertNotNull(savedCar);
        assertEquals(car, savedCar);
        assertNotEquals(car.parentHashCode(), savedCar.parentHashCode());
    }


    
}
