/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Random;
import javax.media.opengl.GL;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
/**
 *
 * @author Christian
 */
public class EnMedio implements Enemigo{
    Cubo Enemigo;
    float px, py, pz, limite, angSup, angInf;
    float posx, posy;
    float ang, r;
    GL gl;
    Random random;
    int n, indice;
    int vueltas;
    public AudioStream audios;
    InputStream music;
    public EnMedio(float r, float z,float rx, GL gl){
        this.random = new Random();        
        this.r = r;
        this.ang = ang;
        this.gl = gl;
        this.pz = z;
        limite = -pz;
        Enemigo = new Cubo(0,0,pz,4,18,4,0,0,45,Test.materiales.get("rojo"),Test.texturas.get("tcubo"),gl);
        n = 1;
    }
    @Override
    public void desplazar() {
        gl.glPushMatrix();
         pz-=2.5f-Test.acele;
         px = r;
         py = r;
         vueltas = (int)((ang+22.5f)/360)+1;
         
        if(pz<=limite){
             pz = 500;             
             indice =  random.nextInt(8);
             n = 2*indice+1;            
         }
        //System.out.println(ang+22.5f);
       if(pz<limite+3){
         if((Math.sin(Math.toRadians(ang+22.5f))<0.913f)&&(Math.sin(Math.toRadians(ang+22.5f))>0.374f)&&(Math.cos(Math.toRadians(ang+22.5f))<0)){
             Test.col = true; 
             colisionar();
         }
          if((Math.sin(Math.toRadians(ang+22.5f))>-0.961f)&&(Math.sin(Math.toRadians(ang+22.5f))<-0.366f)&&(Math.cos(Math.toRadians(ang+22.5f))>0)){
              Test.col = true; 
             colisionar();
         }
       }
        else{
            Test.col = false;
            }
         posy= (float) (14.14f*Math.sin(Math.toRadians((ang+22.5f))));
         gl.glRotatef(ang+22.5f,0,0,1);
         gl.glTranslatef(px,py,pz);
         Enemigo.display();
         gl.glPopMatrix();
    }
    @Override
    public void colisionar() {
        
 
        Test.lives--;
         try{
                music = new FileInputStream(new File("explo.wav"));
                audios = new AudioStream(music);
                AudioPlayer.player.start(audios);
                if(Test.lives==0){
                AudioPlayer.player.stop(ManejadorTeclado.audios);
                }
                }
                catch(Exception e){
                    System.out.println("ERROR");
                 }
         
    }
    @Override
    public void regresar(){
       
       System.out.println("REGRESANDOOOOOOOOOOOOO");
    }
}
