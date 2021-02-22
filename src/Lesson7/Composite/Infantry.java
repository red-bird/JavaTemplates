package Lesson7.Composite;

public class Infantry implements Squad {

    private Integer id;
    private String name;

    public Infantry(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void printSquadName() {
        System.out.println(getClass().getSimpleName());
    }
}
