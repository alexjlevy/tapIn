package org.launchcode.tapIn.controllers;

import org.launchcode.tapIn.data.GoalsRepository;
import org.launchcode.tapIn.data.TapRepository;
import org.launchcode.tapIn.models.Goal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


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
