/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sg.flooringmastery.dao.TaxDaoImpl;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author apprentice
 */
public class TaxDaoTest {
    TaxDaoImpl dao = new TaxDaoImpl();
    public TaxDaoTest() {
    }

    @Before
    public void setUp(){
        dao.load();
    }
    
    @Test
    public void testGetTaxList(){
        //there are 4 states in the text file
        //check that they are correctly loaded 
        //returned as an arrayList by the getTaxList method
        assertEquals(4,dao.getTaxList().size());
    }
    @Test
    public void testGetRate(){
        assertEquals(6.25,dao.getRate("OH"),0.001);
        assertEquals(6.75,dao.getRate("PA"),0.00001);
        assertEquals(5.75,dao.getRate("MI"),0.0001);
        assertEquals(6.0,dao.getRate("IN"),0.0001);
    }
}
