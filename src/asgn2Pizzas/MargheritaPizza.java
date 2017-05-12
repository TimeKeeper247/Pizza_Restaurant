package asgn2Pizzas;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import asgn2Exceptions.PizzaException;

/**
 * 
 *  A class that represents a margherita pizza made at the Pizza Palace restaurant. 
 *  The margherita pizza has certain toppings listed in Section 5.1 of the Assignment Specification Document.  
 *  A description of the class's fields and their constraints is provided in Section 5.1 of the Assignment Specification.
 * 
 * @author Person A
 *
 */
public class MargheritaPizza extends Pizza {
	
	private int quantity;
	private LocalTime orderTime, deliveryTime;
	private List<PizzaTopping> topping;
	
	/**
	 * 
	 *  This class represents a margherita pizza made at the  Pizza Palace restaurant.   The margherita pizza has certain
	 *  toppings listed in Section 5.1 of the Assignment Specification Document.  A description of the class's
	 *  fields and their constraints is provided in Section 5.1 of the Assignment Specification.
	 *  A PizzaException is thrown if the any of the constraints listed in Section 5.1 of the Assignment Specification are violated. 
	 * 
	 * <P>PRE: TRUE
	 * <P>POST: All field values including the cost per pizza are set
     *
	 * @param quantity - The number of pizzas ordered 
	 * @param orderTime - The time that the pizza order was made and sent to the kitchen 
	 * @param deliveryTime - The time that the pizza was delivered to the customer
	 * @throws PizzaException if supplied parameters are invalid 
	 *
	 */
	public MargheritaPizza(int quantity, LocalTime orderTime, LocalTime deliveryTime) throws PizzaException {
		// TODO
		if (quantity < 1 || quantity > 10){
//			throw new PizzaException("Quantity of pizzas must be at least 1");
		} else {
			this.quantity = quantity;
		}
		if (orderTime.isAfter(LocalTime.parse("23:00:00")) && orderTime.isBefore(LocalTime.parse("07:00:00"))){
//			throw new PizzaException("Cannot order during this time");
		} else {
			this.orderTime = orderTime;
		}
		if (deliveryTime.minusHours(1).equals(orderTime) || deliveryTime.minusHours(1).isAfter(orderTime)){
//			throw new PizzaException("Pizza has taken up to or more than 1 hour. It must be thrown out");
		} else {
			this.deliveryTime = deliveryTime;
			
		topping = new ArrayList<PizzaTopping>(2);
		topping.add(PizzaTopping.TOMATO);
		topping.add(PizzaTopping.CHEESE);
	}

}
