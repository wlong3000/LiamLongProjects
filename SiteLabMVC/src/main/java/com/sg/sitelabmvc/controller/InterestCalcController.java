/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.sitelabmvc.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class InterestCalcController {

    @RequestMapping(value = "/interestcalc", method = RequestMethod.GET)
    public String displayInterestCalculator() {
        return "interestcalc";
    }
    
    @RequestMapping(value= "/icresponse", method=RequestMethod.POST)
    public String displayInterestResponse(HttpServletRequest request, Model model){
        int numYears = Integer.parseInt(request.getParameter("years"));
        double annualInterestRate = Double.parseDouble(request.getParameter("interestRate"))/100;
        double principal = Double.parseDouble(request.getParameter("initialPrincipal"));

        for (int currentYear = 1; currentYear <= numYears; currentYear++) {
            for (int quarter = 1; quarter <= 4; quarter++) {
                double quarterlyInterest = annualInterestRate / 4 * principal;
                principal += quarterlyInterest;
            }
        }
        double principalRounded = (double)Math.round(principal * 100) / 100;
        model.addAttribute("years", numYears);
        model.addAttribute("interestString", annualInterestRate * 100);
        model.addAttribute("principal", principalRounded);
        return "icresponse";
    }
}
