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

import javax.sql.DataSource;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Hector Espert
 */
@Component
public class MigrationManager extends Flyway implements InitializingBean {

    @Autowired
    private DataSource dataSource;

    public MigrationManager() {
        super();
    }

    public MigrationManager(String migrationsLocation) {
        super();
        super.setLocations(migrationsLocation);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        super.setDataSource(dataSource);
        super.migrate();
    }
    
}
