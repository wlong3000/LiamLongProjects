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
public class LuckySevensController {
    
    @RequestMapping(value="/luckysevens", method=RequestMethod.GET)
    public String displayLuckySevens(){
        return"luckysevens";
    }
    
    @RequestMapping(value="/luckysevensresponse",method=RequestMethod.POST)
    public String displayLuckySevensResponse(HttpServletRequest request, Model model){
        int initialBet = Integer.parseInt(request.getParameter("initialBet"));
        //play game
        int totalRolls = 0;
        int rollsWhileAhead = 0;
        int currentMoney = initialBet;
        int maxMoney = initialBet;
        int diceValue;

        while (currentMoney > 0) {
            diceValue = (int) Math.floor(Math.random() * 11 + 2);
            totalRolls++;
            if (diceValue == 7) {
                currentMoney += 4;
                if (currentMoney > maxMoney) {
                    maxMoney = currentMoney;
                    rollsWhileAhead = totalRolls;
                }
            } else {
                currentMoney--;
            }
        }
        //set model attributes
        model.addAttribute("initialBet", initialBet);
        model.addAttribute("totalRolls", totalRolls);
        model.addAttribute("maxMoney", maxMoney);
        model.addAttribute("rollsWhileAhead", rollsWhileAhead);
        return "lsresponse";
    }
}
