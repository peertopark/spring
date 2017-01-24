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

import com.mmnaseri.utils.spring.data.store.DataStore;
import com.mmnaseri.utils.spring.data.store.impl.MemoryDataStore;
import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;
import org.apache.commons.lang3.SerializationUtils;

/**
 *
 * @author blackleg
 */
public class SerializedMemoryDataStore<K extends Serializable, E extends Serializable> extends MemoryDataStore<K, E> implements DataStore<K, E> {
    
    public SerializedMemoryDataStore(Class<E> entityType) {
        super(entityType);
    }

    @Override
    public boolean save(K key, E entity) {
        return super.save(key, SerializationUtils.clone(entity)); 
    }

    @Override
    public E retrieve(K key) {
        return SerializationUtils.clone(super.retrieve(key));
    }

    @Override
    public synchronized Collection<E> retrieveAll() {
        LinkedList<E> linkedList = new LinkedList<>(super.retrieveAll());
        return SerializationUtils.clone(linkedList);
    }

}
