package com.example.spicessandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CaculatorController {
    @GetMapping("/sandwich")
    public String index() {
        return "index";
    }


    @PostMapping("/spices")
    public String submit(@RequestParam String lecttuce, String totamto, String mustard, String sprouts, Model model){
        List spices = new ArrayList<>();
        spices.add(lecttuce);
        spices.add(totamto);
        spices.add(mustard);
        spices.add(sprouts);

        model.addAttribute("spices", spices);
        String title = "A Sandwich with:";
        model.addAttribute("title", title);
        return "index";
    }
}
