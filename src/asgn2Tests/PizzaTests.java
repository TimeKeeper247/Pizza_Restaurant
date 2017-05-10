package asgn2Tests;

import asgn2Exceptions.PizzaException;
import asgn2Pizzas.MargheritaPizza;
import asgn2Pizzas.MeatLoversPizza;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.VegetarianPizza;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;

import static junit.framework.TestCase.assertEquals;

/**
 * A class that that tests the asgn2Pizzas.MargheritaPizza, asgn2Pizzas.VegetarianPizza, asgn2Pizzas.MeatLoversPizza classes. 
 * Note that an instance of asgn2Pizzas.MeatLoversPizza should be used to test the functionality of the 
 * asgn2Pizzas.Pizza abstract class. 
 * 
 * @author Person B
 *
 */
public class PizzaTests {
	// TO DO
    @Test
    public void margheritaPizzaSuccessfulCreation() throws PizzaException {
        Pizza pizza = new MargheritaPizza(2, LocalTime.of(20, 0), LocalTime.of(21, 0));
        assertEquals(13.0, pizza.getOrderProfit());
    }

    @Test(expected = PizzaException.class)
    public void margheritaPizzaWrongCreation18() throws PizzaException {
        Pizza pizza = new MargheritaPizza(2, LocalTime.of(18, 0), LocalTime.of(21, 0));
    }

    @Test(expected = PizzaException.class)
    public void margheritaPizzaWrongCreation23_30()  throws PizzaException {
        Pizza pizza = new MargheritaPizza(2, LocalTime.of(23, 30), LocalTime.of(21, 0));
    }

    @Test(expected = PizzaException.class)
    public void margheritaPizzaWrongDelivery17() throws PizzaException {
        Pizza pizza = new MargheritaPizza(2, LocalTime.of(19, 0), LocalTime.of(17, 0));
    }

    @Test(expected = PizzaException.class)
    public void margheritaPizzaWrongQuantity0() throws PizzaException {
        Pizza pizza = new MargheritaPizza(0, LocalTime.of(19, 0), LocalTime.of(21, 0));
    }

    @Test(expected = PizzaException.class)
    public void margheritaPizzaWrongQuantity11() throws PizzaException {
        Pizza pizza = new MargheritaPizza(11, LocalTime.of(19, 0), LocalTime.of(21, 0));
    }

    @Test
    public void meatLoversPizzaSuccessfulCreation() throws PizzaException {
        Pizza pizza = new MeatLoversPizza(1, LocalTime.of(20, 0), LocalTime.of(21, 0));
        assertEquals(7.0, pizza.getOrderProfit());
    }

    @Test(expected = PizzaException.class)
    public void meatLoversPizzaWrongCreation18() throws PizzaException {
        Pizza pizza = new MeatLoversPizza(2, LocalTime.of(18, 0), LocalTime.of(21, 0));
    }

    @Test(expected = PizzaException.class)
    public void meatLoversPizzaWrongCreation23_30()  throws PizzaException {
        Pizza pizza = new MeatLoversPizza(2, LocalTime.of(23, 30), LocalTime.of(21, 0));
    }

    @Test(expected = PizzaException.class)
    public void meatLoversPizzaWrongDelivery17() throws PizzaException {
        Pizza pizza = new MeatLoversPizza(2, LocalTime.of(19, 0), LocalTime.of(17, 0));
    }

    @Test(expected = PizzaException.class)
    public void meatLoversPizzaWrongQuantity0() throws PizzaException {
        Pizza pizza = new MeatLoversPizza(0, LocalTime.of(19, 0), LocalTime.of(21, 0));
    }

    @Test(expected = PizzaException.class)
    public void meatLoversPizzaWrongQuantity11() throws PizzaException {
        Pizza pizza = new MeatLoversPizza(11, LocalTime.of(19, 0), LocalTime.of(21, 0));
    }

    @Test
    public void vegerarianPizzaSuccessfulCreation() throws PizzaException {
        Pizza pizza = new VegetarianPizza(3, LocalTime.of(20, 0), LocalTime.of(21, 0));
        assertEquals(13.5, pizza.getOrderProfit());
    }

    @Test(expected = PizzaException.class)
    public void VegetarianPizzaPizzaWrongCreation18() throws PizzaException {
        Pizza pizza = new MeatLoversPizza(2, LocalTime.of(18, 0), LocalTime.of(21, 0));
    }

    @Test(expected = PizzaException.class)
    public void VegetarianPizzaPizzaWrongCreation23_30()  throws PizzaException {
        Pizza pizza = new MeatLoversPizza(2, LocalTime.of(23, 30), LocalTime.of(21, 0));
    }

    @Test(expected = PizzaException.class)
    public void VegetarianPizzaPizzaWrongDelivery17() throws PizzaException {
        Pizza pizza = new MeatLoversPizza(2, LocalTime.of(19, 0), LocalTime.of(17, 0));
    }

    @Test(expected = PizzaException.class)
    public void VegetarianPizzaPizzaWrongQuantity0() throws PizzaException {
        Pizza pizza = new MeatLoversPizza(0, LocalTime.of(19, 0), LocalTime.of(21, 0));
    }

    @Test(expected = PizzaException.class)
    public void VegetarianPizzaPizzaWrongQuantity11() throws PizzaException {
        Pizza pizza = new MeatLoversPizza(11, LocalTime.of(19, 0), LocalTime.of(21, 0));
    }
}
