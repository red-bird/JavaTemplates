package Lesson6.Factory;

public interface AbstractFactory<T> {
    T create(String animalType) ;
}
