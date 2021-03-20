import java.applet.*;
import java.awt.*;
import java.util.*;
import java.text.*;

public class Banner extends Applet implements Runnable
{
    Thread th;
    String fonts[];
    int i;

    public void init()
    { 
        GraphicsEnvironment GE;
        GE = GraphicsEnvironment.getLocalGraphicsEnvironment();
        fonts = GE.getAvailableFontFamilyNames();

        i= 100;
        
        th = new Thread(this);
        th.start();
    }
    //Function to draw the text
    public void paint(Graphics g)
    {
       

        g.setColor(Color.RED);
        Font myfont = new Font(fonts[1],Font.PLAIN,22);
        g.setFont(myfont);
        g.drawString( "Hello There " ,i,200);
    }

    public void  run()
    {

        while(true){

            i += 20;
            if(i == getWidth()){
                i = -40;
            }

            repaint();


            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                //TODO: handle exception
            }
            
        }


    }



}