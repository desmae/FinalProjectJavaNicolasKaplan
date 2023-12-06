## Cafe simulation

This program simulates a cafe which accept orders

There are 5 classes in the program

- CoffeeShop is the main class which spawns the threads and manages everything
- Order which encapsulates the order
- CoffeeType is an Enum which holds coffee types
- CoffeeMachine implements runnable which prepares the coffee
- Cashier implements runnable which generate new orders.


Your job is to:

- Implement the `placeOrder()` method in `Cashier` class.
- Implement the `brew()` method in the `CoffeeMachine` class.

Feel free to add any extra fields in the program.
Further comments have been provided in the code.
