import java.applet.*;
import java.awt.*;
import java.util.*;
import java.text.*;

public class DateTimeApp extends Applet implements Runnable
{
   Thread th;
    public void init()
    { 

        th = new Thread(this);
        th.start();
    }
    //Function to draw the text
    public void paint(Graphics g)
    {
        // Calendar cal = new GregorianCalendar();
        // Date d = cal.getTime();
        // SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        // g.drawString(sdf.format(d), 20, 30);

        Date d = new Date();

        g.drawString( d.toString()  ,100,200);
    }

    public void  run()
    {

        while(true){

            repaint();


            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                //TODO: handle exception
            }
            
        }


    }



}