
import java.applet.*;
import java.awt.*;
import java.util.*;
import java.text.*;

import java.awt.event.*; 

public class Ballbtn extends Applet implements Runnable
{
  
    Button start;
    Button pause;
    String s ;

    Thread th;
    int x ;
    int dx;
    int dy;
    int y ;

    volatile boolean flag;

    public void init() {
        start = new Button("start");
        pause = new Button("pause");
        start.addActionListener(new MyButtonListener());
        pause.addActionListener(new MyButtonListener());
        add(start);
        add(pause);


        x= 200;
        y= 200;
        dx=0;
        dy=0;
        flag = true;


        th = new Thread(this);
        th.start();


    }
    public void paint(Graphics g) {

        g.setColor(Color.yellow);
        g.fillOval(x,y,50,50);

    }

    class MyButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {

            s = ((Button) ev.getSource()).getActionCommand();
            if (s.equals("start")){
                flag = true;
            }else if (s.equals("pause")){
                flag = false;
            }
           
            // repaint();
        }

        
    }

     public void  run()
    {

        while(true){
            if(!flag){
                continue;
            }

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