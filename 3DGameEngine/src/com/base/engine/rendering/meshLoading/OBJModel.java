package com.base.engine.rendering.meshLoading;


import com.base.engine.core.Util;
import com.base.engine.core.Vector2f;
import com.base.engine.core.Vector3f;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class OBJModel {

    private ArrayList<Vector3f> positions;
    private ArrayList<Vector2f> texCoords;
    private ArrayList<Vector3f> normals;
    private ArrayList<OBJIndex> indices;
    private boolean hasTexCoords;
    private boolean hasNormals;


    public OBJModel(String fileName)
    {
        positions = new ArrayList<>();
        texCoords = new ArrayList<>();
        normals = new ArrayList<>();
        indices = new ArrayList<>();
        hasTexCoords = false;
        hasNormals = false;

        BufferedReader meshReader = null;

        try
        {
            meshReader = new BufferedReader(new FileReader(fileName));
            String line;

            while((line = meshReader.readLine()) != null)
            {
                String[] tokens = line.split(" ");
                tokens = Util.removeEmptyStrings(tokens);

                if(tokens.length == 0 || tokens[0].equals("#"))
                    continue;
                else if(tokens[0].equals("v"))
                {
                    positions.add(new Vector3f( Float.valueOf(tokens[1]),
                                                Float.valueOf(tokens[2]),
                                                Float.valueOf(tokens[3])));
                }
                else if(tokens[0].equals("vt"))
                {
                    texCoords.add(new Vector2f( Float.valueOf(tokens[1]),
                                                Float.valueOf(tokens[2])));
                }
                else if(tokens[0].equals("vn"))
                {
                    normals.add(new Vector3f(   Float.valueOf(tokens[1]),
                                                Float.valueOf(tokens[2]),
                                                Float.valueOf(tokens[3])));
                }
                else if(tokens[0].equals("f"))
                {
                    for(int i = 0; i < tokens.length - 3; i++)
                    {
                        indices.add(parseOBJIndex(tokens[1]));
                        indices.add(parseOBJIndex(tokens[2 + i]));
                        indices.add(parseOBJIndex(tokens[3 + i]));
                    }
                }
            }

            meshReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private OBJIndex parseOBJIndex(String token)
    {
        String[] values = token.split("/");

        OBJIndex result = new OBJIndex();
        result.vertexIndex = Integer.parseInt(values[0]) - 1;


        if(values.length > 1)
        {
            hasTexCoords = true;
            result.texCoordIndex = Integer.parseInt(values[1]) - 1;
            if(values.length > 2)
            {
                hasNormals = true;
                result.normalIndex = Integer.parseInt(values[2]) - 1;
            }
        }

        return result;
    }

    public ArrayList<Vector3f> getPositions() {
        return positions;
    }
    public ArrayList<Vector2f> getTexCoords() {
        return texCoords;
    }
    public ArrayList<Vector3f> getNormals() {
        return normals;
    }
    public ArrayList<OBJIndex> getIndices()
    {
        return indices;
    }
}