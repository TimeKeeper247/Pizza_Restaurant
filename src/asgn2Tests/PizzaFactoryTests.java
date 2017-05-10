package asgn2Tests;

import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;
import constants.Constants;
import org.junit.Test;

import java.time.LocalTime;
import static junit.framework.TestCase.assertEquals;
/** 
 * A class that tests the asgn2Pizzas.PizzaFactory class.
 * 
 * @author Person B 
 * 
 */
public class PizzaFactoryTests {
	// TO DO
	@Test
	public void margheritaPizzaSuccessfulCreation() throws PizzaException {
	    Pizza pizza = PizzaFactory.getPizza(Constants.MARGHERITA_PIZZA, 1, LocalTime.of(19, 0), LocalTime.of(20, 0));
	    assertEquals(8.0, pizza.getPricePerPizza());
	}

	@Test
	public void meatLoversPizzaSuccessfulCreation() throws PizzaException {
	    Pizza pizza = PizzaFactory.getPizza(Constants.MEAT_LOVERS_PIZZA, 3, LocalTime.of(20, 0), LocalTime.of(21, 0));
	    assertEquals(36.0, pizza.getOrderPrice());
	}

	@Test
	public void vegeterianPizzaSuccessfulCreation() throws PizzaException {
	    Pizza pizza = PizzaFactory.getPizza(Constants.VEGETARIAN_PIZZA, 4, LocalTime.of(19, 0), LocalTime.of(22, 0));
	    assertEquals(22.0, pizza.getOrderCost());
	}

	@Test(expected = PizzaException.class)
	public void pizzaFactoryWrongQuantity0() throws PizzaException {
	    PizzaFactory.getPizza(Constants.MARGHERITA_PIZZA, 0, LocalTime.of(19, 0), LocalTime.of(20, 0));
	}

	@Test(expected = PizzaException.class)
	public void pizzaFactoryWrongQuantity11() throws PizzaException {
	    PizzaFactory.getPizza(Constants.MARGHERITA_PIZZA, 11, LocalTime.of(19, 0), LocalTime.of(20, 0));
	}

	@Test(expected = PizzaException.class)
	public void pizzaFactoryWrongType() throws PizzaException {
	    PizzaFactory.getPizza("MyPizzaType", 11, LocalTime.of(19, 0), LocalTime.of(20, 0));
	}

	@Test(expected = PizzaException.class)
	public void pizzaFactoryWrongOrderTime18() throws PizzaException {
	    PizzaFactory.getPizza("MyPizzaType", 11, LocalTime.of(18, 0), LocalTime.of(20, 0));
	}

	@Test(expected = PizzaException.class)
	public void pizzaFactoryWrongOrderTime22() throws PizzaException {
	    PizzaFactory.getPizza("MyPizzaType", 11, LocalTime.of(22, 0), LocalTime.of(20, 0));
	}

	@Test(expected = PizzaException.class)
	public void pizzaFactoryWrongDeliveryTime15() throws PizzaException {
	    PizzaFactory.getPizza("MyPizzaType", 11, LocalTime.of(22, 0), LocalTime.of(20, 0));
	}
}
