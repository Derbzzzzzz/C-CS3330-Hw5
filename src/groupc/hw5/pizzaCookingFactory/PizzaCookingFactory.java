package groupc.hw5.pizzaCookingFactory;

import groupc.hw5.pizza.AbstractPizza;
import groupc.hw5.pizza.HawaiianPizza;
import groupc.hw5.pizza.MargheritaPizza;
import groupc.hw5.pizza.PizzaType;
import groupc.hw5.pizza.SupremePizza;
import groupc.hw5.pizza.VegetarianPizza;

public class PizzaCookingFactory {
	
	/**
	 *  This method creates an AbstractPizza instance and instantiates 
	 *  it according to the pizzaType parameter. It also sets 
	 *  the pizzaOrderID of the pizza using the current orderIDCounter 
	 *  of the pizza. The orderIDCounter will be incremented and 
	 *  assigned automatically on every creation of pizza, 
	 *  to assign unique pizza order IDs.
	 * 
	 * @param pizzaType
	 * @return AbstractPizza
	 */
	public AbstractPizza createPizza(PizzaType pizzaType) {
		AbstractPizza pizza;
		
		if(pizzaType.equals(PizzaType.HAWAIIAN)) {
			return new HawaiianPizza();
		} else if(pizzaType.equals(PizzaType.MARGHERITA)) {
			return new MargheritaPizza();
		} else if(pizzaType.equals(PizzaType.VEGETARIAN)) {
			return new VegetarianPizza();
		} else if(pizzaType.equals(PizzaType.SUPREME)) {
			return new SupremePizza();
		}
		
		return null;
	}
	
	/**
	 * Copy constructor for the different pizza types. An abstractPizza is passed into the function and a copy is returned
	 * 
	 * @param p Pizza to make a copy of
	 * @return AbstractPizza a copy of the pizza p.
	 */
	public AbstractPizza copyPizza(AbstractPizza p) {
		//The if's check what type of pizza the passed in pizza "p" is 
		//A proper copy is then made of that pizza type and returned to the user
		 if(p instanceof MargheritaPizza) {
			 return new MargheritaPizza((MargheritaPizza)p);
		 } else if (p instanceof HawaiianPizza) {
			 return new HawaiianPizza((HawaiianPizza)p);
		 } else if (p instanceof VegetarianPizza) {
			 return new VegetarianPizza((VegetarianPizza)p);
		 } else if(p instanceof SupremePizza) {
			 return new SupremePizza((SupremePizza)p);
		 }
		 
		 //pizza passed in wasn't a known type of pizza
		 return null;
	 }

}
