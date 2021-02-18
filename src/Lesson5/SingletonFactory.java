package Lesson5;

public class SingletonFactory {

    private static final SingletonFactory instance = new SingletonFactory();
    private SingletonFactory() {
    }

    public static SingletonFactory getInstance(){
        return instance;
    }
}
