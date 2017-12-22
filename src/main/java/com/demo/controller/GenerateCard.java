/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Administrator
 */
@Controller
public class GenerateCard {
    
    public ModelAndView singleton(){
        ModelAndView mv = new ModelAndView();
        
        mv.setViewName("/generateCardSingleton");
        return mv;
    }
    
}
