import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList; 


public class Finestra extends JFrame implements ActionListener
{
    JPanel o;
    private int h=0;
    private String tipo;
    private int appo;
    private int t1;
    private int x1;
    private int y1;
    private int n=0;
    private int c=0;
    private int d=0;
    private int abbo1;
    private int abbo2;
    private int abbo3;
    private int abbo4;
    ArrayList<JLabel> abbonati;
    ArrayList<Integer> metax = new ArrayList();
    ArrayList<Integer> metay = new ArrayList();
    ArrayList<Integer> coordinatex = new ArrayList();
    ArrayList<Integer> coordinatey = new ArrayList();
    public Finestra()
    {  
        Timer t=new Timer(10, this);
        t.setActionCommand("TIMER");
        

        setSize(600,800);        
        setLayout(new BorderLayout()); 


        n=(int)(Math.random()*7+3);
        abbonati=new ArrayList();
        for(int i=0; i<n;i++)
        {
            JLabel o1=new JLabel();
            t1=(int)(Math.random()*2+1);
            if(t1==1) 
            {
                tipo="buono";                
                Sprite appo=new Sprite(tipo);
                abbonati.add(appo.dammiLabel());   
            }
            if(t1==2) 
            {
                tipo="cattivo";
                Sprite appo=new Sprite(tipo);
                abbonati.add(appo.dammiLabel());
            }
        }

        o=new JPanel();
        o.setBackground(new Color(255,255,255));
        o.setLayout(null);

        add(o,BorderLayout.CENTER); 
        for(int i=0;i<n;i++)
        {
            coordinatex.add((int)(Math.random()*550+1));
            coordinatey.add((int)(Math.random()*660+1));
                      
            o.add(abbonati.get(i)); 
            abbonati.get(i).setLocation(x1,y1);
        }
        
        for(int i=0;i<n;i++)
        {
                metax.add(coordinatex.get(i));
                metay.add(coordinatey.get(i));
        }
        
        t.start();
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {                  
            for(int i=0;i<n;i++)
            {
                abbo1=coordinatex.get(i);
                abbo2=metax.get(i);
                abbo3=coordinatey.get(i);
                abbo4=metay.get(i);
                if((abbo1==abbo2)&&(abbo3==abbo4))
                {
                       
                      metax.set(i,(int)(Math.random()*550+1));
                      metay.set(i,(int)(Math.random()*660+1));

                        
                }                
            }  
                    
            for(int i=0;i<n;i++)
            {            
                c=metax.get(i);
                d=metay.get(i);    
                
                x1=coordinatex.get(i);
                y1=coordinatey.get(i);
                if(c-x1>0)
                {
                      x1=x1+1;
                      abbonati.get(i).setLocation(x1,y1);
                }                    
                if(c-x1<0)
                {
                      x1=x1-1;
                      abbonati.get(i).setLocation(x1,y1);
                }                
                if(c-x1==0)
                {                
                      abbonati.get(i).setLocation(x1,y1);
                }            
                if(d-y1>0)
                {
                      y1=y1+1;
                      abbonati.get(i).setLocation(x1,y1);
                }                    
                if(d-y1<0)
                {
                      y1=y1-1;
                      abbonati.get(i).setLocation(x1,y1);
                }                
                if(d-y1==0)
                {                
                      abbonati.get(i).setLocation(x1,y1);
                }
                
                coordinatex.set(i,x1);
                coordinatey.set(i,y1);
            }       
    }
    
    

}
