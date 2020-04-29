package org.launchcode.tapIn.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Tap extends AbstractEntity {

    @NotBlank(message = "Date is required")
    private String date;

    @Min(1)
    @Max(10)
    private Integer score;

    @ManyToMany(mappedBy = "taps")
    private final List<Goal> goals = new ArrayList<>();

    public Tap(@NotBlank(message = "Date is required") String date, @Min(1) @Max(10) Integer score) {
        this.date = date;
        this.score = score;
    }

    public Tap () {}

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public List<Goal> getGoals() {
        return goals;
    }
}
