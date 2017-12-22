
package com.demo.config.pay;


import java.sql.Timestamp;
import com.demo.util.DateUtil;

public class CardConfig {

    /**
     * PC端钻石卡价格
     */
    public static final int card_total = 368;

    /**
     * 网络订单生成卡年份
     */
//    public static final int GenerateCardYear = 2017;
//    public static final Timestamp cardExpirationTime = DateUtil.getTimestamp("2017-08-31");
    public static final int GenerateCardYear = DateUtil.getYearInt();
    public static final Timestamp cardExpirationTime = DateUtil.getTimestamp((DateUtil.getYearInt()+1) + "-08-31");

    /**
     * 生成订单号序列-键 切记与数据库表Sequence中的Keys字段保持一致 www.diyigaokao.com
     * 站点value="订单号"；edu.163.diyigaokao.com 站点value="订单号163
     */
    public static final String ORDER_SEQUENCE_KEY = "订单号";
    public static final String ORDER_SEQUENCE_KEY_163 = "订单号163";

    /**
     * 生成卡号序列-键 切记与数据库表Sequence中的Keys字段保持一致 www.diyigaokao.com
     * 站点value="虚拟卡段"；edu.163.diyigaokao.com 站点value="虚拟卡段163"
     */
    public static final String CARDNUMBER_SEQUENCE_KEY = "虚拟卡段";
    public static final String CARDNUMBER_SEQUENCE_KEY_163 = "虚拟卡段163";

    /**
     * 生成订单号序列 目的与其它站点区分 www.diyigaokao.com 站点value="0"；edu.163.diyigaokao.com
     * 站点value="1"
     */
    public static final String ORDER_SEQUENCE = "0";
    public static final String ORDER_SEQUENCE_163 = "1";
    public static final String ORDER_UPDATECARD = "2";

    /**
     * 生成卡号序列 目的与其它站点区分 www.diyigaokao.com 站点value="0"；edu.163.diyigaokao.com
     * 站点value="1"
     */
    public static final String CARDNUMBER_SEQUENCE = "0";
    public static final String CARDNUMBER_SEQUENCE_163 = "1";

    /**
     * 生成订单号序列-描述 目的与其它站点区分，其中站点序列号应与 ORDER_SEQUENCE 的value一样
     */
    public static final String ORDER_SEQUENCE_DESCRIPTION = "年月日时分秒+站点序列号+3位数序列(3位数序列从100至999)，如141217162735+{0}+{103}";

    /**
     * 生成卡号序列-描述 目的与其它站点区分，其中站点序列号应与 CARDNUMBER_SEQUENCE 的value一样
     */
    public static final String CARDNUMBER_SEQUENCE_DESCRIPTION = "100000 卡号规则3位高考年份+站点序列号+6位的序列号（6位序列号从100000至999999），如017+{0}+{100000}";

}
