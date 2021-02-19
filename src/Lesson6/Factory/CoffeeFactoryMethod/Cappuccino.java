package Lesson6.Factory.CoffeeFactoryMethod;

public class Cappuccino implements Coffee{
    @Override
    public void identify() {
        System.out.println("I'm Cappuccino");
    }
}
