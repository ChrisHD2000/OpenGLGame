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
public class Cilindro {
    public float x,y,z;
    public float w,h,d;
    public float rx,ry;
    public Material material;
    
    public float radio1, radio2;
    int slices, stacks;
    public GL gl;
     public Cilindro(float x, float y, float z,float w, float h, float d,float rx, float ry, float radio1, float radio2, int slices, int stacks, GL gl, Material material){
        this.x=x;
        this.y=y;
        this.z=z;
        this.w =w;
        this.h =h;
        this.d =d;
        this.rx = rx;
        this.ry=ry;
        this.material = material;
        this.radio1=radio1;
        this.radio2=radio2;
        this.slices=slices;
        this.stacks=stacks;
        this.gl = gl;
    }
    public void display(){
    GLU glu = new GLU();
    gl.glPushMatrix();
    material.activar();
    gl.glRotatef(rx,1,0,0);
     gl.glTranslatef(x,y,z);
     
     gl.glRotatef(ry,0,1,0);
     gl.glScalef(w,h,d);
     
     GLUquadric cilindro = glu.gluNewQuadric();
     glu.gluCylinder(cilindro, radio1, radio2,h , slices, stacks);
     gl.glPopMatrix();
}
    
    
}
