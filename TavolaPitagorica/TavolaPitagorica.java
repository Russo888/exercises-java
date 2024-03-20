import javax.swing.*;
import java.awt.*;
public class TavolaPitagorica extends JFrame
{
    public TavolaPitagorica()
    {
        setSize(450, 450);
        Container p=getContentPane();
        p.setLayout(null);   
        for(int i=1; i<=10; i++)
        {
            for(int j=1; j<=10; j++)
            {
              
                JLabel t1= new JLabel(""+i*j);
                t1.setLocation(i*30, j*30);
                t1.setSize(100,30);
                p.add(t1);
              
            }            
        }
        setVisible(true);   
    }       
}

