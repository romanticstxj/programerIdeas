package com.disney.wdpro.service.mockpis.controller;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Controller
public class WelcomeController {

    // inject via application.properties
    @Value("${welcome.message}")
    private String message;

    private List<String> tasks = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("message", message);
        model.addAttribute("tasks", tasks);
        model.addAttribute("idea1", "Number");

        return "welcome"; //view
    }

    // /hello?name=kotlin
    @GetMapping("/hello")
    public String mainWithParam(
            @RequestParam(name = "name", required = false, defaultValue = "")
                    String name, Model model) {

        model.addAttribute("message", name);

        return "welcome"; //view
    }

    @GetMapping("/number")
    public String number(){
//        NumberDto numberDto = new NumberDto().setFirstNumerator(1)
//                .setFirstDenominator(4)
//                .setSecondNumerator(1)
//                .setSecondDenominator(6);

        return "number";
    }

    @GetMapping("/clock")
    public String clock(){
//        NumberDto numberDto = new NumberDto().setFirstNumerator(1)
//                .setFirstDenominator(4)
//                .setSecondNumerator(1)
//                .setSecondDenominator(6);

        return "game/clock";
    }

    @GetMapping("/findVowel")
    public int foundVowelNumber(){
        Set<Character> vowelChars = Sets.newHashSet('a', 'o', 'i', 'e', 'u');
        String s = "adfsdf;lkjl;kj";
        int count = 0;
        for(Character c: s.toCharArray()){
            if(vowelChars.contains(c)){
                count++;
            }
        }

        return count;
    }



}
