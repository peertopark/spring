/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peertopark.spring.data;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.peertopark.spring.data.test.SpringDataConfigTestImpl;
import javax.sql.DataSource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.AbstractEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.PlatformTransactionManager;

/**
 *
 * @author Hector Espert
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringDataConfigTestImpl.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class})
public class SpringDataConfigTest {
    
    @Autowired
    private DataSource dataSource;
    
    @Autowired
    private AbstractEntityManagerFactoryBean entityManagerFactoryBean;
    
    @Autowired
    private AbstractJpaVendorAdapter jpaVendorAdapter;
    
    @Autowired
    private PlatformTransactionManager transactionManager;
    
    @Autowired
    private MigrationManager migrationManager;
    
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
    
    
    @Test
    public void testDataSource() {
        assertNotNull(dataSource);
    }
    
    @Test
    public void testEntityManagerFactoryBean() {
        assertNotNull(entityManagerFactoryBean);
    }
    
    @Test
    public void testJpaVendorAdapter() {
        assertNotNull(jpaVendorAdapter);
    }
    
    
    @Test
    public void testTransactionManager() {
        assertNotNull(transactionManager);
    }
    
    @Test
    public void testMigrationManager() {
        assertNotNull(migrationManager);
    }

    
}
