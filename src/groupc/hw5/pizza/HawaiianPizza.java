package groupc.hw5.pizza;

public class HawaiianPizza extends AbstractPizza {

	// Default Constructor
	public HawaiianPizza() {
		super(3.00, 3.00, AbstractPizza.orderIDCounter++, null, 0);
		getToppingList().add(Toppings.CANADIAN_BACON);
		getToppingList().add(Toppings.CHEESE);
		getToppingList().add(Toppings.PINEAPPLE);
		addTopingsToPrice(priceWithoutToppings);
	}
	
	// Copy Constructor
	public HawaiianPizza(HawaiianPizza pizza) {
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
