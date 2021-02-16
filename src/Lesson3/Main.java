package Lesson3;

import java.util.Map;
import java.util.Set;

public class Main {
    static volatile Set set = new SynchronizedSet();
    static volatile Map map = new SynchronizedMap();

    static void inc(int i) {
        set.add(i);
        map.put(i, i);
    }

    public static void main(String[] args) throws Exception {
        Thread one = new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                inc(i);
            }
        });
        Thread two = new Thread(()->{
            for (int i = 5000; i < 10000; i++) {
                inc(i);
            }
        });

        one.start();
        two.start();
        Thread.sleep(3000);
        System.out.println(set.size());
        // Hash calculate sometimes wrong, it's not threads
        System.out.println(map.size());
    }
}
