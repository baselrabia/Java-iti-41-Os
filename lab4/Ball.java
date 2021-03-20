import java.applet.*;
import java.awt.*;
import java.util.*;
import java.text.*;

public class Ball extends Applet implements Runnable
{
    Thread th;
    int x ;
    int dx;
    int dy;
    int y ;


    public void init()
    { 
        x= 200;
        y= 200;
        dx=0;
        dy=0;


        th = new Thread(this);
        th.start();
    }
    //Function to draw the text
    public void paint(Graphics g)
    {
       

        g.setColor(Color.yellow);
        g.fillOval(x,y,50,50);
    }

    public void  run()
    {

        while(true){

            if (dx == 0 && dy == 0 ){
                x += 40;
                y += 20;
            }
            if (dx == 1 && dy == 0 ){
                x -= 40;
                y += 20;
            }
             if (dx == 1 && dy == 1 ){
                x -= 40;
                y -= 20;
            }

            if (dx == 0 && dy == 1 ){
                x += 40;
                y -= 20;
            }

           


            if(x > getWidth()-50){
                dx =1;    
            }
            if( x < 0){
                dx = 0;
            }

            if(y > getHeight()-50){
                dy =1;    
            }
            if( y < 0){
                dy = 0;
            }

            repaint();


            try {
                Thread.sleep(200);
            } catch (Exception e) {
                //TODO: handle exception
            }
            
        }


    }



}