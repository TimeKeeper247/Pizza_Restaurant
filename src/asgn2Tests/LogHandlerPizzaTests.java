package asgn2Tests;

import asgn2Customers.Customer;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.LogHandler;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

/** A class that tests the methods relating to the creation of Pizza objects in the asgn2Restaurant.LogHander class.
* 
* @author Person B
* 
*/
public class LogHandlerPizzaTests {
	// TO DO
    private static final String correctPizzaRecord = "20:23:00,20:44:00,Riley Brown,0708426008,DNC,-2,0,PZV,2";
    private static final String incorrectPizzaRecord = "20:23:00,20:44:00,Riley Brown,0708426008,DNC,-2,0,WRONG,2";

    @Test
    public void populatePizzaDatasetSuccess() throws PizzaException, LogHandlerException {
        LogHandler.populatePizzaDataset("log.csv");
    }

    @Test(expected = LogHandlerException.class)
    public void populateCustomerWrongFile() throws PizzaException, LogHandlerException {
        LogHandler.populatePizzaDataset("wrong_file.csv");
    }

    @Test(expected = PizzaException.class)
    public void populateCustomerIncorrectFile() throws PizzaException, LogHandlerException {
        LogHandler.populatePizzaDataset("incorrect_log.csv");
    }

    @Test
    public void parseCustomerLine() throws PizzaException, LogHandlerException {
        Pizza pizza = LogHandler.createPizza(correctPizzaRecord);
        assertEquals("PZV", pizza.getPizzaType());
    }

    @Test(expected = PizzaException.class)
    public void parseCustomerWrongLine() throws PizzaException, LogHandlerException {
        LogHandler.createPizza(incorrectPizzaRecord);
    }
}
