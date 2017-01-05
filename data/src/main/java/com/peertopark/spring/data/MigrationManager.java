/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
