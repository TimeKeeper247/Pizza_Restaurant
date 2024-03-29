package asgn2Restaurant;


import java.io.BufferedReader;
import java.io.FileReader;
<<<<<<< HEAD
import java.time.LocalTime;
=======
import java.io.IOException;
>>>>>>> branch 'master' of https://timekeeper247@bitbucket.org/timekeeper247/cab302_asgn2.git
import java.util.ArrayList;
import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;

/**
 *
 * A class that contains methods that use the information in the log file to return Pizza 
 * and Customer object - either as an individual Pizza/Customer object or as an
 * ArrayList of Pizza/Customer objects.
 * 
 * @author Person A and Person B
 *
 */
public class LogHandler {
	


	/**
	 * Returns an ArrayList of Customer objects from the information contained in the log file ordered as they appear in the log file.
	 * @param filename The file name of the log file
	 * @return an ArrayList of Customer objects from the information contained in the log file ordered as they appear in the log file. 
	 * @throws CustomerException If the log file contains semantic errors leading that violate the customer constraints listed in Section 5.3 of the Assignment Specification or contain an invalid customer code (passed by another class).
	 * @throws LogHandlerException If there was a problem with the log file not related to the semantic errors above
	 * 
	 */
	public static ArrayList<Customer> populateCustomerDataset(String filename) throws CustomerException, LogHandlerException{
		// TO DO
		ArrayList<Customer> customerList = new ArrayList<>();

	       try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
	           String line;

	           while ((line = br.readLine()) != null) {
	               customerList.add(createCustomer(line));
	           }

	       } catch (IOException ex) {
	           throw new LogHandlerException("There was a problem with the log file " + filename);
	       }
	       return customerList;
	}		

	/**
	 * Returns an ArrayList of Pizza objects from the information contained in the log file ordered as they appear in the log file. .
	 * @param filename The file name of the log file
	 * @return an ArrayList of Pizza objects from the information contained in the log file ordered as they appear in the log file. .
	 * @throws PizzaException If the log file contains semantic errors leading that violate the pizza constraints listed in Section 5.3 of the Assignment Specification or contain an invalid pizza code (passed by another class).
	 * @throws LogHandlerException If there was a problem with the log file not related to the semantic errors above
	 * 
	 */
	public static ArrayList<Pizza> populatePizzaDataset(String filename) throws PizzaException, LogHandlerException{
		// TODO
		Pizza pizza;
		ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line = br.readLine();
		while(line != null){
			pizza = createPizza(line);
			pizzas.add(pizza);
			line = br.readLine();
		}
		return pizzas;
	}		

	
	/**
	 * Creates a Customer object by parsing the  information contained in a single line of the log file. The format of 
	 * each line is outlined in Section 5.3 of the Assignment Specification.  
	 * @param line - A line from the log file
	 * @return- A Customer object containing the information from the line in the log file
	 * @throws CustomerException - If the log file contains semantic errors leading that violate the customer constraints listed in Section 5.3 of the Assignment Specification or contain an invalid customer code (passed by another class).
	 * @throws LogHandlerException - If there was a problem parsing the line from the log file.
	 */
	public static Customer createCustomer(String line) throws CustomerException, LogHandlerException{
		// TO DO
        String[] record = line.split(",");

        String customerName = record[2];
        String mobileNumber = record[3];
        String customerCode = record[4];
        int locationX = Integer.valueOf(record[5]);
        int locationY = Integer.valueOf(record[6]);

        return CustomerFactory.getCustomer(customerCode, customerName, mobileNumber, locationX, locationY);
	}
	
	/**
	 * Creates a Pizza object by parsing the information contained in a single line of the log file. The format of 
	 * each line is outlined in Section 5.3 of the Assignment Specification.  
	 * @param line - A line from the log file
	 * @return- A Pizza object containing the information from the line in the log file
	 * @throws PizzaException If the log file contains semantic errors leading that violate the pizza constraints listed in Section 5.3 of the Assignment Specification or contain an invalid pizza code (passed by another class).
	 * @throws LogHandlerException - If there was a problem parsing the line from the log file.
	 */
	public static Pizza createPizza(String line) throws PizzaException, LogHandlerException{
		// TODO
		Pizza pizza;
		String[] p_array = line.split(",");
		LocalTime o_time = LocalTime.parse(p_array[0]);
		LocalTime d_time = LocalTime.parse(p_array[1]);
		String p_code = p_array[7];
		int p_num = Integer.parseInt(p_array[8]);
		pizza = PizzaFactory.getPizza(p_code, p_num, o_time, d_time);
		return pizza;
	}

}
