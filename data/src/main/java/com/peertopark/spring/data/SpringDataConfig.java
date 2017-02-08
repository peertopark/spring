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
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.orm.jpa.AbstractEntityManagerFactoryBean;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaDialect;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

/**
 *
 * @author Hector Espert
 */
public class SpringDataConfig {

    private DataSourceConfig dataSourceConfig;

    @Autowired(required = false)
    public void setDataSourceConfig(DataSourceConfig dataSourceConfig) {
        this.dataSourceConfig = dataSourceConfig;
    }
    

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(dataSourceConfig.getJDBCUrl());
        dataSource.setUsername(dataSourceConfig.getJDBCUser());
        dataSource.setPassword(dataSourceConfig.getJDBCPassword());
        dataSource.setDriverClassName(dataSourceConfig.getJDBCDriver());
        dataSource.setMaxTotal(dataSourceConfig.getMaxConnections());
        return dataSource;
    }
    
    @Bean
    @DependsOn("migrationManager")
    public AbstractEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        entityManagerFactoryBean.setJpaDialect(jpaDialect());
        return entityManagerFactoryBean;
    }
    
    @Bean
    public AbstractJpaVendorAdapter jpaVendorAdapter() {
        return new EclipseLinkJpaVendorAdapter();
    }
    
    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setJpaDialect(jpaDialect());
        return transactionManager;
    }
    
    @Bean
    public MigrationManager migrationManager() {
        return new MigrationManager();
    }
    
    
    @Bean
    public JpaDialect jpaDialect() {
        EclipseLinkJpaDialect jpaDialect = new EclipseLinkJpaDialect();
        jpaDialect.setLazyDatabaseTransaction(true);
        return jpaDialect;
    }

}
