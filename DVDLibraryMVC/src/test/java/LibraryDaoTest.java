
import com.sg.dvdlibrarymvc.dao.DVDLibraryFileIO;
import com.sg.dvdlibrarymvc.model.DVD;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class LibraryDaoTest {
    DVDLibraryFileIO testingDao = new DVDLibraryFileIO();
    
    DVD[] dvdsForTesting = {
        new DVD(1,"The Producers", 1968, "PG", "Mel Brooks", "Embassy Pictures", "The Original"),
        new DVD(2,"The Producers", 2005, "PG-13", "Mel Brooks", "Universal Pictures", "The Remake"),
        new DVD(3,"The Dark Knight", 2008, "PG-13", "Christopher Nolan", "Legendary Pictures", "10/10 would recommend")
    };
    
    DVD dvdToAdd = new DVD(4,"Deadpool", 2016, "R", "Tim Miller", "Marvel Entertainment", "Not Family Friendly...");
    @Before
    public void setUp(){
        for(DVD dvd : dvdsForTesting){
            testingDao.addDVD(dvd);
        }
    }
    
    //tests addDVD method using getDVDBySerialNumber method
    @Test
    public void addDVDTest(){
        DVD expected = new DVD(4,"Deadpool", 2016, "R", "Tim Miller", "Marvel Entertainment", "Not Family Friendly...");
        testingDao.addDVD(expected);
        DVD actual = testingDao.getDVDBySerialNumber(4);
        
        testingDao.addDVD(expected);
        assertEquals(expected.getSerialNumber(),actual.getSerialNumber());
        assertEquals(expected.getTitle(),actual.getTitle());
        assertEquals(expected.getReleaseYear(),actual.getReleaseYear());
        assertEquals(expected.getRating(),actual.getRating());
        assertEquals(expected.getStudio(),actual.getStudio());
        assertEquals(expected.getDirector(),actual.getDirector());
        assertEquals(expected.getNote(),actual.getNote());
    }
    
    @Test
    public void getAllDVDsTest(){
        //3 DVDs are loaded from the array before every test
        //this method should return those three DVDs
        int numDVDs = testingDao.getAllDVDs().size();
        assertEquals(3,numDVDs);
    }
    
    @Test
    public void removeDVDTest(){
        testingDao.remove(1);
        int numDVDs = testingDao.getAllDVDs().size();       
        assertEquals(2,numDVDs);
    }
    @Test
    public void editDVDTest(){
        DVD editedDVD = new DVD(1,"Spaceballs",1987,"PG-13","Mel Brooks","Some Studio", "Great Movie");
        testingDao.editDVD(editedDVD);
        assertEquals("Spaceballs",testingDao.getDVDBySerialNumber(1).getTitle());
        assertEquals("Mel Brooks", testingDao.getDVDBySerialNumber(1).getDirector());
        assertEquals(3,testingDao.getAllDVDs().size());
    }
    
    @Test
    public void getAverageAgeTest(){
        assertEquals(22,testingDao.getAverageAge(),.0001);
        testingDao.addDVD(dvdToAdd);
        assertEquals(16,testingDao.getAverageAge(),0.0001);
    }
    
    @Test
    public void getOldestMovieTest(){
        assertEquals("The Producers",testingDao.getOldestMovie().getTitle());
        assertEquals(1968,testingDao.getOldestMovie().getReleaseYear());
    }
    
    @Test
    public void getNewestMovieTest(){
        assertEquals("The Dark Knight", testingDao.getNewestMovie().getTitle());
        assertEquals(2008,testingDao.getNewestMovie().getReleaseYear());
    }
    
    @Test
    public void getAverageNumNotesTest(){
        assertEquals(1,testingDao.getAverageNumNotes(),0.00001);
    }
            
}
