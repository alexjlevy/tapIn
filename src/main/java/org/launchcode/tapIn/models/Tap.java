package org.launchcode.tapIn.models;

import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Tap extends AbstractEntity {

    @NotNull
    private LocalDate date;

    @ManyToOne
    @NotNull
    private Goal goal;

    public Tap(LocalDate date, Goal goals) {
        this.date = LocalDate.now();
        this.goal = goal;
    }

    public Tap() { }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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
