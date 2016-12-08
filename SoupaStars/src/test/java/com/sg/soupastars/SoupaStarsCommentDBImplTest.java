/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.soupastars;

import com.sg.soupastars.dao.SoupaStarsCommentDao;
import com.sg.soupastars.dao.SoupaStarsPostDao;
import com.sg.soupastars.model.Comment;
import com.sg.soupastars.model.Post;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 *
 * @author apprentice
 */
public class SoupaStarsCommentDBImplTest {

    private SoupaStarsCommentDao dao;
    private SoupaStarsPostDao pdao;

    public SoupaStarsCommentDBImplTest() {

    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Before
    public void setup() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = (SoupaStarsCommentDao) ctx.getBean("SoupaStarsCommentDBImpl");
        pdao = (SoupaStarsPostDao) ctx.getBean("SoupaStarsPostDaoDBImpl");

        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");

        cleaner.execute("delete from PostComment");
        cleaner.execute("delete from Comments");
        cleaner.execute("delete from PostTag");
        cleaner.execute("delete from PostComment");
        cleaner.execute("delete from Post");
        
    }


    @After
    public void tearDown() {

    }

    @Test
    public void addGetDeleteComment() {
        Post pt = new Post();
        pt.setTitle("Cookies");
        pt.setYear(2016);
        pt.setMonth("December");
        pt.setDay(02);
        pt.setAuthor("admin");
        pt.setBody("hello");
        pt.setCategory("Food");
        List<String> tagList = new ArrayList();
        tagList.add("tag");
        pt.setTagList(tagList);
        Post post = pdao.addPost(pt);
        
        Comment nc = new Comment();
        nc.setName("Alyssa");
        nc.setEmail("arice713@yahoo.com");
        nc.setText("hi");
        nc.setDate("November 17, 2016");
        nc = dao.addComment(nc, post.postId);
        Comment fromDb = dao.getCommentById(nc.getCommentId());
        assertEquals(fromDb.getCommentId(), nc.getCommentId());
        assertEquals(fromDb.getName(), nc.getName());
        assertEquals(fromDb.getEmail(), nc.getEmail());
        assertEquals(fromDb.getText(), nc.getText());
        assertEquals(fromDb.getDate(), nc.getDate());
        dao.removeComment(nc.getCommentId());
        assertNull(dao.getCommentById(nc.getCommentId()));
    }
}
