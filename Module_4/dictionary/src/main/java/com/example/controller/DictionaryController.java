package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

//    @PostMapping("/usd")
//    public String submit(@RequestParam String usd,String rate, Model model) {
//        float result = Float.parseFloat(usd)*Float.parseFloat(rate);
//        model.addAttribute("result1", result);
//        return "submit";
//    }

    @PostMapping("/translate")
    public String submit(@RequestParam String txtSearch, Model model) {

        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");

        String result = dictionary.get(txtSearch);

//        if(result == null){
//            result = "Not found";
//        }

        model.addAttribute("result", result);

        return "index";
    }
}
