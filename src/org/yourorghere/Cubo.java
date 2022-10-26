/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;
import com.sun.opengl.util.texture.Texture;
import javax.media.opengl.GL;
/**
 *
 * @author GaryPC
 */
public class Cubo {
    GL gl;
    float x,y,z;
    float w,h,d;
    Material material;
    float rx,ry,rz;
    public Texture t;
    // Ahora creamos el constructor
    public Cubo (float x,float y,float z,float w,float h,float d,float rx, float ry, Material Material, GL gl){
        this.x =x;
        this.y =y;
        this.z =z;
        this.w =w;
        this.h =h;
        this.d =d;
        this.material = Material;
        this.rx = rx;
        this.ry = ry;
        this.gl = gl;
    }
        public Cubo (float x,float y,float z,float w,float h,float d,float rx, float ry,float rz, Material Material, GL gl){
        this.x =x;
        this.y =y;
        this.z =z;
        this.w =w;
        this.h =h;
        this.d =d;
        this.material = Material;
        this.rx = rx;
        this.ry = ry;
        this.rz = rz;
        this.gl = gl;
    }
      public Cubo (float x,float y,float z,float w,float h,float d,float rx, float ry,float rz, Material Material, Texture textura, GL gl){
        this.x =x;
        this.y =y;
        this.z =z;
        this.w =w;
        this.h =h;
        this.d =d;
        this.material = Material;
        this.rx = rx;
        this.ry = ry;
        this.rz = rz;
        this.gl = gl;
        this.t = textura;
    }
    public void display(){
        gl.glPushMatrix();
        this.material.activar();
        if(this.t!= null){
            this.t.enable();
            this.t.bind();
        }
        gl.glTranslatef(x,y,z);
        gl.glRotatef(rx,1,0,0);
        gl.glRotatef(ry,0,1,0);
        gl.glRotatef(rz,0,0,1);
        gl.glScalef(w,h,d);
        gl.glBegin(GL.GL_QUADS);
           // gl.glColor3f(r, g,b);
            gl.glNormal3f(0,0,1);
            gl.glTexCoord2f(1, 1);
            gl.glVertex3f(1, 1, 1);
            gl.glTexCoord2f(1, 0);
            gl.glVertex3f(1, -1, 1);
            gl.glTexCoord2f(0, 0);
            gl.glVertex3f(-1, -1, 1);
            gl.glTexCoord2f(0, 1);
            gl.glVertex3f(-1, 1, 1);
            
        gl.glEnd();
        
        //cara derecha
        gl.glBegin(GL.GL_QUADS);
        //gl.glColor3f(r, g,b);
            gl.glNormal3f(1,0,0);
            gl.glTexCoord2f(1, 1);
            gl.glVertex3f(1, 1, 1);
            gl.glTexCoord2f(1, 0);
            gl.glVertex3f(1, 1, -1);
            gl.glTexCoord2f(0, 0);
            gl.glVertex3f(1, -1, -1);
            gl.glTexCoord2f(0, 1);
            gl.glVertex3f(1, -1, 1);
        gl.glEnd();
        // cara trasera
        gl.glBegin(GL.GL_QUADS);
         // gl.glColor3f(r, g,b);
            gl.glNormal3f(0,0,-1);
            gl.glTexCoord2f(1, 1);
            gl.glVertex3f(1, 1, -1);
            gl.glTexCoord2f(0, 1);
            gl.glVertex3f(-1, 1, -1);
            gl.glTexCoord2f(0, 0);
            gl.glVertex3f(-1, -1, -1);
            gl.glTexCoord2f(1, 0);
            gl.glVertex3f(1, -1, -1);
        gl.glEnd();
        //cara izquierda
        gl.glBegin(GL.GL_QUADS);
          //gl.glColor3f(r, g,b);
            gl.glNormal3f(-1,0,0);
            gl.glTexCoord2f(1, 0);
            gl.glVertex3f(-1, 1, -1);
            gl.glTexCoord2f(1, 1);
            gl.glVertex3f(-1, 1, 1);
            gl.glTexCoord2f(0, 1);
            gl.glVertex3f(-1, -1, 1);
            gl.glTexCoord2f(0, 0);
            gl.glVertex3f(-1, -1, -1);
        gl.glEnd();
        //cara superior
        gl.glBegin(GL.GL_QUADS);
         // gl.glColor3f(r, g,b);
            gl.glNormal3f(0,1,0);
            gl.glTexCoord2f(1, 1);
            gl.glVertex3f(1, 1, 1);
            gl.glTexCoord2f(1, 0);
            gl.glVertex3f(1, 1, -1);
            gl.glTexCoord2f(0, 0);
            gl.glVertex3f(-1, 1, -1);
            gl.glTexCoord2f(0, 1);
            gl.glVertex3f(-1, 1, 1);
        gl.glEnd();
        //cara inferior
        gl.glBegin(GL.GL_QUADS);
     //  gl.glColor3f(r, g,b);
            gl.glNormal3f(0,-1,0);
            gl.glTexCoord2f(0, 0);
            gl.glVertex3f(-1, -1, -1);
            gl.glTexCoord2f(0, 1);
            gl.glVertex3f(-1, -1, 1);
            gl.glTexCoord2f(1, 1);
            gl.glVertex3f(1, -1, 1);
            gl.glTexCoord2f(1, 0);
            gl.glVertex3f(1, -1, -1);
        gl.glEnd();
         if(this.t!= null){
            this.t.disable();
           
        }
        gl.glPopMatrix();
    } 
 
}
