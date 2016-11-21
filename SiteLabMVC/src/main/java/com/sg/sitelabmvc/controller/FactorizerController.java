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
public class FactorizerController {
    
    @RequestMapping(value="/factorizer", method=RequestMethod.GET)
    public String displayFactorizer(){
        return "factorizer";
    }
    
    @RequestMapping(value="/factresponse", method=RequestMethod.POST)
    public String displayFactorizerResponse(HttpServletRequest request, Model model){
        int num = Integer.parseInt(request.getParameter("number"));
        int numberOfFactors = 0;
        int factorSum = 0;
        String message1 ="";
        String message2 ="";
        
        //do logic
        for(int i=1;i<num;i++){
            if(num % i == 0){
                numberOfFactors++;
                factorSum += i;
                System.out.println(i);
            }
        }
        if(num==1){
            factorSum=1;
            numberOfFactors=1;
        }
        //change message
        if(factorSum == num){
            message1 = (num + " is a perfect number.");
        }else{
            message1 = (num + " is not a perfect number.");
        }
        if(factorSum==1){
            message2 = (num + " is a prime number.");
        }else{
            message2 = (num + " is not a prime number.");
        }
        //set request attributes
        model.addAttribute("number",num);
        model.addAttribute("message1",message1);
        model.addAttribute("message2",message2);
        return "factresponse";
    }
}
