package groupc.hw5.pizza;


public class MargheritaPizza extends AbstractPizza{
	
	// Default Constructor
	public MargheritaPizza() {
		super(2.50, 2.50, AbstractPizza.orderIDCounter++, null, 0);
		getToppingList().add(Toppings.TOMATO);
		getToppingList().add(Toppings.CHEESE);
		addTopingsToPrice(priceWithoutToppings);
	}
	
	// Copy Constructor
	public MargheritaPizza(MargheritaPizza pizza) {
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
		this.totalPrice += cookingPrice;
		return calculatedTotalPrice;
	}
	
}
