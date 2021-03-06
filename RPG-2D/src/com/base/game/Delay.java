/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.game;

/**
 *
 * @author Malik
 */
public class Delay {
    
    private int lenght;
    private long endTime;
    boolean started;
    
    public Delay(int lenght){
        this.lenght = lenght;
        started = false;
    }
    public boolean isOver(){
        if(!started) return false;
        
        return Time.getTime() > endTime;
        
    }
    public boolean isActive(){
        return started;
    }
    public void restart(){
        started = true;
        endTime = lenght * 1000000 + Time.getTime();
    }
    public void stop(){
        started = false;
    }
    public void terminate(){
        started = true;
        endTime = 0;
    }
}
