/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.soupastars.dao;

import com.sg.soupastars.model.StaticPage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class SoupaStarsStaticPageDaoDBImpl implements SoupaStarsStaticPageDao {

    private static final String SQL_INSERT_STATICPAGE = "INSERT INTO StaticPage (Author, Title, Body, ExpirationDate) VALUES (?, ?, ?, ?)";
    private static final String SQL_DELETE_STATICPAGE = "DELETE FROM StaticPage WHERE PageID = ? ";
    private static final String SQL_SELECT_STATICPAGE = "SELECT * FROM StaticPage WHERE PageID=?";
    private static final String SQL_UPDATE_STATICPAGE = "UPDATE StaticPage SET Author=?, Title=?, Body = ?, ExpirationDate=? WHERE PageID=?";
    private static final String SQL_SELECT_ALL_STATICPAGES = "SELECT * FROM StaticPage";

    private JdbcTemplate jdbcTemplate;

       

   
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public StaticPage create(StaticPage staticPage) {

        jdbcTemplate.update(SQL_INSERT_STATICPAGE,
                staticPage.getAuthor(),
                staticPage.getTitle(),
                staticPage.getBody(),               
                staticPage.getExpirationDate());

        Integer staticPageId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        staticPage.setPageId(staticPageId);
        return staticPage;

    }

    @Override
    public StaticPage selectPageById(Integer id) {
        try{
        return jdbcTemplate.queryForObject(SQL_SELECT_STATICPAGE, new PageMapper(), id);
        } catch (EmptyResultDataAccessException ex) {
        return null;
    }
    
       

    }

    @Override
    public void update(StaticPage staticPage) {

        jdbcTemplate.update(SQL_UPDATE_STATICPAGE,
                staticPage.getAuthor(),
                 staticPage.getTitle(),
                staticPage.getBody(),
                staticPage.getExpirationDate(),
                staticPage.getPageId());

    }

    @Override
    public void delete(StaticPage staticPage) {

        jdbcTemplate.update(SQL_DELETE_STATICPAGE, staticPage.getPageId());

    }

    @Override
    public List<StaticPage> getAllStaticPages() {

        List<StaticPage> staticPage = jdbcTemplate.query(SQL_SELECT_ALL_STATICPAGES, new PageMapper());
        return staticPage;

    }

    @Override
    public List<StaticPage> listActivePages() {

        List<StaticPage> staticPage = jdbcTemplate.query(SQL_SELECT_ALL_STATICPAGES, new PageMapper());
        List<StaticPage> pages = new ArrayList();
        String isActive = "Active";

        for (StaticPage s : staticPage)
        {
            if (s.getExpirationDate().equals(isActive) ) {

                pages.add(s);

            }

        }

        pages.size();

        return pages;

    }

    private static final class PageMapper implements RowMapper<StaticPage> {

        @Override
        public StaticPage mapRow(ResultSet rs, int i) throws SQLException {

            StaticPage staticPage = new StaticPage();
            staticPage.setPageId(rs.getInt("PageID"));
            staticPage.setBody(rs.getString("Body"));
            staticPage.setTitle(rs.getString("Title"));
            staticPage.setAuthor(rs.getString("Author"));
            staticPage.setExpirationDate(rs.getString("ExpirationDate"));

            return staticPage;

        }
    }

}