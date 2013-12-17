/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.gameobject;

import com.base.engine.GameObject;

/**
 *
 * @author Malik
 */
public class statObject extends GameObject{ 
    protected Stats stats;
    
    public void damage(int amt){
        stats.damage(amt);
    }
    public float getSpeed(){
        return stats.getSpeed();
    }
    
    public int getLevel(){
        return stats.getLevel();
    }
    
    public int getMaxHealth(){
        return stats.getMaxHealth();
    }
    
    public int getCurrentHealth(){
        return stats.getCurrentHealth();
    }
    
    public float getStrength(){
        return stats.getStrength();
    }
    
    public float getMagic(){
        return stats.getMagic();
    }
}
