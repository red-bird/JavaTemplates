package Lesson7;

import Lesson7.Composite.*;
import Lesson7.Decorator.BubbleLights;
import Lesson7.Decorator.ChristmasTree;
import Lesson7.Decorator.ChristmasTreeImpl;
import Lesson7.Decorator.Garland;

public class Main {
    public static void main(String[] args) {

        /// Composite

        Squad infantry = new Infantry(1, "infantry");
        Squad cavalry = new Cavalry(2, "cavalry");
        Squad archers = new Archers(3, "archers");

        Army army = new Army(4, "army");

        army.addSquad(infantry).addSquad(cavalry).addSquad(archers);
        army.printSquadName();

        /// Decorator

        ChristmasTree tree = new BubbleLights(new ChristmasTreeImpl());
        ChristmasTree tree2 = new Garland(new ChristmasTreeImpl());
        ChristmasTree tree3 = new ChristmasTreeImpl();
        System.out.println(tree.decorate());
        System.out.println(tree2.decorate());
        System.out.println(tree3.decorate());
    }

}
