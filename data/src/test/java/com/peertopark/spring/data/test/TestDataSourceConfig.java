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
package com.peertopark.spring.data.test;

import com.peertopark.spring.data.DataSourceConfig;

/**
 *
 * @author hector
 */
public class TestDataSourceConfig implements DataSourceConfig {

    @Override
    public String getPersistenceUnit() {
        return "org.h2.Driver";
    }

    @Override
    public String getJDBCDriver() {
        return "org.h2.Driver";
    }

    @Override
    public String getJDBCUrl() {
        return "jdbc:h2:mem:testdb;MODE=MySQL";
    }

    @Override
    public String getJDBCUser() {
        return "";
    }

    @Override
    public String getJDBCPassword() {
        return "";
    }

    @Override
    public int getMaxConnections() {
        return 5;
    }

}
