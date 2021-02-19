package Lesson6.Factory.CoffeeFactoryMethod;

public class Espresso implements Coffee{
    @Override
    public void identify() {
        System.out.println("I'm Espresso");
    }
}
