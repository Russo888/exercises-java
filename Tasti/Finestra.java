import javax.swing.*;
import java.awt.*;
public class Finestra extends JFrame
{
    public Finestra()
    {
        setSize(500,500);        
        setLayout(new BorderLayout());
        
        JPanel a=new JPanel();
        a.setLayout(new GridLayout());
        a.setSize(100,500);
        JButton a1= new JButton ("UP");
        a.add(a1);
        add(a,BorderLayout.NORTH);
        
        JPanel b=new JPanel();
        b.setLayout(new GridLayout());
        b.setSize(500,100);
        JButton b1= new JButton ("RIGHT");
        b.add(b1);
        add(b,BorderLayout.EAST);
        
        
        JPanel c=new JPanel();
        c.setLayout(new GridLayout());
        c.setSize(100,500);
        JButton c1= new JButton ("DOWN");
        c.add(c1);
        add(c,BorderLayout.SOUTH);
        
        
        JPanel d=new JPanel();
        d.setLayout(new GridLayout());
        d.setSize(500,100);
        JButton d1= new JButton ("LEFT");
        d.add(d1);
        add(d,BorderLayout.WEST);
        
        
        JPanel o=new JPanel();
        o.setLayout(new GridLayout());
        o.setSize(100,100);
        JLabel o1=new JLabel("O");
        o.add(o1);
        o.setLocation(300,300);
        add(o,BorderLayout.CENTER);
        
        
        setVisible(true);
    }
}


