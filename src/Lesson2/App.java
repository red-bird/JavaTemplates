package Lesson2;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    static List<Human> Humans = List.of(
            Human.of(12, "Bob", "Dylan",  LocalDate.of(1941, 5, 24), 90),
            Human.of(10, "Charles", "Verteny",  LocalDate.of(2011, 7, 17), 86),
            Human.of(26, "Bob", "Rosa",  LocalDate.of(1995, 7, 4), 60),
            Human.of(53, "Hue", "Jackman",  LocalDate.of(1968, 10, 12), 75),
            Human.of(22, "Ivan", "Ivanov",  LocalDate.of(1999, 1, 6), 102),
            Human.of(46, "Artemy", "Lebedev",  LocalDate.of(1975, 2, 13), 78),
            Human.of(104, "Montgomery", "Burns",  LocalDate.of(1917, 9, 14), 64)
    );

    public static void run() {
        List<Human> StreamedHumans = Humans.stream().sorted(Comparator.comparing(Human::getWeight).reversed()).
                sorted(Comparator.comparing(Human::getAge)).
                filter(human -> !human.getLastName().equals("Ivanov")).
                collect(Collectors.toList());

        StreamedHumans.forEach(System.out::println);
        System.out.println(StreamedHumans.stream().map(Human::getAge).reduce((a, b) -> a * b).orElseThrow(NullPointerException::new));
    }

}
