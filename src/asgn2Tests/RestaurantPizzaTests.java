package asgn2Tests;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.PizzaRestaurant;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * A class that tests the methods relating to the handling of Pizza objects in the asgn2Restaurant.PizzaRestaurant class as well as
 * processLog and resetDetails.
 * 
 * @author Person B
 *
 */
public class RestaurantPizzaTests {
	// TO DO
    private PizzaRestaurant pizzaRestaurant;
    private static final String correctLogFile = "log.csv";
    private static final String incorrectLogFile = "incorrect_log.csv";

    @Before
    public void initTest() {
        pizzaRestaurant = new PizzaRestaurant();
    }

    @After
    public void resetTest() {
        pizzaRestaurant.resetDetails();
    }

    @Test
    public void correctLogFileTest() throws CustomerException, PizzaException, LogHandlerException {
        assertEquals(true, pizzaRestaurant.processLog(correctLogFile));
    }

    @Test
    public void incorrectLogFileTest() throws CustomerException, PizzaException, LogHandlerException {
        assertEquals(false, pizzaRestaurant.processLog(incorrectLogFile));
    }

    @Test
    public void getFirstPizzaTest() throws CustomerException, PizzaException, LogHandlerException {
        pizzaRestaurant.processLog(correctLogFile);
        assertEquals("PZV", pizzaRestaurant.getPizzaByIndex(0).getPizzaType());
    }

    @Test
    public void getPizzaListSizeTest() throws CustomerException, PizzaException, LogHandlerException {
        pizzaRestaurant.processLog(correctLogFile);
        assertEquals(10, pizzaRestaurant.getNumPizzaOrders());
    }

    @Test
    public void getTotalProfitTest() throws CustomerException, PizzaException, LogHandlerException {
        pizzaRestaurant.processLog(correctLogFile);
        assertEquals(316.5, pizzaRestaurant.getTotalProfit());
    }
}
