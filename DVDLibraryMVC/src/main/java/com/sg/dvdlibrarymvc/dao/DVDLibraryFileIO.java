/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrarymvc.dao;


import com.sg.dvdlibrarymvc.model.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Double.NaN;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class DVDLibraryFileIO implements DVDLibrary {
     //Intialize HashMap <Integer (serialNumber), DVD>
    ArrayList<DVD> dvdList = new ArrayList();
     final String DVD_FILE = "dvdLibrary.txt";
     final String DELIMITER = "::";
     
     //add dvd
    @Override
     public void addDVD(DVD newDVD){
         dvdList.add(newDVD);
     }
     //remove dvd
    @Override
     public void remove(int targetNumber){
         DVD targetDVD = new DVD();
         for (DVD dvd : dvdList){
             if(dvd.getSerialNumber() == targetNumber){
                 targetDVD = dvd;
             }
         }
         dvdList.remove(targetDVD);
     }
     @Override
     public void editDVD(DVD updatedDVD){
         int targetNumber = updatedDVD.getSerialNumber();
         remove(targetNumber);
         addDVD(updatedDVD);
     }
     //get dvd
    @Override
     public ArrayList<DVD> getAllDVDs(){
         //get all dvds
         return dvdList;
     }

    @Override
     public void load(){
         dvdList.clear();
         try{readFromFile();
         }catch(FileNotFoundException fnf){
           //do nothing
         }
     }
     
    @Override
     public void save(){
         try{writeToFile();
         }catch(IOException ioe){
           //do nothing  
         }
     }
     
   
     public void readFromFile()throws FileNotFoundException{
        Scanner sc = new Scanner(new BufferedReader(new FileReader(DVD_FILE)));
        String currentLine;
        String[] currentTokens;
        while(sc.hasNextLine()){
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            int serialNumber = Integer.parseInt(currentTokens[0]);
            String title = currentTokens[1];
            int releaseDate = Integer.parseInt(currentTokens[2]);
            String rating = currentTokens[3];
            String director = currentTokens[4];
            String studio = currentTokens[5];
            String note = currentTokens[6];
            
            DVD currentDVD = new DVD(serialNumber, title, releaseDate, rating, director, studio, note);
            addDVD(currentDVD);
        }
     }
   
     public void writeToFile() throws IOException{
         PrintWriter writer = new PrintWriter(new FileWriter(DVD_FILE));
         for(DVD dvd : dvdList){
             writer.println(dvd.getSerialNumber() + DELIMITER +
                     dvd.getTitle() + DELIMITER + 
                     dvd.getReleaseYear() + DELIMITER + 
                     dvd.getRating() + DELIMITER +
                     dvd.getDirector() + DELIMITER + 
                     dvd.getStudio() + DELIMITER +
                     dvd.getNote());
             writer.flush();            
         }   
         writer.close();
     } 
     
    @Override
     public double getAverageAge(){
         int totalAge = 0;
         totalAge = dvdList.stream().map((dvd) -> 2016 - dvd.getReleaseYear())
                 .reduce(totalAge, Integer::sum);
         return totalAge / dvdList.size();
     }
     
    @Override
     public DVD getOldestMovie(){
         DVD oldest = new DVD();
         oldest.setReleaseYear(2016);
         for(DVD dvd : dvdList){
             if(dvd.getReleaseYear() < oldest.getReleaseYear()){
                 oldest = dvd;
             }
         }
         return oldest;
     }
     
    @Override
     public DVD getNewestMovie(){
         DVD newest = new DVD();
         newest.setReleaseYear(0);
         for(DVD dvd : dvdList){
             if(dvd.getReleaseYear() > newest.getReleaseYear()){
                 newest = dvd;
             }
         }
         return newest;
     }
     
    @Override
     public double getAverageNumNotes(){
         int numNotes = 0;
         numNotes = dvdList.stream().filter((dvd) -> (!dvd.getNote().equals("")))
                 .map((_item) -> 1).reduce(numNotes, Integer::sum);
         return numNotes / dvdList.size();
     }

    @Override
    public DVD getDVDBySerialNumber(int serialNumber) {
        DVD targetDVD = new DVD();
        for(DVD dvd : dvdList){
            if(dvd.getSerialNumber() == serialNumber){
                targetDVD = dvd;
            }
        }
        return targetDVD;
    }

    @Override
    public List<DVD> searchDVDs(Map<SearchTerm, String> criteria) {
       // Get all the things we're searching for into individual variables
        String titleCriteria = criteria.get(SearchTerm.TITLE);
        String yearCriteria = criteria.get(SearchTerm.RELEASEYEAR);
        String ratingCriteria = criteria.get(SearchTerm.RATING);
        String directorCriteria = criteria.get(SearchTerm.DIRECTOR);
        String studioCriteria = criteria.get(SearchTerm.STUDIO);
        String noteCriteria = criteria.get(SearchTerm.NOTE);

        // Declare predicate conditions - to be used by our filters
        Predicate<DVD> titleMatches;
        Predicate<DVD> yearMatches;
        Predicate<DVD> ratingMatches;
        Predicate<DVD> directorMatches;
        Predicate<DVD> studioMatches;
        Predicate<DVD> noteMatches;

        // Default predicate
        Predicate<DVD> truePredicate = (c) -> {return true; };
        
        // Assign values to predicates
        // If a given search term is empty, assign the default Predicate
        // Otherwise, assign the predicate that filters for that term
        
        // ? expression = ternary expression
        // boolean expression ? true value : false value
        // (Do we have nothing in first name criteria?  Use default : Filter on firstNameCriteria
        titleMatches = (titleCriteria == null || titleCriteria.isEmpty()) ?
                truePredicate
                : (c) -> c.getTitle().equalsIgnoreCase(titleCriteria);
        
        yearMatches = (yearCriteria == null || yearCriteria.isEmpty()) ?
                truePredicate
                : (c) -> Integer.toString(c.getReleaseYear()).equals(yearCriteria);
        
//        yearMatches = (yearCriteria == NaN ) ?
//                truePredicate
//                : (c) -> c.getReleaseYear()==yearCriteria;
        
        ratingMatches = (ratingCriteria == null || ratingCriteria.isEmpty()) ?
                truePredicate
                : (c) -> c.getRating().equalsIgnoreCase(ratingCriteria);
        
        directorMatches = (directorCriteria == null || directorCriteria.isEmpty()) ?
                truePredicate
                : (c) -> c.getDirector().equalsIgnoreCase(directorCriteria);
        
        studioMatches = (studioCriteria == null || studioCriteria.isEmpty()) ?
                truePredicate
                : (c) -> c.getStudio().equalsIgnoreCase(studioCriteria);
        noteMatches = (noteCriteria == null || noteCriteria.isEmpty()) ?
                truePredicate
                : (c) -> c.getNote().equalsIgnoreCase(noteCriteria);
        // Return the list of contacts that match the given criteria
        // We will use filters and join them with AND
        return dvdList.stream()
                .filter(titleMatches
                .and(ratingMatches)
                .and(directorMatches)
                .and(studioMatches)
                .and(noteMatches)
                .and(yearMatches))
                .collect(Collectors.toList()); 
    }
}
