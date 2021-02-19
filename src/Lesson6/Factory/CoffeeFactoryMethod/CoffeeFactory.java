package Lesson6.Factory.CoffeeFactoryMethod;

import Lesson6.Factory.AbstractFactory;

public class CoffeeFactory implements AbstractFactory {


    @Override
    public Coffee create(String coffeeType) {
        if ("Americano".equalsIgnoreCase(coffeeType)) {
            return new Americano();
        } else if ("Cappuccino".equalsIgnoreCase(coffeeType)) {
            return new Cappuccino();
        } else if ("Espresso".equalsIgnoreCase(coffeeType)) {
            return new Espresso();
        }

        return null;
    }
}
