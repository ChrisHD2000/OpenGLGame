/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
/**
 *
 * @author fing.labcom
 */
public class ManejadorTeclado implements KeyListener {
    public static AudioStream audios;
    public AudioStream audios2;
    InputStream music, transition;
    public void start(){
        if(Test.esMenu == true){
         try{
                music = new FileInputStream(new File("bgm2.wav"));
                audios = new AudioStream(music);
                AudioPlayer.player.start(audios);

                }
                catch(Exception e){
                    System.out.println("ERROR");
                 }
        }
     
    
    }
    public void transition(){
        if(Test.esMenu == true){
         try{
                transition = new FileInputStream(new File("transition.wav"));
                audios2 = new AudioStream(transition);
                AudioPlayer.player.start(audios2);
                
                }
         catch(Exception e){
                    System.out.println("ERROR");
                 }
        }
        
        
      
    
    
    }
    @Override
    public void keyTyped(KeyEvent e) {
    if(Test.esMenu == true){
          if(e.getKeyChar() == KeyEvent.VK_ENTER){
        if(Test.arriba == true){
          Test.start = true;
          start();
        }else{
          System.exit(0);
        }
    }
    if(e.getKeyChar() == 'w'){
        Test.arriba= true;
        transition();
    }
    if(e.getKeyChar() == 's'){
        Test.arriba = false;
        transition();
    }
    }           
  
    }

    @Override
    public void keyPressed(KeyEvent e) {
       if(e.getKeyChar() == 'a'){
        Test.rotH = true;
        Test.rotAH = false;
        }
       if(e.getKeyChar() == 'd'){
        Test.rotAH = true;
        Test.rotH = false;
        }   
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar() == 'a'){
        Test.rotH = false;
        Test.rotAH = false;
        }
       if(e.getKeyChar() == 'd'){
        Test.rotAH = false;
        Test.rotH = false;
        }   
    }
    
}
