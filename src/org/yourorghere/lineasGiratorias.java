/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import java.util.Random;
import javax.media.opengl.GL;

public class lineasGiratorias {
    Cubo linea1, linea2, linea3, linea4, linea5, linea6, linea7, linea8;
    float px, py, pz, limite;
    float posx, posy;
    float ang, r;
    GL gl;
    int n;
    int vueltas;
    float desfase;
    public static boolean col = false;
    public lineasGiratorias(float r, float z,int num , GL gl){
      
        this.r = r;
        this.gl = gl;
        this.pz = z;
        this.n = num;
        linea1 = new Cubo(0,0,250,0.7f,0.7f,500,0,0,45,Test.materiales.get("blanco"),gl);
        desfase = -35.5f;
       
        
    }
  
    public void girar() {
        gl.glPushMatrix();
        if(n==1){
         px = r;
         py = r;        
        }
        if(n==2){
         px = 0;
         py = r+desfase;        
        }
        if(n==3){
         px = -r;
         py = r;        
        }
        if(n==4){
         px = -r-desfase;
         py = 0;        
        }
        if(n==5){
         px = -r;
         py = -r;        
        }
         if(n==6){
         px = 0;
         py = -r-desfase;        
        }
         if(n==7){
         px = r;
         py = -r;        
        }
         if(n==8){
         px = r+desfase;
         py = 0;        
        }
         posy= (float) (14.14f*Math.sin(Math.toRadians((ang+22.5f))));
         gl.glRotatef(ang,0,0,1);
         gl.glTranslatef(px,py,pz);
         linea1.display();
         
         gl.glPopMatrix();
    }

}