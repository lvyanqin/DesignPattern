/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import com.demo.config.RootConfig;
import com.demo.config.pay.CardHelper_Singleton;
import com.demo.mapper.CardMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Administrator
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class CardTest_Singleton {
    
    @Autowired
    private CardMapper cardMapper;
    
    @Test
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
        public void run() {
            String threadName = Thread.currentThread().getName();
//            long beforTime = System.currentTimeMillis();
//            System.out.println("【------------start-------------】");
            CardHelper_Singleton cardHelper = CardHelper_Singleton.GetInstance(cardMapper);
//            System.out.println("com.test.CardTest_Singleton.CardThread.run():" + cardHelper.hashCode());

            String cardNo = cardHelper.GenerateCardNumber();
            System.out.println(threadName + "--cardNo:" + cardNo);
//            long endTime = System.currentTimeMillis();
//            System.out.println(threadName + "【------------end-------------】" + (endTime - beforTime));
        }

    }
    
}


