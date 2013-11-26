/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.engine;

import java.awt.Rectangle;

/**
 *
 * @author Malik
 */
public class Physiks {
    public static boolean checkCollision(GameObject go1, GameObject go2){
        Rectangle r1 = new Rectangle((int)go1.getX(), (int)go1.getSX(), (int)go1.getY(), (int)go1.getSY());
        Rectangle r2 = new Rectangle((int)go2.getX(), (int)go2.getSX(), (int)go2.getY(), (int)go2.getSY());
        
        return r1.intersects(r2);
    }
}