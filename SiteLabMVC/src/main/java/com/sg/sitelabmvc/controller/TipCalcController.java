/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.sitelabmvc.controller;

import java.text.DecimalFormat;
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
public class TipCalcController {

    @RequestMapping(value = "/tipcalc", method = RequestMethod.GET)
    public String displayTipCalculator() {
        return "tipcalc";
    }
    
    @RequestMapping(value="/tcresponse",method=RequestMethod.POST)
    public String displayTipResponse(HttpServletRequest request, Model model){
        double amount = Double.parseDouble(request.getParameter("amount"));
        double tipPercent = Double.parseDouble(request.getParameter("tipPercent"));
        
        double tip = amount * tipPercent/100;
        double total = tip + amount;
        
        //round values for output
        DecimalFormat df = new DecimalFormat("#.00");
        
        model.addAttribute("amount", df.format(amount));
        model.addAttribute("tip", df.format(tip));
        model.addAttribute("tipPercent",df.format(tipPercent));
        model.addAttribute("total",df.format(total));
        return "tcresponse";
    }
}
