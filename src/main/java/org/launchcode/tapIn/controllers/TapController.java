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
import java.util.Optional;

@Controller
public class TapController {

    @Autowired
    private GoalsRepository goalsRepository;

    @Autowired
    private TapRepository tapRepository;
}
