package org.launchcode.tapIn.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tap extends AbstractEntity {

    @NotBlank(message = "Date is required")
    private String date;

    @Min(1)
    @Max(10)
    private Integer score;

    private final List<Goal> goals = new ArrayList<>();


}
