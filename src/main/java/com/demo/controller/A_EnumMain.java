/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.controller;

import com.demo.helper.A_EnumAdapter;
import java.util.Enumeration;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @author Administrator
 */
@Controller
@RequestMapping("/enum")
public class A_EnumMain {
    
    @RequestMapping("/init")
    public String init(){
        return "redirect:/enum/enum?a=1&b=2&c=3";
    }
    
    @RequestMapping("/enum")
    @ResponseBody
    public String enumTest(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Enumeration paramNames = request.getParameterNames();
        Iterator enumAdapter = new A_EnumAdapter(paramNames);
        String s = "";
        while(enumAdapter.hasNext()){
            s += (String)enumAdapter.next();
        }
        return s;
    }
    
}
