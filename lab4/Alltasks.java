import java.applet.*;
import java.awt.*;
import java.util.*;
import java.text.*;

public class Alltasks extends Applet implements Runnable
{
    Thread th1;
    Thread th2;
    Thread th3;
    int x ;
    int dx;
    int dy;
    int y ;

    String fonts[];
    int i;

    public void init()
    { 
        x= 200;
        y= 200;
        dx=0;
        dy=0;

        GraphicsEnvironment GE;
        GE = GraphicsEnvironment.getLocalGraphicsEnvironment();
        fonts = GE.getAvailableFontFamilyNames();
        i= 100;


        th1 = new Thread(this);
            th1.setName("th1");

        th1.start();

        th2 = new Thread(this);
                    th2.setName("th2");

        th2.start();
        
        th3 = new Thread(this);
                    th3.setName("th3");

        th3.start();
    }
    //Function to draw the text
    public void paint(Graphics g)
    {
        //th1
       Date d = new Date();
        g.drawString( d.toString()  ,100,150);
 

        //th2

        g.setColor(Color.RED);
        Font myfont = new Font(fonts[1],Font.PLAIN,22);
        g.setFont(myfont);
        g.drawString( "Hello There " ,i,200);


        //th 3
        g.setColor(Color.yellow);
        g.fillOval(x,y,50,50);
    }



    public void  run()
    {

        String currentthread =Thread.currentThread().getName();

        if(currentthread.equals("th1")){
            
                 while(true){

                    repaint();


                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        //TODO: handle exception
                    }
                    
                }


        }

        if(currentthread.equals("th2")){

            while(true){

                    i += 20;
                    if(i == getWidth()){
                        i = -40;
                    }

                    repaint();


                    try {
                        Thread.sleep(400);
                    } catch (Exception e) {
                        //TODO: handle exception
                    }
                    
                }


        }


        if(currentthread.equals("th3")){
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



}