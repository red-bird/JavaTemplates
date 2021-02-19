package Lesson6.Factory;

import Lesson6.Factory.AnimalFactoryMethod.AnimalFactory;
import Lesson6.Factory.CoffeeFactoryMethod.CoffeeFactory;

public class FactoryProvider {

    public static AbstractFactory getFactory(String choice) {

        if("Animal".equalsIgnoreCase(choice)){
            return new AnimalFactory();
        }
        else if("Coffee".equalsIgnoreCase(choice)){
            return new CoffeeFactory();
        }

        return null;
    }

}
