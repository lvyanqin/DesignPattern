/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.controller;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;


import com.demo.config.pay.CardHelper;

/**
 *
 * @author Administrator
 */
public class GenerateCard {
	
	public static void main(String[] args){
//       
        Thread[] t = new MyThread[10];
        for(int i = 0; i < 10; i ++){
        	t[i] = new MyThread();
        	t[i].start();
        }
        
        
       
        
    }
	
	
	
}


class MyThread extends Thread{
	
	 WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
    CardHelper cardHelper = (CardHelper)webApplicationContext.getBean(CardHelper.class);
	
	@Override
	public void run() {
		String cardNo  = cardHelper.GenerateCardNumber();
		System.out.println(Thread.currentThread().getName() + ":" + cardNo);
	}
	
}

