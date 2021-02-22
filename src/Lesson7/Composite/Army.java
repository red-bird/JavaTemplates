package Lesson7.Composite;

import java.util.ArrayList;
import java.util.List;

public class Army implements Squad{

    private Integer id;
    private String name;

    private List<Squad> squads;

    public Army(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.squads = new ArrayList<>();
    }

    @Override
    public void printSquadName() {
        squads.forEach(Squad::printSquadName);
    }

    public Army addSquad(Squad squad) {
        squads.add(squad);
        return this;
    }

    public void removeSquad(Squad squad) {
        squads.remove(squad);
    }
}
