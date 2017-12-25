package com.test;

import com.demo.config.RootConfig;
import com.demo.helper.CardHelper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class CardTest {
    
    @Autowired
    private CardHelper cardHelper;
    
//    @Test
    public void init(){}
    
    @Test
    public void card(){
        Thread t = new CardThread();
        t.start();
//        String cardNo = cardHelper.GenerateCardNumber();
//        System.out.println(cardNo);
    }
    
    class CardThread extends Thread{
        
        @Override
        public void run() {
            System.out.println("【------------start-------------】");
            String cardNo = cardHelper.GenerateCardNumber();
            System.out.println("cardNo:" + cardNo);
            System.out.println("【------------end-------------】");
        }

    }
  
    
}


