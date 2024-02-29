package groupc.hw5.cookingStrategy;

import groupc.hw5.pizza.AbstractPizza;

public interface ICookingStrategy {
	
	/**
	 *  This method sets the cookingPrice, cookingStrategy and 
	 *  updates the pizzaPrice of the pizza that is being cooked 
	 *  and passed as a parameter. There could only be one 
	 *  cooking strategy selected for a pizza
	 * 
	 *  The cooking strategy changes the pizza price as below:
	 *  	BrickOvenCookingStrategy: Additional $10.0
	 *  	ConventionalOvenCookingStrategy: Additional $8.0
	 *  	MicrowaveCookingStrategy: Additional $1.0
	 *  
	 * @param pizza
	 * @return
	 */
	public boolean cook(AbstractPizza pizza);
	
}
