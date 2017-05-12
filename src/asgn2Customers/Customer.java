package asgn2Customers;

import asgn2Exceptions.CustomerException;
import constants.Constants;

/** An abstract class to represent a customer at the Pizza Palace restaurant.
 *  The Customer class is used as a base class of PickUpCustomer, 
 *  DriverDeliveryCustomer and DroneDeliverCustomer. Each of these subclasses overwrites
 *  the abstract method getDeliveryDistance. A description of the class's
 * fields and their constraints is provided in Section 5.2 of the Assignment Specification.  
 * 
 * @author Person B
*/
public abstract class Customer {

    private String name;
    private String mobileNumber;
    private int locationX;
    private int locationY;
    private String type;

    private int restaurantLocationX = 0;
    private int restaurantLocationY = 0;


	/**
	 *  This class represents a customer of the Pizza Palace restaurant.  A detailed description of the class's fields
	 *  and parameters is provided in the Assignment Specification, in particular in Section 5.2. 
	 *  A CustomerException is thrown if the any of the constraints listed in Section 5.2 of the Assignment Specification
	 *  are violated. 
	 *  
  	 * <P> PRE: True
  	 * <P> POST: All field values are set
  	 * 
	 * @param name - The Customer's name 
	 * @param mobileNumber - The customer mobile number
	 * @param locationX - The customer x location relative to the Pizza Palace Restaurant measured in units of 'blocks' 
	 * @param locationY - The customer y location relative to the Pizza Palace Restaurant measured in units of 'blocks' 
	 * @param type - A human understandable description of this Customer type
	 * @throws CustomerException if supplied parameters are invalid 
	 * 
	 */
	public Customer(String name, String mobileNumber, int locationX, int locationY, String type) throws CustomerException{
		// TO DO
		setName(name);
		setMobileNumber(mobileNumber);
		setLocations(locationX, locationY);
		setType(type);
	}
	
	/**
	 * Returns the Customer's name.
	 * @return The Customer's name.
	 */
	public final String getName(){
		// TO DO
		return this.name;
	}
	
	/**
	 * Returns the Customer's mobile number.
	 * @return The Customer's mobile number.
	 */
	public final String getMobileNumber(){
		// TO DO
		return this.mobileNumber;
	}

	/**
	 * Returns a human understandable description of the Customer's type. 
	 * The valid alternatives are listed in Section 5.2 of the Assignment Specification. 
	 * @return A human understandable description of the Customer's type.
	 */
	public final String getCustomerType(){
		// TO DO
		return this.type;
	}
	
	/**
	 * Returns the Customer's X location which is the number of blocks East or West 
	 * that the Customer is located relative to the Pizza Palace restaurant. 
	 * @return The Customer's X location
	 */
	public final int getLocationX(){
		// TO DO
		return this.locationX;
	}

	/**
	 * Returns the Customer's Y location which is the number of blocks North or South 
	 * that the Customer is located relative to the Pizza Palace restaurant. 
	 * @return The Customer's Y location
	 */
	public final int getLocationY(){
		// TO DO
		return this.locationY;
	}

	/**
	 * An abstract method that returns the distance between the Customer and 
	 * the restaurant depending on the mode of delivery. 
	 * @return The distance between the restaurant and the Customer depending on the mode of delivery.
	 */
	public abstract double getDeliveryDistance();

	
	
	/**
	 * Compares *this* Customer object with an instance of an *other* Customer object and returns true if  
	 * if the two objects are equivalent, that is, if the values exposed by public methods are equal.
	 *  You do not need to test this method.
	 * 
	 * @return true if *this* Customer object and the *other* Customer object have the same values returned for 	
	 * getName(),getMobileNumber(),getLocationX(),getLocationY(),getCustomerType().
	 */
	@Override
	public boolean equals(Object other){
		Customer otherCustomer = (Customer) other;

		return ( (this.getName().equals(otherCustomer.getName()))  &&
			(this.getMobileNumber().equals(otherCustomer.getMobileNumber())) && 
			(this.getLocationX() == otherCustomer.getLocationX()) && 
			(this.getLocationY() == otherCustomer.getLocationY()) && 
			(this.getCustomerType().equals(otherCustomer.getCustomerType())) );			
	}

	/**
	 * check if name is correct
	 * if true - set
	 * else = throw CustomerException
	 * @param name
	 * @throws CustomerException
	 */
    private void setName(String name) throws CustomerException {
        if (name.length() < 1 || name.length() > 20) {
            throw new CustomerException("The name length " + name.length() + " isn't valid");
        } else if (name.trim().length() == 0) {
            throw new CustomerException("The name cannot be only white spaces.");
        } else {
        	this.name = name;
		}

    }

	/**
	 * check if mobileNumber is correct
	 * if true - set
	 * else = throw CustomerException
	 * @param mobileNumber
	 * @throws CustomerException
	 */
    private void setMobileNumber(String mobileNumber) throws CustomerException {
        if (mobileNumber.length() != 10) {
            throw new CustomerException("The mobile number must be 10 digits. " + mobileNumber);
        } else if (mobileNumber.toCharArray()[0] != '0') {
            throw new CustomerException("The mobile number must begin with ‘0’. " + mobileNumber);
        } else {
            for (char digit : mobileNumber.toCharArray()) {
                if (!Character.isDigit(digit)) {
                    throw new CustomerException("The mobile number must be 10 digits long and begin with ‘0’. " + mobileNumber);
                }
            }
        }
        this.mobileNumber = mobileNumber;
    }

	/**
	 * check if type is correct
	 * if true - set
	 * else = throw CustomerException
	 * @param type
	 * @throws CustomerException
	 */
    private void setType(String type) throws CustomerException {
        switch (type) {
            case Constants.PICK_UP_CUSTOMER:
				if (this.locationX != 0 || this.locationY != 0) {
					throw new CustomerException("PickUpCustomer with locations: " + locationX + ", " + locationY + " should be 0");
			}
            case Constants.DRIVER_DELIVERY_CUSTOMER:
            case Constants.DRONE_DELIVERY_CUSTOMER:
                this.type = type;
                break;
            default:
                throw new CustomerException("The type " + type + " isn't supported");

        }
    }

	/**
	 * check if locationX, locationY are correct
	 * if true - set
	 * else = throw CustomerException
	 * @param locationX, locationY
	 * @throws CustomerException
	 */
    private void setLocations(int locationX, int locationY) throws CustomerException {
        if (Math.abs(locationX) > 10 || Math.abs(locationY) > 10) {
            throw new CustomerException("The restaurant will not deliver is the customer is more than 10 blocks");
        } else {
            this.locationX = locationX;
            this.locationY = locationY;
        }
    }

	/**
	 * @param value
	 * @return the round value with two digits after point
	 */
	protected double round(double value) {
		long factor = (long) Math.pow(10, 2);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}

	/**
	 * getter
	 * @return locationX field
	 */
	public int getRestaurantLocationX() {
		return restaurantLocationX;
	}

	/**
	 * getter
	 * @return locationY field
	 */
	public int getRestaurantLocationY() {
		return restaurantLocationY;
	}

}

