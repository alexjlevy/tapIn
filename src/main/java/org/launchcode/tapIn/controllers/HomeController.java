package org.launchcode.tapIn.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("tapIn")
public class HomeController {

    @GetMapping
    public String tap() { return "tapIn/index"; }
}
