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
public class DBConnection {
    
    public static void main(String[] args) {
        DBConnection con1 = DataSourceEnum.DATASOURCE.getConnection();
        DBConnection con2 = DataSourceEnum.DATASOURCE.getConnection();
        System.out.println("【】con1 == con2?" + (con1 == con2));
    }
    
}
