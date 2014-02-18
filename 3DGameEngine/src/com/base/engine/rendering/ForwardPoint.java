package com.base.engine.rendering;

import com.base.engine.components.PointLight;
import com.base.engine.core.Matrix4f;
import com.base.engine.core.Transform;

public class ForwardPoint extends Shader
{
    private static final ForwardPoint instance = new ForwardPoint();

    public static ForwardPoint getInstance()
    {
        return instance;
    }

    private ForwardPoint()
    {
        super();

        addVertexShaderFromFile("forward-point.vs");
        addFragmentShaderFromFile("forward-point.fs");
        compileShader();



        addUniform("MVP");
        addUniform("model");

        addUniform("specularIntensity");
        addUniform("specularPower");
        addUniform("eyePos");


            addUniform("pointLight.base.color");
            addUniform("pointLight.base.intensity");
            addUniform("pointLight.atten.constant");
            addUniform("pointLight.atten.linear");
            addUniform("pointLight.atten.exponent");
            addUniform("pointLight.position");
            addUniform("pointLight.range");

    }

    public void updateUniforms(Transform transform, Material material)
    {
        Matrix4f worldMatrix = transform.getTransformation();
        Matrix4f projectedMatrix = getRenderingEngine().getMainCamera().getViewProjection().mul(worldMatrix);
        material.getTexture().bind();

        setUniform("MVP", projectedMatrix);
        setUniform("model", worldMatrix);

        setUniformf("specularIntensity", material.getSpecularIntensity());
        setUniformf("specularPower", material.getSpecularPower());

        setUniform("eyePos", getRenderingEngine().getMainCamera().getPos());
        setUniform("pointLight", getRenderingEngine().getActivePointLight());
    }

    public void setUniform(String uniformName, BaseLight baseLight)
    {
        setUniform(uniformName + ".color", baseLight.getColor());
        setUniformf(uniformName + ".intensity", baseLight.getIntensity());
    }

    public void setUniform(String uniformName, PointLight pointLight)
    {
        setUniform(uniformName + ".base", pointLight.getBaseLight());
        setUniformf(uniformName + ".atten.constant", pointLight.getAtten().getConstant());
        setUniformf(uniformName + ".atten.linear", pointLight.getAtten().getLinear());
        setUniformf(uniformName + ".atten.exponent", pointLight.getAtten().getExponent());
        setUniform(uniformName + ".position", pointLight.getPosition());
        setUniformf(uniformName + ".range", pointLight.getRange());
    }
}
