package asgn2GUIs;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;

import javax.swing.text.DefaultCaret;

import asgn2Customers.Customer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.PizzaRestaurant;
import constants.Constants;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/**
 * This class is the graphical user interface for the rest of the system. 
 * Currently it is a ‘dummy’ class which extends JFrame and implements Runnable and ActionLister. 
 * It should contain an instance of an asgn2Restaurant.PizzaRestaurant object which you can use to 
 * interact with the rest of the system. You may choose to implement this class as you like, including changing 
 * its class signature – as long as it  maintains its core responsibility of acting as a GUI for the rest of the system. 
 * You can also use this class and asgn2Wizards.PizzaWizard to test your system as a whole
 * 
 * 
 * @author Person A and Person B
 *
 */
public class PizzaGUI extends javax.swing.JFrame implements Runnable, ActionListener {
	
	
	private PizzaRestaurant restaurant;
	
	private JFileChooser jFileChooser;
	private JTable customerTable;
	private JTable pizzaTable;
	private JButton resetButton;
	private JButton getTotalProfitButton;
	private JButton chooseFile;
	private JTextField totalProfitField;
	private JButton getTotalDistanceTravelled;
	private JTextField totalDistanceField;
	
	/**
	 * Creates a new Pizza GUI with the specified title 
	 * @param title - The title for the supertype JFrame
	 */
	public PizzaGUI(String title) {
		// TO DO
		restaurant = new PizzaRestaurant();
        setTitle(title);
        setLayout(new BorderLayout());

        jFileChooser = new JFileChooser("C:\\Users\\Vova\\IdeaProjects\\GF\\PizzaRestourant\\asgn2");

        pizzaTable = new JTable();
        customerTable = new JTable();

        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);
        chooseFile = new JButton("Choose file");
        chooseFile.addActionListener(this);
        getTotalProfitButton = new JButton("Get total profit of the day");
        getTotalProfitButton.addActionListener(this);
        totalProfitField = new JTextField(20);
        getTotalDistanceTravelled = new JButton("Get total distance travelled");
        getTotalDistanceTravelled.addActionListener(this);
        totalDistanceField = new JTextField(20);

        JPanel northPanel = new JPanel();
        northPanel.add(chooseFile);
        northPanel.add(resetButton);
        add(northPanel, BorderLayout.NORTH);

        JPanel pizzaPanel = new JPanel(new GridLayout(2, 1));
        pizzaPanel.add(pizzaTable);
        JPanel pizzaPanelButtons = new JPanel();
        pizzaPanelButtons.add(getTotalProfitButton);
        pizzaPanelButtons.add(totalProfitField);
        pizzaPanel.add(pizzaPanelButtons);

        JPanel customerPanel = new JPanel(new GridLayout(2, 1));
        customerPanel.add(customerTable);
        JPanel customerPanelButtons = new JPanel();
        customerPanelButtons.add(getTotalDistanceTravelled);
        customerPanelButtons.add(totalDistanceField);
        customerPanel.add(customerPanelButtons);

        JPanel centerPanel = new JPanel();
        centerPanel.add(pizzaPanel);
        centerPanel.add(customerPanel);

        add(centerPanel, BorderLayout.CENTER);
	}

	
	@Override
	public void run() {
		// TO DO
		setSize(600, 600);
        setVisible(true);
	}

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals(chooseFile.getActionCommand())) {
            int returnValue = jFileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jFileChooser.getSelectedFile();
                setTablesAccordingToTheFile(selectedFile.getPath());
            }
        } else if (e.getActionCommand().equals(resetButton.getActionCommand())) {
            DefaultTableModel customerModel = (DefaultTableModel) customerTable.getModel();
            customerModel.setRowCount(0);

            DefaultTableModel pizzaModel = (DefaultTableModel) pizzaTable.getModel();
            pizzaModel.setRowCount(0);
        } else if (e.getActionCommand().equals(getTotalDistanceTravelled.getActionCommand())) {
            totalDistanceField.setText(String.valueOf(restaurant.getTotalDeliveryDistance()));
        } else if (e.getActionCommand().equals(getTotalProfitButton.getActionCommand())) {
            totalProfitField.setText(String.valueOf(restaurant.getTotalProfit()));
        }
    }

    /**
     * init PizzaRestaurant instance or show error message
     * @param filePath
     */
    private void setTablesAccordingToTheFile(String filePath) {
	    if(restaurant.processLog(filePath)) {
            fillCustomerTable();
            fillPizzaTable();
        } else {
	        JOptionPane.showMessageDialog(this, "The file " + filePath + " could not be readed");
        }
    }

    /**
     * fill the customer table according to the file or show error dialog
     */
    private void fillCustomerTable() {
        try {
            DefaultTableModel model = (DefaultTableModel) customerTable.getModel();
            Object[] customerTableColumn = {Constants.CUSTOMER_NAME, Constants.MOBILE_NUMBER, Constants.CUSTOMER_TYPE,
                    Constants.X_LOCATION, Constants.Y_LOCATION, Constants.DISTANCE_FROM_RESTAURANT};
            model.setColumnIdentifiers(customerTableColumn);

            for (int i = 0; i < restaurant.getNumCustomerOrders(); i++) {
                Customer customer = restaurant.getCustomerByIndex(i);
                model.addRow(new Object[]{customer.getName(), customer.getMobileNumber(), customer.getCustomerType(),
                                            customer.getLocationX(), customer.getLocationY(), customer.getDeliveryDistance()});
            }


        } catch (CustomerException ex) {
            JOptionPane.showMessageDialog(this, "Error occurs while filling customer table");
        }
    }

    /**
     * fill pizza table according to the file or show error dialog
     */
    private void fillPizzaTable() {
        try {
            DefaultTableModel model = (DefaultTableModel) pizzaTable.getModel();
            String[] pizzaTableColumn = {Constants.PIZZA_TYPE, Constants.QUANTITY, Constants.ORDER_PRICE, Constants.ORDER_COST,
                    Constants.ORDER_PROFIT};
            model.setColumnIdentifiers(pizzaTableColumn);

            for (int i = 0; i < restaurant.getNumPizzaOrders(); i++) {
                Pizza pizza = restaurant.getPizzaByIndex(i);
                model.addRow(new Object[]{pizza.getPizzaType(), pizza.getQuantity(), pizza.getOrderPrice(), pizza.getOrderCost(),
                                    pizza.getOrderProfit()});
            }
        } catch (PizzaException ex) {
            JOptionPane.showMessageDialog(this, "Error occurs while filling customer table");
        }
    }

    public static void main(String[] args) {
        new Thread(new PizzaGUI("AGR Pizza Resaurant")).start();
    }

}
