package com.codeup.blogappjavacohort.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
//    Create a MathController class.
//    This controller should listen for requests for several routes that correspond to basic arithmetic operations and produce the result of the arithmetic.
    @GetMapping(path = "/{operation}/{numerator}/and/{denominator}")
    @ResponseBody
    public String process(@PathVariable("operation") String operation,@PathVariable("numerator") Double numerator, @PathVariable("denominator") Double denominator){
        switch(operation){
            case "add":
                return String.valueOf(numerator + denominator);
            case "subtract":
                return String.valueOf(numerator - denominator);
            case "multiply":
                return String.valueOf(numerator * denominator);
            case "divide":
                if(denominator != 0) {
                    return String.valueOf(numerator / denominator);
                }else{
                    return "Cannot divide by 0";
                }
            default:
                return "Invalid arithmetic operation.";
        }
    }
}
