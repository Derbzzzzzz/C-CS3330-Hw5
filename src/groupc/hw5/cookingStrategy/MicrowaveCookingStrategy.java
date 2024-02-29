package groupc.hw5.cookingStrategy;

import groupc.hw5.pizza.AbstractPizza;

public class MicrowaveCookingStrategy implements ICookingStrategy {

	@Override
	public boolean cook(AbstractPizza pizza) {
		pizza.setCookingStrategy(new MicrowaveCookingStrategy());
		pizza.setCookingPrice(1);
		pizza.updatePizzaPrice();
		return true;
	}

}
