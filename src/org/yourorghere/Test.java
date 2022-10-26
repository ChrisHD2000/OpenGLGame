package org.yourorghere;
import javax.imageio.ImageIO;
import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;
import com.sun.opengl.util.Animator;
import com.sun.opengl.util.j2d.TextRenderer;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Hashtable;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;
import java.io.*;
import java.util.ArrayList;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import java.util.Random;
public class Test implements GLEventListener {

ManejadorTeclado mt = new ManejadorTeclado();
public static Hashtable <String, Texture> texturas;
public static float girar = 0f;
public static boolean rotH = false;
public static boolean rotAH = false;
public static int score, lives;
float iluminar = 0;
Random random;
int rand;
InputStream music;
Luz luz1;
Material blanco, rojo;
Cubo  cubo;
Esfera esfera;
EscenarioMovil EscenarioMovil;
EnFacil en1;
EnFacil en12, en13;
EnMedio en2;
EnDificil en3;
TextRenderer renderer;
lineasGiratorias line0, line2, line3, line4, line5, line6, line7, line8;
public static float acele;
public AudioStream audios;
public static boolean col;
public static boolean start, arriba, esMenu;
ArrayList<EnFacil> Churo  = new ArrayList<EnFacil>();
ArrayList<EnFacil> Churo2  = new ArrayList<EnFacil>();
public static Hashtable <String, Material> materiales;


float r,g,b;
float inv;
    public static void main(String[] args) {
        
        Frame frame = new Frame("Juego Final");
        GLCanvas canvas = new GLCanvas();       
        canvas.addGLEventListener(new Test());
        frame.add(canvas);
        frame.setSize(1000, 1000);
        final Animator animator = new Animator(canvas);
       
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable() {

                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        // Center frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        animator.start();
    }

    public void init(GLAutoDrawable drawable) {
        // Use debug pipeline
        // drawable.setGL(new DebugGL(drawable.getGL()));
        
        GL gl = drawable.getGL();
        lives = 3;
        col = false;
        random = new Random();
        rand = random.nextInt(4)+1;
        System.err.println("INIT GL IS: " + gl.getClass().getName());
        gl.glEnable(GL.GL_LIGHTING);
       // Pir = new Piramide(-5,0,-14,1,1,1,1.0f,1.0f,1.0f,0,0,gl); 
             //casa = new Casa(0,0,-14,1,1,1, 1,0,1, 0,0, gl);
             score = 0;
             texturas = new Hashtable<String, Texture>();
                try{
                    Texture tcubo = TextureIO.newTexture(new File ("tiles.jpg"), false);
                    texturas.put("tcubo", tcubo);
                }
                catch(IOException ex){
                    System.out.println("ERROR LEYENDO FICHERO");
                }
             
            
                 try{
                    music = new FileInputStream(new File("Super Smash Bros. Ultimate - Main Theme.wav"));
                    audios = new AudioStream(music);
                    //AudioPlayer.player.start(audios);
                }
                catch(Exception e){
                    System.out.println("ERROR");
                 }
             renderer = new TextRenderer (new Font("Rockwell Extra Bold",Font.ITALIC,75));
             
             float [] posluz1 = {0,0,0,1};
             float [] aluz1 = {100, 100, 100, 1};
             float [] dluz1 = {100, 100, 100, 1};
             float[] sluz1 = {255,255,255,1};
             
             materiales = new Hashtable<String, Material>();
             luz1 = new Luz(posluz1,aluz1,dluz1,sluz1,gl,GL.GL_LIGHT0,true);
              
              float [] acemento = {20,20,20};
              float [] dcemento = {20,20,20};
              float [] scemento = {0,0,0};
              float [] ecemento = {0,0,0};
              float shininess = 2;
              Material pared = new Material(acemento, dcemento, scemento, ecemento, shininess, gl );
              materiales.put("pared", pared);
            //creamos los materiales
            float [] a_blanco = {255,255,255};     
             float [] d_blanco = {100, 100, 100};
             float [] s_blanco = {0, 0, 0};
             float[] e_blanco = {255,255,255};
             blanco = new Material(a_blanco, d_blanco, s_blanco, e_blanco,1f, gl);
             materiales.put("blanco", blanco);
             
             float [] a_rojo = {255,180,0};
             float [] d_rojo = {255, 150, 0};
             float [] s_rojo = {255, 255, 255};
             float[] e_rojo = {0,0,0};
             rojo = new Material(a_rojo, d_rojo, s_rojo, e_rojo,0.98f, gl);
             materiales.put("rojo", rojo);
             esfera = new Esfera (0,0,150,1,1,1,5f,10,10,rojo,gl);
        
               /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
             //////////////////////////Creación de las cosas luego de tener creados los materiales/////////////////////////////////
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            EscenarioMovil = new EscenarioMovil(0,0,0,0,gl);
            mt = new ManejadorTeclado();
            drawable.addKeyListener(mt);
            en1 = new EnFacil(10f,150,8,gl);
            en2 = new EnMedio(0f,250,girar,gl);
            en3 = new EnDificil(13f,100,girar,gl);
            en12 = new EnFacil(10f,200,rand,gl);
            en13 = new EnFacil(10f,200,rand+2,gl);
            line0 = new lineasGiratorias(14.7f,250,1,gl);
            line2 = new lineasGiratorias(14.7f,250,2,gl);
            line3 = new lineasGiratorias(14.7f,250,3,gl);
            line4 = new lineasGiratorias(14.7f,250,4,gl);
            line5 = new lineasGiratorias(14.7f,250,5,gl);
            line6 = new lineasGiratorias(14.7f,250,6,gl);
            line7 = new lineasGiratorias(14.7f,250,7,gl);
            line8 = new lineasGiratorias(14.7f,250,8,gl);
            for(int i=1; i<=8; i++){
                this.Churo.add(new EnFacil(10,550+i*10,i,gl));
            }
            for(int i=8; i>=2; i-=2){
                this.Churo2.add(new EnFacil(10,400,i,gl));
            }
            start = false;
            arriba = true;
            
        gl.setSwapInterval(1);
        gl.glEnable(GL.GL_DEPTH_TEST);

        // Setup the drawing area and shading mode
        gl.glClearColor(0.05f, 0.05f, 0.05f, 1.0f);
        gl.glShadeModel(GL.GL_SMOOTH); // try setting this to GL_FLAT and see what happens.
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        if (height <= 0) { // avoid a divide by zero error!
        
            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(60.0f, h, 1.0, 500.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void display(GLAutoDrawable drawable) {
  
        
      
        GL gl = drawable.getGL();
        GLU glu = new GLU();
                gl.glLoadIdentity();
        glu.gluLookAt(0, -15,-7, 0,0 ,150 , 0, 1, 0);
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        
       esMenu = true;
        if( lives==0){
            esMenu = false;
            luz1.desactivate();
            line0.girar();
            line2.girar();
            line3.girar();
            line4.girar();
            line5.girar();
            line6.girar();
            line7.girar();
            line8.girar();
            EscenarioMovil.display();
            renderer.beginRendering(drawable.getWidth(), drawable.getHeight());
            renderer.setColor(1.0f,0.4f,0.4f,1f);
            renderer.draw("GAME OVER",drawable.getWidth()/4,drawable.getHeight()/2);
            renderer.endRendering();
            renderer.beginRendering(drawable.getWidth(), drawable.getHeight());
            renderer.setColor(0.0f,0.0f,1.0f,1f);
            renderer.draw("Your Score:",drawable.getWidth()/4,drawable.getHeight()/2-60);
            renderer.endRendering();
            renderer.beginRendering(drawable.getWidth(), drawable.getHeight());
            renderer.setColor(1.0f,0.9f,0.6f,1f);
            renderer.draw(String.valueOf(score),drawable.getWidth()/4,drawable.getHeight()/2-130);
            renderer.endRendering();
        }
        
        
        
        // Reset the current matrix to the "identity"
 // la camara se ubica aqui por defecto
         //glu.gluLookAt(0, 0,-20, 0,0 ,150 , 0, 1, 0);
        
        
       if( start == true && lives>0){
           esMenu = false;
           luz1.activate();
           AudioPlayer.player.stop(audios);
            line0.girar();
            line2.girar();
            line3.girar();
            line4.girar();
            line5.girar();
            line6.girar();
            line7.girar();
            line8.girar();
           

            EscenarioMovil.display();
            en1.desplazar();
            en12.desplazar();
            en13.desplazar();
            en2.desplazar();
            en3.desplazar();
            
            for(EnFacil Churo:Churo){
               Churo.desplazar();  
            }
            for(EnFacil Churo2:Churo2){
               Churo2.desplazar();  
            }
            System.out.println(col);
            if(col == true){
                
                
                en1.regresar();
                en12.regresar();
                en13.regresar();
                en2.regresar();
                en3.regresar();
                for(EnFacil Churo:Churo){
                    Churo.regresar(); 
                }
                for(EnFacil Churo2:Churo2){
                    Churo2.regresar(); 
                }
            }
          if(rotH == true){
            rotAH = false;
            girar-=2;   
            EscenarioMovil.rot = girar;
            en1.ang = girar;
            en2.ang = girar;
            en3.ang = girar;
            en12.ang = girar;
            en13.ang = girar;
            for(EnFacil Churo:Churo){
               Churo.ang = girar;  
            }
            for(EnFacil Churo2:Churo2){
               Churo2.ang = girar;  
            }
            line0.ang = girar;
            line2.ang=girar;
            line3.ang = girar;
            line4.ang=girar;
            line5.ang = girar;
            line6.ang=girar;
            line7.ang = girar;
            line8.ang=girar;
        }
        if(rotAH == true){
            rotH = false;
            girar+=2;   
            EscenarioMovil.rot = girar;
            en12.ang= girar;
            en13.ang = girar;
            for(EnFacil Churo:Churo){
               Churo.ang = girar;  
            }
            for(EnFacil Churo2:Churo2){
               Churo2.ang = girar;  
            }
            en1.ang = girar;
            en2.ang = girar;
            en3.ang = girar;
            line0.ang = girar;
            line2.ang = girar;
            line3.ang = girar;
            line4.ang=girar;
            line5.ang = girar;
            line6.ang=girar;
            line7.ang = girar;
            line8.ang=girar;
        } 

            score = (int)(score + 1);
            acele = acele - score*0.00000010f;
            renderer.beginRendering(drawable.getWidth(), drawable.getHeight());
            renderer.setColor(1.0f,1.0f,1.0f,1f);
            renderer.draw(String.valueOf(score),0,30);
            renderer.endRendering();
            renderer.beginRendering(drawable.getWidth(), drawable.getHeight());
            renderer.setColor(0.5f,1.0f,0.0f,1f);
            renderer.draw("lives: "+lives,600,30);
            renderer.endRendering();
            //System.out.println(score);
       }
        if(lives >0 && start == false){

            EscenarioMovil.display();
            line0.girar();
            line2.girar();
            line3.girar();
            line4.girar();
            line5.girar();
            line6.girar();
            line7.girar();
            line8.girar();
            if(arriba == true){
            renderer.beginRendering(drawable.getWidth(), drawable.getHeight());
            renderer.setColor(1.0f,1.0f,1.0f,1f);
            renderer.draw("START GAME",drawable.getWidth()/4,drawable.getHeight()/2);
            renderer.endRendering();
            renderer.beginRendering(drawable.getWidth(), drawable.getHeight());
            renderer.setColor(0.5f,0.5f,0.5f,1f);
            renderer.draw("QUIT",drawable.getWidth()/4,drawable.getHeight()/2-80);
            renderer.endRendering();
            }
            else{
            renderer.beginRendering(drawable.getWidth(), drawable.getHeight());
            renderer.setColor(0.5f,0.5f,0.5f,1f);
            renderer.draw("START GAME",drawable.getWidth()/4,drawable.getHeight()/2);
            renderer.endRendering();
            renderer.beginRendering(drawable.getWidth(), drawable.getHeight());
            renderer.setColor(1f,1f,1f,1f);
            renderer.draw("QUIT",drawable.getWidth()/4,drawable.getHeight()/2-80);
            renderer.endRendering();
            
            
        }
            renderer.beginRendering(drawable.getWidth(), drawable.getHeight());
            renderer.setColor(1.0f,1.0f,1.0f,1f);
            renderer.draw("0",0,30);
            renderer.endRendering();
            luz1.desactivate();
        }

        gl.glFlush();
    }
    
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
}

