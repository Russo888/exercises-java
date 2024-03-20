import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList; 
public class Sprite extends JFrame
{
    JLabel o1;
    public Sprite(String s)
    {
        ImageIcon sprite1=new ImageIcon("cassano.png");                   
        ImageIcon sprite2=new ImageIcon("saba.png");    

        if(s=="buono")
        {
            o1=new JLabel(sprite1);
            o1.setSize(40,40);
        }
        
        if(s=="cattivo")
        {
            o1=new JLabel(sprite2);
            o1.setSize(40,40);
        }
    }
    
    public JLabel dammiLabel()
    {
        return o1;
    }
}
