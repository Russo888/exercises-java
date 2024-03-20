import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList; 
public class Tratteggio extends JFrame
{
    JLabel o1;
    public Tratteggio(String trattini)
    {
            o1=new JLabel();
            o1.setText(trattini); 
    }
    
    public JLabel dammiLabel()
    {
        return o1;
    }
}

