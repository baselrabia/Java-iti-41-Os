import java.applet.*;
import java.awt.*;
 
public class HelloApp extends Applet {
 
Image picture;  
  
  public void init() {  
    picture = getImage(getDocumentBase(),"unnamed.jpg");  
  }  
    
  public void paint(Graphics g) { 
    g.drawImage( picture, 0, 0, this ); // draw original image
    g.drawImage( picture, 0, 400, getWidth(), getHeight() - 400 , this );
      
  }  



}
 