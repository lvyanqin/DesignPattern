/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.controller;

import com.demo.helper.Phone;
import com.demo.helper.SocketAdapter;
import com.demo.helper.ForeignSocketImp;
import com.demo.helper.ChineseSocketImp;
import com.demo.helper.ForeignSocketI;
import com.demo.helper.ChineseSocketI;

/**
 *
 * @author Administrator
 */
public class SocketAdapterMain {

    public static void main(String[] args){
        //国内
        System.out.println("===========国内===========");
        ChineseSocketImp socket = new ChineseSocketImp();
        Phone phone = new Phone();
        phone.setChineseSocket(socket);
        phone.printVoltage();

        // 国外
        System.out.println("===========国外===========");
        ForeignSocketImp foreignSocket = new ForeignSocketImp();
        System.out.println("电压是" + foreignSocket.voltage() + "伏特\n");

        System.out.println("===========国外  适配器===========");
        SocketAdapter socketAdapter = new SocketAdapter(foreignSocket);
        System.out.println("电压是" + socketAdapter.voltage() + "伏特\n");

        phone.setChineseSocket(socketAdapter);
        phone.printVoltage();

    }

    
}
