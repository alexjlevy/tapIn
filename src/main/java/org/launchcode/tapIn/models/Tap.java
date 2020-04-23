package org.launchcode.tapIn.models;

import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Tap extends AbstractEntity {

    @NotBlank(message = "Date is required")
    private String date;

    @ManyToOne
    @NotNull
    private Goal goal;

    public Tap(String date, Goal goals) {
        this.date = date;
        this.goal = goal;
    }

    public Tap() { }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Goal getGoals() {
        return goal;
    }

    public void setGoals(Goal goals) {
        this.goal = goals;
    }

    @Override
    public String toString() {
        return "Tap{" +
                "date=" + date +
                ", goal=" + goal +
                '}';
    }
}
