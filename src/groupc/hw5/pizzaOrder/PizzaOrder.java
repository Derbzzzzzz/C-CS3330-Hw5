package groupc.hw5.pizzaOrder;

import java.util.ArrayList;
import java.util.List;

import groupc.hw5.cookingStrategy.BrickOvenCookingStrategy;
import groupc.hw5.cookingStrategy.ConventionalOvenCookingStrategy;
import groupc.hw5.cookingStrategy.ICookingStrategy;
import groupc.hw5.cookingStrategy.MicrowaveCookingStrategy;
import groupc.hw5.pizza.AbstractPizza;
import groupc.hw5.pizza.CookingStyleType;
import groupc.hw5.pizza.HawaiianPizza;
import groupc.hw5.pizza.MargheritaPizza;
import groupc.hw5.pizza.PizzaType;
import groupc.hw5.pizza.SupremePizza;
import groupc.hw5.pizza.Toppings;
import groupc.hw5.pizza.VegetarianPizza;
import groupc.hw5.pizzaCookingFactory.PizzaCookingFactory;

public class PizzaOrder {
	
	private PizzaCookingFactory pizzaFactory;
	private ICookingStrategy cookingStrategy;
	private List<AbstractPizza> pizzaOrderList;
	
	public PizzaOrder() {
		pizzaFactory = new PizzaCookingFactory();
		pizzaOrderList = new ArrayList<AbstractPizza>();
	}
	
	/**
	 * This method gets the pizza order with the given pizza order ID 
	 * and prints the toppings of that order.
	 * 
	 * Author: Ryan
	 * 
	 * @param orderID
	 */
	public void printListOfToppingsByPizzaOrderID(int orderID) {
		AbstractPizza target = null;
		for(AbstractPizza p : pizzaOrderList) {
			if(p.getPizzaOrderID() == orderID) {
				target = p;
				break;
			}
		}
		
		if(target == null) {
			return;
		}
		
		for(Toppings t : target.getToppingList()) {
			System.out.println(t);
		}
		
	}
	
	/**
	 * This method prints the pizzas in the pizzaOrderList.
	 * 
	 * Author: Ryan
	 * 
	 * @param orderID
	 */
	public void printPizzaOrderCart(int orderID) {
		for(AbstractPizza p : pizzaOrderList) {
			System.out.println(p);
		}
	}
	
	/**
	 * This method finds the pizza order 
	 * with the given pizza order id and returns it.
	 * Note: It returns a copy of the pizza
	 * 
	 * Author: Ryan
	 * 
	 * @param orderID
	 * @return AbstractPizza
	 */
	 public AbstractPizza getPizzaByOrderID(int orderID) {
		 for(AbstractPizza p : pizzaOrderList) {
				if(p.getPizzaOrderID() == orderID) {
					//gets a copy of pizza
					return pizzaFactory.copyPizza(p);
				}
		 }
		 return null;
	 }
	 
	 /**
	  *  This method creates a new pizza with the given 
	  *  PizzaType and adds it to the pizzaOrderList
	  *  
	  * Author: Ryan
	  *  
	  * @param pizzaType
	  * @return boolean
	  */
	 public boolean addPizzaToCart(PizzaType pizzaType) {
		 AbstractPizza p = pizzaFactory.createPizza(pizzaType);
		 if(p == null) {
			 return false;
		 }
		 pizzaOrderList.add(p);
		 return true;
	 }
	 
	 /**
	  * Helper Method that gets a pizza by id and returns the reference to that specific pizza 
	  * from the pizzaOrderList.
	  * It is a helper Method so it is private and, additionally, since it returns a reference to a specific
	  * pizza without making a copy. Otherwise it would be considered a data leak.
	  * 
	  * Author: Zoe 
	  * 
	  * 
	  * @param OrderID An id representing the pizza to search for
	  * @return AbstractPizza or null if there is no pizza that matches
	  * 
	  */
	 private AbstractPizza getPizzaReferenceByID(int OrderID) {
		 for(AbstractPizza pizza:pizzaOrderList) {
			 if(pizza.getPizzaOrderID()==OrderID) {
				 return pizza;
			 }
		 }
		 return null;
	 }
	 
	 /**
	  * Helper Method that checks a pizza for a specific topping using the contains method.
	  * 
	  * Author: Zoe
	  * @param topping topping to search for
	  * @param pizza pizza to search for the topping.
	  * @return true if the pizza contains the topping, false if it does not 
	  */
	 private boolean CheckPizzaForTopping(Toppings topping, AbstractPizza pizza) {
		 List<Toppings> toppingList = pizza.getToppingList();
		 return toppingList.contains(topping);
	 }
	 /**
	  * This method finds the pizza order with the given ID
	  * and adds the given topping to its topping list 
	  * if it doesn’t already exist in the list. If the given
	  * topping is added, it also updates the pizza price and 
	  * returns true. If the topping already exists in
	  * the topping list of the pizza, it returns false.
	  * 
	  * Author Zoe 
	  * 
	  * @param orderID
	  * @param topping
	  * @return boolean
	  */
	 public boolean addNewToppingToPizza(int orderID, Toppings topping) {
		 //gets the pizza by ID
		 AbstractPizza pizza = getPizzaReferenceByID(orderID);
		 //checks that the pizza isn't null to add the toppings
		 if(pizza != null) {
			 //checks to see if the pizza topping doesn't exist
			 if(!CheckPizzaForTopping(topping, pizza)) {
				 //adds the topping to the list
				 pizza.getToppingList().add(topping);
				 //update price of pizza
				 pizza.updatePizzaPrice();
				 return true;
			 }
			 
		 }
		 return false;
	 }
	 
	 /**
	  * This method finds the pizza order with the given ID
	  * and removes the given topping from its topping list 
	  * if it exists in the list. If the given topping is removed, 
	  * it also updates the pizza price and returns true. If the 
	  * topping doesn’t exist in the topping list of the pizza and 
	  * cannot be removed, it returns false.
	  * 
	  * @param orderID
	  * @param topping
	  * @return boolean
	  */
	 public boolean removeToppingFromPizza(int orderID, Toppings topping) {
		 return false;
	 }
	 
	 /**
	  * This method checks the pizzas in the pizzaOrderList and 
	  * checks their cooking strategies. It returns true if there 
	  * are any pizzas without any assigned pizza cooking strategy. 
	  * It returns false if there are no pizzas without an 
	  * assigned cooking strategy.
	  * 
	  * @return boolean
	  */
	 public boolean isThereAnyUncookedPizza() {
		 return false;
	 }
	 
	 
	 /**
	  * This method checks if there are any uncooked pizzas. 
	  * If all pizzas are cooked, it calculates the total price 
	  * of all pizzas and returns the total cart price. 
	  * However, if there is at least one uncooked pizza it 
	  * throws an exception (Use the general Exception class). 
	  * The checkout method calls the isThereAnyUncookedPizza method 
	  * to check for uncooked pizzas and throws an exception.
	  * 
	  * @return double
	  * @throws Exception
	  */
	 public double checkout() throws Exception {
		 return 0.0;
	 }
	 
	 /**
	  * This method gets the pizza with the given order ID, 
	  * instantiates the cookingStrategy according to the 
	  * cookingStrategyType parameter. Calls the cook function 
	  * for the pizza of the pizza order with the given order ID.
	  * 
	  * 
	  * Author: Zoe 
	  * @param orderID The pizza ID of the pizza to select the cooking Strategy 
	  * @param cookingStrategyType How the pizza is supposed to be cooked
	  * @return boolean returns true on success, returns false on failure. Failure occurs if the pizza doesn't exist or the strategy is already set to the strategy that it is getting changed to
	  */
	 public boolean selectCookingStrategyByPizzaOrderID(int orderID, 
			 CookingStyleType cookingStrategyType) {
		 	//gets the pizza by id
		 	AbstractPizza pizza = getPizzaReferenceByID(orderID);
		 	if(pizza != null) { //checks to see if the pizza exists
		 		
		 		//The following "if's" test to see what type of cooking style will be utilized
		 		if (cookingStrategyType == CookingStyleType.BRICK_OVEN) {
		 			
		 			//instantiate a brickOvenCookingStrategy
		 			BrickOvenCookingStrategy strategyTemp =(new BrickOvenCookingStrategy());
		 			//tests to see if cooking strategy was already set to the same strategy that it is being changed to
		 			if(pizza.getCookingStrategy() !=null && pizza.getCookingStrategy().getClass() == strategyTemp.getClass()) {
		 				return false;
		 			}
		 			//cook the pizza according to the brickOvencookingStrategy - return boolean
		 			return strategyTemp.cook(pizza);
		 		}
		 		if(cookingStrategyType== CookingStyleType.CONVENTIONAL_OVEN) {
		 			//instantiate a ConventionalOvenCookingStrategy
		 			ConventionalOvenCookingStrategy strategyTemp =(new ConventionalOvenCookingStrategy());
		 			//tests to see if cooking strategy was already set to the same strategy that it is being changed to
		 			if(pizza.getCookingStrategy() !=null && pizza.getCookingStrategy().getClass() == strategyTemp.getClass()) {
		 				return false;
		 			}
		 			//cook the pizza according to the convential_oven cooking strategy - return boolean
		 			return strategyTemp.cook(pizza);
		 		}
		 		if(cookingStrategyType == CookingStyleType.MICROWAVE) {
		 			//instantiate a Microwave cooking strategy 
		 			MicrowaveCookingStrategy strategyTemp = new MicrowaveCookingStrategy();
		 			//tests to see if cooking strategy was already set to the same strategy that it is being changed to
		 			if(pizza.getCookingStrategy() !=null && pizza.getCookingStrategy().getClass() == strategyTemp.getClass()) {
		 				return false;
		 			}
		 			//cook the pizza according to the conventional oven cooking strategy - return boolean
		 			return strategyTemp.cook(pizza);
		 			
		 		}
		 	}
		 //changing the strategy was a failure
		 return false;
	 }
	 
	 
}
