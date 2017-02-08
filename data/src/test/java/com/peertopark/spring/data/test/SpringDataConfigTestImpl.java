/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peertopark.spring.data.test;

import com.peertopark.spring.data.DataSourceConfig;
import com.peertopark.spring.data.SpringDataConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Hector Espert
 */
@Configuration
@ComponentScan
public class SpringDataConfigTestImpl extends SpringDataConfig {

    public SpringDataConfigTestImpl() {
        super();
        DataSourceConfig dataSourceConfig = new TestDataSourceConfig();
        super.setDataSourceConfig(dataSourceConfig);
    }

}
