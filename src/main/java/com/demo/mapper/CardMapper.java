package com.demo.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import com.demo.bean.SequenceBean;
import org.apache.ibatis.annotations.Update;

public interface CardMapper {


    /**
     * 查询 Sequence(网络订单前程卡的卡号) 字段的最大值
     *
     * @param keys
     * @return
     */
    @Select("select Value from Sequence  where Keys=#{keys}")
    String getCardNumberSequenceMaxValue(@Param("keys") String keys);
    
    /**
     * 插入一条sequence（网络订单前程卡卡号）最大值信息到数据库
     *
     * @param sequenceBean
     * @return
     */
    @Insert("insert into Sequence(Keys,Value,Description) values (#{sequence.keys},#{sequence.value},#{sequence.description})")
    @SelectKey(statement = "SELECT @@IDENTITY as id", keyProperty = "sequence.id", keyColumn = "id", before = false, resultType = int.class)
    int insertSequenceDetail(@Param("sequence") SequenceBean sequenceBean);
    
    /**
     * 修改网络订单前程卡卡号最大卡号值
     *
     * @param value
     * @param keys
     * @return
     */
    @Update("update Sequence set Value=#{Value} where Keys=#{Keys}")
    int UpdateCardNumberMaxValue(@Param("Value") int value, @Param("Keys") String keys);

}
