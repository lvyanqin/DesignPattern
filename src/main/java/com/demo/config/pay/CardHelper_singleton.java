/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.config.pay;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.commons.lang3.StringUtils;
import com.demo.bean.SequenceBean;
import com.demo.mapper.CardMapper;
import com.demo.util.DateUtil;

/**
 *
 * @author Administrator
 */
public class CardHelper_singleton {
    
    //定义一个私有的静态全局变量来保存该类的唯实例
    private static CardHelper_singleton cardhelper;
    private static CardMapper cardMapper;

    //定义一个只读静态对象
    //且这个对象是在程序运行时创建的
    private static Object syncObject = new Object();

    // 构造函数必须是私有的
    // 这样在外部便无法使用 new 来创建该类的实例
    private CardHelper_singleton() {
    }

    // 定义一个全局访问点
    // 设置为静态方法
    // 则在类的外部便无需实例化就可以调用该方法
    public static CardHelper_singleton GetInstance(CardMapper c) {
        //这里可以保证只实例化一次
        //即在第一次调用时实例化
        //以后调用便不会再实例化

        //第一重 cardhelper == null
        if (cardhelper == null) {
            Lock lock = new ReentrantLock();// 锁对象
            lock.lock();
            try {
                //第二重 cardhelper == null
                if (cardhelper == null) {
                    cardhelper = new CardHelper_singleton();
                    cardMapper = c;
                }
            } finally {
                lock.unlock();
            }
        }

        return cardhelper;
    }

    public String GenerateCardNumber() {
        Lock lock = new ReentrantLock();// 锁对象
        lock.lock();
        try {
            String CARDNUMBER_SEQUENCE_KEY = "";
            String CARDNUMBER_SEQUENCE = "";
            String CARDNUMBER_SEQUENCE_DESCRIPTION = CardConfig.CARDNUMBER_SEQUENCE_DESCRIPTION;
            
            CARDNUMBER_SEQUENCE_KEY = CardConfig.CARDNUMBER_SEQUENCE_KEY;
            CARDNUMBER_SEQUENCE = CardConfig.CARDNUMBER_SEQUENCE;
            

            int CARDSEQUENCE = 0;
            //CARDSEQUENCE = cardMapper.getCardNumberSequenceMaxValue(CARDNUMBER_SEQUENCE_KEY);
            String value = cardMapper.getCardNumberSequenceMaxValue(CARDNUMBER_SEQUENCE_KEY);
            if (StringUtils.isNotBlank(value)) {
                CARDSEQUENCE = Integer.parseInt(value);
            }

            if (CARDSEQUENCE <= 0) {
                CARDSEQUENCE = 100000;
                SequenceBean sequence = new SequenceBean();
                sequence.setKeys_(CARDNUMBER_SEQUENCE_KEY);
                sequence.setValue_(String.valueOf(CARDSEQUENCE));
                sequence.setDescription(CARDNUMBER_SEQUENCE_DESCRIPTION);

                cardMapper.insertSequenceDetail(sequence);
            }

            //组装完整卡号
            String CARDNUMBER = "";
            if (CARDSEQUENCE != 0 && String.valueOf(CARDSEQUENCE).length() == 6) {
                //组装完整卡号
                CARDNUMBER = DateUtil.getNowTime("yyyy").substring(1, 4) + CARDNUMBER_SEQUENCE + CARDSEQUENCE;
                if (CARDNUMBER.length() == 10) {
                    //返回 CARDNUMBER 更新 Sequence 表
                    cardMapper.UpdateCardNumberMaxValue(CARDSEQUENCE + 1, CARDNUMBER_SEQUENCE_KEY);
                }
            }
            return CARDNUMBER;
        } finally {
            lock.unlock();
        }
    }

}
