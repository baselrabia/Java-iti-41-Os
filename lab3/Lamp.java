import java.awt.*;
import java.applet.*;

public class Lamp extends Applet
{

public void paint(Graphics g)
{
    g.setColor(Color.yellow);
    g.fillRoundRect(90,250,120,30,30,30);                // Lamp Platform

    g.setColor(Color.MAGENTA);
    g.drawLine(125,200,125,250);
    g.drawLine(175,200,175,250) ;                        // the base of the lamp

    g.setColor(Color.ORANGE);
    g.fillOval(85,80,135,40);
    g.drawArc(60,161,180,45,180,180);        // the lamp shade, top and bottom edges

    g.setColor(Color.PINK);
    g.drawLine(60,177,95,89);
    g.drawLine(240,177,210,89);              // lamp shade, sides


    g.setColor(Color.yellow);
    g.fillOval(90,140,20,20);

     g.setColor(Color.yellow);                        // dots on the shade
    g.fillOval(130,130,40,40);

    g.setColor(Color.yellow);                        // dots on the shade
    g.fillOval(190,140,20,20);

  
}

}