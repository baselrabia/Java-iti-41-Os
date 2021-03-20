import java.applet.Applet;
import java.awt.Graphics;
 
public class HelloApp extends Applet {
 
public void paint(Graphics g) {
  
  g.drawString("Hello World ! From HelloApp.java", 100, 200);
 }
}