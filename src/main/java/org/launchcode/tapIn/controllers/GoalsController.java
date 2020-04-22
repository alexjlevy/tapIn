package org.launchcode.tapIn.controllers;

import org.launchcode.tapIn.data.GoalsRepository;
import org.launchcode.tapIn.models.Goal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("goals")
public class GoalsController {

    @Autowired
    private GoalsRepository goalsRepository;

    @GetMapping
    public String displayAllGoals(Model model){
        model.addAttribute("goals", goalsRepository.findAll());
        return "goals/index";
    }

    @GetMapping("create")
    public String createGoalForm (Model model) {
        model.addAttribute(new Goal());
        return "goals/create";
    }

    @PostMapping("create")
    public String processGoalForm (@Valid @ModelAttribute Goal goal,
                                                 Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute(new Goal());
            return "goals/create";
        }

        goalsRepository.save(goal);
        return "redirect:";
    }


}
