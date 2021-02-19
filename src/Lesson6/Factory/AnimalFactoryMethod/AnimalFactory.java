package Lesson6.Factory.AnimalFactoryMethod;

import Lesson6.Factory.AbstractFactory;

public class AnimalFactory implements AbstractFactory {

    @Override
    public Animal create(String animalType) {
        if ("Dog".equalsIgnoreCase(animalType)) {
            return new Dog();
        } else if ("Duck".equalsIgnoreCase(animalType)) {
            return new Duck();
        } else if ("Cat".equalsIgnoreCase(animalType)) {
            return new Cat();
        }

        return null;
    }

}