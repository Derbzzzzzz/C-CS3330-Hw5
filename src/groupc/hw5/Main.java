package groupc.hw5;

import groupc.hw5.pizza.PizzaType;
import groupc.hw5.pizzaOrder.PizzaOrder;

public class Main {

	public static void main(String[] args) {
		
		// Instantiate a pizzaOrder, perform operations based on the requirements.
		PizzaOrder order = new PizzaOrder();
		// Adds pizzas to the cart, selects cooking strategies for the pizzas in the cart,
		// prints pizza order cart. Calls checkout to calculate the bill, throws exception if
		// triggered.
		
		///////////////////////////////////////////////////////////////////////////////////////////
		// Adding Pizza
		///////////////////////////////////////////////////////////////////////////////////////////
		
		System.out.println("\n###############################################################\n");
		System.out.println("Adding 4 Types of Pizza...\n");
		
		System.out.println(order.addPizzaToCart(PizzaType.MARGHERITA));
		System.out.println(order.addPizzaToCart(PizzaType.HAWAIIAN));
		System.out.println(order.addPizzaToCart(PizzaType.VEGETARIAN));
		System.out.println(order.addPizzaToCart(PizzaType.SUPREME));
		
		///////////////////////////////////////////////////////////////////////////////////////////
		// Printing Pizza Order Cart
		///////////////////////////////////////////////////////////////////////////////////////////
		
		System.out.println("\n###############################################################\n");
		
		System.out.println("Printing Pizza Order Cart...\n");
				
		order.printPizzaOrderCart(0);
		
		///////////////////////////////////////////////////////////////////////////////////////////
		// Getting Pizza by Order ID
		///////////////////////////////////////////////////////////////////////////////////////////
		
		System.out.println("\n###############################################################\n");
		
		System.out.println("Getting Pizza by Order ID....\n");
		
		System.out.println("ID 2:  " + order.getPizzaByOrderID(2));
		System.out.println("ID 0:  " + order.getPizzaByOrderID(0));
		
		///////////////////////////////////////////////////////////////////////////////////////////
		// Printing Toppings of Pizza by Order ID
		///////////////////////////////////////////////////////////////////////////////////////////
		
		System.out.println("\n###############################################################\n");
		
		System.out.println("Printing Toppings of Pizza by Order ID....\n");
		
		System.out.println("ID 2:  "); order.printListOfToppingsByPizzaOrderID(2);
		System.out.println("\nID 0:  "); order.printListOfToppingsByPizzaOrderID(0);
		
	}

}
