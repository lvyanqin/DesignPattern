package com.demo.helper;


public class Phone {
    
    ChineseSocketI chineseSocket;

    public Phone() {}

    public void setChineseSocket(ChineseSocketI chineseSocket){
        this.chineseSocket = chineseSocket;
    }

    public void printVoltage(){
        System.out.println("手机" + chineseSocket.voltage() + " 伏特充电中\n");
    }
}
