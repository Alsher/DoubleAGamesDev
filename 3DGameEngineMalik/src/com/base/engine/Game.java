package com.base.engine;

import org.lwjgl.input.Keyboard;

/**
 * Created by Malik on 19.01.14.
 */
public class Game {

    private Mesh mesh;
    private Shader shader;
    private Transform transform;

    public Game(){
        mesh = new Mesh();
        shader = new Shader();

        Vertex[] vertices = new Vertex[] {new Vertex(new Vector3f(-1,-1, 0)),
                                      new Vertex(new Vector3f(-1, 1, 0)),
                                      new Vertex(new Vector3f( 0, 1, 0)),
                                      new Vertex(new Vector3f( 0,-1, 1)),};

        int[] indices = new int[]{0,1,3,
                                  3,1,2,
                                  2,1,0,
                                  0,2,3};

        mesh.addVertices(vertices, indices);

        transform = new Transform();

        shader.addVertexShader(RecourceLoader.loadShader("basicVertex.vs"));
        shader.addFragmentShader(RecourceLoader.loadShader("basicFragment.fs"));
        shader.compileShader();

        shader.addUniform("transform");
    }

    public void input(){
        if(Input.getKeyDown(Keyboard.KEY_UP))
            System.out.println("up");
        if(Input.getKeyUp(Keyboard.KEY_UP))
            System.out.println("released up");

        if(Input.getMouseDown(1))
            System.out.println("right click");
        if(Input.getMouseUp(1))
            System.out.println("released right click");
    }

    float temp = 0.0f;

    public void update(){
        temp += Time.getDelta();

        float sinTemp = (float)Math.sin(temp);

        transform.setTranslation(sinTemp, 0, 0);
        transform.setRotation(0 ,sinTemp * 180, 0);
        transform.setScale(sinTemp, sinTemp, sinTemp);
    }

    public void render(){
        shader.bind();
        shader.setUniform("transform", transform.getTransformation());
        mesh.draw();
    }
}
