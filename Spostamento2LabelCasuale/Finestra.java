import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Finestra extends JFrame implements ActionListener, KeyListener, MouseListener
{
    JLabel o1;
    JLabel o2;
    private int x;
    private int y;
    private int a1=0;
    private int b1=0;
    private int a=x;
    private int b=y;
    private int x1;
    private int y1;
    private int c1=0;
    private int d1=0;
    private int c=x;
    private int d=y;
    public Finestra()
    {
        Timer t=new Timer(20, this);
        t.setActionCommand("TIMER");
        t.start();
        
        setSize(500,500);        
        setLayout(new BorderLayout());
        
        JPanel a=new JPanel();
        a.setLayout(new GridLayout());
        a.setSize(100,500);
        JButton a1= new JButton ("UP");
        a1.addActionListener(this);
        a1.addKeyListener(this);
        a.add(a1);
        add(a,BorderLayout.NORTH);
        
        JPanel b=new JPanel();
        b.setLayout(new GridLayout());
        b.setSize(500,100);
        JButton b1= new JButton ("RIGHT");
        b1.addActionListener(this);
        b1.addKeyListener(this);
        b.add(b1);
        add(b,BorderLayout.EAST);
        
        
        JPanel c=new JPanel();
        c.setLayout(new GridLayout());
        c.setSize(100,500);
        JButton c1= new JButton ("DOWN");
        c1.addActionListener(this);
        c1.addKeyListener(this);
        c.add(c1);
        add(c,BorderLayout.SOUTH);
        
        
        JPanel d=new JPanel();
        d.setLayout(new GridLayout());
        d.setSize(500,100);
        JButton d1= new JButton ("LEFT");
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
        o.addMouseListener(this); 
        
        o2=new JLabel();
        o2.setText("O");
        o2.setSize(200,200);
        x1=190;
        y1=130;
        o2.setLocation(x1,y1);
        o.add(o2);

        
        setVisible(true);
    }


    public void actionPerformed(ActionEvent e)
    {
        //primalabel              
        if((x==a)&&(y==b))
        {
             a1=(int)(Math.random()*300+1);
             b1=(int)(Math.random()*300+1);
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
                
               
        //secondalabel    
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
        
        //tasti
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
    
  
    
    public void mouseExited(MouseEvent e)
    {
    
    }
    
    public void mouseEntered(MouseEvent e)
    {
    
    }
    
    public void mouseReleased(MouseEvent e)
    {
    
    }
   
    public void mousePressed(MouseEvent e)
    {
        if(e.getButton() == MouseEvent.BUTTON1)
        {
            x=(e.getX()-3);
            y=(e.getY()-100);
            o1.setLocation(x,y);
        }
    }
    
    public void mouseClicked(MouseEvent e)
    {
    
    }

}
