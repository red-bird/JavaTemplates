package Lesson1;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        Pair pair = new Pair(10, 8);

        Function<Pair, Integer> Nod = x -> {
            int a = x.num1;
            int b = x.num2;
            while (b !=0) {
                int tmp = a%b;
                a = b;
                b = tmp;
            }
            return a;
        };

        System.out.println(Nod.apply(pair));
    }
}
