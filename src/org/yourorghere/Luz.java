package org.yourorghere;

import javax.media.opengl.GL;

public class Luz {
    float[] position;
    float [] ambient, diffuse, specular;
    int id_luzopengl;
    boolean activado,  bombilla_visible;
    Material colorBombilla = Test.materiales.get("cemento");
   // float[] ambientCubo, diffuseCubo, specularCubo, emissiveCubo;
    float shininess;
    Cubo bombilla;
    GL gl;
    
    public Luz(float[] position, float[] ambient, float[] diffuse, float[] specular, GL gl, int id_luzopengl, boolean bombilla_visible){
        this.position = position;
        this.ambient = ambient;
        this.gl = gl;
        this.id_luzopengl = id_luzopengl;
        this.activado = activado;
        this.bombilla_visible = bombilla_visible;
        
        this.bombilla = new Cubo(0,0,0,.5f,.5f,.5f,0,0,colorBombilla,gl);
        this.activate();
        ambient[0] = ambient[0] /255;
        ambient[1] = ambient[1] /255;
        ambient[2] = ambient[2] /255;
        
        diffuse[0] = diffuse[0] /255;
        diffuse[1] = diffuse[1] /255; 
        diffuse[2] = diffuse[2] /255; 
        
        specular[0] = specular[0] /255;
        specular[1] = specular[1] /255;
        specular[2] = specular[2] /255;
        
        this.diffuse = diffuse;
        this.specular = specular;
        this.ambient = ambient;
        
        gl.glLightfv(id_luzopengl, GL.GL_POSITION, this.position,0);
        gl.glLightfv(id_luzopengl, GL.GL_AMBIENT, this.ambient,0);
        gl.glLightfv(id_luzopengl, GL.GL_DIFFUSE, this.diffuse,0);
        gl.glLightfv(id_luzopengl, GL.GL_SPECULAR,this.specular,0);
        
    }
    
    public void display(){
        if(this.bombilla_visible){
            gl.glPushMatrix();
            gl.glTranslatef(position[0], position[1], position [2]);
            this.bombilla.display();
            gl.glPopMatrix();
        }        
    }
    
    public void activate(){
        gl.glEnable(id_luzopengl);
        this.activado = true;
    }
     public void desactivate(){
        gl.glDisable(id_luzopengl);
        this.activado = false;
    }
     
}
