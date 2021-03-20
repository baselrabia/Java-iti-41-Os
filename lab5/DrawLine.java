
import java.applet.*;
import java.awt.*;
import java.util.*;
import java.text.*;

import java.awt.event.*; 


public class DrawLine extends Applet{
    int x1,y1,x2,y2;
    
    public void init()
    {
        

        addMouseMotionListener(new MouseMotionAdapter (){

            public void mouseDragged(MouseEvent e) {
                x2=e.getX();
                y2=e.getY();
                repaint(); 
            }

            
        });
        
        addMouseListener(new MouseAdapter() {


            public void mousePressed(MouseEvent e) {
                x1=e.getX();
                y1=e.getY();
               
            }
 
        });
    }
    
    public void paint(Graphics g)
    {
        g.drawLine(x1, y1, x2, y2);
    }
}
