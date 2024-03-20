import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Finestra extends JFrame implements ActionListener
{
    JLabel o1;
    private int x;
    private int y;
    public Finestra()
    {
        setSize(500,500);        
        setLayout(new BorderLayout());
        
        JPanel a=new JPanel();
        a.setLayout(new GridLayout());
        a.setSize(100,500);
        JButton a1= new JButton ("UP");
        a1.addActionListener(this);
        a.add(a1);
        add(a,BorderLayout.NORTH);
        
        JPanel b=new JPanel();
        b.setLayout(new GridLayout());
        b.setSize(500,100);
        JButton b1= new JButton ("RIGHT");
        b1.addActionListener(this);
        b.add(b1);
        add(b,BorderLayout.EAST);
        
        
        JPanel c=new JPanel();
        c.setLayout(new GridLayout());
        c.setSize(100,500);
        JButton c1= new JButton ("DOWN");
        c1.addActionListener(this);
        c.add(c1);
        add(c,BorderLayout.SOUTH);
        
        
        JPanel d=new JPanel();
        d.setLayout(new GridLayout());
        d.setSize(500,100);
        JButton d1= new JButton ("LEFT");
        d1.addActionListener(this);
        d.add(d1);
        add(d,BorderLayout.WEST);
        
        
        
        JPanel o=new JPanel();
        o1=new JLabel();
        o.setLayout(null);
        o1.setText("O");
        o1.setSize(200,200);
        x=175;
        y=100;
        o1.setLocation(x,y);
        o.add(o1);
        add(o,BorderLayout.CENTER);
        
        
        setVisible(true);
    }


    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand()=="UP")
        {    
            y=y-10;     
            o1.setLocation(x,y);
        }
        if (e.getActionCommand()=="DOWN")
        {
            y=y+10;
            o1.setLocation(x,y);
        }
        if (e.getActionCommand()=="RIGHT")
        {
            x=x+10;
            o1.setLocation(x,y);
        }
        if (e.getActionCommand()=="LEFT")
        {
            x=x-10;
            o1.setLocation(x,y);
        }
    }

}
