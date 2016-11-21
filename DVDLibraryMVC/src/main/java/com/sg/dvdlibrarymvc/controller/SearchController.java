/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrarymvc.controller;

import com.sg.dvdlibrarymvc.dao.DVDLibrary;
import com.sg.dvdlibrarymvc.dao.SearchTerm;
import com.sg.dvdlibrarymvc.model.DVD;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author apprentice
 */
@Controller
public class SearchController {
     private DVDLibrary dao;
    
    @Inject
    public SearchController(DVDLibrary dao){
        this.dao = dao;
    }
    @RequestMapping(value="search", method=RequestMethod.GET)
    public String displaySearch(){
        return "search";
    }
    @RequestMapping(value="search/dvds",method=RequestMethod.POST)
    @ResponseBody public List<DVD> searchContacts(@RequestBody Map<String, String> searchMap){
        //Create the map of search criteria to send to the DAO
        Map<SearchTerm, String> criteriaMap = new HashMap();
        
        //determine which search terms have values, translate the String
        //keys into SearchTerm enums, and set the corresponding values appropriately
        String currentTerm = searchMap.get("title");
        if(!currentTerm.isEmpty()){
            criteriaMap.put(SearchTerm.TITLE, currentTerm);
        }
        currentTerm = searchMap.get("releaseYear");
        if(!currentTerm.isEmpty()){
            criteriaMap.put(SearchTerm.RELEASEYEAR, currentTerm);
        }
        currentTerm = searchMap.get("rating");
        if(!currentTerm.isEmpty()){
            criteriaMap.put(SearchTerm.RATING, currentTerm);
        }
        currentTerm = searchMap.get("director");
        if(!currentTerm.isEmpty()){
            criteriaMap.put(SearchTerm.DIRECTOR, currentTerm);
        }
        currentTerm = searchMap.get("studio");
        if(!currentTerm.isEmpty()){
            criteriaMap.put(SearchTerm.STUDIO, currentTerm);
        }
        currentTerm = searchMap.get("note");
        if(!currentTerm.isEmpty()){
            criteriaMap.put(SearchTerm.NOTE, currentTerm);
        }
        return dao.searchDVDs(criteriaMap);
    }
}
