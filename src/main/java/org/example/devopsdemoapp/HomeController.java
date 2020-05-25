package org.example.devopsdemoapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author maureen on 24/5/2020
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("course","DevOps");
        return "home";
    }
}
