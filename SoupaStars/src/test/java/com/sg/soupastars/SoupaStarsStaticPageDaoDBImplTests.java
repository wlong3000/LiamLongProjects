
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.soupastars;

import com.sg.soupastars.dao.SoupaStarsStaticPageDao;
import com.sg.soupastars.model.StaticPage;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author apprentice
 */
public class SoupaStarsStaticPageDaoDBImplTests {
    
    private SoupaStarsStaticPageDao dao;
    
    public SoupaStarsStaticPageDaoDBImplTests(){
        
    }
    
    @BeforeClass
    public static void setUpClass(){
       
    }
    
    @AfterClass
    public static void tearDownClass(){
        
    }
    
    @Before
    public void setUp(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        
        dao = (SoupaStarsStaticPageDao) ctx.getBean("SoupaStarsStaticPageDaoDBImpl");
        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        cleaner.execute("delete from StaticPage");
    }
    
    @After
    public void tearDown(){
        
    }
    
    @Test
    public void addGetDeleteStaticPage(){
        StaticPage sp = new StaticPage();
        sp.setAuthor("Alyssa");
        sp.setTitle("candy");
        sp.setBody("yum");
        sp.setExpirationDate("12/30/2016");
        dao.create(sp);
        StaticPage fromDb = dao.selectPageById(sp.getPageId());
        assertEquals(fromDb.getPageId(), sp.getPageId());
        assertEquals(fromDb.getAuthor(), sp.getAuthor());
         assertEquals(fromDb.getBody(), sp.getBody());
        assertEquals(fromDb.getExpirationDate(), sp.getExpirationDate());
        dao.delete(sp);
        assertNull(dao.selectPageById(sp.getPageId()));
    }
        }
