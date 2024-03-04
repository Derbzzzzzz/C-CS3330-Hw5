package groupc.hw5.cookingStrategy;

import groupc.hw5.pizza.AbstractPizza;

public class ConventionalOvenCookingStrategy implements ICookingStrategy {

	@Override
	public boolean cook(AbstractPizza pizza) {
		pizza.setCookingStrategy(new ConventionalOvenCookingStrategy());
		pizza.setCookingPrice(8);
		pizza.updatePizzaPrice();
		return true;
	}
	
	@Override
	public String toString() {
		
		return "Conventional_Oven";
	}

}
