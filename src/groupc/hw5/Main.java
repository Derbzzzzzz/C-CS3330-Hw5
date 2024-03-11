package groupc.hw5;

import groupc.hw5.pizza.CookingStyleType;
import groupc.hw5.pizza.PizzaType;
import groupc.hw5.pizza.Toppings;
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
		
		///////////////////////////////////////////////////////////////////////////////////////////
		//update pizza toppings (ADD)
		///////////////////////////////////////////////////////////////////////////////////////////
		
		System.out.println("\n###############################################################\n");
		System.out.println("updating Pizza ID 2 toppings to include Bell Peppers");
		System.out.println("ID 2 (true/false): " + order.addNewToppingToPizza(2, Toppings.BELL_PEPPER));
		System.out.println(order.getPizzaByOrderID(2));
		
		System.out.println("\nupdating nonexistent pizza toppings to include Bell Peppers");
		System.out.println("nonexistent pizza (true/false): " + order.addNewToppingToPizza(-1, Toppings.BELL_PEPPER));

		///////////////////////////////////////////////////////////////////////////////////////////
		//update pizza toppings (REMOVE)
		///////////////////////////////////////////////////////////////////////////////////////////
		
		System.out.println("\n###############################################################\n");
		System.out.println("updating Pizza ID 2 toppings to remove Bell Peppers");
		System.out.println("ID 2 (true/false): " + order.removeToppingFromPizza(2, Toppings.BELL_PEPPER));
		System.out.println(order.getPizzaByOrderID(2));
		
		System.out.println("\nupdating nonexistent pizza toppings to remove Bell Peppers");
		System.out.println("nonexistent pizza (true/false): " + order.removeToppingFromPizza(-1, Toppings.BELL_PEPPER));

		///////////////////////////////////////////////////////////////////////////////////////////
		//update cooking strategy
		///////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("\n###############################################################\n");
		System.out.println("\nupdating the cooking strategy of order 2 to brickOvenCookingStrategy: " + order.selectCookingStrategyByPizzaOrderID(2, CookingStyleType.BRICK_OVEN));
		System.out.println(order.getPizzaByOrderID(2));
		System.out.println("\nupdating the cooking strategy of order 2 to the same thing again (should fail): " + order.selectCookingStrategyByPizzaOrderID(2, CookingStyleType.BRICK_OVEN));
		System.out.println(order.getPizzaByOrderID(2));
		System.out.println("\nupdating the cooking strategy of order 2 to MicrowaveCookingStrategy: " + order.selectCookingStrategyByPizzaOrderID(2, CookingStyleType.MICROWAVE));
		System.out.println(order.getPizzaByOrderID(2));
		System.out.println("\nupdating the cooking strategy of order 2 to ConventionalOvenCookingStrategy: " + order.selectCookingStrategyByPizzaOrderID(2, CookingStyleType.CONVENTIONAL_OVEN));
		System.out.println(order.getPizzaByOrderID(2));
		
		System.out.println("\nupdating the cooking strategy of non-existent pizza: " + order.selectCookingStrategyByPizzaOrderID(-1, CookingStyleType.CONVENTIONAL_OVEN));

		System.out.println("\n###############################################################\n");
		
		///////////////////////////////////////////////////////////////////////////////////////////
		//check for pizzas that do not have a cooking strategy
		///////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("\n###############################################################\n");
		System.out.println("pizza 1 cooking strategy = " + order.getPizzaByOrderID(1).getCookingStrategy());
		System.out.println("pizza 2 cooking strategy = " + order.getPizzaByOrderID(2).getCookingStrategy());
		System.out.println("pizza 3 cooking strategy = " + order.getPizzaByOrderID(3).getCookingStrategy());
		System.out.println("pizza 4 cooking strategy = " + order.getPizzaByOrderID(4).getCookingStrategy());
		System.out.println("\nis if there are any uncooked pizza: (expected: true) : " + order.isThereAnyUncookedPizza());
		
		try {
			System.out.print("Should throw exception: ");			
			System.out.println("Total order price:" + order.checkout());			
		} catch (Exception e) {
			System.out.println(e);
		}

		order.selectCookingStrategyByPizzaOrderID(1, CookingStyleType.BRICK_OVEN);
		order.selectCookingStrategyByPizzaOrderID(2, CookingStyleType.MICROWAVE);
		order.selectCookingStrategyByPizzaOrderID(3, CookingStyleType.CONVENTIONAL_OVEN);
		order.selectCookingStrategyByPizzaOrderID(4, CookingStyleType.BRICK_OVEN);
		System.out.println("\nis if there are any uncooked pizza: (expected: false) : " + order.isThereAnyUncookedPizza());
		System.out.println("\n###############################################################\n");

		try {
			System.out.println("Should print order price");			
			System.out.println("Total order price:" + order.checkout());			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	

}
