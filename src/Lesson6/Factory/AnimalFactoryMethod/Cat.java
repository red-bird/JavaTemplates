package Lesson6.Factory.AnimalFactoryMethod;

public class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Mew");
    }
}
