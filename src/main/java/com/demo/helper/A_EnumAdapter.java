/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.helper;

import java.util.Enumeration;
import java.util.Iterator;

/**
 *
 * @author Administrator
 */
public class A_EnumAdapter implements Iterator{

    private Enumeration e;
    
    public A_EnumAdapter(Enumeration e){
        this.e = e;
    }
    
    @Override
    public boolean hasNext() {
        return e.hasMoreElements();
    }

    @Override
    public Object next() {
        return e.nextElement();
    }
    
}
