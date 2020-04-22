package org.launchcode.tapIn.models;

import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
public class Tap extends AbstractEntity {

    @NotNull
    @OneToOne
    private LocalDate date;

    @ManyToOne
    @NotNull
    private Goal goals;

    public Tap(LocalDate date, Goal goals) {
        this.date = LocalDate.now();
        this.goals = goals;
    }

    public Tap() { }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Goal getGoals() {
        return goals;
    }

    public void setGoals(Goal goals) {
        this.goals = goals;
    }
}
