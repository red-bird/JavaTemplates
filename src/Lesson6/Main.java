package Lesson6;

import Lesson6.Builder.Student;
import Lesson6.Factory.AbstractFactory;
import Lesson6.Factory.AnimalFactoryMethod.Animal;
import Lesson6.Factory.CoffeeFactoryMethod.Coffee;
import Lesson6.Factory.FactoryProvider;
import Lesson6.Prototype.Oak;
import Lesson6.Prototype.Tree;

import java.awt.*;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        /// Abstract factory & factory method

        AbstractFactory factory = FactoryProvider.getFactory("Coffee");

        Coffee coffee = (Coffee) factory.create("Americano");
        coffee.identify();

        coffee = (Coffee) factory.create("Cappuccino");
        coffee.identify();

        coffee = (Coffee) factory.create("Espresso");
        coffee.identify();

        factory = FactoryProvider.getFactory("Animal");

        Animal animal = (Animal) factory.create("Duck");
        animal.makeSound();

        animal = (Animal) factory.create("Dog");
        animal.makeSound();

        animal = (Animal) factory.create("Cat");
        animal.makeSound();

        System.out.println("------------------");

        ///// Builder pattern

        Student student = new Student();
        student.setId(1).setName("Abraham").setAddress("Dallas");
        System.out.println(student);

        System.out.println("------------------");

        ///// Prototype pattern

        Tree oak = new Oak(15, Color.GREEN);
        Tree oak2 = (Oak)oak.clone();

        System.out.println(oak);
        System.out.println(oak2);
    }

}
