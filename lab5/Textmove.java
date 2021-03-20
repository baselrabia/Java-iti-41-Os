
import java.applet.*;
import java.awt.*;
import java.util.*;
import java.text.*;

import java.awt.event.*; 

public class Textmove extends Applet {
    int x ;
    int y ;
    String s ;

    public void init() {
        x = 100; 
        y = 100; 

       addKeyListener(new KeyAdapter() {

            public void keyReleased(KeyEvent ev) {
                 if(ev.getKeyCode()==ev.VK_LEFT && x >10)
                {
                    x-=10;
                }
                else if (ev.getKeyCode()==ev.VK_RIGHT && x < getWidth())
                {
                    x+=10;
                }
                else if (ev.getKeyCode() ==ev.VK_UP && y> 10)
                {
                    y-=10;
                }
                else if (ev.getKeyCode()==ev.VK_DOWN && y < getHeight())
                {
                    y+=10;
                }
                repaint();
            }
        });
       
    }
    public void paint(Graphics g) {
        g.drawString("JAVA " , x, y);
    }

     


}