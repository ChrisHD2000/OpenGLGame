/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;
import javax.media.opengl.GL;
/**
 *
 * @author Christian
 */
public class AnimacionEscenario {
    float px, py, pz, rot;
    Cilindro arcos; 
    GL gl;
    public AnimacionEscenario(float x, float y, float z,float rot, GL gl){
        this.px = x;
        this.py = y;
        this.pz = z;
        this.gl = gl;
        arcos = new Cilindro(0,0,150, 1,1,2,0,0,20,20,8,8,gl, Test.materiales.get("blanco"));
        this.rot = rot;
    }
    public void animar(){
    pz-=2.5f-Test.acele;
    gl.glPushMatrix();
    gl.glRotatef(rot,1,0,0);
    gl.glTranslatef(px,py,pz);
    arcos.display();
    if(pz<=-150){
             pz = 800;
             
    }
        //System.out.println(pz);
    gl.glPopMatrix();
    }
}
