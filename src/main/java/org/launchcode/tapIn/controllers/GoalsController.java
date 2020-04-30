package org.launchcode.tapIn.controllers;

import org.launchcode.tapIn.data.GoalsRepository;
import org.launchcode.tapIn.data.TapRepository;
import org.launchcode.tapIn.models.Goal;
import org.launchcode.tapIn.models.Tap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("goals")
public class GoalsController {

    @Autowired
    private GoalsRepository goalsRepository;

    @Autowired
    private TapRepository tapRepository;

    @GetMapping
    public String displayAllGoals(Model model){
        model.addAttribute("goals", goalsRepository.findAll());
        model.addAttribute("taps", tapRepository.findAll());
        return "goals/index";
    }

    @GetMapping("taps")
    public String displayTapHistory (@RequestParam Integer goalId, Model model){
        Optional<Goal> result = goalsRepository.findById(goalId);
        Goal goal = result.get();
        List<Tap> taps = goal.getTaps();
        model.addAttribute("taps", taps);
        model.addAttribute("goal", goal);
        return "goals/taps";
    }

    @GetMapping("create")
    public String createGoalForm (Model model) {
        model.addAttribute(new Goal());
        return "goals/create";
    }

    @PostMapping("create")
    public String processGoalForm (@ModelAttribute @Valid Goal goal,
                                                 Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "goals/create";
        }
        goalsRepository.save(goal);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteGoalsForm(Model model) {
        model.addAttribute("goals", goalsRepository.findAll());
        return "goals/delete";
    }

    @PostMapping("delete")
    public String processDeleteGoalsForm(@RequestParam(required = false) int[] goalIds) {

        if (goalIds != null){
            for (int id : goalIds) {
                goalsRepository.deleteById(id);
            }
        }
        return "redirect:";
    }
}
