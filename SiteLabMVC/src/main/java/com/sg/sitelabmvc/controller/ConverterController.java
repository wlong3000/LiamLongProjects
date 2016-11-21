/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.sitelabmvc.controller;


import com.sg.sitelabmvc.calculator.Calculator;
import java.math.RoundingMode;
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
public class ConverterController {
    
    @RequestMapping(value="/converter",method=RequestMethod.GET)
    public String displayUnitConverter(){
        return "converter";
    }
    
    @RequestMapping(value="/convertresponse",method=RequestMethod.POST)
    public String displayConverterResponse(HttpServletRequest request, Model model){
        String type = request.getParameter("type");
        String sourceUnit = request.getParameter("sourceUnit");
        String targetUnit = request.getParameter("targetUnit");
        Double amount = Double.parseDouble(request.getParameter("amount"));

        Double newAmount = Calculator.Convert(type, sourceUnit, targetUnit, amount);
        DecimalFormat df = new DecimalFormat("#.###");
        df.setRoundingMode(RoundingMode.CEILING);
        
        request.setAttribute("sourceUnit", sourceUnit);
        request.setAttribute("targetUnit", targetUnit);
        request.setAttribute("originalAmount", df.format(amount));
        request.setAttribute("newAmount", df.format(newAmount));
        return "convertresponse";
    }
}
