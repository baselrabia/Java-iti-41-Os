import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javafx.scene.shape.Line;

public class DrawLineMulti extends Applet{
    Line[] lines;
    int index;
    Line line;
    
    
    
    public void init()
    {
        lines= new Line[10];
        index=0;
        line = new Line(0,0,0,0);
        addMouseMotionListener(new MouseMotionListener() {
            public void mouseDragged(MouseEvent e) {
                line.setEndX((int) e.getX());
                line.setEndY((int) e.getY());
                repaint();
            }

            public void mouseMoved(MouseEvent e) {
               
            }
        });
        
        addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                
            }

            public void mousePressed(MouseEvent e) {
                line=new Line(0,0,0,0);
                line.setStartX((int) e.getX());
                line.setStartY((int) e.getY());
            }

            public void mouseReleased(MouseEvent e) {
                if(index < 9 && line.getEndX()!=0 && line.getEndY() !=0)
                {
                    lines[index]=line;
                    index++;
                    repaint();
                }
            }

            public void mouseEntered(MouseEvent e) {
                
            }

            public void mouseExited(MouseEvent e) {
                
            }
        });
    }
    
    public void paint(Graphics g)
    {
        g.drawLine((int)line.getStartX(),(int)line.getStartY(),(int)line.getEndX(),(int)line.getEndY());
         if(index >0)
        {
            
        for(int i=0 ; i<index;i++ )
        {
            g.drawLine((int)lines[i].getStartX(),(int)lines[i].getStartY(),(int)lines[i].getEndX(),(int)lines[i].getEndY());
        }
     
     
     }
    }
}
