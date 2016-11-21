
import com.sg.flooringmastery.dao.ProductDaoImpl;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class ProductDaoTest {
    ProductDaoImpl testingDao = new ProductDaoImpl();
    
    @Before
    public void setUp(){
        //load from text file because there are no add 
        //or remove product methods
        //because the user doesn't need them
       testingDao.load();
    }
    
    @Test
    public void testGetAllProducts(){
        //there are 4 products in text file
        //make sure it loaded correctly and getAllProducts 
        //returns an arrayList of 4 Products
        assertEquals(4,testingDao.getAllProducts().size());
    }
    
    @Test
    public void testGetMaterialCostPerSqFt(){
        assertEquals(2.25,testingDao.getMaterialCostPerSqFt("Carpet"),0.001);
        assertEquals(5.15,testingDao.getMaterialCostPerSqFt("Wood"),0.0001);
    }
    @Test
    public void testGetLaborCostPerSqFt(){
        
        assertEquals(2.1,testingDao.getLaborCostPerSqFt("Carpet"),0.0001);
        assertEquals(2.1,testingDao.getLaborCostPerSqFt("Laminate"),0.001);
        assertEquals(4.15,testingDao.getLaborCostPerSqFt("Tile"),0.001);
        assertEquals(4.75,testingDao.getLaborCostPerSqFt("Wood"),0.001);        
    }   
}
