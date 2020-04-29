package org.launchcode.tapIn.models;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Goal extends AbstractEntity{

    @NotBlank(message = "Date is required")
    private String date;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 100, message = "Goal must be at least 3 characters long")
    private String name;

    @Max(10)
    @Min(1)
    private Integer scoreStart;

    @ElementCollection
    private final List<Integer> taps = new ArrayList<>();

    public Goal(@NotBlank(message = "Date is required") String date, @NotBlank(message = "Name is required") @Size(min = 3, max = 100, message = "Goal must be at least 3 characters long") String name, @Max(10) @Min(1) Integer scoreStart) {
        this.date = date;
        this.name = name;
        this.scoreStart = scoreStart;
    }

    public Goal () {}

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScoreStart() {
        return scoreStart;
    }

    public void setScoreStart(Integer scoreStart) {
        this.scoreStart = scoreStart;
    }

    public List<Integer> getTaps() {
        return taps;
    }

    public void addTap(Integer tap) {this.taps.add(tap);}
}

