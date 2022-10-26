/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.media.opengl.GL;
import java.util.Random;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
/**
 *
 * @author Christian
 */
public class EnFacil implements Enemigo{
    Cubo Enemigo;
    float px, py, pz, limite;
    float posx, posy;
    float ang, r;
    GL gl;
    int tipo;
    Random random;
    int n, indice;
    int vueltas;
    public AudioStream audios;
    InputStream music;
    public static boolean col = false;
    public EnFacil(float r, float z,int tipo, GL gl){
        this.random = new Random();        
        this.r = r;
        this.ang = ang;
        this.gl = gl;
        this.pz = z;
        limite = -pz;
        Enemigo = new Cubo(0,0,pz,4,4,4,0,0,45,Test.materiales.get("rojo"),Test.texturas.get("tcubo"),gl);
        n = 1;
        this.tipo = tipo;
        
    }
    @Override
    public void desplazar() {
        gl.glPushMatrix();
        if(tipo == 1){
            pz-=2.5f-Test.acele;
            px = r;
            py = r;
            vueltas = (int)((ang+22.5f)/360)+1;

            if(pz<=limite ){
                pz = 500;             
           
            }

            if(pz<limite+3){
                if((Math.sin(Math.toRadians(ang))<0)&&(Math.sin(Math.toRadians(ang))>-0.766f)&&(Math.cos(Math.toRadians(ang))<0)){
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
        }
        if(tipo == 2){
            pz-=2.5f-Test.acele;
            px = 0;
            py = r+5;
            vueltas = (int)((ang+22.5f)/360)+1;
            Enemigo.rz = 0;
            if(pz<=limite ){
                pz = 500;                      
            }
            //System.out.println(ang);
            if(pz<limite+3){
                if((Math.sin(Math.toRadians(ang))<0.788f)&&(Math.sin(Math.toRadians(ang))>-0.0348f)&&(Math.cos(Math.toRadians(ang))<0)){
                    //System.out.println("COLISION");       
                    //System.out.println("COLISION"); 
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
        }
        if(tipo == 3){
            pz-=2.5f-Test.acele;
            px = -r;
            py = r;
            vueltas = (int)((ang+22.5f)/360)+1;
            Enemigo.rz = 45;
            if(pz<=limite ){
                pz = 500;             
           
            }
           // System.out.println(ang);
            if(pz<limite+3){
                if((Math.sin(Math.toRadians(ang))<0.9993f)&&(Math.sin(Math.toRadians(ang))>0.719f)&&(Math.cos(Math.toRadians(ang))<0)){
                    //System.out.println("COLISION");       
                    //System.out.println("COLISION"); 
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
        }
        if(tipo == 4){
            pz-=2.5f-Test.acele;
            px = -r-5;
            py = 0;
            vueltas = (int)((ang+22.5f)/360)+1;
            Enemigo.rz = 0;
            if(pz<=limite ){
                pz = 500;             
          
            }
            //System.out.println(ang);
            if(pz<limite+3){
                if((Math.sin(Math.toRadians(ang))<0.9993f)&&(Math.sin(Math.toRadians(ang))>0.719f)&&(Math.cos(Math.toRadians(ang))>0)){
                    //System.out.println("COLISION");       
                    //System.out.println("COLISION"); 
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
        }
        if(tipo == 5){
            pz-=2.5f-Test.acele;
            px = -r;
            py = -r;
            vueltas = (int)((ang+22.5f)/360)+1;
            Enemigo.rz = 45;
            if(pz<=limite ){
                pz = 500;             
           
            }
            //System.out.println(ang);
            if(pz<limite+3){
                if((Math.sin(Math.toRadians(ang))<0.7193f)&&(Math.sin(Math.toRadians(ang))>0.069f)&&(Math.cos(Math.toRadians(ang))>0)){
                    //System.out.println("COLISION");       
                    //System.out.println("COLISION"); 
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
        }
        if(tipo == 6){
            pz-=2.5f-Test.acele;
            px = 0;
            py = -r-5f;
            vueltas = (int)((ang+22.5f)/360)+1;
            Enemigo.rz = 0;
            if(pz<=limite ){
                pz = 500;             
           
            }
           // System.out.println(ang);
            if(pz<limite+3){
                if((Math.sin(Math.toRadians(ang))<=0)&&(Math.sin(Math.toRadians(ang))>-0.7193f)&&(Math.cos(Math.toRadians(ang))>0)){
                    //System.out.println("COLISION");       
                    //System.out.println("COLISION"); 
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
        }
        if(tipo == 7){
            pz-=2.5f-Test.acele;
            px = r;
            py = -r;
            vueltas = (int)((ang+22.5f)/360)+1;
            Enemigo.rz = 45;
            if(pz<=limite ){
                pz = 500;             
         
            }
            //System.out.println(ang);
            if(pz<limite+3){
                if((Math.sin(Math.toRadians(ang))<=-0.6946f)&&(Math.sin(Math.toRadians(ang))>-1f)&&(Math.cos(Math.toRadians(ang))>0)){
                    //System.out.println("COLISION");       
                    //System.out.println("COLISION"); 
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
        }
        if(tipo == 8){
            pz-=2.5f-Test.acele;
            px = r+5;
            py = 0;
            vueltas = (int)((ang+22.5f)/360)+1;
            Enemigo.rz = 0;
            if(pz<=limite ){
                pz = 500;             
           
            }
            //System.out.println(ang);
            if(pz<limite+3){
                if((Math.sin(Math.toRadians(ang))>=-0.9975f)&&(Math.sin(Math.toRadians(ang))<-0.6691f)&&(Math.cos(Math.toRadians(ang))<0)){
                    //System.out.println("COLISION");       
                    //System.out.println("COLISION"); 
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
        }
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
