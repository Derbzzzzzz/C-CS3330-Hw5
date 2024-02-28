package groupc.hw5.pizza;

public class SupremePizza extends AbstractPizza{
	
	// Default Constructor
	public SupremePizza() {
		super(3.50, 3.50, AbstractPizza.orderIDCounter++, null, 0);
		getToppingList().add(Toppings.TOMATO);
		getToppingList().add(Toppings.CHEESE);
		getToppingList().add(Toppings.BELL_PEPPER);
		getToppingList().add(Toppings.ITALIAN_SAUSAGE);
		getToppingList().add(Toppings.PEPPERONI);
		getToppingList().add(Toppings.BLACK_OLIVE);
		getToppingList().add(Toppings.MUSHROOM);
		addTopingsToPrice(priceWithoutToppings);
	}
	
	// Copy Constructor
	public SupremePizza(SupremePizza pizza) {
		super(pizza);
	}
	
	@Override
	protected double addTopingsToPrice(double priceWithoutToppings) {
		double calculatedTotalPrice = priceWithoutToppings;
		for(Toppings t : getToppingList()) {
			calculatedTotalPrice += t.getToppingPrice();
		}
		this.totalPrice = calculatedTotalPrice;
		return calculatedTotalPrice;
	}
	
	@Override
	public double updatePizzaPrice() {
		double calculatedTotalPrice = this.priceWithoutToppings;
		for(Toppings t : getToppingList()) {
			calculatedTotalPrice += t.getToppingPrice();
		}
		this.totalPrice = calculatedTotalPrice;
		return calculatedTotalPrice;
	}
}
