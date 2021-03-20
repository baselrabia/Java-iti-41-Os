
import java.applet.*;
import java.awt.*;
import java.util.*;
import java.text.*;

import java.awt.event.*; 

public class Ballmove extends Applet  
{
  
    
 
    int x ;
    int y ;
 
    public void init() {
 

        x= 200;
        y= 200;

    
        addMouseMotionListener(new MouseMotionAdapter (){
            public void mouseDragged(MouseEvent e) {
                    x = e.getX() -20;
                    y = e.getY() -20;
                    repaint();
            }

        });

       addMouseListener(new MouseAdapter() {

        

            public void mouseDragged(MouseEvent e) {  
                    x = e.getX();
                    y = e.getY();
                    repaint();
            }  
            // public void mouseEntered(MouseEvent e) {  
            //     l.setText("Mouse Entered");  
            // }  
            // public void mouseExited(MouseEvent e) {  
            //     l.setText("Mouse Exited");  
            // }  
            // public void mousePressed(MouseEvent e) {  
            //         x = e.getX();
            //         y = e.getY();
            //         repaint()
            // }  
            // public void mouseReleased(MouseEvent e) {  
            //     l.setText("Mouse Released");  
            // }

        });


    }
    public void paint(Graphics g) {

        g.setColor(Color.yellow);
        g.fillOval(x,y,50,50);

    }

    
    

    


}