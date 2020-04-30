package org.launchcode.tapIn.controllers;

import org.launchcode.tapIn.data.GoalsRepository;
import org.launchcode.tapIn.data.TapRepository;
import org.launchcode.tapIn.models.Goal;
import org.launchcode.tapIn.models.Tap;
import org.launchcode.tapIn.models.dto.TapGoalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("tapIn")
public class TapController {

    @Autowired
    private GoalsRepository goalsRepository;

    @Autowired
    private TapRepository tapRepository;

    @GetMapping
    public String displayAllTaps(Model model){
        model.addAttribute("goals", goalsRepository.findAll());
        model.addAttribute("taps", tapRepository.findAll());
        return "tapIn/index";
    }

    @GetMapping("create")
    public String displayTapInForm (@RequestParam Integer goalId, Model model){
        Optional<Goal> result = goalsRepository.findById(goalId);
        Goal goal = result.get();
        TapGoalDTO tapGoal = new TapGoalDTO();
        tapGoal.setGoal(goal);
        model.addAttribute("tapGoal", tapGoal);
        return "tapIn/create";
    }

    @PostMapping("create")
    public String processTapInForm(@ModelAttribute @Valid TapGoalDTO tapGoal,
                                   Errors errors,
                                   Model model){
        Goal goal = tapGoal.getGoal();
        Tap tap = tapGoal.getTap();
        goal.addTap(tap);
        tapRepository.save(tap);
        goalsRepository.save(goal);
        return "redirect:/goals";
    }
}
