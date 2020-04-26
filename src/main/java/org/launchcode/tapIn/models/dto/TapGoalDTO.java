package org.launchcode.tapIn.models.dto;

import com.sun.istack.NotNull;
import org.launchcode.tapIn.models.Goal;
import org.launchcode.tapIn.models.Tap;

public class TapGoalDTO {

    @NotNull
    private Tap tap;

    @NotNull
    private Goal goal;

    public TapGoalDTO () {}

    public Tap getTap() {
        return tap;
    }

    public void setTap(Tap tap) {
        this.tap = tap;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }
}
