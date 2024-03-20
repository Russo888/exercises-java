import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList; 


public class Finestra extends JFrame
{
    JPanel o;
    private int cas=0;
    private int appo=0;
    private int n=0;
    private int c=0;
    private int saba=0;
    private int x=0;
    private int y=0;
    ArrayList<JLabel> mazzo;

    public Finestra()
    {      
        setSize(800,800);  
        setLayout(new BorderLayout()); 
        
        n=40;
        mazzo=new ArrayList();
        for(int i=0; i<n;i++)
        {            
                Sprite appo=new Sprite(i);
                mazzo.add(appo.dammiLabel());           
        }

        o=new JPanel();
        o.setBackground(new Color(255,255,255));
        o.setLayout(null);
        add(o,BorderLayout.CENTER);         
                     
        saba=40;
     
        for(int i=0;i<12;i++)
        {
            cas=(int)(Math.random()*saba);          
            o.add(mazzo.get(cas)); 
            if(i==0)x=250;y=1; 
            if(i<3)
            {                
                mazzo.get(cas).setLocation(x,y);
                x=x+60;
            }
            if(i==3)x=680;y=250;
            if(i>=3&&i<6)
            {
                mazzo.get(cas).setLocation(x,y);
                x=x-60;
            }
            if(i==6)x=250;y=650; 
            if(i>=6&&i<9)
            {
                mazzo.get(cas).setLocation(x,y);
                x=x+60;
            }
            if(i==9)x=1;y=250;
            if(i>=9)
            {
                mazzo.get(cas).setLocation(x,y);
                x=x+60;
            }
            
            mazzo.remove(cas);
            saba=saba-1;
        }

        setVisible(true);
    }
}
