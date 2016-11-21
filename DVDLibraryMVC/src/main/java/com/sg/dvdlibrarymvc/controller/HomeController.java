/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrarymvc.controller;


import com.sg.dvdlibrarymvc.dao.DVDLibrary;
import com.sg.dvdlibrarymvc.dao.DVDLibraryFileIO;
import com.sg.dvdlibrarymvc.model.DVD;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author apprentice
 */
@Controller
public class HomeController {
    
    private DVDLibrary dao;
    
    @Inject
    public HomeController(DVDLibrary dao){
        this.dao = dao;
    }
    
    @RequestMapping(value={"/","home"},method=RequestMethod.GET)
    public String displayDVDHome(){
        dao.load();
        return "home";
    }
    //Get DVD
    @RequestMapping(value="/dvd/{id}",method=RequestMethod.GET)
    @ResponseBody public DVD getDVD(@PathVariable("id") int id){
        return dao.getDVDBySerialNumber(id);
    }
    //Create DVD
    @RequestMapping(value="/dvd", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody public DVD createDVD(@Valid @RequestBody DVD dvd){
        int id = dao.getAllDVDs().size() +1;
        dvd.setSerialNumber(id);
        dao.addDVD(dvd);
        dao.save();
        return dvd;
    }
    //Update DVD
    @RequestMapping(value="/dvd/{id}",method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putDVD(@PathVariable("id") int id, @RequestBody DVD dvd){
        dvd.setSerialNumber(id);
        dao.editDVD(dvd);
        dao.save();
    }
    //Delete DVD
    @RequestMapping(value="/dvd/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDVD(@PathVariable("id") int id){
        dao.remove(id);
        dao.save();
    }
    //Get all DVDs
    @RequestMapping(value="/dvds", method=RequestMethod.GET)
    @ResponseBody public List<DVD> getAllDVDs(){
        return dao.getAllDVDs();
    }
    //------------------------------------------------------------------------
    //WITHOUT AJAX
    //Create
    @RequestMapping(value="/addDVD", method=RequestMethod.GET)
    public String displayAddMovie(){
        return "addnewdvd";
    }
    @RequestMapping(value="addDVDToLibrary", method=RequestMethod.POST)
    public String addDVDToLibrary(HttpServletRequest request, Model model){
        String title = request.getParameter("title");
        int year = Integer.parseInt(request.getParameter("year"));
        String rating = request.getParameter("rating");
        String director = request.getParameter("director");
        String studio = request.getParameter("studio");
        String note = request.getParameter("note");
        
        dao.load();
        List<DVD> allDVDs = dao.getAllDVDs();
        DVD dvdToAdd = new DVD(allDVDs.size()+1,title,year,rating,director,studio,note);
        dao.addDVD(dvdToAdd);

        dao.save();
        model.addAttribute("allDVDs", allDVDs);
        return "library";
    }
    //Read
    @RequestMapping(value="/library",method=RequestMethod.GET)
    public String displayAllDVDs(Model model){
        dao.load();
        List<DVD> allDVDs = dao.getAllDVDs();
        model.addAttribute("allDVDs", allDVDs);
       return "library"; 
    }
    //Update
    @RequestMapping(value="/editPage", method=RequestMethod.GET)
    public String displayEditPage(HttpServletRequest request, Model model){
        int serialNumber = Integer.parseInt(request.getParameter("serialNumber"));
        DVD dvdToEdit = dao.getDVDBySerialNumber(serialNumber);
        
        model.addAttribute("dvd",dvdToEdit);
        return "editdvd";
    }
    @RequestMapping(value="/editDVD", method=RequestMethod.POST)
    public String submitEdits(@Valid @ModelAttribute ("dvd") DVD dvd, BindingResult result,
            Model model){
        if(result.hasErrors()){
            return "editdvd";
        }
        
        dao.editDVD(dvd);
        dao.save();
        List<DVD> allDVDs = dao.getAllDVDs();
        model.addAttribute("allDVDs", allDVDs);
        return "library";
    }
    //Delete
    @RequestMapping(value="deleteDVD", method=RequestMethod.GET)
    public String deleteDVD(HttpServletRequest request, Model model){
        int serialNumber = Integer.parseInt(request.getParameter("serialNumber"));
        dao.remove(serialNumber);
        dao.save();
        List<DVD> allDVDs = dao.getAllDVDs();
        model.addAttribute("allDVDs", allDVDs);
        return "library";
    }
}
