/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;
import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;
/**
 *
 * @author Christian
 */
public class Esfera {
  //  GLU  glu = new GLU ();
    public float x,y,z;
    public float w,h,d;
    public float radio, slices, stacks;
    public GL gl;
    public Material material;
    
    public Esfera(float x, float y, float z,float w, float h, float d, float radio, float slices, float stacks,Material m, GL gl){
        this.x=x;
        this.y=y;
        this.z=z;
        this.w =w;
        this.h =h;
        this.d =d;
        this.material = m;
        this.radio=radio;
        this.slices=slices;
        this.stacks=stacks;
        this.gl = gl;
    }
    public void display(){
        gl.glPushMatrix();
    GLU glu = new GLU();
    material.activar(); 
     gl.glTranslatef(x,y,z);
     gl.glScalef(w,h,d);
 
     GLUquadric esfera = glu.gluNewQuadric();
     glu.gluSphere(esfera, radio, 10, 10);
     gl.glPopMatrix();
}
    
    
}
