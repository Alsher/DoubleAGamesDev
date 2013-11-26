/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.game;

import com.base.engine.GameObject;
import com.base.gameobject.Player;
import com.base.gameobject.items.Cube;
import java.util.ArrayList;
import org.lwjgl.opengl.Display;

/**
 *
 * @author Malik
 */
public class Game {
    
    private ArrayList<GameObject> objects;
    private Player player;
    
    public Game(){
        objects = new ArrayList<GameObject>();
        
        player = new Player(Display.getWidth() / 2 - Player.SIZE / 2,Display.getHeight() / 2 - Player.SIZE / 2);
        
        objects.add(player);
        objects.add(new Cube(32,32));
    }
    public void getInput(){
        player.getInput();
    }
    public void update(){
        for(GameObject go : objects)
            go.update();
    }
    public void render(){
        for(GameObject go : objects)
            go.render();
    }
}