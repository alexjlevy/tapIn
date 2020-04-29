package org.launchcode.tapIn.controllers;

import org.launchcode.tapIn.data.GoalsRepository;
import org.launchcode.tapIn.data.TapRepository;
import org.launchcode.tapIn.models.Goal;
import org.launchcode.tapIn.models.Tap;
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
@RequestMapping("tapIn")
public class TapController {

    @Autowired
    private GoalsRepository goalsRepository;

    @Autowired
    private TapRepository tapRepository;

    @GetMapping
    public String displayAllTaps (Model model) {
        model.addAttribute("goals", goalsRepository.findAll());
        model.addAttribute("taps", tapRepository.findAll());
        return "tapIn/index";
    }

    @GetMapping("create")
    public String createTapForm (Model model) {
        model.addAttribute(new Tap());
        model.addAttribute(new Goal());
        model.addAttribute("goals", goalsRepository.findAll());
        return "tapIn/create";
    }

    @PostMapping("create")
    public String processTapForm (@ModelAttribute @Valid Tap tap, Goal goal,
                                            Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "tapIn/create";
        }
        tapRepository.save(tap);
        return "redirect:";
    }
}
