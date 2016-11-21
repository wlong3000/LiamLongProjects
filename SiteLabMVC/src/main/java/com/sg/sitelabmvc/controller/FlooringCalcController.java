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
public class FlooringCalcController {
    
    @RequestMapping(value="/flooringcalc",method=RequestMethod.GET)
    public String displayFlooringCalculator(){
        return "flooringcalc";
    }
    
    @RequestMapping(value="/fcresponse", method=RequestMethod.POST)
    public String displayFlooringResponse(HttpServletRequest request, Model model){
        double width = Double.parseDouble(request.getParameter("width"));
        double length = Double.parseDouble(request.getParameter("length"));
        double materialCostPerSqFt = Double.parseDouble(request.getParameter("materialCost"));
        
        double laborCostPerQuarterHour = 21.5;
        double area = width * length;
        double totalMaterialCost = materialCostPerSqFt * area;
        int timeInQuarterHours = (int) Math.ceil(area/5);
        double totalLaborCost = laborCostPerQuarterHour * (double)timeInQuarterHours;
        double timeInHours = timeInQuarterHours / 4.0;
        double totalCost = totalMaterialCost + totalLaborCost;
        
        //round values for output
        DecimalFormat df = new DecimalFormat("#.00");
      
        model.addAttribute("area", area);
        model.addAttribute("numHours", timeInHours);
        model.addAttribute("totalMaterialCost", df.format(totalMaterialCost));
        model.addAttribute("totalLaborCost", df.format(totalLaborCost));
        model.addAttribute("totalCost", df.format(totalCost));
        return "fcresponse";
    }
}
