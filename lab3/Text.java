import java.applet.*;
import java.awt.*;
import java.awt.GraphicsEnvironment;
import java.lang.Math;
public class Text extends Applet
{
    String fonts[];
    //Function to get the list of fonts available
    public void init()
    {
        setBackground(Color.white);
    
        //GraphicsEnvironment GE;
        //GE = GraphicsEnvironment.getLocalGraphicsEnvironment();
        //fonts = GE.getAvailableFontFamilyNames(); //toolkit 
        Toolkit tk = Toolkit.getDefaultToolkit();

        fonts = tk.getFontList();

    }
    //Function to draw the text
    public void paint(Graphics g)
    {
        int size = fonts.length;
 
        for(int i=1; i < size ; i++)
        {
            Font myfont = new Font(fonts[i],Font.PLAIN,20);
            g.setFont(myfont);
            g.drawString( fonts[i],100,(i*40));
        }
    }
}