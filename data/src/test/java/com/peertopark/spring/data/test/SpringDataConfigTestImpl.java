/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peertopark.spring.data.test;

import com.peertopark.spring.data.SpringDataConfig;
import javax.sql.DataSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Hector Espert
 */
@Configuration
@ComponentScan
public class SpringDataConfigTestImpl extends SpringDataConfig {

    @Override
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername("");
        dataSource.setPassword("");
        dataSource.setUrl("jdbc:h2:mem:testdb;MODE=MySQL");
        dataSource.setDriverClassName("org.h2.Driver");
        return dataSource;
    }

}
