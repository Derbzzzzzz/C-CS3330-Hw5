package groupc.hw5.pizza;

import java.util.ArrayList;
import java.util.List;

import groupc.hw5.cookingStrategy.ICookingStrategy;

public abstract class AbstractPizza {
	
	protected List<Toppings> toppingList;
	protected double priceWithoutToppings;
	protected double totalPrice;
	protected int pizzaOrderID;
	protected static int orderIDCounter;
	protected ICookingStrategy cookingStrategy;
	protected double cookingPrice;
	
	// Constructor
	
	public AbstractPizza(double priceWithoutToppings, double totalPrice, int pizzaOrderID,
			ICookingStrategy cookingStrategy, double cookingPrice) {
		this.toppingList = new ArrayList<Toppings>();
		this.priceWithoutToppings = priceWithoutToppings;
		this.totalPrice = totalPrice;
		this.pizzaOrderID = pizzaOrderID;
		this.cookingStrategy = cookingStrategy;
		this.cookingPrice = cookingPrice;
	}
	
	// Copy Constructor
	
	public AbstractPizza(AbstractPizza other) {
		// Note: Shallow cloned toppingList to encapsulate data
		this.toppingList = new ArrayList<Toppings>(other.toppingList);
		this.priceWithoutToppings = other.priceWithoutToppings;
		this.totalPrice = other.totalPrice;
		this.pizzaOrderID = other.pizzaOrderID;
		this.cookingStrategy = other.cookingStrategy;
		this.cookingPrice = other.cookingPrice;
	}
	
	// Abstract Methods
	
	protected abstract double addTopingsToPrice(double priceWithoutToppings);
	public abstract double updatePizzaPrice();
	
	// Getters and Setters
	
	public List<Toppings> getToppingList() {
		return toppingList;
	}

	public void setToppingList(List<Toppings> toppingList) {
		this.toppingList = toppingList;
	}

	public double getPriceWithoutToppings() {
		return priceWithoutToppings;
	}

	public void setPriceWithoutToppings(double priceWithoutToppings) {
		this.priceWithoutToppings = priceWithoutToppings;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getPizzaOrderID() {
		return pizzaOrderID;
	}

	public void setPizzaOrderID(int pizzaOrderID) {
		this.pizzaOrderID = pizzaOrderID;
	}

	public static int getOrderIDCounter() {
		return orderIDCounter;
	}

	public static void setOrderIDCounter(int orderIDCounter) {
		AbstractPizza.orderIDCounter = orderIDCounter;
	}

	public ICookingStrategy getCookingStrategy() {
		return cookingStrategy;
	}

	public void setCookingStrategy(ICookingStrategy cookingStrategy) {
		this.cookingStrategy = cookingStrategy;
	}

	public double getCookingPrice() {
		return cookingPrice;
	}

	public void setCookingPrice(double cookingPrice) {
		this.cookingPrice = cookingPrice;
	}
	
	
}
