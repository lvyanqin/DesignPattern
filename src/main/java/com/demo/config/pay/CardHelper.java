/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.config.pay;

import com.demo.bean.SequenceBean;
import com.demo.mapper.CardMapper;
import com.demo.util.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrator
 */
@Component
public class CardHelper {
 
    @Autowired
    private static CardMapper cardMapper;

    public String GenerateCardNumber() {
            String CARDNUMBER_SEQUENCE_KEY = "";
            String CARDNUMBER_SEQUENCE = "";
            String CARDNUMBER_SEQUENCE_DESCRIPTION = CardConfig.CARDNUMBER_SEQUENCE_DESCRIPTION;
            
            CARDNUMBER_SEQUENCE_KEY = CardConfig.CARDNUMBER_SEQUENCE_KEY;
            CARDNUMBER_SEQUENCE = CardConfig.CARDNUMBER_SEQUENCE;

            int CARDSEQUENCE = 0;
            synchronized(CardHelper.class){
                String value = cardMapper.getCardNumberSequenceMaxValue(CARDNUMBER_SEQUENCE_KEY);
                if (StringUtils.isNotBlank(value)) {
                    CARDSEQUENCE = Integer.parseInt(value);
                }

                if (CARDSEQUENCE <= 0) {
                    CARDSEQUENCE = 100000;
                    SequenceBean sequence = new SequenceBean();
                    sequence.setKeys(CARDNUMBER_SEQUENCE_KEY);
                    sequence.setValue(String.valueOf(CARDSEQUENCE));
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
            }
    }

}
