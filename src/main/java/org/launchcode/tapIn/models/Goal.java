package org.launchcode.tapIn.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Goal extends AbstractEntity{

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 100, message = "Goal must be at least 3 characters long")
    private String name;

    @Max(10)
    @Min(1)
    private Integer score;

    @OneToMany(mappedBy = "goal")
    private final List<Tap> goals = new ArrayList<>();

    public Goal(@Size(min = 3, message = "Goal must be at least 3 characters long") String name, @Max(10) @Min(1) Integer score) {
        this.name = name;
        this.score = score;
    }

    public Goal() { }

    public String getName() {
        return name;
    }

    public List<Tap> getGoals() {
        return goals;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Goal{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", goals=" + goals +
                '}';
    }
}

