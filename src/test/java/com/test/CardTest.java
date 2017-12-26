package com.test;

import com.demo.config.RootConfig;
import com.demo.helper.CardHelper;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public void card() throws InterruptedException{
        Thread[] ts = new CardThread[20];
        for(int i = 0; i < 20; i ++){
            ts[i] = new CardThread();
            ts[i].start();
        }
        Thread.sleep(60000);
    }
    
    class CardThread extends Thread{
        
        @Override
        public void run(){
            String threadName = Thread.currentThread().getName();
            long beforTime = System.currentTimeMillis();
//            try {
//                Thread.sleep(((int)(Math.random() * 10)) * 1000);
//            } catch (InterruptedException ex) {
//                System.out.println("【exception】");
//            }
            long time = System.currentTimeMillis();
            System.out.println("com.test.CardTest_Singleton.CardThread.run():" + cardHelper.hashCode());
//            System.out.println(Thread.currentThread().getName() + "【------------start--------------------------------------------】" + time);
            String cardNo = cardHelper.GenerateCardNumber();
            System.out.println(threadName + "cardNo:" + cardNo);
            long endTime = System.currentTimeMillis();
            System.out.println(threadName + "【------------end-------------】" + (endTime - beforTime));
        }

    }
   
}


