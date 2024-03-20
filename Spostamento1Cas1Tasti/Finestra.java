import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Finestra extends JFrame implements ActionListener, KeyListener
{
    JLabel o1;
    JLabel o2;
    private int x;
    private int y;

    private int x1;
    private int y1;
    private int c1=0;
    private int d1=0;
    private int c=x;
    private int d=y;
    public Finestra()
    {  
        Timer t=new Timer(10, this);
        t.setActionCommand("TIMER");
        t.start();
        
        setSize(500,500);        
        setLayout(new BorderLayout());        
               
        
        JPanel d=new JPanel();
        d.setLayout(null);
        d.setSize(1,1);
        JButton d1= new JButton ();
        d1.addActionListener(this);
        d1.addKeyListener(this);
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


        o2=new JLabel();
        o2.setText("O");
        o2.setSize(220,220);
        x1=190;
        y1=130;
        o2.setLocation(x1,y1);
        o.add(o2);
        o2.addKeyListener(this); 
        


        
        setVisible(true);
    }


    public void actionPerformed(ActionEvent e)
    {
              
        //labelcasuale  
        if((x1==c)&&(y1==d))
        {
              c1=(int)(Math.random()*300+1);
              d1=(int)(Math.random()*300+1);
        }            
        c=c1;
        d=d1;            
        if(c-x1>0)
        {
              x1=x1+1;
              o2.setLocation(x1,y1);
        }                    
        if(c-x1<0)
        {
              x1=x1-1;
              o2.setLocation(x1,y1);
        }                
        if(c-x1==0)
        {                
              o2.setLocation(x1,y1);
        }            
        if(d-y1>0)
        {
              y1=y1+1;
              o2.setLocation(x1,y1);
        }                    
        if(d-y1<0)
        {
              y1=y1-1;
              o2.setLocation(x1,y1);
        }                
        if(d-y1==0)
        {                
              o2.setLocation(x1,y1);
        }
        
        if(x<=x1+4&&x>=x1-4 && y1<=y1+4&&y>=y1-4)
        {
            setVisible(false);  
        }
       
    }
    
    public void keyReleased(KeyEvent e)
    {
    
    }
    
    public void keyTyped(KeyEvent e)
    {
    
    }
    
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode()==KeyEvent.VK_UP)
        {
            y=y-10;     
            o1.setLocation(x,y);
        }
        
        if(e.getKeyCode()==KeyEvent.VK_DOWN)
        {
            y=y+10;
            o1.setLocation(x,y);
        }
        
        if(e.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            x=x+10;
            o1.setLocation(x,y);
        }
        
        if(e.getKeyCode()==KeyEvent.VK_LEFT)
        {
            x=x-10;
            o1.setLocation(x,y);
        }
    }


}
