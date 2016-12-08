/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.soupastars.dao;

import com.sg.soupastars.model.StaticPage;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface SoupaStarsStaticPageDao {
    
StaticPage create(StaticPage staticPage);

    public StaticPage selectPageById(Integer id);

    public void update(StaticPage staticPage);

    public void delete(StaticPage staticPage);

    List<StaticPage> getAllStaticPages();

    List<StaticPage> listActivePages();

}
    

