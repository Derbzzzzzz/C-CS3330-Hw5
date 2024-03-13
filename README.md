**_C-CS3330-HW5_**
------------------------------

_**Authors**_
------------------------------
- Darkskymoon - Zoe
- Derbzzzzzz - Ryan
- andopepe - Ando
- LinYu-Ch - John

**_Description_**
---------------------------
This project simulates a pizza restaurant that has different types of pizzas and different ways of cooking those pizzas. A user is able to construct an order of pizzas, 
decide how they want them cooked, add toppings, retrieve pizzas by their order ID, remove pizzas from an order, and check for uncooked pizzas. The project implements ENUMS to represent
the pizza types, toppings, and cookingStyle. 

The project also demonstrates how the factory and strategy design pattern can be used. The factory design pattern is used to create new pizzas from a centralized location. The pizzas are grouped by an abstract class and the PizzaCookingfactory instantiates new types of pizzas. The strategy design pattern is used to select what cooking style should be used. An interface is used to group all the different cooking strategies and then the PizzaOrder class provides a way for the user to select what strategy is used. Each of the different cooking strategies changes how the code functions (by setting different cookingPrices, for example).



**_Contributions_**
----------------------------
_- Zoe:_

Pizza Order Methods:
- addNewToppingToPizza
- SelectCookingStrategyByPizzaOrderID

Helper methods: 
- checkPizzaForTopping: helps by checking if a passed-in pizza contains the passed-in topping. Used for addNewToppingToPizza to ensure that there are no duplicate toppings added
- getPizzaReferenceByID: helps by returning a reference to the exact pizza. Similar to getPizzaByOrderID, except that it returns a reference

Additionally:
- Created a toString for the different cooking strategy
- Adjusted the pizza copy constructor to be in the PizzaCookingFactory instead of PizzaOrder. Also fixed any broken code from that change
- wrote description section of readme for the project


_- Ryan:_   

Pizza Order Methods:  
-   printListOfToppingsByPizzaOrderID
-   printPizzaOrderCart
-   getPizzaByOrderID
-   addPizzaToCart

Additionally:
-   Did bulk of setting up project (we rotate weeks we do this part)
-   Created copyPizza method

_- Ando:_

Pizza Order Methods:  
-   checkout
-   printPizzaOrderCart

Additionally:
-   Fixed typos and grammar issues
-   Fixed the orderIDcounter to be incremented in the factory

_- John:_

Pizza Order Methods:  
-   removeToppingFromPizza
-   isThereAnyUncookedPizza

_**Running The Code:**_
--------------------------
There are no additional requirements to run the code. To run the code clone the repository:

git clone git@github.com:Derbzzzzzz/C-CS3330-Hw5.git

You should then be able to select the main file and run the code.
