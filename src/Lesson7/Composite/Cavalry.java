package Lesson7.Composite;

public class Cavalry implements Squad {

    private Integer id;
    private String name;

    public Cavalry(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void printSquadName() {
        System.out.println(getClass().getSimpleName());
    }
}
