/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.controller;

/**
 *
 * @author Administrator
 */
public class AdapterMain {
    
   public static void main(String[] args) {
       HeadSet_Common_Adapter adapter = new HeadSet_Common_Adapter(new HeadSet_Common());
       adapter.HeadSet();
   }
    
}

//耳机
class HeadSet_Common_Adapter{
    
    private HeadSet_Common headSetCommon;

    public HeadSet_Common_Adapter(HeadSet_Common headSetCommon) {
        this.headSetCommon = headSetCommon;
    }
    
    public void HeadSet(){
        System.out.println("我是2.5mm的耳机孔");
        System.out.println("使用中。。。。");
        headSetCommon.HeadSet();
    }
    
}

//耳机
class HeadSet_Common{
    
    public void HeadSet(){
        System.out.println("我是3.5mm的耳机孔");
    }
    
}
