package org.yourorghere;

import javax.media.opengl.GL;

public class Material {
    float[] ambient, diffuse, specular, emissive;
    float shininess;
    GL gl;
    public Material(float [] ambient, float [] diffuse, float [] specular,  float [] emissive,  float shininess, GL gl ){
       ambient[0] = ambient[0] /255;
       ambient[1] = ambient[1] /255;
       ambient[2] = ambient[2] /255;
        
       diffuse[0] = diffuse[0] /255;
       diffuse[1] = diffuse[1] /255; 
       diffuse[2] = diffuse[2] /255; 
        
       specular[0] = specular[0] /255;
       specular[1] = specular[1] /255;
       specular[2] = specular[2] /255;
       
       emissive[0] = emissive[0] /255;
       emissive[1] = emissive[1] /255;
       emissive[2] = emissive[2] /255;
       this.ambient = ambient;
       this.diffuse = diffuse;
       this.specular = specular;
       this.emissive = emissive;
       this.shininess = shininess;
       this.gl = gl;
       
    }
    
    public void activar(){
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT, ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, specular, 0);
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_DIFFUSE, diffuse, 0);
        gl.glMaterialf(GL.GL_FRONT, GL.GL_SHININESS, shininess);
    }
    
}
