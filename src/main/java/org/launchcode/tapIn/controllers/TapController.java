package org.launchcode.tapIn.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TapController {

    @GetMapping
    public String home() { return "home"; }
}
