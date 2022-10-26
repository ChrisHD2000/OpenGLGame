
package org.yourorghere;
import javax.media.opengl.GL;
public class Piramide {
    GL gl;
    float x,y,z;
    float w,h,d;
    float r,g,b;
    float rx,ry;
    
    public Piramide (float x, float y, float z, float w, float h, float d, float r, float g, float b, float rx, float ry, GL gl){
    this.x = x;
    this.y = y;
    this.z = z;
    this.w = w;
    this.h = h;
    this.d = d;
    this.r = r;
    this.g = g;
    this.b = b;
    this.rx = rx;
    this.ry = ry;
    this.gl = gl;
    }
    
    public void display(){
        gl.glPushMatrix();
        gl.glTranslatef(x,y,z);
        gl.glRotatef(rx,1,0,0);
        gl.glRotatef(ry,0,1,0);
        gl.glScalef(w,h,d);
        
        //base
        gl.glBegin(GL.GL_QUADS);
            gl.glColor3f(r,g,b);
            gl.glVertex3f(-1, -1, -1);
            gl.glVertex3f(-1, -1, 1);
            gl.glVertex3f(1, -1, 1);
            gl.glVertex3f(1, -1, -1);
                
        gl.glEnd();
        
         gl.glBegin(GL.GL_TRIANGLES);
            gl.glColor3f(r,g,b);
            gl.glVertex3f(1, -1, -1);
            gl.glVertex3f(1, -1, 1);
            gl.glVertex3f(0, 1, 0);
        gl.glEnd();
          gl.glBegin(GL.GL_TRIANGLES);
            gl.glColor3f(r,g,b);
            gl.glVertex3f(-1, -1, 1);
            gl.glVertex3f(0, 1, 0);
            gl.glVertex3f(-1, -1, -1);
        gl.glEnd();
           gl.glBegin(GL.GL_TRIANGLES);
            gl.glColor3f(r,g,b);
            gl.glVertex3f(-1, -1, -1);
            gl.glVertex3f(1, -1, -1);
            gl.glVertex3f(0, 1, 0);
        gl.glEnd();
         gl.glBegin(GL.GL_TRIANGLES);
            gl.glColor3f(r,g,b);
            gl.glVertex3f(0, 1,0);
            gl.glVertex3f(1, -1, 1);
            gl.glVertex3f(-1, -1, 1);
        gl.glEnd();
        gl.glPopMatrix();
    }
    
    
}
