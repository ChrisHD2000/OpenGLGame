package org.yourorghere;

import java.util.ArrayList;
import javax.media.opengl.GL;

public class EscenarioMovil {
    private float movz;
    public float x,y,z, rot;
    public GL gl;
    public Cilindro paredes;
    ArrayList<AnimacionEscenario> arcos = new ArrayList<AnimacionEscenario>();

    public EscenarioMovil(float x, float y, float z, float rot,  GL gl){
        movz = 0;
        this.x = x;
        this.y = y;
        this.z = z;
        this.gl = gl; 
        this.rot = rot;
        paredes = new Cilindro(0,0,0, 1.01f,1.01f,500,0,0,20,20,8,8,gl, Test.materiales.get("pared"));
        for (int i = 125; i>= -50; i=i-10){
            this.arcos.add(new AnimacionEscenario(0,0,i*6, rot,gl));
        }

    }
    public void display(){
        
        
        gl.glPushMatrix();
                
        
        gl.glTranslatef(x,y,z);
        gl.glRotatef(rot,0,0,1);
        paredes.display();
       
        for(AnimacionEscenario arcos:arcos){
               arcos.animar();  
               
              
        }
        gl.glPopMatrix();
    }
    

    
}
