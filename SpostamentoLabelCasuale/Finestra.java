import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Finestra extends JFrame implements ActionListener
{
    JLabel o1;
    private int x;
    private int y;
    private int a1=0;
    private int b1=0;
    private int a=x;
    private int b=y;
    public Finestra()
    {
       Timer t=new Timer(2, this);
       t.setActionCommand("TIMER");
       t.start();
        
        setSize(500,500);        
        setLayout(new BorderLayout());
              

        
        JPanel o=new JPanel();
        o1=new JLabel();
        o.setLayout(null);
        o1.setText("x");
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
            
            
            if((x==a)&&(y==b))
            {
                a1=(int)(Math.random()*400+1);
                b1=(int)(Math.random()*400+1);
            }
            
            a=a1;
            b=b1;

            
            if(a-x>0)
            {
                x=x+1;
                o1.setLocation(x,y);
            }    
                
            if(a-x<0)
            {
                x=x-1;
                o1.setLocation(x,y);
            }
            
            if(a-x==0)
            {                
                o1.setLocation(x,y);
            }
            
            if(b-y>0)
            {
                y=y+1;
                o1.setLocation(x,y);
            }    
                
            if(b-y<0)
            {
                y=y-1;
                o1.setLocation(x,y);
            }
                
            if(b-y==0)
            {                
                o1.setLocation(x,y);
            }

    }
    

}
