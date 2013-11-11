/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.doubleagamesdev.game.item;

/**
 *
 * @author Philipp Friese
 */
public class SwordOfDebugging extends EquippableItem{

    public static final float SIZE = 32;
    
    private int damage;
    
    public SwordOfDebugging(float x, float y)
    {
        init(x, y, 1.0f, 0.5f, 0, SIZE, SIZE, "Some Sword", WEAPON_SLOT);
        damage = 3;
    }
}

