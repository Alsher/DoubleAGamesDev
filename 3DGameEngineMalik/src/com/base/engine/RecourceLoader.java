package com.base.engine;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Malik on 02.02.14.
 */
public class RecourceLoader {
    public static String loadShader(String fileName){
        StringBuilder shaderSource = new StringBuilder();
        BufferedReader shaderReader = null;

        try{
            shaderReader = new BufferedReader(new FileReader("./res/shaders/" + fileName));
            String line;
            while ((line = shaderReader.readLine()) != null)
            {
                shaderSource.append(line).append("/n");
            }

            shaderReader.close();
        }
        catch(Exception e){
            e.printStackTrace();
            System.exit(1);
        }

        return shaderSource.toString();
    }
}