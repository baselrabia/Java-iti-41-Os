
import java.applet.*;
import java.awt.*;
import java.util.*;
import java.text.*;

import java.awt.event.*; 

public class Buttonapp extends Applet {
    int x = 0;
    String s ;
    Button inc;
    Button dec;

    public void init() {
        inc = new Button("increment");
        dec = new Button("decrement");
        inc.addActionListener(new MyButtonListener());
        dec.addActionListener(new MyButtonListener());
        add(inc);
        add(dec);
    }
    public void paint(Graphics g) {
        g.drawString("Click Count is: " + x   , 50, 200);
    }

    class MyButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {

            s = ((Button) ev.getSource()).getActionCommand();
            if (s.equals("increment")){
                x++;
            }else if (s.equals("decrement")){
                x--;
            }
           
            repaint();
        }
    }


}