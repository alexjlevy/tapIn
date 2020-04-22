package org.launchcode.tapIn.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Goal extends AbstractEntity{

    @Size(min = 3, message = "Goal must be at least 3 characters long")
    private String name;

    @OneToMany(mappedBy = "goal")
    private final List<Tap> goals = new ArrayList<>();

    public Goal(@Size(min = 3, message= "Goal must be at least 3 characters long") String name) {
        this.name = name;
    }

    public Goal() {
    }

    public String getName() {
        return name;
    }

    public List<Tap> getGoals() {
        return goals;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Goal{" +
                "name='" + name + '\'' +
                ", goals=" + goals +
                '}';
    }
}

