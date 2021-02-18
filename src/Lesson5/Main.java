package Lesson5;

public class Main {
    // Lazy initialization
    SingletonLazy one = SingletonLazy.getInstance();
//    SingletonLazy one2 = new SingletonLazy();

    // Enum
    SingletonEnum two = SingletonEnum.INSTANCE;
//    SingletonEnum two2 = new SingletonEnum();

    // Singleton With Public Static Factory Method
    SingletonFactory three = SingletonFactory.getInstance();
//    SingletonFactory three2 = new SingletonFactory();
}
