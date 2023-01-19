package com.codeup.blogappjavacohort.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

@Controller
public class RollDice {
//    Create a page at /roll-dice that asks the user to guess a number.
//    There should be links on this page for 1 through 6 that should make a GET request to /roll-dice/n where
//    n is the number guessed. This page should display a random number (the dice roll), the user's guess and a
//    message based on whether or not they guessed the correct number.
    @GetMapping("/roll")
    String roll(){
        return "guess";
    }

    @GetMapping("/roll-dice/{n}")
    String rollDice(@PathVariable("n") int guess, Model model) {
        Random r = new Random();
        int roll = r.nextInt(6-1) + 1;
        model.addAttribute("guess", guess);
        model.addAttribute("roll",roll);
        return "roll-dice";
    }
}
