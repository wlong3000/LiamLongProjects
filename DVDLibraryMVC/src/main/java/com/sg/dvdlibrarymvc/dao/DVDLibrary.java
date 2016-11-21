/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrarymvc.dao;

import com.sg.dvdlibrarymvc.model.DVD;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface DVDLibrary {
    
    public void addDVD(DVD newDVD);
    public void remove(int serialNumber);
    public void editDVD(DVD updatedDVD);
    public DVD getDVDBySerialNumber(int serialNumber);
    public ArrayList<DVD> getAllDVDs();
    public void load();
    public void save();
    public double getAverageAge();
    public DVD getOldestMovie();
    public DVD getNewestMovie();
    public double getAverageNumNotes();

    public List<DVD> searchDVDs(Map<SearchTerm, String> criteriaMap);
    
}
