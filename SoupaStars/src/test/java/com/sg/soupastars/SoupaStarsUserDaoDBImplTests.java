/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.soupastars;

import com.sg.soupastars.dao.SoupaStarsUserDaoDBImpl;
import com.sg.soupastars.dao.SoupaStarsUserDao;
import com.sg.soupastars.model.User;
import java.util.List;
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
public class SoupaStarsUserDaoDBImplTests {
    
    private SoupaStarsUserDao dao;
    
    public SoupaStarsUserDaoDBImplTests(){
        
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
        dao = (SoupaStarsUserDao) ctx.getBean("SoupaStarsUserDaoDBImpl");
        
        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        cleaner.execute("delete from authorities");
    }
    
    @After
    public void tearDown(){
        
    }
    
    @Test
    public void addGetDeleteUser(){
        User us = new User();
        us.setUserId(9);
        us.setUsername("cat");
        us.setPassword("meow");
        us = dao.addUser(us);
        User fromDb = dao.getUserById(us.getUserId());
        assertEquals(fromDb.getUserId(), us.getUserId());
        assertEquals(fromDb.getUsername(), us.getUsername());
        assertEquals(fromDb.getPassword(), us.getPassword());
        
        //Test Delete Method
        List<User> userList = dao.getAllUsers();
        int numUsersBeforeDelete = userList.size();
        dao.deleteUser(us.getUsername());
        userList = dao.getAllUsers();
        int numUsersAfterDelete = userList.size();
        assertEquals(numUsersBeforeDelete,numUsersAfterDelete+1);
        
    }
}
