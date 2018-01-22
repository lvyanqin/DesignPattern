
package com.demo.helper;

public class SocketAdapter implements ChineseSocketI {
    ForeignSocketI foreignSocket; 
    

    public SocketAdapter(ForeignSocketI foreignSocket){
        this.foreignSocket = foreignSocket;
    }

    @Override
    public int voltage(){
        return foreignSocket.voltage() * 2; // 适配器把电压从 110V 升到 220V 
    }

}