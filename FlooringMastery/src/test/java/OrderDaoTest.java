
import com.sg.flooringmastery.dao.OrderDao;
import com.sg.flooringmastery.dto.Order;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
public class OrderDaoTest {

    OrderDao testDao;
    Order[] ordersForTesting = {
        new Order(1, "Liam", "OH", 6.25, "Wood", 203.2, 5.15, 4.75),
        new Order(2, "Chris", "PA", 3.3, "Tile", 225, 4.4, 3.3),
        new Order(3, "Dale", "IN", 3.5, "Carpet", 209, 2.2, 3.5),
        new Order(4, "Jared", "MI", 3.2, "Laminate", 298, 5.9, 1.4)
    };

    public OrderDaoTest() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        testDao = (OrderDao) ctx.getBean("daoInMemImpl");
    }

    @Test
    public void addOrderTest() {
        //construct new Order
        Order order1 = new Order(1, "Liam Long", "OH", 6.25, "Wood", 203.2, 5.15, 4.75);

        //add the order to the arrayList in the orderDao
        testDao.addOrder(order1);

        //retrieve the order from the arrayList in the orderDao using its orderNumber
        Order actual = testDao.getOrder(1);

        //test the main order properties
        assertEquals(actual.getOrderNumber(), order1.getOrderNumber());
        assertEquals(actual.getCustomerName(), order1.getCustomerName());
        assertEquals(actual.getState(), order1.getState());
        assertEquals(actual.getTaxRate(), order1.getTaxRate(), 0.001);
        assertEquals(actual.getProductType(), order1.getProductType());
        assertEquals(actual.getArea(), order1.getArea(), 0.001);
        //because all other cost attributes contribute to total cost
        assertEquals(actual.getTotalCost(), order1.getTotalCost(), 0.001);
    }

    @Test
    public void getAllOrdersTest() {
        assertEquals(0, testDao.getNumOrders());
        for (Order o : ordersForTesting) {
            testDao.addOrder(o);
        }
        //check that length of array of Orders passed in has same length 
        // arrayList passed back
        assertEquals(ordersForTesting.length, testDao.getAllOrders().size());
        //check the same thing with getNumOrders method
        assertEquals(ordersForTesting.length, testDao.getNumOrders());
    }

    @Test
    public void updateOrderTest() {
        for (Order o : ordersForTesting) {
            testDao.addOrder(o);
        }
        Order updatedOrder = new Order(1, "Jimmy Ong", "PA", 4.35, "Wood", 203.2, 5.15, 4.75);
        testDao.updateOrder(updatedOrder);
        //check that we have the same number of orders after updating
        //rather than just adding or deleting something
        assertEquals(ordersForTesting.length, testDao.getAllOrders().size());

        Order actual = testDao.getOrder(1);
        assertEquals(updatedOrder.getCustomerName(), actual.getCustomerName());
        assertEquals(updatedOrder.getTotalCost(), actual.getTotalCost(), 0.0001);
    }

    @Test
    public void removeOrderTest() {
        for (Order o : ordersForTesting) {
            testDao.addOrder(o);
        }
        Order toRemove = ordersForTesting[0];
        testDao.removeOrder(toRemove);
        //check that the length of the orderList is now one less than the array of orders
        assertEquals(ordersForTesting.length - 1, testDao.getNumOrders());
    }
}
